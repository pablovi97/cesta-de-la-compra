package com.mycompany.cestacompra;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import modelo.Compra;
import modelo.MainDB;

public class FXMLController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Label label1;
    @FXML
    private TextField txProducto;
    @FXML
    private TextField txCant;
    @FXML
    private Label lblError;
    @FXML
    private ListView<Compra> listV;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            Compra cp = new Compra();

            cp.setNombreProducto(txProducto.getText());
            cp.setCantidad(Integer.parseInt(txCant.getText()));

            MainDB.insertarCompra(cp);
            actualizarListView();
            lblError.setText("");
            txProducto.setText("");
            txCant.setText("");
        } catch (NumberFormatException numberFormatException) {

            lblError.setText("No se ha podido introducir a la cesta! ");
        }

    }

    public void actualizarListView() {
        try {

            List<Compra> compra = MainDB.obtenerCompras();
            ObservableList<Compra> observableList = FXCollections.observableList(compra);

            listV.setItems(observableList);
        } catch (Exception e) {
            System.out.println("________________________________________________");
            System.out.println(e.getMessage());

            System.out.println("_______________________________________________");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
