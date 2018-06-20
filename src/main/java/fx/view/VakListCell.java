package main.java.fx.view;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Pane;
import main.java.fx.model.VakOnderdeel;

import java.io.IOException;


public class VakListCell extends ListCell<VakOnderdeel> {

    @FXML
    private Label labelName;
    @FXML
    private Label labelDescription;
    @FXML
    private Button verder;

    private FXMLLoader mLLoader;

    @FXML
    private Pane paneCell;

    @Override
    protected void updateItem(VakOnderdeel vakOnderdeel, boolean empty) {
        super.updateItem(vakOnderdeel, empty);

        //nullcheck
        if (empty || vakOnderdeel == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (mLLoader == null) {
                //laad de fxml compositie voor een item uit de lijst.
                mLLoader = new FXMLLoader(getClass().getResource("/main/java/fx/view/ListUtil/listCell.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //Set de naam
                labelName.setText(vakOnderdeel.getTitle());
                //Set de beschrijving
                labelDescription.setText(vakOnderdeel.getDescription());

                System.out.println("hello");
            }
            setText(null);
            setGraphic(paneCell);
        }
    }

    
}
