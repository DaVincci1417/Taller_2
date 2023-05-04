package GestionArchivos;

import Model.Cafe;
import Model.Cafeteria;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class GestionDatos {
    public LinkedList<Cafe> obtenerCafes(){
        LinkedList<Cafe> cafes = null;
        Archivo archivo = new Archivo("cafes.txt");
        LinkedList<String> lineas = archivo.obtenerTextoDelArchivoCafe();
        if(lineas != null){
            cafes = new LinkedList<>();
            for(int i = 0; i < lineas.size(); i++){
                String linea = lineas.get(i);
                StringTokenizer tokens = new StringTokenizer(linea, ",");
                String gramosCafe = tokens.nextToken();
                String mililitrosAgua = tokens.nextToken();
                String tamaño = tokens.nextToken();
                String ingEspecial = tokens.nextToken();
                cafes.add(new Cafe(gramosCafe, mililitrosAgua, tamaño, ingEspecial));
            }
        }
        return cafes;
    }
    public LinkedList<Cafeteria> obtenerCafeteria(){
        LinkedList<Cafeteria> cafeteria = null;
        Archivo archivo = new Archivo("cafetería.txt");
        LinkedList<String> lineas = archivo.obtenerTextoDelArchivoCafetería();
        if(lineas != null){
            cafeteria = new LinkedList<>();
            for(int i = 0; i < lineas.size(); i++){
                String linea = lineas.get(i);
                StringTokenizer tokens = new StringTokenizer(linea, ",");
                String nombre = tokens.nextToken();
                String direccion = tokens.nextToken();
                cafeteria.add(new Cafeteria(nombre, direccion));
            }
        }
        return cafeteria;
    }
    public boolean agregarCafe(Cafe cafe) {
        boolean lineaVacia = false;
        try {
            File file = new File("C:\\Users\\56976\\Documents\\Nivel 5\\Ramos\\Laboratorio de Programacion II\\Tareas\\Taller_2\\src\\main\\resources\\Archivos\\cafes.txt");
            if (!file.exists()) {
                file.createNewFile();
                lineaVacia = true;
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            if (lineaVacia == false) {
                bw.newLine();
            }
            bw.write(cafe.toString());
            bw.close();
            fw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al intentar registrar al usuario, favor contactar con administrador");
            return false;
        }
    }
    public boolean agregarCafeteria(Cafeteria cafeteria) {
        boolean lineaVacia = false;
        try {
            File file = new File("C:\\Users\\56976\\Documents\\Nivel 5\\Ramos\\Laboratorio de Programacion II\\Tareas\\Taller_2\\src\\main\\resources\\Archivos\\cafetería.txt");
            if (!file.exists()) {
                file.createNewFile();
                lineaVacia = true;
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            if (lineaVacia == false) {
                bw.newLine();
            }
            bw.write(cafeteria.toString());
            bw.close();
            fw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al intentar registrar al usuario, favor contactar con administrador");
            return false;
        }
    }
}
