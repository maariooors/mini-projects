use std::env;
use reqwest::Client;
use std::error::Error;
use http::header::CONTENT_TYPE;
use serde::{Deserialize, Serialize};

use crate::config::Config;

/// Struct needed to authenticate the user request every time
/// a petition is done to the Spotify API.
///
/// Necessary use of [Token::build] function to generate the token.
#[derive(Serialize, Deserialize, Debug)]
pub struct Token {
    access_token: String,
}

#[allow(dead_code)]
impl Token {

    /// Async function that generates a token associated with
    /// the [Config] to authenticate every petition.
    /// # EXAMPLE
    /// ```
    /// let token: Token = Token::build().await.unwrap();
    /// ```
    /// # SUCCESS
    /// Returns a [Token] struct.
    /// # ERROR
    /// Returns a dyn error.
    pub async fn build() -> Result<Token, Box<dyn Error>> {
        let id: String = env::var("CLIENT_ID").unwrap();
        let secret: String = env::var("CLIENT_SECRET").unwrap();
        let body: String = "grant_type=client_credentials&client_id=".to_string()
            + id.as_ref()
            + "&client_secret="
            + secret.as_ref();

        let token = Client::new()
            .post("https://accounts.spotify.com/api/token")
            .header(CONTENT_TYPE, "application/x-www-form-urlencoded")
            .body(body)
            .send().await?
            .text().await?;

        let token: Token = serde_json::from_str(token.as_str())?;
        Ok(token)
    }

    /// Returns a String containing the access token of the [Config].
    pub fn access_token(&self) -> &String { &self.access_token }
}
