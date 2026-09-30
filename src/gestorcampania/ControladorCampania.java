
package gestorcampania;

import java.time.LocalDate;

/*Clase que sirve como controlador para la ventana de todo lo que tenga que ver con campaña*/
public class ControladorCampania {
    private GestorCampania gestor;
    
    /*Constructor para recibir el gestor */
    public ControladorCampania(GestorCampania gestor){
        this.gestor = gestor;
    }
    
    public String mostrarCampanias(){
        String mostrar = gestor.mostrarCampania();
        return mostrar;
    }
    
    /*Se hace sobrecarga de metodo tanto para crear campaña fija y movil ya que cada una depende si se ingresa alguna fecha
    por el usuario o ninguna (en ese caso el sistema le asigna fecha de forma automatica
    */
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
    
    /*Se hace uso de sobrecarga de metodos para modificar campaña dependiendo de la fecha si es ingresada o no por el usuario 
    
    */
    public void modificarCampania(int idCampania, String nombreCampania, LocalDate fecha, String ubicacion){
        gestor.modificarCampanias(idCampania, nombreCampania, fecha, ubicacion);
    }
    public void modificarCampania(int idCampania, String nombreCampania, String ubicacion){
        gestor.modificarCampanias(idCampania, nombreCampania, ubicacion);
    }
    
    /*Metodo extra para el total de sangre donanda (de todos los tipos)*/
    public int totalSangreDonada(){
        return gestor.totalSangreDonada();
    }
    /*Metodo extra para el total de donadores */
    public int totalDonadores(){
        return gestor.totalDonadores();
    }
    /*Metodo extra para el total de sangre donada de un tipo en especifico*/
    public int totalSangrePorTipo(Sangre tipoSangre){
        return gestor.totalSangreDonadaPorTipo(tipoSangre);
    }
    
    public String buscarCampania(int idCampania){
        Campania campania = gestor.buscarCampania(idCampania);
        if(campania != null){
            return campania.mostrarCampania();
        }
        return "No se encontro campaña";
    }
}
