# Art Gallery Visitor Management System

## 📌 Overview

The **Art Gallery Visitor Management System** is a Java-based desktop application designed to manage art gallery visitors, their visits, artwork purchases, discounts, reward points, cancellations, and visitor information.

The application provides a **Graphical User Interface (GUI)** developed using **Java Swing**, allowing users to perform visitor management and artwork-related operations through an interactive interface.

## ✨ Features

* Register new gallery visitors
* Support for **Standard** and **Elite** visitors
* Record and manage visitor information
* Log visitor visits
* Purchase artworks
* Cancel artwork purchases
* Calculate discounts
* Calculate reward points
* Check eligibility for Standard visitor discount upgrades
* Assign a personal art advisor to eligible Elite visitors
* Generate purchase bills
* Display visitor details in a table
* Save visitor information to a text file
* Read previously saved visitor information
* Input validation and error handling

## 🏗️ Project Structure

```text
Art-Gallery-Visitor-Management-System/
│
├── ArtGalleryGUI.java
├── ArtGalleryVisitor.java
├── StandardVisitor.java
├── EliteVisitor.java
├── StandardVisitorTest.java
├── EliteVisitorTest.java
├── README.md
└── data.txt
```

## 🧩 Class Design

### `ArtGalleryVisitor`

`ArtGalleryVisitor` is the **abstract parent class** containing common visitor information and operations.

It stores details such as:

* Visitor ID
* Full name
* Gender
* Contact number
* Registration date
* Ticket cost and type
* Visit count
* Reward points
* Purchase information
* Cancellation information

It also defines abstract methods for purchasing products, calculating discounts and rewards, cancelling purchases, and generating bills.

### `StandardVisitor`

`StandardVisitor` extends `ArtGalleryVisitor` and provides functionality specific to Standard visitors.

A Standard visitor can:

* Receive an initial discount
* Become eligible for a discount upgrade after reaching the required number of visits
* Earn reward points from purchases
* Purchase and cancel artworks
* Generate purchase bills

The class uses a visit limit of **5 visits** and initially applies a **10% discount**, with the discount increased to **15%** after meeting the upgrade condition.

### `EliteVisitor`

`EliteVisitor` also extends `ArtGalleryVisitor` and provides additional benefits for Elite visitors.

Features include:

* Higher artwork discount
* Reward points
* Personal art advisor assignment
* Exclusive event access
* Artwork purchase and cancellation
* Purchase bill generation

The personal art advisor is assigned when the visitor's reward points exceed the defined threshold.

## 🖥️ Graphical User Interface

The application uses **Java Swing** to create the graphical interface.

The GUI contains sections for:

### Entry

Visitors can enter:

* Visitor ID
* Full name
* Contact number
* Gender
* Registration date
* Ticket type

The application validates required fields, checks the phone number format, prevents duplicate visitor IDs, and validates visitor IDs.

### Artworks

The artwork section allows visitors to:

* Enter artwork details
* Buy an artwork
* Cancel an artwork purchase
* Calculate discounts
* Calculate reward points
* Check upgrade eligibility
* Request a personal art advisor
* Generate bills

### Visitor Details

Visitor information can be displayed in a table containing details such as visitor ID, name, gender, registration date, ticket type, ticket price, visit count, and active status.

## 💾 File Handling

The application supports storing visitor information in a text file.

The **Write to File** functionality saves visitor information including:

* Visitor details
* Ticket information
* Visit count
* Purchase count
* Artwork information
* Cancellation count
* Personal art advisor status

The **Read from File** functionality displays the stored information through the GUI.

## 🧠 Object-Oriented Programming Concepts Used

This project demonstrates several important Java OOP concepts:

* **Abstraction** — `ArtGalleryVisitor` is an abstract class.
* **Inheritance** — `StandardVisitor` and `EliteVisitor` inherit from `ArtGalleryVisitor`.
* **Encapsulation** — Visitor attributes are controlled through methods such as getters and setters.
* **Polymorphism** — Common operations such as `buyProduct()`, `calculateDiscount()`, `calculateRewardPoint()`, `cancelProduct()`, and `generateBill()` are implemented differently by the subclasses.
* **Method Overriding** — Both visitor subclasses override methods from the parent class.

## 🧪 Testing

Separate test classes are provided for Standard and Elite visitors.

### Standard Visitor Test

The test demonstrates:

1. Creating a Standard visitor
2. Displaying visitor details
3. Purchasing an artwork
4. Calculating the discount
5. Calculating reward points
6. Generating a bill
7. Cancelling the purchase
8. Displaying updated visitor details

### Elite Visitor Test

The Elite visitor test demonstrates:

1. Creating an Elite visitor
2. Purchasing an artwork
3. Calculating the discount
4. Calculating reward points
5. Assigning a personal art advisor
6. Generating a bill
7. Cancelling an artwork purchase
8. Displaying updated visitor information

## 🛠️ Technologies Used

* **Language:** Java
* **GUI:** Java Swing
* **File Handling:** Java I/O
* **Collections:** ArrayList
* **IDE:** Any Java-compatible IDE such as IntelliJ IDEA, Eclipse, or VS Code

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone <your-repository-link>
```

### 2. Open the project

Open the project in your preferred Java IDE.

### 3. Compile the Java files

```bash
javac *.java
```

### 4. Run the application

```bash
java ArtGalleryGUI
```

The main application is launched through the `ArtGalleryGUI` class.

## 👩‍💻 Contributors

* **Anshita Gupta** — GUI Development & `ArtGalleryVisitor`
* **Madhbi Sah** — `EliteVisitor`
* **Anita Kumari Gupta** — `StandardVisitor`

## 📄 License

This project was developed for educational purposes as part of a Java Object-Oriented Programming project.

