Setting up a postgres container for local usage

Docker command

```
docker run --name postgres-container -e POSTGRES_USER=root -e POSTGRES_PASSWORD=root -p 5432:5432 -d postgres
```
