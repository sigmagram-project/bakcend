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

## Layout

```
backend/
├── docker-compose.yml            Postgres for local dev
├── src/main/java/.../
│   ├── controller/                4 controllers = the 4 tasks (placeholders)
│   ├── entity/                    JPA entities (done)
│   ├── repository/                Spring Data repos (done)
│   ├── dto/                       Request/response DTOs (done)
│   └── config/CorsConfig.java     Allows the Vite dev server to call the API (done)
├── src/test/java/.../controller/  Test placeholders, one class per task
└── src/test/resources/
    ├── application-test.yml       H2 config for tests (done)
    └── qa-test-plan.md            QA placeholder — manual test cases
```

## The 4 tasks (backend side)

Find every placeholder with:
```
grep -rn "PLACEHOLDER" src
```

| Task | Controller | Tests |
|------|-----------|-------|
| 1. Upload an image & serve it | `controller/ImageController.java` | `controller/ImageControllerTest.java` |
| 2. Like / unlike | `controller/LikeController.java` | `controller/LikeControllerTest.java` |
| 3. Comment | `controller/CommentController.java` | `controller/CommentControllerTest.java` |
| 4. Feedback | `controller/FeedbackController.java` | `controller/FeedbackControllerTest.java` |

Each controller method currently throws `UnsupportedOperationException` —
that's the placeholder. Each test class has empty `@Test` methods marked
`// TODO: implement`.

## QA

Manual test case tables live at `src/test/resources/qa-test-plan.md`, one
section per task. QA fills in steps, expected results, and pass/fail once a
task's implementation is ready to test.

## Design decisions already made for you

- No login — likes are a plain counter on the image, not tied to a user.
- Images: `POST /api/images` (multipart upload) → stored as `byte[]` in
  Postgres; `GET /api/images/{id}/data` streams them back for `<img src>`.
- `spring.jpa.hibernate.ddl-auto: update` auto-creates the schema — fine for
  this assignment, not for production.
