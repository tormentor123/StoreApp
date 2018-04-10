package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.text.html.ListView;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class GUIController implements Initializable {

    @FXML
    private javafx.scene.control.ListView<String> listView;

    @FXML
    private javafx.scene.control.TextField miliseconds;

    private DbController dbcontroller=null;

    public GUIController(DbController controller) {
        this.dbcontroller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {


    }

    public void PrintAllTRacks(ActionEvent actionEvent) {
            dbcontroller.getTrackList().clear();;
            dbcontroller.printallTracks();

            ObservableList<String> items = listView.getItems();

            items.clear();

            Iterator<String> it=dbcontroller.getTrackList().listIterator();
        while(it.hasNext())
            {
                String name=it.next();
                listView.getItems().add(name);
            }
    }

    public void getSongs(ActionEvent actionEvent)
    {
        dbcontroller.getSongs().clear();
        dbcontroller.getSongs(Integer.parseInt(miliseconds.getText()));

       Login login=new Login(this);

        ObservableList<String> items = listView.getItems();

        items.clear();
        Iterator<String> it=dbcontroller.getSongs().listIterator();

        while (it.hasNext())
        {
            String name = it.next();
            listView.getItems().add(name);
        }

    }
    public void login(ActionEvent actionEvent)
    {
        actionEvent.consume();
    }
}
