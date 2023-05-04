package Vista_Controller;

import GestionArchivos.GestionDatos;
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

    GestionDatos gd = new GestionDatos();
    Cafeteria cafeteria = new Cafeteria();
    ObservableList<Cafe> cafesEncontrados;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gd.agregarCafeteria(cafeteria);

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

    //Agregar Cafe
    @FXML
    public void agregarCafe(){
        if(txtGrCafe.getText().isEmpty() || txtMlAgua.getText().isEmpty() ||
                comboTamaño.getSelectionModel().isEmpty() || comboOpcionales.getSelectionModel().isEmpty()){
            mensajeErrorBotonAgregarCafe();
        }else{
            cafeteria.agregarCafe(new Cafe(txtGrCafe.getText(), txtMlAgua.getText(),
                    comboTamaño.getSelectionModel().getSelectedItem(), comboOpcionales.getSelectionModel().getSelectedItem()));
            mensajeConfirmacionAgregarCafe();
        }
    }
    private void mensajeConfirmacionAgregarCafe(){
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

    //Eliminar Cafe
    @FXML
    public void eliminarCafe(){
        if(txtGrCafeEliminar.getText().isEmpty() || txtMlAguaEliminar.getText().isEmpty() ||
                comboTamañoEliminar.getSelectionModel().isEmpty() || comboOpcionalesEliminar.getSelectionModel().isEmpty()){
            mensajeErrorBotonElimnarCafe();
        }else{
            cafeteria.eliminarCafe(new Cafe(txtGrCafeEliminar.getText(), txtMlAguaEliminar.getText(),
                    comboTamañoEliminar.getSelectionModel().getSelectedItem(), comboOpcionalesEliminar.getSelectionModel().getSelectedItem()));
            mensajeConfirmacionEliminarCafe();
        }
    }
    private void mensajeConfirmacionEliminarCafe(){
        Alert mensaje = new Alert(Alert.AlertType.NONE);
        mensaje.setTitle("Eliminar Cafe");
        mensaje.setHeaderText("Accion concretada");
        mensaje.setContentText("Cafe eliminado correctamente");
        ButtonType botonOk = new ButtonType("Ok");
        mensaje.getButtonTypes().setAll(botonOk);
        mensaje.show();
    }
    private void mensajeErrorBotonElimnarCafe(){
        if (txtGrCafeEliminar.getText().isEmpty() || txtMlAguaEliminar.getText().isEmpty() ||
                comboTamañoEliminar.getSelectionModel().isEmpty() || comboOpcionalesEliminar.getSelectionModel().isEmpty()) {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Eliminar Cafe");
            mensaje.setHeaderText("Error");
            mensaje.setContentText("No puede dejar campos vacios");
            ButtonType botonOk = new ButtonType("Ok");
            mensaje.getButtonTypes().setAll(botonOk);
            mensaje.show();
        }
    }


    //Buscar Cafe
    @FXML
    public void buscarCafe() {
        if (comboTamañoBusca.getSelectionModel().isEmpty()) {
            mensajeBotonBuscarVehiculo();
        } else {
            if (cafeteria.buscarCafe(comboTamañoBusca.getSelectionModel().getSelectedItem()).size() == 0) {
                mensajeBotonBuscarVehiculo();
            } else {
                panelBuscar.setVisible(false);
                panelResultado.setVisible(true);
                cafesEncontrados.addAll(cafeteria.buscarCafe(comboTamañoBusca.getSelectionModel().getSelectedItem()));
            }
        }
    }
    private void mensajeBotonBuscarVehiculo(){
        if(comboTamañoBusca.getSelectionModel().isEmpty()){
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Buscar Cafes");
            mensaje.setHeaderText("Error");
            mensaje.setContentText("No puede dejar campos vacios");
            ButtonType botonOk = new ButtonType("Ok");
            mensaje.getButtonTypes().setAll(botonOk);
            mensaje.show();
        }
        if(cafeteria.buscarCafe(comboTamañoBusca.getSelectionModel().getSelectedItem()).size() == 0){
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Buscar Cafes");
            mensaje.setHeaderText("Error");
            mensaje.setContentText("No se ha encontrado cafes");
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