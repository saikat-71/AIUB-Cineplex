# AIUB Cineplex 🎬

A Java Swing-based desktop application developed as an academic project for managing user accounts and movie-related activities. The application provides user registration, authentication, movie searching, movie purchasing, wallet management, and movie deletion features.

## 📌 Project Overview

**AIUB Cineplex** is a desktop movie management application built with **Java Swing**. It provides an interactive graphical user interface where users can create an account, log in using their student ID and password, browse available movies, search for movies, purchase movies, and manage their personal movie wallet.

The project demonstrates practical implementation of **Object-Oriented Programming (OOP)**, **Java Swing GUI development**, **event-driven programming**, and **file-based data persistence**.

## ✨ Features

* User registration
* Student ID and password-based login
* User profile information display
* Movie browsing
* Movie search
* Movie purchasing
* Personal movie wallet
* Remove movies from wallet
* Logout functionality
* Local user-data storage using a text file
* Graphical user interface using Java Swing

## 🎬 Available Movies

The current application includes:

* **TOOFAN**
* **NOBAB**
* **DIN-THE-DAY**

## 🛠️ Technologies Used

* **Java**
* **Java Swing**
* **Object-Oriented Programming (OOP)**
* **Java File I/O**
* **Event-Driven Programming**
* **ArrayList**
* **Text File Data Storage**

## 📂 Project Structure

```text
AIUB_Cineplex_Project_JAVA/
│
├── Main.java
├── Home.java
├── LoginFrame.java
├── RegisterFrame.java
├── DashboardFrame.java
├── SearchMovieFrame.java
├── PurchaseMovieFrame.java
├── DeleteMovieFrame.java
├── User.java
├── UserService.java
├── users.txt
│
└── Pictures/
    ├── Background.png
    ├── CreateAccountBackground.png
    ├── Deletemovie.jpg
    ├── dintheday.png
    ├── HomeImage.png
    ├── Movie.jpg
    ├── Nobab.png
    ├── PortalBG.png
    ├── ProfileBG.png
    ├── ProfileUpdateBG.png
    ├── SearchMovie.jpg
    └── Toofan.png
```

## 🧩 Main Components

### `Main.java`

The main entry point of the application.

### `Home.java`

Provides the initial home interface and navigation to the authentication section.

### `LoginFrame.java`

Handles user authentication using student ID and password.

### `RegisterFrame.java`

Allows new users to create an account with:

* Name
* Gender
* Mobile number
* Student ID
* Password

### `DashboardFrame.java`

Acts as the main user dashboard and provides access to:

* Profile
* Movies
* Wallet
* Movie Search
* Delete Movie
* Logout

### `SearchMovieFrame.java`

Allows users to search for available movies by movie name.

### `PurchaseMovieFrame.java`

Provides the movie purchasing interface and adds selected movies to the user's wallet.

### `DeleteMovieFrame.java`

Allows users to remove movies from their wallet.

### `User.java`

Represents the user data model, including:

* Name
* Gender
* Mobile number
* Student ID
* Password
* Movie wallet

### `UserService.java`

Handles the application's core user and movie-related operations, including:

* Registration
* Login
* User lookup
* File-based user storage
* Movie purchase
* Movie deletion
* Wallet management
* Logout

### `users.txt`

Used for local storage of registered user information.

## 🔄 Application Flow

```text
Start Application
       ↓
     Home
       ↓
 ┌───────────────┐
 │ Login/Register│
 └───────┬───────┘
         ↓
    Authentication
         ↓
     Dashboard
         ↓
 ┌───────┼────────┬────────────┐
 ↓       ↓        ↓            ↓
Profile Movie   Search       Wallet
         ↓
      Purchase
         ↓
   Movie Wallet
         ↓
   Delete Movie
         ↓
      Logout
```

## 💾 Data Storage

The application uses a local `users.txt` file for storing registered user information.

User information is stored using a comma-separated format:

```text
Name,Gender,Mobile,StudentID,Password
```

The application reads the file when user information needs to be loaded and appends newly registered users to the file.

> **Note:** This project is intended for academic demonstration. Passwords are stored as plain text and should not be handled this way in a production application.

## 🚀 How to Run

### Prerequisites

Make sure **Java JDK** is installed on your computer.

Check the installation with:

```bash
java -version
javac -version
```

### Run from Terminal

Navigate to the project directory:

```bash
cd AIUB_Cineplex_Project_JAVA
```

Compile the Java files:

```bash
javac *.java
```

Run the application:

```bash
java Main
```

## 🖥️ Application Type

**Desktop Application**

The application uses Java Swing to create its graphical user interface and does not require a web server or external database.

## 🎓 Project Information

**Project:** AIUB Cineplex
**Type:** Academic Project
**Platform:** Desktop
**Language:** Java
**Framework/GUI:** Java Swing
**Data Storage:** Local Text File

## 👨‍💻 Development Focus

This project focuses on practical implementation of:

* Object-Oriented Programming
* GUI design with Java Swing
* User authentication
* File handling
* Event handling
* Data management
* Application navigation
* Basic CRUD-style movie wallet operations

## 📜 License

This project was developed for academic and educational purposes.
