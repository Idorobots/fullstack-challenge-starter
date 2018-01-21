# obstacle-course-solver
A full-stack-ish technical challenge for a company.

## Backend part
To run the included tests (hopefuly I wrote some ¯\_(ツ)_/¯) run either of the following commands:

```
sbt clean-test
```

To build & package the project:

```
sbt clean-compile
sbt docker:publishLocal
```

Ensure that the Docker daemon is up an running in order to create an image. The image will be based on `phusion:basebox` so it'll download a bit of crap on the first run. To then run the backend run either command:

```
sbt run
docker run -p 1234:1234 -e REST_HOST=0.0.0.0 -e REST_PORT=1234 -e LOG_LEVEL=DEBUG obstacle-course:latest
```
