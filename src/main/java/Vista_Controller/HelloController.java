package Vista_Controller;

import Model.Cafe;
import Model.Cafeteria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable{
    //Paneles
    @FXML
    AnchorPane panelPrincipal, panelAgregar, panelBuscar, panelResultado, panelEliminar, panelModificar;
    //Panel Agregar
    @FXML
    TextField txtGrCafe, txtMlAgua;
    @FXML
    ComboBox<String> comboTamaño, comboOpcionales;

    //Paneñ Buscar
    @FXML
    ComboBox<String> comboTamañoBusca;
    //Panel Resultado
    @FXML
    ListView<Cafe> listaCafes;

    //Panel Eliminar Cafe
    @FXML
    TextField txtGrCafeEliminar, txtMlAguaEliminar;
    @FXML
    ComboBox<String> comboTamañoEliminar, comboOpcionalesEliminar;

    //Panel Modificar Datos Cafeteria
    @FXML
    TextField txtNombre, txtDireccion;
    @FXML
    RadioButton radioFacebook, radioTwitter, radioInstagram;

    Cafeteria cafeteria = new Cafeteria();
    ObservableList<Cafe> cafesEncontrados;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboTamaño.setItems(agregarTamañosComboBox());
        comboTamañoEliminar.setItems(agregarTamañosComboBox());
        comboTamañoBusca.setItems(agregarTamañosComboBox());
        comboOpcionales.setItems(agregarIngredientesEspeciales());
        comboOpcionalesEliminar.setItems(agregarIngredientesEspeciales());

        cafesEncontrados = FXCollections.observableArrayList();
        listaCafes.setItems(cafesEncontrados);
    }

    //Metodos para llenar ComboBox
    private ObservableList<String> agregarTamañosComboBox(){
        ObservableList<String> tamaños = FXCollections.observableArrayList();
        tamaños.add("Pequeño");
        tamaños.add("Mediano");
        tamaños.add("Grande");
        return tamaños;
    }
    private ObservableList<String> agregarIngredientesEspeciales(){
        ObservableList<String> ingEspeciales = FXCollections.observableArrayList();
        ingEspeciales.add("Crema");
        ingEspeciales.add("Leche");
        ingEspeciales.add("Chocolate");
        return ingEspeciales;
    }

    //Agregar Clientes
    @FXML
    public void agregarCliente(){
        if(txtNombre.getText().isEmpty() || txtRut.getText().isEmpty() ||
                txtDireccion.getText().isEmpty() || txtCorreo.getText().isEmpty()
                || txtTelefono.getText().isEmpty()){
            mensajeErrorBotonAgregarCafe();
        }else{

        }
    }
    private void mensajeConfirmacionAgregarClientes(){
        Alert mensaje = new Alert(Alert.AlertType.NONE);
        mensaje.setTitle("Agregar Cafe");
        mensaje.setHeaderText("Registro exitoso");
        mensaje.setContentText("Cafe agregado correctamente");
        ButtonType botonOk = new ButtonType("Ok");
        mensaje.getButtonTypes().setAll(botonOk);
        mensaje.show();
    }
    private void mensajeErrorBotonAgregarCafe() {
        if (txtGrCafe.getText().isEmpty() || txtMlAgua.getText().isEmpty() ||
                comboTamaño.getSelectionModel().isEmpty() || comboOpcionales.getSelectionModel().isEmpty()) {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Agregar Cafe");
            mensaje.setHeaderText("Error");
            mensaje.setContentText("No puede dejar campos vacios");
            ButtonType botonOk = new ButtonType("Ok");
            mensaje.getButtonTypes().setAll(botonOk);
            mensaje.show();
        }
    }

    //Agregar Vehiculo
    @FXML
    public void agregarVehiculo(){
        if(txtMarca.getText().isEmpty() || txtModelo.getText().isEmpty() ||
                txtKilometros.getText().isEmpty() || txtPrecio.getText().isEmpty()
                || comboBoxAño.getSelectionModel().isEmpty() || comboBoxColor.getSelectionModel().isEmpty()){
            mensajeErrorBotonAgregarVehiculo();
        }else{
            automotora.agregarVehiculo(new Vehiculo(
                    txtMarca.getText(), txtModelo.getText(), comboBoxAño.getSelectionModel().getSelectedItem(),
                    comboBoxColor.getSelectionModel().getSelectedItem(), txtKilometros.getText(), txtPrecio.getText()));
            mensajeConfirmacionAgregarVehiculo();
        }
    }
    private void mensajeConfirmacionAgregarVehiculo(){
        Alert mensaje = new Alert(Alert.AlertType.NONE);
        mensaje.setTitle("Agregar Vehiculo");
        mensaje.setHeaderText("Registro exitoso");
        mensaje.setContentText("Vehiculo agregado correctamente");
        ButtonType botonOk = new ButtonType("Ok");
        mensaje.getButtonTypes().setAll(botonOk);
        mensaje.show();
    }
    private void mensajeErrorBotonAgregarVehiculo(){
        if(txtMarca.getText().isEmpty() || txtModelo.getText().isEmpty() ||
                txtKilometros.getText().isEmpty() || txtPrecio.getText().isEmpty()
                || comboBoxAño.getSelectionModel().isEmpty() || comboBoxColor.getSelectionModel().isEmpty()){
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Agregar Vehiculo");
            mensaje.setHeaderText("Error");
            mensaje.setContentText("No puede dejar campos vacios");
            ButtonType botonOk = new ButtonType("Ok");
            mensaje.getButtonTypes().setAll(botonOk);
            mensaje.show();
        }
    }


    //Buscar Vehiculo
    @FXML
    public void buscarVehiculo(ActionEvent event) {
        if (txtModeloBuscar.getText().isEmpty() || comboBoxMarca.getSelectionModel().isEmpty()) {
            mensajeBotonBuscarVehiculo();
        } else {
            if (automotora.buscarVehiculos(comboBoxMarca.getSelectionModel().getSelectedItem(), txtModeloBuscar.getText()).size() == 0) {
                mensajeBotonBuscarVehiculo();
            } else {
                panelBuscar.setVisible(false);
                panelTabla.setVisible(true);
                vehiculosEncontrados.addAll(automotora.buscarVehiculos(comboBoxMarca.getSelectionModel().getSelectedItem(), txtModeloBuscar.getText()));
            }
        }
    }
    private void mensajeBotonBuscarVehiculo(){
        if(txtModeloBuscar.getText().isEmpty() || comboBoxMarca.getSelectionModel().isEmpty()){
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Buscar Vehiculo");
            mensaje.setHeaderText("Error");
            mensaje.setContentText("No puede dejar campos vacios");
            ButtonType botonOk = new ButtonType("Ok");
            mensaje.getButtonTypes().setAll(botonOk);
            mensaje.show();
        }
        if(automotora.buscarVehiculos(comboBoxMarca.getSelectionModel().getSelectedItem(), txtModeloBuscar.getText()).size() == 0){
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Buscar Vehiculo");
            mensaje.setHeaderText("Error");
            mensaje.setContentText("No se ha encontrado vehiculos");
            ButtonType botonOk = new ButtonType("Ok");
            mensaje.getButtonTypes().setAll(botonOk);
            mensaje.show();
        }
    }

    //Metodos que permitiran moverse por el software
    @FXML
    public void ingresarAgregarCafe(){
        panelPrincipal.setVisible(false);

        panelAgregar.setVisible(true);
    }
    @FXML
    public void ingresarBuscarCafes(){
        if(cafeteria.getCafes().size() == 0){
            mensajeErrorBotonBuscar();
        }else{
            panelPrincipal.setVisible(false);

            panelBuscar.setVisible(true);
        }
    }
    private void mensajeErrorBotonBuscar(){
        if(cafeteria.getCafes().size() == 0){
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Buscar Cafes");
            mensaje.setHeaderText("Error");
            mensaje.setContentText("Aun no hay cafes en la Cafeteria");
            ButtonType botonOk = new ButtonType("Ok");
            mensaje.getButtonTypes().setAll(botonOk);
            mensaje.show();
        }
    }
    @FXML
    public void ingresarEliminarCafe(){
        panelPrincipal.setVisible(false);

        panelEliminar.setVisible(true);
    }
    @FXML
    public void ingresarModificarCafeteria(){
        panelPrincipal.setVisible(false);

        panelModificar.setVisible(true);
    }

    @FXML
    public void volverPrincipal(){
        panelAgregar.setVisible(false);
        panelBuscar.setVisible(false);
        panelResultado.setVisible(false);
        panelEliminar.setVisible(false);
        panelModificar.setVisible(false);

        panelPrincipal.setVisible(true);
    }
    @FXML
    public void volverBuscar(){
        panelAgregar.setVisible(false);
        panelBuscar.setVisible(false);
        panelResultado.setVisible(false);
        panelEliminar.setVisible(false);
        panelModificar.setVisible(false);

        panelPrincipal.setVisible(true);
        for(int i = 0; i < cafesEncontrados.size(); i++){
            cafesEncontrados.remove(i);
        }
        listaCafes.setItems(cafesEncontrados);
    }


    //Metodos para limpiar las casiilas de las respectivas pestañas
    @FXML
    public void limpiarAgregarCafe(){
        txtGrCafe.setText(null);
        txtMlAgua.setText(null);
        comboTamaño.getSelectionModel().select(null);
        comboOpcionales.getSelectionModel().select(null);
    }
    @FXML
    public void limpiarBuscarCafe(){
        comboTamañoBusca.getSelectionModel().select(null);
    }
    @FXML
    public void limpiarEliminarCafe(){
        txtGrCafeEliminar.setText(null);
        txtMlAguaEliminar.setText(null);
        comboTamañoEliminar.getSelectionModel().select(null);
        comboOpcionalesEliminar.getSelectionModel().select(null);
    }
    @FXML
    public void limiparModificarDatosCafeteria(){
        txtNombre.setText(null);
        txtDireccion.setText(null);
        radioFacebook.setSelected(false);
        radioTwitter.setSelected(false);
        radioInstagram.setSelected(false);
    }
}