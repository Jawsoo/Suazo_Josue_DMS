package AnimeDatabase;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.print.PrinterJob;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Author: Josue Suazo
 * Course: Software Development I CEN-3024C
 * Date: 6/12/2024 (Update 1 6/19/2024) (GUI Update 7/1/2024) (SQlite update 7/10/2024) (Jar update 7/14/2024)
 * AnimeDatabaseGUI.java
 * This class provides the graphical user interface for the Anime Database Management System.
 */
public class AnimeDatabaseGUI extends Application {
    private final AnimeDatabase animeDatabase = new AnimeDatabase();

    private final TextField titleField = new TextField();
    private final ComboBox<String> genreField = new ComboBox<>();
    private final TextField episodesField = new TextField();
    private final TextField ratingField = new TextField();
    private final TextField studioField = new TextField();
    private final TextField startYearField = new TextField();
    private final TextField endYearField = new TextField();
    private final ComboBox<String> typeField = new ComboBox<>();
    private final TableView<Anime> tableView = new TableView<>();

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
        updateAnimeButton.setOnAction(e -> promptForUpdateTitle());
        searchAnimeButton.setOnAction(e -> promptForSearchOption());
        displayAllAnimeButton.setOnAction(e -> displayAllAnime());
        loadFromFileButton.setOnAction(e -> promptForFileName());
        exitButton.setOnAction(e -> exit());

        // Ensure all buttons have the same width
        addAnimeButton.setMaxWidth(Double.MAX_VALUE);
        removeAnimeButton.setMaxWidth(Double.MAX_VALUE);
        updateAnimeButton.setMaxWidth(Double.MAX_VALUE);
        searchAnimeButton.setMaxWidth(Double.MAX_VALUE);
        displayAllAnimeButton.setMaxWidth(Double.MAX_VALUE);
        loadFromFileButton.setMaxWidth(Double.MAX_VALUE);
        exitButton.setMaxWidth(Double.MAX_VALUE);

        // Create image view
        Image vegetaImage = new Image(Objects.requireNonNull(getClass().getResource("/Vegeta-No-Background.png")).toExternalForm());
        ImageView imageView = new ImageView(vegetaImage);
        imageView.setFitWidth(150);
        imageView.setPreserveRatio(true);

        // Buttons and Image Layout
        VBox buttonsBox = new VBox(10);
        buttonsBox.getChildren().addAll(addAnimeButton, removeAnimeButton, updateAnimeButton, searchAnimeButton, displayAllAnimeButton, loadFromFileButton, exitButton);

        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(buttonsBox, imageView);
        hbox.setAlignment(Pos.CENTER); // Center the buttons and image

        // Set up ComboBox options
        genreField.getItems().addAll("Action", "Adventure", "Comedy", "Drama", "Fantasy", "Horror", "Mystery", "Romance", "Sci-Fi", "Thriller");
        typeField.getItems().addAll("TV", "Movie", "OVA", "ONA");

        // Main Layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER); // Center the grid pane
        Label titleLabel = new Label("Title:");
        Label genreLabel = new Label("Genre:");
        Label episodesLabel = new Label("Episodes:");
        Label ratingLabel = new Label("Rating:");
        Label studioLabel = new Label("Studio:");
        Label typeLabel = new Label("Type:");
        Label startYearLabel = new Label("Start Year:");
        Label endYearLabel = new Label("End Year:");
        gridPane.add(titleLabel, 0, 0);
        gridPane.add(titleField, 1, 0);
        gridPane.add(genreLabel, 2, 0);
        gridPane.add(genreField, 3, 0);
        gridPane.add(episodesLabel, 0, 1);
        gridPane.add(episodesField, 1, 1);
        gridPane.add(ratingLabel, 2, 1);
        gridPane.add(ratingField, 3, 1);
        gridPane.add(studioLabel, 0, 2);
        gridPane.add(studioField, 1, 2);
        gridPane.add(typeLabel, 2, 2);
        gridPane.add(typeField, 3, 2);
        gridPane.add(startYearLabel, 0, 3);
        gridPane.add(startYearField, 1, 3);
        gridPane.add(endYearLabel, 2, 3);
        gridPane.add(endYearField, 3, 3);

