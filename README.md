# School Management System

This is a **School Management System** web application designed to manage professors, students, absences, marks, and timetables. The system provides separate views for **Professors** and **Students**, allowing them to access relevant information and perform specific actions.

---

## Features

### Admin View
- **Manage Professors**: Add, edit, and delete professors.
- **Manage Students**: Add, edit, and delete students.
- **Manage Absences**: Add, edit, and delete student absences.
- **Manage Marks**: Add, edit, and delete student marks.
- **Manage Timetable**: Add, edit, and delete timetable entries.

### Professor View
- View assigned classes.
- View and update student marks.
- View and update student absences.
- View timetable.

### Student View
- View personal marks.
- View personal absences.
- View timetable.

---

## Technologies Used
- **Backend**: Java Servlets, JDBC
- **Frontend**: HTML, CSS, JSP
- **Database**: MySQL
- **Build Tool**: Maven

---

## Setup Instructions

### Prerequisites
1. **Java Development Kit (JDK)**: Ensure JDK 8 or higher is installed.
2. **Apache Tomcat**: Install Tomcat 9 or higher to run the application.
3. **MySQL Database**: Install MySQL and create a database for the application.
4. **Maven**: Install Maven to build the project.

### Database Setup
1. Create a MySQL database named `school_management`.
2. Create the following tables in the database:
   - **User**: Stores user information (email, password, role).
   - **Professor**: Stores professor details (user ID, first name, last name, CNI, employment date, salary).
   - **Student**: Stores student details (user ID, first name, last name, CNE, study level, status, birthday).
   - **Class**: Stores class information (name, professor ID, year).
   - **Absence**: Stores student absences (student ID, class ID, date, justified status).
   - **Marks**: Stores student marks (student ID, class ID, mark).
   - **Timetable**: Stores timetable entries (time slot, Monday to Friday classes).

3. Update the `DatabaseUtil.java` file with your MySQL credentials:

```java
public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/school_management";
    private static final String USER = "your_mysql_username";
    private static final String PASSWORD = "your_mysql_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
```

Build and Run the Application
Clone the repository:

```bash
git clone https://github.com/your-repo/school-management-system.git
```
Navigate to the project directory:

```bash
cd school-management-system
```
Build the project using Maven:

```bash
mvn clean install
```
Deploy the generated .war file to your Tomcat server.

Start the Tomcat server and access the application at:

http://localhost:8080/school-management-system

Usage
Admin Dashboard
Access the admin dashboard at /admin-dashboard.

Use the navigation menu to manage professors, students, absences, marks, and timetables.

Professor View
Professors can log in to view their assigned classes, update student marks, and manage absences.

Student View
Students can log in to view their marks, absences, and timetable.

Screenshots
Admin Dashboard
![Opera Snapshot_2025-03-02_231315_127 0 0 1](https://github.com/user-attachments/assets/fe5bae5e-2540-4f45-83ad-9a8a3702a388)


Professor View
![Opera Snapshot_2025-03-02_231515_127 0 0 1](https://github.com/user-attachments/assets/c9484ba0-467f-4959-ac5a-0047648f27db)

Student View
![Opera Snapshot_2025-03-02_231817_127 0 0 1](https://github.com/user-attachments/assets/74e40975-44b4-462b-96af-31dc71827a8c)




Contact
For questions or feedback, please contact:

[Mehdi](https://github.com/ME17FD)
[Younes](https://github.com/PasDouey)
[Amine](https://github.com/AHMED4MIN)

