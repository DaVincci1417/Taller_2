package Model;

import GestionArchivos.GestionDatos;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Cafeteria {
    private String nombre;
    private String direccion;
    private ArrayList<String> redesSociales = new ArrayList<>();
    private ArrayList<Cafe> cafes = new ArrayList<>();

    public Cafeteria(){

    }
    public Cafeteria(String nombre, String direccion){
        setNombre(nombre);
        setDireccion(direccion);
    }

    //Getters and Setters
    public String getNombre() {
        return nombre;
    }
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    private void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public ArrayList<String> getRedesSociales() {
        return redesSociales;
    }
    private void setRedesSociales(ArrayList<String> redesSociales) {
        this.redesSociales = redesSociales;
    }
    public ArrayList<Cafe> getCafes() {
        return cafes;
    }
    private void setCafes(ArrayList<Cafe> cafes) {
        this.cafes = cafes;
    }

    public void modificarCafeteria(String atributoQueModifica, ArrayList<String> nuevoValor){
        switch (atributoQueModifica){
            case "nombre":
                for(int i = 0; i < nuevoValor.size(); i++){
                    setNombre(nuevoValor.get(i));
                }
                break;
            case "direccion":
                for(int i = 0; i < nuevoValor.size(); i++){
                    setDireccion(nuevoValor.get(i));
                }
                break;
            case "redesSociales":
                for(int i = 0; i < nuevoValor.size(); i++){
                    redesSociales.add(nuevoValor.get(i));
                }
                break;
            default:
        }
    }
    public void agregarCafe(Cafe cafe){
        GestionDatos gd = new GestionDatos();
        cafes.add(cafe);
        gd.agregarCafe(cafe);
    }
    public void buscarCafe(String tamaño){

    }

    @Override
    public String toString() {
        return "{" + nombre + "," + direccion + "}";
    }
}
