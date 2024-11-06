use std::env;

/// Main struct that configures all the relevant keys needed for
/// the API to work.
#[derive(Debug, Default)]
pub struct Config {
    pub client_id: String,
    pub client_secret: String,
    pub artist_id: String,
}

impl Config {

    /// Returns a [Config] struct with the [default] trait.
    pub fn new() -> Config { Config::default() }

    /// Returns a [Config] struct containing both user keys and the artist ID
    /// needed for all the request de API does.
    ///
    /// It sets both the keys and the ID as [env] variables, soo there is no need
    /// to pass as a parameter the keys everytime a request is done.
    /// # NOTES
    /// Read the Spotify developer API to know how to get your user keys.
    /// # EXAMPLE
    /// ```
    /// let user_id: String = String::from("xxxxxxxxxxxxxxxxx");
    /// let user_secret: String = String::from("xxxxxxxxxxxxxxxxx");
    /// let artist_id: String = String::from("xxxxxxxxxxxxxxxxx");
    ///
    /// let config: Config = Config::new()::build(user_id, user_secret, artist_id);
    /// println!(":#?", config);
    /// ```
    /// # SUCCESS
    /// Returns the [Config] struct and sets the arguments as [env] variables.
    /// # ERROR
    /// Panics due to an error in the [env] variable set.
    pub fn build(self, id: String, secret: String, artist_id: String) -> Self {

        env::set_var("CLIENT_ID", &id);
        env::set_var("CLIENT_SECRET", &secret);
        env::set_var("ARTIST_ID", &artist_id);

        Config {
            client_id: id,
            client_secret: secret,
            artist_id,
        }
    }
}
