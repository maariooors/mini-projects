use serde::{Deserialize, Serialize};

use crate::artist::Artist;

/// Structure containing all relevant information regarding a [Track].
#[derive(Deserialize, Serialize, Debug, Default)]
pub struct Track {
    id: String,
    name: String,
    artists: Vec<Artist>,
}

#[allow(dead_code)]
impl Track {

    /// Returns a vector of [Artist] structs containing the artist of the [Track].
    pub fn artists(&self) -> &Vec<Artist> { &self.artists }

    /// Returns a String containing the ID of the [Track].
    pub fn id(&self) -> &String { &self.id }

    /// Returns a String containing the name of the [Track].
    pub fn name(&self) -> &String { &self.name }
}