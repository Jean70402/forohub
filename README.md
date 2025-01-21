# ForoHub API REST ✨

## Descripción

Este proyecto es una API REST desarrollada en Java utilizando Spring Boot. Forma parte del desafío final para el Challenge Back-End de Alura y tiene como objetivo la gestión de tópicos en un foro. La API incluye funcionalidades esenciales como autenticación, creación, lectura, actualización y eliminación de tópicos, además de seguir buenas prácticas de desarrollo y seguridad.

## Características principales 🌐

- **CRUD de Tópicos**:
  - Registrar un nuevo tópico
  - Listar todos los tópicos
  - Actualizar tópicos existentes
  - Eliminar tópicos

- **Autenticación y seguridad**:
  - Implementación de JSON Web Tokens (JWT) para el inicio de sesión y la protección de rutas.
  - Uso de contraseñas almacenadas en la base de datos.

- **Base de datos**:
  - Integración con MySQL.
  - Migraciones gestionadas con Flyway.

- **Documentación y pruebas**:
  - Documentación interactiva con OpenAPI (Swagger).
  - Endpoints listos para ser probados directamente desde la documentación.
  - Casos de prueba con Spring Boot Test y Spring Security Test.

## Tecnologías y herramientas 🛠️

- **Spring Boot 3.4.1**
- **Java 17**
- **Maven**
- **MySQL**
- **Spring Security**
- **JSON Web Tokens (JWT)**
- **Lombok**
- **Flyway**
- **SpringDoc OpenAPI**
- **JUnit y Mockito**

## Requisitos previos 🔧

Asegúrate de tener instalados los siguientes programas:

- Java 17 o superior.
- Maven.
- MySQL.

## Configuración inicial ⚙️

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tu-usuario/forohub.git
   cd forohub
   ```

2. Configura la base de datos en `application.properties` o `application.yml`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/forohub
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña

   spring.jpa.hibernate.ddl-auto=validate
   spring.flyway.enabled=true
   spring.flyway.locations=classpath:db/migration
   ```

3. Ejecuta las migraciones con Flyway:
   ```bash
   mvn flyway:migrate
   ```

4. Ejecuta la aplicación:
   ```bash
   mvn spring-boot:run
   ```

## Endpoints principales 🔠

| Método | Endpoint           | Descripción                     |
|--------|--------------------|---------------------------------|
| POST   | `/auth/login`      | Autenticación mediante JWT      |
| POST   | `/topics`          | Registrar un nuevo tópico       |
| GET    | `/topics`          | Listar todos los tópicos        |
| PUT    | `/topics/{id}`     | Actualizar un tópico existente  |
| DELETE | `/topics/{id}`     | Eliminar un tópico existente    |

Consulta la documentación completa en `/swagger-ui.html`.

## Dependencias principales ♻️

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>com.auth0</groupId>
        <artifactId>java-jwt</artifactId>
        <version>4.4.0</version>
    </dependency>
    <dependency>
        <groupId>org.flywaydb</groupId>
        <artifactId>flyway-core</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.8.3</version>
    </dependency>
</dependencies>
```

## Contribuciones 🌈

Si deseas contribuir a este proyecto, no dudes en realizar un fork y enviar un pull request. ¡Toda ayuda es bienvenida!

## Autor 👨‍💻

Este proyecto fue desarrollado como parte del Challenge Back-End de Alura. Creado por Jean704.



