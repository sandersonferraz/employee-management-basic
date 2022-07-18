# Employee management basic.

This is a simple employee register.
The following is a script in docker-compose.yml to build a container with PostgreSQL.

-    - ```
          version: '3.1'
          
          services:
          
            db:
              image: postgres:12-alpine
              container_name: "dbemployeemanagement"
              environment:
                POSTGRES_USER: postgres
                POSTGRES_PASSWORD: postgres
                POSTGRES_DB: dbemployeemanagementbasic
              volumes:
          
             - "./data/postgres:/var/lib/postgresql/data"
               rts:
                  - 5432:5432
          ```



- Endpoints:
    1. http://localhost:8080/employee/add
    2. http://localhost:8080/employee/update
    3. http://localhost:8080/employee/delete/{id}
    4. http://localhost:8080/employee/all
    5. http://localhost:8080/employee/{id}