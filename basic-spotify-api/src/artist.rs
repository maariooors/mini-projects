use std::env;
use crate::token::Token;
use crate::album::{Album};

use reqwest::Client;
use std::error::Error;
use http::header::AUTHORIZATION;
use serde::{Deserialize, Serialize};

/// Main struct needed to use all implementation regarding
/// an artist.
///
/// Previous need of and [ArtistBuilder] struct.
/// # CREATION
/// ```
/// let artist: Artist = ArtistBuilder::new().build().await.unwrap();
/// ```
#[derive(Deserialize, Serialize, Debug, Default)]
pub struct Artist {
    id: String,
    name: String,
}

/// Used to create an [Artist] with its basic data: ID, name.
///
/// Necessary use of [ArtistBuilder::build] function to create an [Artist] struct.
#[derive(Deserialize, Serialize, Debug, Default)]
pub struct ArtistBuilder {
    id: String,
    name: String,
}

/// Aux struct used to parse the JSON "items" filed received
/// in the function [Artist::discography].
#[derive(Deserialize, Debug)]
struct Items {
    items: Vec<Album>,
}

impl ArtistBuilder {

    /// Returns an [ArtistBuilder] struct with the [default] trait.
    pub fn new() -> ArtistBuilder { ArtistBuilder::default() }

    /// Async function needed to convert an [ArtistBuilder] to an [Artist].
    ///
    /// It does a request to the Spotify API and deserialize the incoming JSON
    /// to store the basic attributes: ID, name.
    /// # EXAMPLE
    /// ```
    /// let artist: Artist = ArtistBuilder::new().build().await.unwrap();
    /// ```
    /// # SUCCESS
    /// Returns the [Artist] struct with the information received by de API.
    /// # ERROR
    /// Returns a dyn Error.
    pub async fn build(self) -> Result<Artist, Box<dyn Error>> {
        let token: Token = Token::build().await.unwrap();
        let id = env::var("ARTIST_ID").unwrap();
        let mut artist = Artist {
            id,
            ..Artist::default()
        };

        let request = Client::new()
            .get("https://api.spotify.com/v1/artists/".to_string() + &artist.id)
            .header(AUTHORIZATION, "Bearer ".to_string() + token.access_token())
            .send().await?
            .text().await?;
        artist = serde_json::from_str(request.as_str())?;
        Ok(artist)
    }
}

#[allow(dead_code)]
impl Artist {

    /// Async function that does a request to the Spotify API and deserializes the incoming JSON
    /// to store all the discography of the [Artist].
    /// # NOTES
    /// The Spotify API returns all the discography information inside a filed named
    /// "items". For this reason the aux struct [Items] is needed. This is due to the
    /// way the serde_json crate deserializes the incoming JSON files.
    ///
    /// The Spotify API counts songs inside albums as albums with only one song in it.
    /// Therefore, the other two functions [Artist::songs] and [Artist::albums]
    /// help to distinguish if the album received is actually an album or a song.
    /// # EXAMPLE
    /// ```
    /// let artist: Artist = ArtistBuilder::new().build().await.unwrap();
    /// let discography: Vec<Album> = artist.discography();
    /// println!("{:#?}", discography);
    /// ```
    /// # SUCCESS
    /// Returns a vector of [Album] structs: [`Vec<Album>`].
    /// # ERROR
    /// Returns a dyn Error.
    pub async fn discography(&self) -> Result<Vec<Album>, Box<dyn Error>> {
        let token: Token = Token::build().await.unwrap();
        let mut albums: Vec<Album> = Vec::new();

        let request = Client::new()
            .get("https://api.spotify.com/v1/artists/".to_string() + &self.id + "/albums\
            ?limit=50")
            .header(AUTHORIZATION, "Bearer ".to_string() + token.access_token())
            .send().await?
            .text().await?;

        let request: Items = serde_json::from_str(request.as_str())?;
        for album in request.items { albums.push(album) }
        Ok(albums)
    }

    /// Async function that calls the [Artist::discography] function and returns a vector containing
    /// all the songs of the artist.
    /// # NOTES
    /// As mentioned before, the Spotify API does not distinguish between
    /// songs and albums, because it treats them all the same. Therefore,
    /// to simplify the structure of the crate, both elements will be treated
    /// as albums.
    /// # EXAMPLE
    /// ```
    /// let artist: Artist = ArtistBuilder::new().build().await.unwrap();
    /// let songs: Vec<Album> = artist.songs();
    /// println!("{:#?}", songs);
    /// ```
    /// # SUCCESS
    /// Returns a vector of [Album] structs: [`Vec<Album>`].
    /// # ERROR
    /// Returns a dyn Error.
    pub async fn songs(&self) -> Result<Vec<Album>, Box<dyn Error>> {
        let discography: Vec<Album> = self.discography().await.unwrap();
        let mut tracks: Vec<Album> = Vec::new();

        for album in discography {
            if album.total_tacks().to_owned() == 1 { tracks.push(album) }
        }
        Ok(tracks)
    }

    /// Async function that call the [Artist::discography] function and returns
    /// all the albums of the [Artist].
    /// # EXAMPLE
    /// ```
    /// let artist: Artist = ArtistBuilder::new().build().await.unwrap();
    /// let albums: Vec<Album> = artist.albums();
    /// println!("{:#?}", albums);
    /// ```
    /// # SUCCESS
    /// Returns a vector of [Album] structs: [`Vec<Album>`].
    /// # ERROR
    /// Returns a dyn Error.
    pub async fn albums(&self) -> Result<Vec<Album>, Box<dyn Error>> {
        let discography: Vec<Album> = self.discography().await.unwrap();
        let mut albums: Vec<Album> = Vec::new();

        for album in discography {
            if album.total_tacks().to_owned() != 1 { albums.push(album) }
        }
        Ok(albums)
    }

    /// Returns a String containing the ID of the [Album].
    pub fn id(&self) -> &String { &self.id }

    /// Returns a String containing the name of the [Album].
    pub fn name(&self) -> &String { &self.name }
}
