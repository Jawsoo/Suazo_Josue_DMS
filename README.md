# Anime Database Management System

## Author
- **Name:** Josue Suazo
- **Course:** Software Development I CEN-3024C
- **Date:** 6/12/2024 (Update 1: 6/19/2024, GUI Update : 7/1/2024, SQlite update 7/10/2024)

## Project Objective
The Anime Database Management System is a Java-based application that provides a graphical user interface (GUI) to manage a list of anime. The application supports various CRUD operations (Create, Read, Update, Delete) and includes features to load anime data from a file, search, and print the list of anime. This project aims to provide a simple yet functional tool to manage anime data efficiently.

## Features
- **Add Anime:** Allows the user to add a new anime to the database by entering details such as title, genre, episodes, rating, and studio.
- **Remove Anime:** Users can remove an anime from the database by either its title or studio.
- **Update Anime:** Provides functionality to update the details of an existing anime.
- **Search Anime:** Enables searching for an anime by either its title or studio.
- **Display All Anime:** Displays all anime currently stored in the database.
- **Load from File:** Allows the user to load anime data from a specified file.
- **Print:** Offers a print dialog to print the list of anime.
  
## Data Validation
The application includes data validation to ensure the user inputs are correct and the application does not crash. Some of the validation measures include:
- Checking for valid integer and double values for episodes and rating fields.
- Handling file-related errors when loading data from a file.
- Ensuring no duplicate titles are added to the database.

## GUI Update
The graphical user interface (GUI) has been enhanced to improve the user experience:
- **Color Scheme:** The background color has been updated to blue with white text for better visibility.
- **Image:** An image of Vegeta from Dragon Ball has been added to the interface for visual appeal.
- **Menu Options:** Simplified menu options to include only Add File, Print, and Exit.
- **Field Labels:** Text color of the labels for Title, Genre, Episodes, Rating, Studio, and Display Area has been updated to white for better visibility.

## SQLite Update
The SQLite database has been integrated to enhance data management:

- **Schema**: The database schema has been defined to include fields like title, genre, episodes, rating, studio, start year, end year, and type.
- **Data Population**: The database has been populated with at least 20 different anime entries.
- **CRUD Operations**: The application supports full CRUD operations on the SQLite database.
- **File Path Input**: Users are prompted to input the file path for the SQLite database, ensuring flexibility and compatibility across different systems.

How to Run the JAR file
To run the application, you need to have JavaFX and the SQLite JDBC driver. 

1. Clone or download the Repository:

Copy code:
git clone https://github.com/Jawsoo/Suazo_Josue_DMS.git
cd Suazo_Josue_DMS

2. Ensure the Required Libraries are Present:

Make sure you have the following libraries in the lib directory:

javafx-sdk-23
sqlite-jdbc-3.46.0.0.jar
slf4j-api-1.7.32.jar
log4j-over-slf4j-1.7.32.jar
slf4j-simple-1.7.32.jar

3. Set the Paths for the Libraries:

Copy code:
export PATH_TO_FX="/path/to/your/javafx-sdk-23/lib"
export PATH_TO_SQLITE_JDBC="/path/to/your/sqlite-jdbc-3.46.0.0.jar"
export PATH_TO_SLF4J="/path/to/your/slf4j-api-1.7.32.jar:/path/to/your/log4j-over-slf4j-1.7.32.jar:/path/to/your/slf4j-simple-1.7.32.jar"

Replace /path/to/your/ with the actual path where your libraries are located.

4. Run the JAR File:

If the JAR file is in the Downloads folder, run the following command:

Copy code:
java --module-path $PATH_TO_FX:$PATH_TO_SQLITE_JDBC:$PATH_TO_SLF4J --add-modules javafx.controls,javafx.fxml -jar /Users/jawjiro/Downloads/AnimeDatabaseManagementSystem.jar

Make sure to replace /Users/jawjiro/Downloads/ with the path where the JAR file is located if it’s different.
