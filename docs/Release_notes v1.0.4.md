```markdown
# 📝 Release Notes

## Overview

These release notes summarize the work completed as part of the latest development cycle for the **Automic** project. This release focuses on enhancing backend data retrieval capabilities and improving core workflow components. Additionally, it introduces notable updates to our testing infrastructure. Please review the QA checklist to ensure all changes meet project standards before closing the release.

---

## 🚀 Key Updates

- * JUnit 5 Integration *  
   - The `spring-boot-starter-test` now provides JUnit 5 by default.
   - The JUnit 5 "vintage" engine is included automatically, enabling continued support for existing JUnit 4-based test classes.
   - You can now run both JUnit 4 and JUnit 5 test classes within the same module, facilitating incremental migrations to JUnit 5.

- * Testcontainers for Integration Testing *  
   - Integration tests now utilize [Testcontainers](https://www.testcontainers.org) instead of plain Docker, leading to improved test isolation and environment portability.

---

## 🔖 Pull Requests

| Pull Request | Summary                                                                 | Author      | Status  | URL                                                                                       |
|:-------------|:------------------------------------------------------------------------|:------------|:--------|:------------------------------------------------------------------------------------------|
| #16          | [AUT-10358] - Implement API for retrieving data from statistic tables   | MerlinBlr   | Closed  | [View Pull Request #16](https://github.com/MerlinBlr/Demo/pull/16)                        |
| #15          | [AUT-10344] - Enhance Main-Workflow Component                          | MerlinBlr   | Closed  | [View Pull Request #15](https://github.com/MerlinBlr/Demo/pull/15)                        |

---

## 🗂 Ticket Summaries

### [AUT-10358] - Implement API for retrieving data from statistic tables
- **Type:** Sub-task
- **Status:** Done
- **Reporter:** Siarhei Sobol
- **Project:** Automic
- **Summary:** Developed and integrated a new API endpoint to retrieve data efficiently from the statistics tables, supporting enhanced data visibility and downstream analytics.

---

### [AUT-10344] - Enhance Main-Workflow Component
- **Type:** Change Request
- **Status:** Done
- **Reporter:** Tim Murko
- **Project:** Automic
- **Summary:** Refactored and improved the main workflow component to better support extensibility, maintainability, and future enhancements.

---

## 🔎 QA Checklist

- [ ] **Verify all new features:** Ensure all recent features function as intended.
- [ ] **Check for regression issues:** No existing functionality should be inadvertently affected.
- [ ] **Ensure documentation is updated:** All new features and changes are reflected in the relevant documentation.

---

## 📎 Useful Links

1. Naming conventions and best practices
2. Service Directory Structure guidelines
3. [Service Dependency Documentation](#) (add actual link)

---

## 📋 API Usage Example

| Key            | Value                                                               |
|----------------|---------------------------------------------------------------------|
| Authorization  | Bearer &lt;Mobile User or Lynx Admin accessToken&gt;                |
| Content-Type   | application/json                                                    |

---

> **Note:**  
> For a detailed list of changes, refer to the individual pull request descriptions.  
> Enhancement requests and bug reports should be raised via the project’s ticketing system.

---

**End of Release Notes**
```
