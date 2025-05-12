# 🚀 Java-MultiModule-App

### Overview

This repository contains a simple Java EE multi-module application using **EJB** and **Servlet/JSP (Web)** modules. It demonstrates the integration of Enterprise JavaBeans (EJB) with a web front end in a clean and modular structure using **Jakarta EE (9.1)** and **Maven**.

---

## 📽️ Demo Video
[![Java RMI Project Demo](https://github.com/chamikathereal/Java-MultiModule-App/blob/main/Java-MultiModule-App.png)](https://youtu.be/wyZckJSypLc)

---

## 📁 Project Structure

```

Java-MultiModule-App/
├── EJBModule/       # Contains EJB session beans and remote interfaces
├── WebModule/       # Web layer with servlets and JSP, uses EJBModule via remote interface

````

---

## 📦 Technologies Used

- Java 11
- Jakarta EE 9.1
- EJB (Enterprise JavaBeans)
- JSP/Servlets
- Maven
- GlassFish Server (or any Jakarta EE-compatible server)

---

## 🔧 Modules Overview

### 1. **EJBModule**

This module contains the **business logic** and exposes remote interfaces.

#### 📌 Key Components:

- `UserDetails`: A remote EJB interface that returns user information.
- `AppSettings`: (optional usage shown) for settings logic.
- `UserDetailsBean`: EJB implementation class (should be defined here).

> **Packaging**: `ejb`

---

### 2. **WebModule**

This is the web front end that interacts with the EJBModule remotely.

#### 📌 Key Components:

- `Home.java`: A `Servlet` that looks up the `UserDetails` EJB via JNDI and displays user data.
- `index.jsp`: Frontend page (currently basic).
- Uses `@EJB` and JNDI to access remote beans.

> **Packaging**: `war`

---

## 🚀 Deployment Steps

1. **Build EJBModule** first:
   ```bash
   cd EJBModule
   mvn clean install


2. **Then build WebModule**:

   ```bash
   cd ../WebModule
   mvn clean package
   ```

3. **Deploy `EJBModule` JAR and `WebModule` WAR** to a Jakarta EE server (e.g., GlassFish).

4. Access:

   ```
   http://localhost:8080/WebModule/home
   ```

---

## 🧠 How It Works

* `WebModule` uses `@EJB` and `InitialContext` lookup to get a remote instance of `UserDetails`.
* It retrieves the user name and displays it.
* The EJB session is then removed from the session.

---

## ✅ Prerequisites

* Java 11+
* Maven 3.6+
* GlassFish 5.1 / Payara / WildFly (Jakarta EE 9+ support)
* Properly configured `domain.xml` or deploy both modules via Admin Console

---

## 🤝 Contributing

Feel free to fork the repository and enhance the functionality or structure!

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

## 🙋‍♂️ Author

**Chamika Indudunu Gayashan**
GitHub: [@chamikathereal](https://github.com/chamikathereal)




