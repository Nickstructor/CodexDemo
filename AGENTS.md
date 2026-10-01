# Course Registration Workshop
This is a student Java console application. Work only on the requested task.
## Constraints
- Use Java 17 compatible syntax and the standard JDK only. Java 26 may run the project.
- Do not add Maven, Gradle, JUnit, frameworks, or third-party libraries.
- Keep the existing packages and use readable loops and descriptive names.
- Put business rules in services, collection access in repositories, and interaction in ConsoleMenu.
- Preserve unrelated behavior and sample records. Use fresh in-memory fixtures for tests. Do not add file storage.
## Coding standards
- Use clear, descriptive variable, method, and class names that explain their purpose. Follow Java naming conventions: camelCase for variables and methods, PascalCase for classes, and UPPER_SNAKE_CASE for constants.
- Add comments where they help explain intent, business rules, or non-obvious logic. Keep comments accurate and avoid repeating what the code already says.
- Change other classes only when necessary to complete the requested task. Avoid unrelated refactoring, formatting changes, or cleanup.
## Workflow
- Inspect relevant code and README before editing.
- If the task asks for investigation or a plan only, do not edit files. Wait for the next instruction.
- Implement the smallest change that satisfies the acceptance criteria.
- Add behavioral regression tests for changed rules. Never weaken assertions to make tests pass.
- Compile with javac -d out @sources.txt and run java -cp out AllTests.
- Report changed files, commands and actual results. State checks you could not run.
## Scope
Do not repair other issues discovered during a task without first reporting them.
