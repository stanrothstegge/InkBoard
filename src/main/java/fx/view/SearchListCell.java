package main.java.fx.view;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.java.fx.model.SearchResult;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class beschrijft de 'logica' van een zoekresultaat.
 * Update xml elementen met gebruikersdata.
 *
 * @author stan Rothstegge
 */
public class SearchListCell extends ListCell<SearchResult> {


    @FXML
    private Text resultTitle;       //Titel van een module
    @FXML
    private Text resultCategory;     //groep van de module
    @FXML
    private Text resultUpdate;
    @FXML
    private Pane searchCell;
    @FXML
    private Button verderButton;
    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(SearchResult searchResult, boolean empty) {
        super.updateItem(searchResult, empty);

        //nullcheck
        if (empty || searchResult == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (mLLoader == null) {
                //laad de fxml compositie voor een item uit de lijst.
                mLLoader = new FXMLLoader(getClass().getResource("/main/java/fx/view/ListUtil/searchResultCell.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //Set de naam
                resultTitle.setText(searchResult.getCouseName());
                //Set de beschrijving
                resultCategory.setText(searchResult.getCourseFaculty());
                resultUpdate.setText(searchResult.getLastUpdated());

                verderButton.setOnMouseClicked((event) -> {
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("/main/java/fx/view/UI/courseMain.fxml"));

                        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
                        Stage stage = new Stage();
                        stage.setTitle("New Window");
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        Logger logger = Logger.getLogger(getClass().getName());
                        logger.log(Level.SEVERE, "Failed to create new Window.", e);
                    }
                });

            }
            setText(null);
            setGraphic(searchCell);
        }

    }
}
