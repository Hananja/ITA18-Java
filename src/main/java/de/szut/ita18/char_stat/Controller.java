package de.szut.ita18.char_stat;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Controller {
    @FXML
    private NumberAxis numberAxis;
    @FXML
    private CategoryAxis categoryAxis;
    @FXML
    private BarChart<String,Integer> chart;
    @FXML
    private Pane rootPane;
    private Set<String> visibleCharacters = new TreeSet<>(Arrays.asList(
            "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ":", ";", "<", "=", ">", "?",
            "@", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "[", "\\", "]", "^", "_",
            "`", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
            "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "{", "|", "}", "~"
    ));
    private boolean isFiltered;
    private CharStat charStat = new CharStat();
    private String selectedFilePath = "";

    public void onMenuOpen(ActionEvent actionEvent) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            try {
                charStat.add(new FileInputStream(selectedFile));
                selectedFilePath = selectedFile.getAbsolutePath();
                updateData();
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Fehler!");
                alert.setHeaderText("Ein Fehler ist aufgetreten.");
                alert.setContentText(e.getLocalizedMessage());
                alert.showAndWait();
            }
        }

    }

    public void onMenuExit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void onMenuAbout(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Dialog");
        alert.setHeaderText(null);
        alert.setContentText("CharStat statistic histogram for text files.\n2019 by Europaschule szut");
        alert.showAndWait();
    }

    public void onMenuVisible(ActionEvent actionEvent) {
        isFiltered = ((CheckMenuItem) actionEvent.getSource()).isSelected();
        updateData();
    }

    private void updateData() {
        ObservableList<XYChart.Data<String,Integer>> chartData = FXCollections.observableList(
                charStat.entrySet().parallelStream()
                        .filter(entry -> !isFiltered || visibleCharacters.contains(entry.getKey().toString()))
                        .map(entry -> new XYChart.Data<String, Integer>(entry.getKey().toString(), entry.getValue()))
                        .collect(Collectors.toList()));
        XYChart.Series<String,Integer> series = new XYChart.Series<>(chartData);
        chart.getData().clear();
        chart.getData().add(series);
        series.setName("Character Count");
        chart.setTitle("Character Count: " + selectedFilePath);
        chart.setLegendVisible(false);
        for(Node n:chart.lookupAll(".default-color0.chart-bar")) {
            n.setStyle("-fx-bar-fill: green;");
        }
    }
}
