# BTA TA Technical Assessment

## Requirements

- Java 8
- Maven
- Chrome

### Dependencies

- Selenide 6.10.0
- TestNG 7.6.0
- Allure 2.21.0

All dependencies and versions are listed in the `pom.xml`

## Setup

### Clone Repository

- `git clone https://github.com/ubahobs/bta-demo.git`
- `bta-demo`

### Install Dependencies

- `mvn clean install`

## Running tests

Inside root of the project run:

- `mvn test`

## Reporting

In order to open allure report, run:

- `allure generate allure-results --clean`
- `allure serve allure-results`

## Test Configuration

Inside `src/test/resources/test-config/project.properties` located all project related properties, like:

- Browser
- URLs
- Timeouts
- etc

### Overriding Configurations

You can override configurations for the test run via:

- `mvn test -Dtimeout=20 -DbaseUrl=https://staging.example.com`

## Findings and Challenges

### Key Findings

1. **Rental Car option auto select:** after click on `edit settings` button, rental car option selects automatically. 
2. **Home page lacks of stable selectors**: in our case `travel` insurance options does not have any reliable selector(e.g. id, class or any other uniq html property).

### Challenges 

1. **Selenide automatic scrolling issue**: The Selenide scrollTo() (or automatic scroll on click()) method did not work as expected due to dynamic DOM changes (most probably). The issue was resolved using the Selenium Actions class for scrolling.
