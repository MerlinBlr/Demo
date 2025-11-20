```markdown
# Conventions and Standards

---

## 📝 Release Notes

### Pull Request #16: [AUT-10358] - Implement API for retrieving data from statistic tables
- **Author:** MerlinBlr  
- **State:** Closed  
- **Merged At:** Not merged  
- **Labels:** None  
- **Description:** No description provided  
- **URL:** [View Pull Request #16](https://github.com/MerlinBlr/Demo/pull/16)

#### Ticket Summary

| Key            | Value                              |
|:---------------|:-----------------------------------|
| **Ticket**     | [AUT-10358]                        |
| **Summary**    | Implement API for retrieving data from statistic tables |
| **Status**     | Done                               |
| **Reporter**   | Siarhei Sobol                      |
| **Type**       | Sub-task                           |
| **Project**    | Automic                            |

---

### Pull Request #15: [AUT-10344] - Enhance Main-Workflow Component
- **Author:** MerlinBlr  
- **State:** Closed  
- **Merged At:** Not merged  
- **Labels:** None  
- **Description:** No description provided  
- **URL:** [View Pull Request #15](https://github.com/MerlinBlr/Demo/pull/15)

#### Ticket Summary

| Key            | Value                              |
|:---------------|:-----------------------------------|
| **Ticket**     | [AUT-10344]                        |
| **Summary**    | Enhance Main-Workflow Component    |
| **Status**     | Done                               |
| **Reporter**   | Tim Murko                          |
| **Type**       | Change Request                     |
| **Project**    | Automic                            |

---

## ✅ QA Checklist

- [ ] Verify all new features
- [ ] Check for regression issues
- [ ] Ensure documentation is updated

---

## Useful Links

1. **Naming Conventions** – [TBD: Confluence Page]
2. **Service Directory Structure** – [TBD: Confluence Page]
3. **Service Dependency Documentation** – [TBD: Confluence Page]

---

## Key Updates

- **JUnit 5 Integration:**  
  The `spring-boot-starter-test` now provides JUnit 5 by default. The JUnit 5 vintage engine is included to support existing JUnit 4-based test classes. This allows for gradual migration from JUnit 4 to JUnit 5 within the same module, enabling hybrid test suites.

    _Impact:_ Teams can adopt JUnit 5 features incrementally without breaking existing tests.  
    _Reference:_ [JUnit 5 migration guide](https://junit.org/junit5/docs/current/user-guide/)

- **Testcontainers Adoption:**  
  Integration tests now leverage [Testcontainers](https://www.testcontainers.org) instead of plain Docker commands. Testcontainers enables the automated lifecycle management of test dependencies (such as databases or third-party services) using lightweight, disposable containers in test setups.

    _Impact:_ Simplifies integration test setup, improves repeatability, and reduces test environment flakiness.

---

## Testing Methodologies

- **Unit Testing:** Continue to use standard JUnit 5 for Java unit tests. Existing JUnit 4 tests will remain functional due to the inclusion of the vintage engine.
- **Integration Testing:** Employ Testcontainers to manage containerized dependencies within integration test suites. See the service-specific test directories for configuration examples.
- **Regression Checks:** All new features and critical paths must include both unit and integration tests, and be validated through continuous integration (CI) pipelines.
- **Documentation Requirements:** All new APIs and significant internal logic should be accompanied by clear JavaDoc and markdown documentation updates.

---

## API Documentation

> **Endpoint:** `/api/v1/statistics`  
> **Description:** Retrieve data from statistic tables based on filters and criteria.

### Request

**Method:** `GET`  
**Headers:**

| Key            | Value                                                  |
|:---------------|:------------------------------------------------------|
| Authorization  | `Bearer <Mobile User or Lynx Admin accessToken>`       |
| Content-Type   | `application/json`                                     |

**Query Parameters (example):**
- `table`: The name of the statistics table. (*string*, **required**)
- `fromDate`: Start date for statistics (ISO 8601). (*string*, optional)
- `toDate`: End date for statistics (ISO 8601). (*string*, optional)
- `limit`: Max number of records to return. (*integer*, optional, default: 100)

#### Example Request

```http
GET /api/v1/statistics?table=usage&fromDate=2024-01-01&toDate=2024-01-31&limit=50
Authorization: Bearer eyJhbGciOiJIUzI1NiIs...
Content-Type: application/json
```

---

### Response

**Status:** `200 OK`

```json
{
  "data": [
    {
      "id": 1,
      "timestamp": "2024-01-05T12:34:56Z",
      "metric": "active_users",
      "value": 1023
    },
    ...
  ],
  "total": 30,
  "page": 1,
  "limit": 50
}
```

#### Response Fields

| Field       | Type       | Description                         |
|:------------|:-----------|:------------------------------------|
| data        | array      | Array of statistics records         |
| total       | integer    | Total records matching the filter   |
| page        | integer    | Current page number                 |
| limit       | integer    | Max records returned                |

---

### Error Handling

| Status Code | Description          | Example                                                                |
|:------------|:---------------------|:-----------------------------------------------------------------------|
| 400         | Bad Request          | `{"error": "Missing required parameter: table"}`                       |
| 401         | Unauthorized         | `{"error": "Invalid or expired access token"}`                         |
| 404         | Not Found            | `{"error": "Statistics table not found"}`                              |
| 500         | Internal Server Error| `{"error": "Unexpected error, please try again later."}`               |

---

## Example Header Table

| Key           | Value                                             |
|:--------------|:-------------------------------------------------|
| Authorization | Bearer <Mobile User or Lynx Admin accessToken>    |
| Content-Type  | application/json                                  |

---

## Additional Context and Impact

- **Why These Changes Matter:**  
  The introduction of a dedicated API for statistics unlocks real-time access to analytical tables, simplifying data querying for both web and mobile clients. The enhanced workflow component ([AUT-10344]) improves orchestration and error handling in core logic, reducing operational friction.
- **Migration Guidance:**  
  If you maintain test code bases on JUnit 4, begin incrementally migrating to JUnit 5 for enriched features. Leverage Testcontainers for reproducible, reliable integration tests.

---
```