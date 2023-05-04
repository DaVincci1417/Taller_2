package Model;

public class Cafe {
    private  String gramosCafe;
    private String mililitrosAga;
    private String tamaño;
    private String ingEspecial;

    public Cafe(String gramosCafe, String mililitrosAga, String tamaño,
                   String ingEspecial){
        setGramosCafe(gramosCafe);
        setMililitrosAga(mililitrosAga);
        setTamaño(tamaño);
        setIngEspecial(ingEspecial);
    }

    //Getters and Setters
    public String getGramosCafe() {
        return gramosCafe;
    }
    private void setGramosCafe(String gramosCafe) {
        this.gramosCafe = gramosCafe;
    }
    public String getMililitrosAga() {
        return mililitrosAga;
    }
    private void setMililitrosAga(String mililitrosAga) {
        this.mililitrosAga = mililitrosAga;
    }
    public String getTamaño() {
        return tamaño;
    }
    private void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }
    public String getIngEspecial() {
        return ingEspecial;
    }
    private void setIngEspecial(String ingEspecial) {
        this.ingEspecial = ingEspecial;
    }

    @Override
    public String toString() {
        return "{" + gramosCafe + "," +
               mililitrosAga + "," +
                tamaño + "," +
                ingEspecial + "}";
    }
}
