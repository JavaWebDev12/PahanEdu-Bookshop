# Pahana Edu Online Billing System

## 📌 Project Overview
The **Pahana Edu Online Billing System** is a Java-based web application developed to manage customer accounts and billing operations for a leading bookshop in Colombo. The system replaces the manual process of maintaining customer records by providing secure, user-friendly, and efficient functionalities.

This project is developed as part of the **CIS6003 – Advanced Programming** module at ICBT, following modern software engineering practices, design patterns, and version control.

---

## Workflow Status
[![Java CI (Maven)](https://github.com/JavaWebDev12/PahanEdu-Bookshop/actions/workflows/maven-ci.yml/badge.svg)](https://github.com/JavaWebDev12/PahanEdu-Bookshop/actions/workflows/maven-ci.yml)
[![Java CI (No Maven, javax servlet)](https://github.com/JavaWebDev12/PahanEdu-Bookshop/actions/workflows/java-ci.yml/badge.svg)](https://github.com/JavaWebDev12/PahanEdu-Bookshop/actions/workflows/java-ci.yml)

---

## 🎯 Features
1. **User Authentication**
   - Secure login with username and password.
   
2. **Customer Management**
   - Add, edit, and view customer details.
   - Store account number, name, address, contact, and units consumed.

3. **Item Management**
   - Add, update, and delete item information.

4. **Billing**
   - Calculate bill amount based on units consumed.
   - Print bill.

5. **Reports**
   - Generate and display account details.
   
6. **Help Section**
   - Provide system usage guidelines.

7. **Exit**
   - Safe logout and exit functionality.

---

## 🛠️ Technologies Used
- **Programming Language:** Java (JSP, Servlets)
- **IDE:** Eclipse IDE for Enterprise Java and Web Developers
- **Database:** MySQL (or text file storage if no DB is required)
- **Web Server:** Apache Tomcat
- **Version Control:** Git & GitHub
- **Build Tool:** Maven (if applicable)
- **Design Patterns:** MVC architecture, DAO pattern, Singleton (as applicable)

---

## 📂 Project Structure
```
/PahanaEduBillingSystem
│── /src
│   ├── controller        # Servlets handling requests
│   ├── model             # Java classes for business logic
│   ├── dao               # Data Access Objects for DB operations
│   └── utils             # Utility classes
│── /web
│   ├── css               # Stylesheets
│   ├── js                # JavaScript files
│   ├── images            # Image assets
│   └── WEB-INF
│       ├── views         # JSP pages
│       └── web.xml       # Deployment descriptor
│── /docs                 # UML diagrams, reports, and documentation
│── README.md             # Project documentation
│── pom.xml               # Maven configuration (if used)
```

---

## ⚙️ Installation & Setup
### **Prerequisites**
- Java JDK 8 or higher
- Eclipse IDE (Enterprise Java Edition)
- Apache Tomcat (v9 or compatible)
- MySQL Server (if using DB)
- Git

### **Steps**
1. Clone the repository:
   ```bash
   https://github.com/JavaWebDev12/PahanEdu-Bookshop.git
   ```
2. Open the project in **Eclipse IDE**.
3. Configure Apache Tomcat in Eclipse.
4. If using MySQL:
   - Create a database.
   - Import the provided SQL script (`/docs/database.sql`).
   - Update DB credentials in `DBConnection.java`.
5. Deploy the project to Tomcat and run.

---

## 🧪 Testing
- **Approach:** Test-Driven Development (TDD)
- **Tools:** JUnit for unit testing, Selenium (optional) for UI automation.
- **Test Cases:** Cover authentication, customer CRUD operations, billing calculations, and report generation.
- **Automation:** Automated builds and tests using GitHub Actions CI workflow.

---

## 📈 Version Control & CI/CD
- **GitHub Repository:** Public with daily commits showing feature development.
- **Branching Strategy:** `main` for stable releases, `dev` for ongoing development.
- **Workflows:** GitHub Actions for build and test automation.
- **Deployment:** Automated deployment to local Tomcat server.

---

## 📊 UML Diagrams
- **Use Case Diagram** – Identifies actors and functionalities.
- **Class Diagram** – Shows classes, attributes, methods, and relationships.
- **Sequence Diagram** – Demonstrates the flow of operations for key use cases.

---

## 👨‍💻 Author
**Name:** [Your Name]  
**Module:** CIS6003 – Advanced Programming  
**Institution:** ICBT 
**Year:** 2024/25  

---

## 📜 License
This project is developed for academic purposes under the ICBT assessment guidelines.

---

