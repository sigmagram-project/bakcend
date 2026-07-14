# QA Test Plan — Image Board

## PLACEHOLDER: QA TEAM

This file is the QA team's workspace. For each task below, once the
backend/frontend implementation is ready:

1. Write manual test cases (steps, expected result) in the tables provided.
2. Execute them and record pass/fail + notes.
3. File bugs for anything that fails, referencing the case ID.

Fill in the `TODO` cells. Add as many rows as you need.

---

## Task 1 — Upload an image and display it in the frontend

| ID | Steps | Expected result | Pass/Fail | Notes |
|----|-------|------------------|-----------|-------|
| T1-01 | TODO | TODO | TODO | |
| T1-02 | TODO: upload a non-image file | Should be rejected with a clear error | TODO | |
| T1-03 | TODO: upload a very large file | TODO | TODO | |

## Task 2 — Like and unlike the image

| ID | Steps | Expected result | Pass/Fail | Notes |
|----|-------|------------------|-----------|-------|
| T2-01 | TODO | TODO | TODO | |
| T2-02 | TODO: rapid double-click like/unlike | Count stays consistent, no race condition | TODO | |
| T2-03 | TODO: like count after page refresh | Count persists (loaded from backend) | TODO | |

## Task — Comment on the image

| ID | Steps | Expected result | Pass/Fail | Notes |
|----|-------|------------------|-----------|-------|
| T3-01 | TODO | TODO | TODO | |
| T3-02 | TODO: submit an empty comment | Should be blocked client-side and/or server-side | TODO | |
| T3-03 | TODO: comment ordering | Comments appear in chronological order | TODO | |

## Task 4 — Closing the page and asking for feedback

| ID | Steps | Expected result | Pass/Fail | Notes |
|----|-------|------------------|-----------|-------|
| T4-01 | TODO | TODO | TODO | |
| T4-02 | TODO: skip feedback | Page closes/continues without submitting | TODO | |
| T4-03 | TODO: submit feedback | Feedback is persisted (verify via DB or backend logs) | TODO | |

---

## Cross-cutting checks (fill in as needed)

- [ ] TODO: Responsive layout on a smaller viewport
- [ ] TODO: Basic accessibility pass (keyboard navigation, alt text on images)
- [ ] TODO: Error states are user-friendly (no raw stack traces shown)
