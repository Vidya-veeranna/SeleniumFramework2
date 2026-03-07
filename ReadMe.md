# Selenium Automation Framework

## 📋 Project Overview

A comprehensive **Selenium-based test automation framework** built with Java, designed to perform functional and regression testing of web applications. This framework implements industry-standard best practices including the **Page Object Model (POM)** pattern, robust error handling, detailed test reporting, and data-driven testing capabilities.

The framework is ideal for automating tests across multiple browsers and generating detailed HTML reports with screenshots for test failures.

---

## 🛠️ Technologies & Tools Used

| Technology | Version | Purpose |
|-----------|---------|---------|
| **Selenium WebDriver** | 4.41.0 | Web browser automation |
| **TestNG** | 7.12.0 | Test execution and management framework |
| **Java** | 1.7+ | Programming language |
| **Apache Maven** | Latest | Build and dependency management |
| **ExtentReports** | 5.1.2 | Advanced HTML test reporting |
| **Apache POI** | 5.5.1 | Excel data-driven testing support |
| **WebDriverManager** | 6.3.3 | Automatic WebDriver binary management |
| **JUnit** | 4.11 | Unit testing framework |

---

## ✨ Key Features

✅ **Page Object Model (POM)** - Maintainable and scalable test structure  
✅ **Data-Driven Testing** - Excel-based test data using Apache POI  
✅ **Cross-Browser Testing** - Support for Chrome, Firefox, Edge, Safari  
✅ **Automatic Reporting** - Detailed HTML reports with ExtentReports  
✅ **Screenshot Capture** - Automatic screenshots on test failure  
✅ **Configuration Management** - Externalized config.properties file  
✅ **Test Listeners** - Custom TestNG listeners for enhanced logging  
✅ **Reusable Utilities** - BrowserFactory, ScreenshotUtils, ConfigDataProvider  

---

## 📁 Project Structure

```
seleniumframework/
│
├── pom.xml                          # Maven configuration & dependencies
├── testng.xml                       # TestNG suite configuration
├── ReadMe.md                        # This file
│
└── src/
    ├── main/
    │   └── java/com/selenium/      # Main source code (if needed)
    │
    └── test/
        ├── java/com/selenium/
        │   ├── base/
        │   │   └── BaseTest.java                # Base class with setup/teardown
        │   ├── pages/
        │   │   └── LoginPage.java               # Page Object classes
        │   ├── tests/
        │   │   └── LoginTests.java              # Test classes
        │   └── utils/
        │       ├── BrowserFactory.java          # Browser initialization & management
        │       ├── ConfigDataProvider.java      # Read config.properties
        │       ├── ExcelUtils.java              # Excel file operations
        │       ├── ExtentManager.java           # ExtentReports configuration
        │       ├── ScreenshotUtils.java         # Screenshot capture logic
        │       └── TestListeners.java           # TestNG event listeners
        │
        └── resources/
            └── config.properties                # Configuration file (URL, browser)

└── target/                          # Build output (auto-generated)
```

---

## 📋 Prerequisites

Before running this framework, ensure you have the following installed:

### **System Requirements**
- **Operating System**: Windows, macOS, or Linux
- **Java Development Kit (JDK)**: Version 8 or higher
  - [Download JDK](https://www.oracle.com/java/technologies/downloads/)
  - Verify: `java -version`
- **Apache Maven**: Version 3.6.0 or higher
  - [Download Maven](https://maven.apache.org/download.cgi)
  - Verify: `mvn -version`
- **Git**: For version control (optional)
  - [Download Git](https://git-scm.com/)

### **Environment Variables** (Windows)
```
JAVA_HOME = C:\Program Files\Java\jdk-xxx
MAVEN_HOME = C:\apache-maven-xxx
```
Add both `%JAVA_HOME%\bin` and `%MAVEN_HOME%\bin` to your **PATH** environment variable.

---

## ⚙️ Installation & Setup

### **1. Clone or Download the Project**
```bash
git clone <repository-url>
cd seleniumframework
```

### **2. Verify Java & Maven Installation**
```bash
java -version
mvn -version
```

### **3. Download Dependencies**
Maven will automatically download all required dependencies when you run tests. To explicitly download them:
```bash
mvn clean install
```

### **4. Update Configuration File**
Edit `src/test/resources/config.properties` with your test environment details:
```properties
# Web application URL to test
url=http://example.com

# Browser name (chrome, firefox, edge, safari)
browser=chrome

# Optional: Add more configuration as needed
# timeout=10
# headless=false
```

---

## 🚀 How to Run Tests

### **Run Tests in Parallel**
Modify `testng.xml`:
```xml
<suite name="Suite" parallel="classes" thread-count="4">
```

---

## 📊 Test Reports

### **Extent Report Generation**
Test reports are automatically generated in HTML format after each test run.

**Report Location**: `resources/extent-report.html`

**Report Features**:
- ✅ Test execution summary (Passed/Failed/Skipped)
- 📊 Pie charts and graphs for test results
- 📸 Screenshots for failed tests
- 📝 Detailed logs for each test step
- ⏱️ Execution time tracking

The report automatically opens in your default browser after tests complete.

---

## 🔧 Framework Architecture

### **Page Object Model (POM)**
Each web page is represented as a class with:
- Web element locators as private variables
- Methods to interact with those elements
- Page-specific actions and assertions

**Example - LoginPage.java**:
```java
public class LoginPage {
    private WebDriver driver;
    
    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // Actions
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }
    
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}
```

### **Base Test Class**
`BaseTest.java` provides:
- Browser initialization and teardown
- ExtentReports setup
- Test listeners configuration
- Common utilities access

### **Utility Classes**
- **BrowserFactory**: Initializes and manages WebDriver instances
- **ConfigDataProvider**: Reads configuration from properties file
- **ExcelUtils**: Handles Excel file operations for data-driven tests
- **ExtentManager**: Configures ExtentReports
- **ScreenshotUtils**: Captures screenshots on test failures
- **TestListeners**: Implements TestNG event listeners for logging

---

## 📝 Data-Driven Testing with Excel

Use Apache POI to read test data from Excel files:

```java
ExcelUtils excelUtils = new ExcelUtils("path/to/testdata.xlsx");
excelUtils.getDataBySheetName("Sheet1");
```

---

## 📚 Best Practices

✅ Always use **Page Object Model** for maintainability  
✅ Keep locators **private** in page classes  
✅ Use **descriptive names** for test methods  
✅ Implement **explicit waits** instead of hard waits  
✅ Create **reusable methods** in base classes  
✅ Log **all test steps** for debugging  
✅ **Capture screenshots** on failures  
✅ Use **meaningful assertion messages**  

---

**Happy Testing! 🚀**