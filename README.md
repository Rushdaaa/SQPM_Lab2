# SQPM_Lab2

## 📊 Binary Calculator Project

This project implements a **Binary Calculator** in Java using **Maven** and **Spring Boot**. It allows operations on binary numbers, including **Addition (+)**, **Bitwise OR (|)**, **Bitwise AND (&)**, and **Multiplication (*)**. The project includes unit tests to ensure the correctness of all operations and provides API services for binary calculations.

---

## 🚀 Features

1. **Binary Operations:**
   - **Addition (+):** Adds two binary numbers.
   - **Bitwise OR (|):** Performs a logical OR between two binary numbers.
   - **Bitwise AND (&):** Performs a logical AND between two binary numbers.
   - **Multiplication (*):** Multiplies two binary numbers using binary arithmetic.

2. **Error Handling:**
   - Handles invalid binary inputs gracefully.
   - Provides error messages for unsupported operators.

3. **API Endpoints:**
   - RESTful API endpoints for binary operations.
   - JSON responses for easy integration with other services.

4. **Unit Testing:**
   - Comprehensive test coverage using **JUnit**.
   - Tests include edge cases like large binary numbers and invalid inputs.

---

## 📂 Project Structure

```
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
```

---

## ⚡ Installation & Run

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/Rushdaaa/SQPM_Lab2.git
cd binary-calculator
```

### 2️⃣ Build the Project

```bash
mvn clean install
```

### 3️⃣ Run the Application

```bash
mvn spring-boot:run
```

### 4️⃣ Access the Application

- **Web App:** [http://localhost:8080](http://localhost:8080)
- **API Example:** [http://localhost:8080/add?operand1=101&operand2=11](http://localhost:8080/add?operand1=101&operand2=11)

---

## 🧪 Running Tests

Run all unit tests using Maven:

```bash
mvn test
```

---

## 📑 API Endpoints

- **Addition:** `/add?operand1=101&operand2=11`
- **Multiplication:** `/multiply?operand1=101&operand2=11`
- **AND:** `/and?operand1=1101&operand2=1011`
- **OR:** `/or?operand1=1010&operand2=0110`
- **JSON Response Example:** `/add_json?operand1=101&operand2=11`

---

## 🎥 Video Walkthrough

[Project Video](https://drive.google.com/file/d/1eE-LAdqxFBN7Dx4aRDpe4oOUTrs7A_LD/view?usp=sharing)

