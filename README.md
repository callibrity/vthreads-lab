

## Using Postgres via Docker

```shell
docker run --rm --name vthreads-db -e POSTGRES_PASSWORD=vthreads -e POSTGRES_USER=vthreads -d -p 5432:5432 postgres
```