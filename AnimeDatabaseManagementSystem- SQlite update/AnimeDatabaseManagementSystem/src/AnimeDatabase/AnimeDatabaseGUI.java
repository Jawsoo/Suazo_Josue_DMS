package AnimeDatabase;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.print.PrinterJob;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Author: Josue Suazo
 * Course: Software Development I CEN-3024C
 * Date: 6/12/2024 (Update 1 6/19/2024) (GUI Update 7/1/2024) (SQlite update 7/10/2024)
 * AnimeDatabaseGUI.java
 * This class provides the graphical user interface for the Anime Database Management System.
 */
public class AnimeDatabaseGUI extends Application {
    private final AnimeDatabase animeDatabase = new AnimeDatabase();

    private final TextField titleField = new TextField();
    private final TextField genreField = new TextField();
    private final TextField episodesField = new TextField();
    private final TextField ratingField = new TextField();
    private final TextField studioField = new TextField();
    private final TextField startYearField = new TextField();
    private final TextField endYearField = new TextField();
    private final TextField typeField = new TextField();
    private final TextArea displayArea = new TextArea();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Anime Database Management System");

        // Menu Bar
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Options");

        MenuItem connectToDatabaseMenuItem = new MenuItem("Connect to Database");
        MenuItem printMenuItem = new MenuItem("Print");
        MenuItem exitMenuItem = new MenuItem("Exit");

        menu.getItems().addAll(connectToDatabaseMenuItem, printMenuItem, exitMenuItem);
        menuBar.getMenus().add(menu);

        // Set menu item actions
        connectToDatabaseMenuItem.setOnAction(e -> promptForDatabasePath());
        printMenuItem.setOnAction(e -> printAnime());
        exitMenuItem.setOnAction(e -> exit());

        // Create buttons
        Button addAnimeButton = new Button("Add Anime");
        Button removeAnimeButton = new Button("Remove Anime");
        Button updateAnimeButton = new Button("Update Anime");
        Button searchAnimeButton = new Button("Search Anime");
        Button displayAllAnimeButton = new Button("Display All Anime");
        Button loadFromFileButton = new Button("Load from File");
        Button exitButton = new Button("Exit");

        // Set button actions
        addAnimeButton.setOnAction(e -> addAnime());
        removeAnimeButton.setOnAction(e -> promptForRemoveOption());
        updateAnimeButton.setOnAction(e -> updateAnime());
        searchAnimeButton.setOnAction(e -> promptForSearchOption());
        displayAllAnimeButton.setOnAction(e -> displayAllAnime());
        loadFromFileButton.setOnAction(e -> promptForFileName());
        exitButton.setOnAction(e -> exit());

        // Create image view
        Image vegetaImage = new Image("file:/Volumes/Schooldrive/Coding projects (school)/AnimeDatabaseManagementSystem/AnimeDatabaseManagementSystem/Vegeta-No-Background.png");
        ImageView imageView = new ImageView(vegetaImage);
        imageView.setFitWidth(150);
        imageView.setPreserveRatio(true);

        // Buttons and Image Layout
        VBox buttonsBox = new VBox(10);
        buttonsBox.getChildren().addAll(addAnimeButton, removeAnimeButton, updateAnimeButton, searchAnimeButton, displayAllAnimeButton, loadFromFileButton, exitButton);

        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(buttonsBox, imageView);

