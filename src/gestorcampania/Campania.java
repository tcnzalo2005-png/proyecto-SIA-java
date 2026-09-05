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
    public HashMap<String, Donante> getDonantesPorRut(){
        return donantesPorRut;
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
    public String mostrarDonante(){
        String cosa = "";
        for(Donante i : donantesPorRut.values()){
            cosa += i.mostrar();
            cosa += "\n------------------------------\n";
        }
        return cosa;
    }
    public void modificarDonante(String rut, String nombreDonante, Sangre tipoSangre, int donacion){
        Donante d = donantesPorRut.get(rut);
        
        if(d != null){
            d.modificarDonante(nombreDonante, tipoSangre, donacion);
        }
    }
    

    public abstract String mostrarCampania();
    public abstract  void modificarCampania(String nombreCampania, LocalDate fecha, String ubicacion);
}
