# Fullstack Challenge

A full-stack-ish technical challenge for a company.

## Backend part
To run the included tests (hopefuly I wrote some ¯\\\_(ツ)\_/¯) run either of the following commands:

```
sbt clean-test
```

To build & package the project:

```
sbt clean-compile
sbt docker:publishLocal
```

Ensure that the Docker daemon is up an running in order to create an image. The image will be based on `phusion:basebox` so it'll download a bit of crap on the first run. To then run the backend execute either command:

```
sbt run
docker run -p 8081:1234 -e REST_HOST=0.0.0.0 -e REST_PORT=1234 -e LOG_LEVEL=DEBUG fullstack-challenge-be:latest
```

## Frontend part
To run the tests:

```
npm run test # Runs the tests inside of Firefox & Chrome.
npm run test:ci # Runs tests inside of a headless browser.
npm run test:watch # Runs the tests in an interactive mode - suitable for development.
```

To build the project:

```
npm run build # Builds a debug version of the project.
npm run build:release # Builds a "release" "optimized" version of the project.
npm run build:watch # Rebuilds the project automatically on any source changes.
```

To package the project with Docker ensure that the Docker daemon is running and run:

```
npm run package
```

To run the project after building the image simply execute:

```
docker run -p 8080:80 -e BACKEND_URL="localhost:8081" fullstack-challenge-fe:latest
```

(Alternatively, you can start a static file server inside of the `dist` directory instead of building a Docker image for the frontend.)

Once everything is set up, you can browse `localhost:8080` for the challenge submition.
