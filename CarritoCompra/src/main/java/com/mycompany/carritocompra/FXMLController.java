package com.mycompany.carritocompra;

import com.mycompany.carritocompra.modelo.Articulo;
import com.mycompany.carritocompra.modelo.ManejarDB;
import com.mycompany.carritocompra.modelo.Pedido;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class FXMLController implements Initializable {
    
    private Label label;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCantidad;
    @FXML
    private ListView<Articulo> listV;
    @FXML
    private Button btnCrearProducto;
    
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
      //signin.addEventHandler(MouseEvent.MOUSE_CLICKED, evt -> registrarse(evt));
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
        //ManejarDB.crearCliente(new Cliente(contraseña.getText() ,usuario.getText()));

        return dialog;

    }
   

    
    public void actualizarListView() {
        try {

            List<Articulo> compra = ManejarDB.obtenerArticulos();
            ObservableList<Articulo> observableList = FXCollections.observableList(compra);

            listV.setItems(observableList);
        } catch (Exception e) {
            System.out.println("________________________________________________");
            System.out.println(e.getMessage());

            System.out.println("________________________________________________");
        }

    }

    @FXML
    private void btnAgregarProducto(MouseEvent event) {
        
        Articulo a = new Articulo();
        a.setArticuloNombre(this.txtNombre.getText());
        a.setArticuloPrecio(Integer.parseInt(this.txtPrecio.getText()));
        a.setArticuloCantidad(Integer.parseInt(this.txtCantidad.getText()));
        ManejarDB.insertarArticulo(a);
        
        this.actualizarListView();
    }
}
