# octo-events

## Getting started

- Install [Docker](https://docs.docker.com/v17.09/engine/installation/).

- Install [Docker Compose](https://docs.docker.com/compose/install/).

## Running

- Get the server up by using docker-compose:

    From the project root folder use `docker-compose up` or `docker-compose up -d` (use the last one for running in background)
    
If you are using a default configuration, your server is running on `http://localhost:8500`

## Available endpoints

`octo-events` has two endpoints available:

- [GET] `/issues/:issueId/events`:
    Gets all events related to an issue based on issue ID.

- [POST] `/`: Stores an event related to an issue in octo-events database.

## Github integration
You can use [ngrok](https://ngrok.com/) to get a public URL to your local server. Just set this URL as your `payload URL` in your Github repository webhook.



