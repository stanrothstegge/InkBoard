package main.java.fx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import main.java.fx.model.SearchResult;
import main.java.fx.view.SearchListCell;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller voor het zoekscherm, waar op module kan worden gezocht.
 */
public class SearchResultController implements Initializable {

    @FXML
    private ListView<SearchResult> courseSearchList;

    private ObservableList<SearchResult> searchingObservable;

    public SearchResultController() {
        searchingObservable = FXCollections.observableArrayList();

        searchingObservable.addAll(
                new SearchResult("Ecology 101", "Faculty of extreme stalling", "11-3-12"),
                new SearchResult("Ecology 111", "Faculty of wafwfme stalling", "11-32-12"),
                new SearchResult("Ecology 132", "Faculty of  stalling", "11-3-12"),
                new SearchResult("Ecology 165", "Faculty of ewaffwextreme stalling", "11-39-12"),
                new SearchResult("Ecology 241", "Faculty of extreme stalling", "61-31-12")
        );
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        courseSearchList.setItems(searchingObservable);
        courseSearchList.setCellFactory(SearchListView -> new SearchListCell());
    }
}
