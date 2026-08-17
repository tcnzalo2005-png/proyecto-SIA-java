package gestorcampania;


public class Donante {
    private String rut;
    private String nombreDonante;
    private Sangre tipoSangre;
    private int donacion;

    public Donante(String rut, String nombreDonante, Sangre tipoSangre, int donacion){
        this.rut = rut;
        this.nombreDonante = nombreDonante;
        this.donacion = donacion;
        this.tipoSangre = tipoSangre;
    }


    public String getRut(){
        return rut;
    }
    public String getNombreDonante(){
        return nombreDonante;
    }
    public int getDonacion(){
        return donacion;
    }
    public Sangre getTipoSangre(){
        return tipoSangre;
    }

    public void setRut(String rut){
        this.rut = rut;
    }
    public void setNombreDonante(String nombreDonante){
        this.nombreDonante = nombreDonante;
    }
    public void setDonacion(int donacion){
        this.donacion = donacion;
    }
    public void setTipoSangre(Sangre tipoSangre){
        this.tipoSangre = tipoSangre;
    }
}
