package gestorcampania;

import java.util.*;
import java.time.LocalDate;

/*Clase subtipo de campaña para crear una campaña movil*/
public class CampaniaMovil extends Campania {
    /*Uso de arrayLista para ubicacion ya que una campaña movil puede tener mas de una ubicacion 
    ya que pasa en movimiento
    */
    private ArrayList<String> ubicaciones;  
    
    /*Constructor*/
    public CampaniaMovil(int idCampania, String nombreCampania, LocalDate fecha, String ubicaciones){
        super(idCampania, nombreCampania, fecha);
        this.ubicaciones = new ArrayList<>();
        this.ubicaciones.add(ubicaciones);
    }
   
    public void setUbicacion(String ubicacion){
        this.ubicaciones.add(ubicacion);
    }
    
    
     /*METODO MALO QUITAR SOLAMENTE AL TENER EL CSV ARREGLADO*/
    public ArrayList<String> getUbicaciones(){
        return ubicaciones;
    }

    @Override
    public void modificarCampania(String nombreCampania, LocalDate fecha, String ubicacion){
        setNombreCampania(nombreCampania);
        setFecha(fecha);
        setUbicacion(ubicacion);
    }
    
    /*Metodo sobreescrito y devuelve un tipo String con toda la informacion de la campaña ya que 
    sirve para ser usada tanto en ventana como consola y haci se evita tener que retornar el arreglo completo*/
    @Override
    public String mostrarCampania() {
        /*Guarda primero la informacion de la campaña dejando un espacio para poner todas las ubicaciones*/
        String datos = "Id campaña: " + getIdCampania() +
                    "\nNombre campaña: " + getNombreCampania() +
                    "\nFecha campaña: " + getFecha() +
                    "\nUbicaciones: ";
        
        /*Guarda todas las ubicaciones de la campaña hacia abajo*/
        for (String i : ubicaciones) {
            datos += "\n   " + i;
        }

        return datos;
    }
}
