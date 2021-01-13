# To Run with H2 Embedded
No need to do anything!

# To Run with Postgres
- start the postgres docker container:  
`docker run --name jobrunr-postgres -p 5432:5432 -e POSTGRES_USER=jobrunr -e POSTGRES_PASSWORD=jobrunr -d postgres`

- uncomment the postgres properties in `application.properties` and comment those of H2
