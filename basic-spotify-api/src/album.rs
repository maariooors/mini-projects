use reqwest::Client;
use std::error::Error;
use serde::{Deserialize};
use http::header::AUTHORIZATION;

use crate::token::Token;
use crate::track::Track;
use crate::artist::{Artist};

/// Structure containing all relevant information regarding an [Album].
#[derive(Deserialize, Debug)]
pub struct Album {
    id: String,
    name: String,
    total_tracks: i32,
    artists: Vec<Artist>,
    release_date: String,
}

/// Aux structure used to parse the JSON filed "items" of the function [`Album::tracks`].
#[derive(Deserialize, Debug)]
struct Items {
    items: Vec<Track>,
}

#[allow(dead_code)]
impl Album {

    /// Async function that returns all the album's tracks.
    /// # EXAMPLE
    /// ```
    /// let track: Vec<Track> = album.tracks().await.unwrap();
    /// println!("{:#?}", tracks);
    /// ```
    /// # SUCCESS
    /// Returns a vector of Track structs: [`Vec<Track>`].
    /// # ERROR
    /// Returns a dynamic error.
    pub async fn tracks(&self) -> Result<Vec<Track>, Box<dyn Error>> {
        let token: Token = Token::build().await.unwrap();
        let mut tracks: Vec<Track> = Vec::new();

        let request = Client::new()
            .get("https://api.spotify.com/v1/albums/".to_string() + &self.id + "/tracks\
            ?limit=50")
            .header(AUTHORIZATION, "Bearer ".to_string() + token.access_token())
            .send().await?
            .text().await?;

        let request: Items = serde_json::from_str(request.as_str())?;
        for track in request.items { tracks.push(track) }
        Ok(tracks)
    }

    /// Returns a vector of [Artist] struct: [`Vec<Artist>`].
    pub fn artists(&self) -> &Vec<Artist> { &self.artists }

    /// Returns a String containing the id of the [Album].
    pub fn id(&self) -> &String { &self.id }

    /// Returns a String containing the name of the [Album].
    pub fn name(&self) -> &String { &self.name }

    /// Returns a String containing the release date of the [Album].
    pub fn release_date(&self) -> &String { &self.release_date }

    /// Returns an i32 type containing the number of tracks on the [Album].
    pub fn total_tacks(&self) -> &i32 { &self.total_tracks }
}
