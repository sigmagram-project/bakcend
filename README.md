# Image Board — Backend

Java 17 + Spring Boot 3 + Spring Data JPA + Maven. No authentication.
Images are stored as blobs directly in PostgreSQL.

## Run it

1. Start the database (from this folder):
   ```
   docker compose up -d
   ```
2. Start the app:
   ```
   mvn spring-boot:run
   ```
   Runs on http://localhost:8080.
3. Run tests (uses an in-memory H2 DB, no Docker needed):
   ```
   mvn test
   ```