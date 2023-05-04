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

    //Metodos que permitiran moverse por el software
    @FXML
    public void ingresarAgregarCafe(){
        panelPrincipal.setVisible(false);

        panelAgregar.setVisible(true);
    }
    @FXML
    public void ingresarBuscarCafes(){
        if(automotora.getVehiculos().size() == 0){
            mensajeErrorBotonBuscar();
        }else{
            panelPrincipal.setVisible(false);

            panelBuscar.setVisible(true);
        }
    }
    private void mensajeErrorBotonBuscar(){
        if(automotora.getVehiculos().size() == 0){
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Buscar Vehiculos");
            mensaje.setHeaderText("Error");
            mensaje.setContentText("No hay vehiculos en la Automotora");
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
        panelCliente.setVisible(false);
        panelAuto.setVisible(false);
        panelBuscar.setVisible(false);
        panelTabla.setVisible(false);

        panelPrincipal.setVisible(true);
    }
    @FXML
    public void volverBuscar(){
        panelPrincipal.setVisible(false);
        panelCliente.setVisible(false);
        panelAuto.setVisible(false);
        panelTabla.setVisible(false);

        panelBuscar.setVisible(true);
        for(int i = 0; i < vehiculosEncontrados.size(); i++){
            vehiculosEncontrados.remove(i);
        }
        listaAutos.setItems(vehiculosEncontrados);
    }


    //Metodos para limpiar las casiilas de las respectivas pestañas
    @FXML
    public void limpiarAgregarCafe(){
        txtNombre.setText(null);
        txtRut.setText(null);
        txtDireccion.setText(null);
        txtCorreo.setText(null);
        txtTelefono.setText(null);
    }
    @FXML
    public void limpiarBuscarCafe(){
        txtMarca.setText(null);
        txtModelo.setText(null);
        txtKilometros.setText(null);
        txtPrecio.setText(null);
        comboBoxAño.getSelectionModel().select(null);
        comboBoxColor.getSelectionModel().select(null);
    }
    @FXML
    public void limpiarEliminarCafe(){
        txtNombre.setText(null);
        txtRut.setText(null);
        txtDireccion.setText(null);
        txtCorreo.setText(null);
        txtTelefono.setText(null);
    }
    @FXML
    public void limiparModificarDatosCafeteria(){
        txtModeloBuscar.setText(null);
        comboBoxMarca.getSelectionModel().select(null);
    }
}