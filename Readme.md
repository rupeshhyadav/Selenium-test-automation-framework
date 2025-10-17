
# Selenium Test Automation Framework

This is a java based selenium automation framework that leverages various libraries and tools to facilitate data-driven testing, logging, reportin and integration with cloud-based testing platforms like lambdaTest. 


## Author

- [@rupeshhyadav](https://github.com/rupeshhyadav)


## Language
Java 11
## Prerequisites
Before running this framework, ensure the following softwares are installed on your system :
- Java 11
- Maven

## Features
- Data-driven testing
- Cross browser testing
- Headless mode
- Cloud testing
- Logging
- Reporting

## Techologies Used
- Java 11
- TestNG
- OpenCsv
- Gson
- Apache POI
- Faker
- LambdaTest
- Log4j
- Extent Report


## Setup Instructions

**Clone the repository**

```bash
  git clone https://github.com/rupeshhyadav/Selenium-test-automation-framework.git

  cd Selenium-test-automation-framework
```

**Running on lambda test**

```bash
 mvn clean test -DislamdaTest=true -Dbrowser=chrome -DisHeadless=false
```

**Running on local machine**

```bash
 mvn clean test -DislamdaTest=false -Dbrowser=chrome -DisHeadless=false
```
    
## Reports and Logs
- Reports - After execution reports will be generated at ./ExtentReport.html
- Logs - created at ./logs directory

## Integration with GitHub Actions
- This framework is integrated with GitHub Actions and reports will be archieved in gh-pages branch and can be viewed at  :
``https://rupeshhyadav.github.io/Selenium-test-automation-framework/ExtentReport.html``
