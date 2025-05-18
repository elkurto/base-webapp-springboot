# base-webapp-springboot
a base project with SpringMVC (REST) and test support

### references
- Spring Boot 3 Recipes
  - https://link.springer.com/979-8-8688-0113-6
  - https://github.com/Apress/Deinum_Spring-Boot-3-Recipes/tree/main
- Pro Spring 6
  - https://link.springer.com/978-1-4842-8640-1
  - https://github.com/Apress/pro-spring-6/tree/main
- [Guide to JPA in SpringBoot](https://medium.com/@bshiramagond/jpa-with-spring-boot-a-comprehensive-guide-with-examples-e07da6f3d385)
- [Spring Data JPA from broadcom](https://spring.io/projects/spring-data-jpa)


## setup 

### postgres in docker (desktop)

#### postgres in docker
src= https://www.docker.com/blog/how-to-use-the-postgres-docker-official-image/
src= https://hub.docker.com/_/postgres
src= https://github.com/docker-library/postgres
src= https://www.postgresql.org/docs/current/app-psql.html


1. pull the image
  ```bash
   docker pull postgres:17.5-alpine
  ```
2. create the container
  ```bash
  docker run --name containername -e POSTGRES_PASSWORD=mypassword \
   -e POSTGRES_DB=mydatabasename -e POSTGRES_USER=myusername \
   -p 5432:5432 -d postgres:17.5-alpine
  ```



3. connect to the container via psql  (nb: u must install psql)
  ```bash
   PGPASSWORD=mypassord psql -h myhostname -d mydatabasename -U myusername -p 5432
  ```
4. validate
  ```
  exomission=# create table foo (id bigint PRIMARY KEY NOT NULL, name VARCHAR(25), n int, m int);
  CREATE TABLE
  
  exomission=# insert into foo (id,name, n,m) values (1, 'chud', 2, 3);
  INSERT 0 1
  
  exomission=# select * from foo;
  id | name | n | m
  ----+------+---+---
  1 | chud | 2 | 3
  (1 row)
  
  ```



```sql
create table Book (id uuid PRIMARY KEY not null, name varchar(128), author varchar(128), created_at bigint);



```
