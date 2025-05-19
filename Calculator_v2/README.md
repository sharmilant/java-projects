# Calculator_v2

A simple Java-based calculator application with a graphical user interface (GUI). This project is designed to demonstrate Java fundamentals, including package structure, OOP principles, and GUI development.

## 📁 Project Structure

```bash
Calculator_v2/
├── src/
│ ├── main/
│ │ ├─ Logic.java 
│ │ └─ main.java
│ │
│ └── graphics/
│       ├─ CalculateButton.java
│       ├─ ClearButton.java
│       ├─ NumberButton.java
│       ├─ OperatorButton.java
│       └─ Window.java
├── out/ # Compiled classes (created after build)
└── README.md
```
---
## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or higher
- A terminal or command prompt

### Compile the Project

```bash
javac -d bin -sourcepath src src/main/Main.java
```

### Run the Project

```bash
java -cp bin main.Main
```

---
## 🛠️ Features

- Basic window rendering using a custom GUI class (Window)
- Modular project structure using Java packages
- Simple and extendable architecture


---
## 📚 Technologies Used

- Java SE (Standard Edition)
- Object-Oriented Programming (OOP)
- Java Swing

