package gestorcampania;

import gestorcampania.herramientas.excepciones.DonarException;


/*Clase administrar al donante*/
public class Donante {
    private String rut;
    private String nombreDonante;
    private Sangre tipoSangre;
    private int donacion;

    /*Constructor*/
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

    
    public void setNombreDonante(String nombreDonante){
        this.nombreDonante = nombreDonante;
    }

    public void setDonacion(int donacion)throws DonarException{
        if(donacion < 0){
            throw new DonarException("ERROR, dato negativo ingresado ");
        }
        this.donacion = donacion;
    }
    public void setDonacion(double donacion)throws DonarException{
        if(donacion < 0){
            throw new DonarException("ERROR, dato negativo ingresado ");
        }
        this.donacion = (int) (Math.round(donacion));
    }

    public void setTipoSangre(Sangre tipoSangre){
        this.tipoSangre = tipoSangre;
    }

    /*Metodo para aumentar la cantida de sangre que dono un donante*/
    public void donar(int donacion) throws DonarException
    {
        if(donacion < 0){
            throw new DonarException("ERROR, dato negativo ingresado ");
        }
        this.donacion += donacion;
    }

    /*Metodo para agrupar la informacion del donante en un String y mandarlo*/
    public String mostrar(){
        return  "Rut: " + getRut() +
                "\nNombre: " + getNombreDonante() +
                "\nTipo sangre: " + getTipoSangre() +
                "\nDonacion: " + getDonacion();
    }

    /*Metodo para modificar al donante*/
    public void modificarDonante(String nombreDonante, Sangre tipoSangre){
        setNombreDonante(nombreDonante);
        setTipoSangre(tipoSangre);
        
    }
}
