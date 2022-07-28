# JPMorgan Chase Tech Test

This automation framework has been implemented using Selenium Webdriver (Java), TestNG and Maven using a custom Component-based Page Object Model.

Prerequisites:
- Git
- Maven
- Java 11+ (might work from v8, but haven't tested it)

## Setup and running

- Clone the repository
- Run `mvn test` in the command-line (in project root folder)

## Component based page object model
This automation framework has been prepared to use a Component-based Page Object Model.
Each component in the web application being tested should mirror a component object in the automation code.

Each component should be a `class` that extends the base `Component`.
This base class contains the initial abstraction layer for interaction between the tests and the test automation framework (can be used with other Java based automation frameworks and implementations).
Any function relevant to all components should be stored in the `Component` object.

## If I had more time

- Add a couple more scenarios (eg.: navigate to second page of google results and evaluate results there)
- Optimise the checks against fake articles (currently only checks for number of words that match results)
  - Open result page and verify whole page words for matching references
  - Open The Guardian article to fetch more words for verification against the Google Search results
- Configure dependency injection to pass results/article headline across multiple scenarios (eg: picocontainer)
- Implement a better ElementList object manipulation
- Improve hierarchy of components (i.e. parent/children abstraction in components)
- Improve this documentation
- Add reporting to test results
