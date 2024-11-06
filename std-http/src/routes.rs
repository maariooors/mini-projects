use std::path::Path;
use crate::response::Response;


#[allow(dead_code)]
#[derive(Debug)]
pub struct Route {
    path: String,
}


impl Route {
    pub fn validate(route: &str) -> Result<String, Response> {
        if Path::new(&("static/".to_string() + route)).exists() == true {

            if route == "/" {
                return Ok("index.html".to_string())
            }
            return Ok(route.to_string());
        }
        Err(Response::not_found())
    }
}