        // Set up TableView
        setupTableView();

        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));
        mainLayout.getChildren().addAll(
                menuBar,
                gridPane,
                hbox,
                tableView
        );
        mainLayout.setAlignment(Pos.CENTER); // Center everything in the VBox

        // Set background color and text color
        mainLayout.setStyle("-fx-background-color: #001f3f;");
        for (javafx.scene.Node node : mainLayout.getChildren()) {
            if (node instanceof Label) {
                node.setStyle("-fx-text-fill: white;");
            } else if (node instanceof TextField || node instanceof ComboBox) {
                node.setStyle("-fx-background-color: #0074D9; -fx-text-fill: white;");
            }
        }

        // Set label text color to white
        titleLabel.setStyle("-fx-text-fill: white;");
        genreLabel.setStyle("-fx-text-fill: white;");
        episodesLabel.setStyle("-fx-text-fill: white;");
        ratingLabel.setStyle("-fx-text-fill: white;");
        studioLabel.setStyle("-fx-text-fill: white;");
        typeLabel.setStyle("-fx-text-fill: white;");
        startYearLabel.setStyle("-fx-text-fill: white;");
        endYearLabel.setStyle("-fx-text-fill: white;");

        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void promptForDatabasePath() {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Connect to Database");
        dialog.setHeaderText("Enter the SQLite database file path:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(path -> {
            animeDatabase.connect(path);
            displayAllAnime();  // Display the anime list once connected
        });
    }

    private void promptForFileName() {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Add File");
        dialog.setHeaderText("Enter the file path:");
        dialog.setContentText("File path:");
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
                displaySuccess(attribute + " removed successfully!");
            } else {
                displayError(attribute + " not found.");
            }
        });
    }

    private void addAnime() {
        try {
            String title = titleField.getText();
            String genre = genreField.getValue();
            int episodes = Integer.parseInt(episodesField.getText());
            double rating = Double.parseDouble(ratingField.getText());
            String studio = studioField.getText();
            int startYear = Integer.parseInt(startYearField.getText());
            int endYear = endYearField.getText().isEmpty() ? 0 : Integer.parseInt(endYearField.getText());
            String type = typeField.getValue();
            Anime anime = new Anime(title, genre, episodes, rating, studio, startYear, endYear, type);
            if (animeDatabase.addAnime(anime)) {
                displaySuccess("Anime added successfully!");
                displayAllAnime(); // Refresh the table view
            } else {
                displayError("Anime with the title '" + title + "' already exists.");
            }
        } catch (NumberFormatException e) {
            displayError("Please enter valid numbers for episodes, rating, start year, and end year.");
        }
    }

    private void promptForUpdateTitle() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Update Anime");
        dialog.setHeaderText("Enter the Title of the anime to update:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(this::updateAnime);
    }

    private void updateAnime(String title) {
        Anime existingAnime = animeDatabase.searchAnime(title);
        if (existingAnime != null) {
            titleField.setText(existingAnime.getTitle());
            genreField.setValue(existingAnime.getGenre());
            episodesField.setText(String.valueOf(existingAnime.getEpisodes()));
            ratingField.setText(String.valueOf(existingAnime.getRating()));
            studioField.setText(existingAnime.getStudio());
            startYearField.setText(String.valueOf(existingAnime.getStartYear()));
            endYearField.setText(existingAnime.getEndYear() == 0 ? "" : String.valueOf(existingAnime.getEndYear()));
            typeField.setValue(existingAnime.getType());

            Button updateButton = createUpdateButton(title, existingAnime);

            GridPane gridPane = new GridPane();
            gridPane.setHgap(10);
            gridPane.setVgap(10);
            gridPane.add(new Label("Title:"), 0, 0);
            gridPane.add(titleField, 1, 0);
            gridPane.add(new Label("Genre:"), 2, 0);
            gridPane.add(genreField, 3, 0);
            gridPane.add(new Label("Episodes:"), 0, 1);
            gridPane.add(episodesField, 1, 1);
            gridPane.add(new Label("Rating:"), 2, 1);
            gridPane.add(ratingField, 3, 1);
            gridPane.add(new Label("Studio:"), 0, 2);
            gridPane.add(studioField, 1, 2);
            gridPane.add(new Label("Type:"), 2, 2);
            gridPane.add(typeField, 3, 2);
            gridPane.add(new Label("Start Year:"), 0, 3);
            gridPane.add(startYearField, 1, 3);
            gridPane.add(new Label("End Year:"), 2, 3);
            gridPane.add(endYearField, 3, 3);
            gridPane.add(updateButton, 1, 4, 3, 1);

            Scene updateScene = new Scene(gridPane, 400, 300);
            Stage updateStage = new Stage();
            updateStage.setTitle("Update Anime");
            updateStage.setScene(updateScene);
            updateStage.show();
        } else {
            displayError("Anime not found.");
        }
    }

    private Button createUpdateButton(String title, Anime existingAnime) {
        Button updateButton = new Button("Update");
        updateButton.setOnAction(e -> {
            Anime updatedAnime = new Anime(
                    titleField.getText(),
                    genreField.getValue(),
                    Integer.parseInt(episodesField.getText()),
                    Double.parseDouble(ratingField.getText()),
                    studioField.getText(),
                    Integer.parseInt(startYearField.getText()),
                    endYearField.getText().isEmpty() ? 0 : Integer.parseInt(endYearField.getText()),
                    typeField.getValue()
            );
            if (animeDatabase.updateAnime(title, updatedAnime)) {
                displaySuccess("Anime updated successfully!");
                displayAllAnime(); // Refresh the table view
            } else {
                displayError("Error updating anime.");
            }
        });
        return updateButton;
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
            ObservableList<Anime> searchResults;
            if (attribute.equals("Title")) {
                Anime anime = animeDatabase.searchAnime(value);
                searchResults = (anime != null) ? FXCollections.observableArrayList(anime) : FXCollections.emptyObservableList();
            } else {
                List<Anime> animeList = animeDatabase.searchAnimeByStudio(value);
                searchResults = FXCollections.observableArrayList(animeList);
            }
            tableView.setItems(searchResults);
        });
    }

    private void displayAllAnime() {
        List<Anime> allAnime = animeDatabase.displayAllAnime();
        ObservableList<Anime> animeList = FXCollections.observableArrayList(allAnime);
        tableView.setItems(animeList);
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
            displaySuccess("File loaded successfully!");
            displayAllAnime(); // Refresh the table view
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

    private void displaySuccess(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void printAnime() {
        PrinterJob printerJob = PrinterJob.createPrinterJob();
        if (printerJob != null && printerJob.showPrintDialog(null)) {
            boolean success = printerJob.printPage(tableView);
            if (success) {
                printerJob.endJob();
            }
        }
    }

    private void setupTableView() {
        TableColumn<Anime, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Anime, String> genreColumn = new TableColumn<>("Genre");
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));

        TableColumn<Anime, Integer> episodesColumn = new TableColumn<>("Episodes");
        episodesColumn.setCellValueFactory(new PropertyValueFactory<>("episodes"));

        TableColumn<Anime, Double> ratingColumn = new TableColumn<>("Rating");
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));

        TableColumn<Anime, String> studioColumn = new TableColumn<>("Studio");
        studioColumn.setCellValueFactory(new PropertyValueFactory<>("studio"));

        TableColumn<Anime, Integer> startYearColumn = new TableColumn<>("Start Year");
        startYearColumn.setCellValueFactory(new PropertyValueFactory<>("startYear"));

        TableColumn<Anime, Integer> endYearColumn = new TableColumn<>("End Year");
        endYearColumn.setCellValueFactory(new PropertyValueFactory<>("endYear"));

        TableColumn<Anime, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        tableView.getColumns().addAll(titleColumn, genreColumn, episodesColumn, ratingColumn, studioColumn, startYearColumn, endYearColumn, typeColumn);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
}
