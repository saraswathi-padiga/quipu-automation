# Quipu Automation Project

This project automates Quipu website tasks using Java and Selenium WebDriver. The tests are organized with TestNG and can be run using a `testng.xml` file.

## Table of Contents
- [Installation](#installation)
- [Project Structure](#project-structure)
- [Testing](#testing)

## Installation

### Prerequisites
- Java (version 8 or higher)
- Maven (for managing dependencies)
- Selenium WebDriver

### Setup
1. Clone this repository:
   ```bash
   git clone https://github.com/saraswathi-padiga/quipu-automation.git
2. Navigate to the project directory:
   ```bash
   cd quipu-automation
3. Install dependencies
   ```bash
   mvn install

## Project Structure

src/test/java - Contains test classes.
pom.xml - defines maven dependencies.
testng.xml - Configuration file for TestNG.

## Testing
The tests can be run either using the following command or using TestNG's testing.xml configuration file:
```bash
mvn test