        // Main Layout
        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));
        mainLayout.getChildren().addAll(
                menuBar,
                new Label("Title:"), titleField,
                new Label("Genre:"), genreField,
                new Label("Episodes:"), episodesField,
                new Label("Rating:"), ratingField,
                new Label("Studio:"), studioField,
                new Label("Start Year:"), startYearField,
                new Label("End Year:"), endYearField,
                new Label("Type:"), typeField,
                hbox,
                new Label("Display Area:"), displayArea
        );

        // Set background color and text color
        mainLayout.setStyle("-fx-background-color: #001f3f;");
        for (javafx.scene.Node node : mainLayout.getChildren()) {
            if (node instanceof Label) {
                node.setStyle("-fx-text-fill: white;");
            } else if (node instanceof TextField) {
                node.setStyle("-fx-background-color: #0074D9; -fx-text-fill: white;");
            }
        }

        Scene scene = new Scene(mainLayout, 600, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void promptForDatabasePath() {
        TextInputDialog dialog = new TextInputDialog("anime_database.sqlite");
        dialog.setTitle("Connect to Database");
        dialog.setHeaderText("Enter the SQLite database file path:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(path -> {
            animeDatabase.connect(path);
            displayAllAnime();  // Display the anime list once connected
        });
    }

    private void promptForFileName() {
        TextInputDialog dialog = new TextInputDialog("Sample_anime.txt");
        dialog.setTitle("Add File");
        dialog.setHeaderText("Enter the file name:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(this::loadFromFile);
    }

    private void promptForRemoveOption() {
        ChoiceDialog<String> dialog = new ChoiceDialog<>("Title", "Title", "Studio");
        dialog.setTitle("Remove Anime");
        dialog.setHeaderText("Choose attribute to remove by:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(this::removeAnime);
    }

    private void removeAnime(String attribute) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Remove Anime");
        dialog.setHeaderText("Enter the " + attribute + ":");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(value -> {
            boolean removed = false;
            if (attribute.equals("Title")) {
                removed = animeDatabase.removeAnime(value);
            } else if (attribute.equals("Studio")) {
                removed = animeDatabase.removeAnimeByStudio(value);
            }
            if (removed) {
                displayArea.setText(attribute + " removed successfully!");
            } else {
                displayError(attribute + " not found.");
            }
        });
    }

    private void addAnime() {
        try {
            String title = titleField.getText();
            String genre = genreField.getText();
            int episodes = Integer.parseInt(episodesField.getText());
            double rating = Double.parseDouble(ratingField.getText());
            String studio = studioField.getText();
            int startYear = Integer.parseInt(startYearField.getText());
            int endYear = endYearField.getText().isEmpty() ? 0 : Integer.parseInt(endYearField.getText());
            String type = typeField.getText();
            Anime anime = new Anime(title, genre, episodes, rating, studio, startYear, endYear, type);
            if (animeDatabase.addAnime(anime)) {
                displayArea.setText("Anime added successfully!");
            } else {
                displayArea.setText("Anime with the title '" + title + "' already exists.");
            }
        } catch (NumberFormatException e) {
            displayError("Please enter valid numbers for episodes, rating, start year, and end year.");
        }
    }

    private void updateAnime() {
        try {
            String title = titleField.getText();
            String newTitle = titleField.getText();
            String genre = genreField.getText();
            int episodes = Integer.parseInt(episodesField.getText());
            double rating = Double.parseDouble(ratingField.getText());
            String studio = studioField.getText();
            int startYear = Integer.parseInt(startYearField.getText());
            int endYear = endYearField.getText().isEmpty() ? 0 : Integer.parseInt(endYearField.getText());
            String type = typeField.getText();
            Anime updatedAnime = new Anime(newTitle, genre, episodes, rating, studio, startYear, endYear, type);
            boolean updated = animeDatabase.updateAnime(title, updatedAnime);
            if (updated) {
                displayArea.setText("Anime updated successfully!");
            } else {
                displayError("Anime not found.");
            }
        } catch (NumberFormatException e) {
            displayError("Please enter valid numbers for episodes, rating, start year, and end year.");
        }
    }

    private void promptForSearchOption() {
        ChoiceDialog<String> dialog = new ChoiceDialog<>("Title", "Title", "Studio");
        dialog.setTitle("Search Anime");
        dialog.setHeaderText("Choose attribute to search by:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(this::searchAnime);
    }

    private void searchAnime(String attribute) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Search Anime");
        dialog.setHeaderText("Enter the " + attribute + ":");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(value -> {
            String searchResult;
            if (attribute.equals("Title")) {
                Anime anime = animeDatabase.searchAnime(value);
                searchResult = (anime != null) ? anime.toString() : "Anime not found.";
            } else {
                List<Anime> animeList = animeDatabase.searchAnimeByStudio(value);
                if (animeList.isEmpty()) {
                    searchResult = "Anime not found.";
                } else {
                    StringBuilder builder = new StringBuilder();
                    for (Anime anime : animeList) {
                        builder.append(anime.toString()).append("\n");
                    }
                    searchResult = builder.toString();
                }
            }
            displayArea.setText(searchResult);
        });
    }

    private void displayAllAnime() {
        List<Anime> allAnime = animeDatabase.displayAllAnime();
        StringBuilder displayText = new StringBuilder();
        for (Anime anime : allAnime) {
            displayText.append(anime.toString()).append("\n");
        }
        displayArea.setText(displayText.toString());
    }

    private void loadFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }
                String[] data = line.split(",");
                if (data.length == 8) {
                    String title = data[0];
                    String genre = data[1];
                    int episodes = Integer.parseInt(data[2]);
                    double rating = Double.parseDouble(data[3]);
                    String studio = data[4];
                    int startYear = Integer.parseInt(data[5]);
                    int endYear = data[6].isEmpty() ? 0 : Integer.parseInt(data[6]);
                    String type = data[7];
                    Anime anime = new Anime(title, genre, episodes, rating, studio, startYear, endYear, type);
                    animeDatabase.addAnime(anime);
                }
            }
            displayArea.setText("File loaded successfully!");
        } catch (IOException e) {
            displayError("Error loading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            displayError("Error parsing number: " + e.getMessage());
        }
    }

    private void exit() {
        System.exit(0);
    }

    private void displayError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void printAnime() {
        PrinterJob printerJob = PrinterJob.createPrinterJob();
        if (printerJob != null && printerJob.showPrintDialog(null)) {
            boolean success = printerJob.printPage(displayArea);
            if (success) {
                printerJob.endJob();
            }
        }
    }
}
