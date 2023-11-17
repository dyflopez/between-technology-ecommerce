# Ecommerce Between Tech

Este proyecto es un test técnico para Between Technology.

## Comando para crear el contenedor

- `mvn clean`
- `mvn package`
- `docker build -t img_between_ecommerce:V1 .`
- `docker run -d -p 9092:9092 --name ms-ecommerce img_between_ecommerce:V1`
- ## Comando para subir el contenedor al dockerhub
- `docker login`
- `docker tag img_between_ecommerce:V1 daniel0223/img_between_ecommerce:V1`
- `docker push daniel0223/img_between_ecommerce:V1`

## instalar aplicacion en local

1. Opcion uno para crear el contenedor
- `docker run -d -p 9092:9092 --name ms-between-ecommerce daniel0223/img_between_ecommerce:V1`
2. Opcion uno para crear el contenedor
- `docker run -d -p 9092:9092 --env-file .env --name ms-between-ecommerce-v1 img_between_ecommerce:V1`


## Acceso al Backend local

## Validar estado de salud del servicio

http://localhost:9092/actuator/health

## Swagger

http://localhost:9092/swagger-ui/index.html#/
- explore esribir  "/between-doc"

## Acceso al Backend AWS

## Validar estado de salud del servicio

http://54.167.235.142:9092/actuator/health

## Swagger

http://54.167.235.142:9092/swagger-ui/index.html#/
- explore esribir  "/between-doc"
- 
La aplicación estará disponible en la siguiente URL:
- local

[http://localhost:9092/swagger-ui/index.html#/](http://localhost:9092/swagger-ui/index.html#/)

path ver controladores

/between-doc

Validar estado de salud del servicio

[http://localhost:9092/actuator/health](http://localhost:9092/actuator/health)



## Tecnologías Utilizadas

- [Spring Boot](https://spring.io/projects/spring-boot) - Framework de desarrollo de aplicaciones Java.
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa) - Acceso a datos mediante el estándar de JPA.
- [Hibernate](https://hibernate.org/) - Framework de mapeo objeto-relacional.
- [Maven](https://maven.apache.org/) - Herramienta de gestión de proyectos y construcción.
- [H2](https://www.h2database.com/html/main.html) - Base de datos embebida.
- [Swagger](https://swagger.io/) - Herramienta de documentación y diseño de APIs.
- [Docker](https://www.docker.com/) - Plataforma para desarrollar, enviar y ejecutar aplicaciones.
- [AWS](https://aws.amazon.com/es/) - Amazon Web Services.
- [Postman](https://www.postman.com/) - Plataforma de colaboración para el desarrollo de APIs.
- [Mockito](https://site.mockito.org/) - Marco de prueba de Java.
- [JUnit](https://junit.org/junit5/) - Marco de prueba para el lenguaje de programación Java.



## Configuración
- Actualiza las configuraciones de la base de datos en el archivo `application.properties` según sea necesario o .env
