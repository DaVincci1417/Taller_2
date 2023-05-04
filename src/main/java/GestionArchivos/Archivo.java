package GestionArchivos;

import java.io.*;
import java.util.LinkedList;

public class Archivo{
    private String nombreArchivo;

    //Constructor
    public Archivo(String nombreArchivo) {
        setNombreArchivo(nombreArchivo);
    }

    //Getter and Setter
    public String getNombreArchivo() {
        return nombreArchivo;
    }
    private void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    //Operation
    public LinkedList<String> obtenerTextoDelArchivoCafe(){
        LinkedList<String> texto = null;
        try {
            File archivo = new File("C:\\Users\\56976\\Documents\\Nivel 5\\Ramos\\Laboratorio de Programacion II\\Tareas\\Ayudantia_5\\src\\main\\resources\\Archivos\\cafes.txt");
            if(archivo.exists()){
                texto = new LinkedList<>();
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String linea;
                while ((linea = br.readLine()) != null){
                    texto.add(linea);
                }
                br.close();
            }else{
                System.out.println("El archivo no existe.");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return texto;
    }
    public LinkedList<String> obtenerTextoDelArchivoCafetería(){
        LinkedList<String> texto = null;
        try {
            File archivo = new File("C:\\Users\\56976\\Documents\\Nivel 5\\Ramos\\Laboratorio de Programacion II\\Tareas\\Ayudantia_5\\src\\main\\resources\\Archivos\\cafetería.txt");
            if(archivo.exists()){
                texto = new LinkedList<>();
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String linea;
                while ((linea = br.readLine()) != null){
                    texto.add(linea);
                }
                br.close();
            }else{
                System.out.println("El archivo no existe.");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return texto;
    }
}
