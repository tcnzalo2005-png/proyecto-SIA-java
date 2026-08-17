package gestorcampania;
import java.util.*;
import java.time.LocalDate;

public class Campania {
    private int idCampania;
    private String nombreCampania;
    private Date fecha;
    private HashMap<String , Donante> donantesPorRut;
    
    public Campania(){
        this.donantesPorRut = new HashMap<>();
    }
    public Campania(int idCampania, String nombreCampania , Date fecha){
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
    public Date getFecha(){
        return fecha;
    }
   

    public void setIdCampania(int idAGuardas){
        idCampania = idAGuardas;
    }
    public void setNombreCampania(String nombreAGuardar){
        nombreCampania = nombreAGuardar;
    }
    public void setFecha(Date fechaAGuardar){
        fecha = fechaAGuardar;
    }
    

    public void crearDonante(String rut, String nombreDonante, Sangre tipoSangre, int donacion){
        Donante nuevo = new Donante(rut, nombreDonante, tipoSangre, donacion);
        donantesPorRut.put(rut , nuevo);
    }
    public void eliminarDonante(String rut){
        donantesPorRut.remove(rut);
    }
    public Donante buscarDonante(String rut){
        return donantesPorRut.get(rut);
    }
    public void mostrarDonante(){
        for(Donante i : donantesPorRut.values()){
            System.out.println("Rut: " + i.getRut());
            System.out.println("Nombre: " + i.getNombreDonante());
            System.out.println("Tipo sangre: " + i.getTipoSangre());
            System.out.println("Donacion: " + i.getDonacion());
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
    
}
