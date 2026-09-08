
package gestorcampania;

import java.time.LocalDate;

public class ControladorCampania {
    private GestorCampania gestor;
    
    public ControladorCampania(GestorCampania gestor){
        this.gestor = gestor;
    }
    
    public String mostrarCampanias(){
        String mostrar = gestor.mostrarCampania();
        return mostrar;
    }
    
    public void crearCampaniaFija(int idCampania, String nombreCampania, LocalDate fecha, String ubicacion){
        gestor.crearCampaniaFija(idCampania, nombreCampania,fecha, ubicacion);
    }
    public void crearCampaniaFija(int idCampania, String nombreCampania, String ubicacion){
        gestor.crearCampaniaFija(idCampania, nombreCampania, ubicacion);
    }
    public void crearCampaniaMovil(int idCampania, String nombreCampania, LocalDate fecha, String ubicacion){
        gestor.crearCampaniaMovil(idCampania, nombreCampania, fecha, ubicacion);
    }
    public void crearCampaniaMovil(int idCampania, String nombreCampania,String ubicacion){
        gestor.crearCampaniaMovil(idCampania,nombreCampania,ubicacion);
    }
    
    public void eliminarCampania(int idCampania){
        gestor.eliminarCampania(idCampania);
    }
    
    public void modificarCampania(int idCampania, String nombreCampania, LocalDate fecha, String ubicacion){
        gestor.modificarCampanias(idCampania, nombreCampania, fecha, ubicacion);
    }
    
    public int totalSangreDonada(){
        return gestor.totalSangreDonada();
    }
    public int totalDonadores(){
        return gestor.totalDonadores();
    }
    public int totalSangrePorTipo(Sangre tipoSangre){
        return gestor.totalSangreDonadaPorTipo(tipoSangre);
    }
}
