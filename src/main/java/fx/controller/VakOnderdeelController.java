package main.java.fx.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import main.java.fx.model.VakOnderdeel;
import main.java.fx.view.VakListCell;


import java.net.URL;
import java.util.ResourceBundle;

/*
 * Controller voor vak overzicht scherm
 */
public class VakOnderdeelController implements Initializable{

    @FXML
    private ListView<VakOnderdeel> courseContentList;

    private ObservableList<VakOnderdeel> vakObservableList;

    public VakOnderdeelController() {
        vakObservableList = FXCollections.observableArrayList();

        //voeg een paar vakken toe
        vakObservableList.addAll(
                new VakOnderdeel("John Doe", "dit is een beschrijving"),
                new VakOnderdeel("John Doe", "dit is een beschrijving"),
                new VakOnderdeel("John Doe", "dit is een beschrijving"),
                new VakOnderdeel("John Doe", "dit is een beschrijving"),
                new VakOnderdeel("John Doe", "dit is een beschrijving"),
                new VakOnderdeel("John Doe", "dit is een beschrijving")
        );
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        courseContentList.setItems(vakObservableList);
        courseContentList.setCellFactory(CourseListView -> new VakListCell());
    }
}
