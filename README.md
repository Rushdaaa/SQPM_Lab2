Description
This project is a Binary Calculator Web Application built using Java, Spring Boot, and Maven. It supports binary operations such as Addition (+), Multiplication (*), Bitwise AND (&), and Bitwise OR (|). The application includes both a web-based UI and API services for binary calculations.

Features
- Binary Addition (+)
- Binary Multiplication (*)
- Bitwise AND (&)
- Bitwise OR (|)
- Error Handling for Invalid Inputs
- JSON API Endpoints for Integration

🗂️ Project Structure

├── src
│   ├── main
│   │   ├── java/com/ontariotechu/sofe3980U
│   │   │   ├── Binary.java
│   │   │   ├── BinaryController.java
│   │   │   ├── BinaryAPIController.java
│   │   │   └── BinaryAPIResult.java
│   │   └── resources/templates
│   │       ├── calculator.html
│   │       ├── result.html
│   │       └── error.html
│   └── test/java/com/ontariotechu/sofe3980U
│       ├── BinaryControllerTest.java
│       └── BinaryAPIControllerTest.java
└── pom.xml

Installation & Run

Clone the Repository:
git clone https://github.com/Rushdaaa/SQPM_Lab2.git 
cd binary-calculator

Build the Project:
mvn clean install

Run the Application:
mvn spring-boot:run

Access the Application:
Web App: http://localhost:8080

API Example: http://localhost:8080/add?operand1=101&operand2=11

Running Tests
Run all unit tests using Maven:

mvn test

API Endpoints
Addition: /add?operand1=101&operand2=11
Multiplication: /multiply?operand1=101&operand2=11
AND: /and?operand1=1101&operand2=1011
OR: /or?operand1=1010&operand2=0110
JSON Response Example: /add_json?operand1=101&operand2=11

Project Video: https://drive.google.com/file/d/1eE-LAdqxFBN7Dx4aRDpe4oOUTrs7A_LD/view?usp=sharing 
