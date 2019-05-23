package com.mycompany.cestacompra;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;
import java.awt.Insets;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import modelo.Clientes;
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
            // MainDB.transaccionActiva();
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
        Dialog dialog = login();
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {

        }
        actualizarListView();
    }

    public Dialog login() {

        Dialog dialog = new Dialog<>();
        dialog.setTitle("LOGIN");
        dialog.setHeaderText("Cesta de la compra");
        Button signin = new Button();
        Button login = new Button();
        login.setText("LOGIN");
        signin.setText("SIGN IN");
        signin.addEventHandler(MouseEvent.MOUSE_CLICKED, evt -> registrarse(evt));
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        Label lbl = new Label();
        lbl.setText("Usuario");
        Label lbl2 = new Label();
        lbl2.setText("Contraseña");
        TextField usuario = new TextField();
        TextField contraseña = new TextField();
        GridPane gridpane = new GridPane();
        dialog.getDialogPane().setContent(gridpane);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(50);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50);
        gridpane.getColumnConstraints().addAll(column1, column2);
        gridpane.add(lbl, 0, 0);
        gridpane.add(lbl2, 0, 1);
        gridpane.add(usuario, 1, 0);
        gridpane.add(contraseña, 1, 1);
        gridpane.add(login, 1, 2);
        gridpane.add(signin, 0, 2);

        return dialog;
    }

    public Dialog registrarse(Event evt) {

        Dialog dialog = new Dialog<>();
        dialog.setTitle("SIGN IN");
        dialog.setHeaderText("Cesta de la compra");

        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        Label lbl = new Label();
        lbl.setText("Usuario");
        Label lbl2 = new Label();
        lbl2.setText("Contraseña");
        TextField usuario = new TextField();
        TextField contraseña = new TextField();
        GridPane gridpane = new GridPane();
        dialog.getDialogPane().setContent(gridpane);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(50);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50);
        gridpane.getColumnConstraints().addAll(column1, column2);
        gridpane.add(lbl, 0, 0);
        gridpane.add(lbl2, 0, 1);
        gridpane.add(usuario, 1, 0);
        gridpane.add(contraseña, 1, 1);
        MainDB.crearCliente(new Clientes(contraseña.getText(), usuario.getText()));

        return dialog;

    }

}
