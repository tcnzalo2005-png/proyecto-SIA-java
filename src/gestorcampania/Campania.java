package gestorcampania;

import java.util.*;
import java.time.LocalDate;

public abstract class Campania {
    private int idCampania;
    private String nombreCampania;
    private LocalDate fecha;
    private HashMap<String, Donante> donantesPorRut;
    
    public Campania(int idCampania, String nombreCampania , LocalDate fecha){
        this.idCampania = idCampania;
        this.nombreCampania = nombreCampania;
        this.fecha = fecha;
        this.donantesPorRut = new HashMap<>();
    }
    
    public int getIdCampania(){
        return idCampania;
    }
    public String getNombreCampania(){
        return nombreCampania;
    }
    public LocalDate getFecha(){
        return fecha;
    }
   

    public void setNombreCampania(String nombreAGuardar){
        nombreCampania = nombreAGuardar;
    }
    public void setFecha(LocalDate fechaAGuardar){
        fecha = fechaAGuardar;
    }
    

    public void crearDonante(String rut, String nombreDonante, Sangre tipoSangre, int donacion){
        Donante nuevo = new Donante(rut, nombreDonante, tipoSangre, donacion);
        donantesPorRut.put(rut , nuevo);
    }
    public void crearDonante(String rut, String nombreDonante, Sangre tipoSangre){
        Donante nuevo = new Donante(rut, nombreDonante, tipoSangre, 0);
        donantesPorRut.put(rut, nuevo);
    }
    
    public void eliminarDonante(String rut){
        donantesPorRut.remove(rut);
    }
    public Donante buscarDonante(String rut){
        return donantesPorRut.get(rut);
    }
    public void mostrarDonante(){
        for(Donante i : donantesPorRut.values()){
            i.mostrar();
        }
    }
    public void modificarDonante(String rut, String nombreDonante, Sangre tipoSangre, int donacion){
        Donante d = donantesPorRut.get(rut);
        
        if(d != null){
            d.setNombreDonante(nombreDonante);
            d.setTipoSangre(tipoSangre);
            d.setDonacion(donacion);
        }
    }
    

    public abstract void mostrarCampania();
}
