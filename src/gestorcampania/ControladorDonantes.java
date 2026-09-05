
package gestorcampania;


public class ControladorDonantes {
    private GestorCampania gestor;
    
    public ControladorDonantes(GestorCampania gestor){
        this.gestor = gestor;
    }
    
    public void crearDonante(int idCampania, String rut, String nombre, Sangre tipoSangre, int donacion){
        Campania cmp = gestor.buscarCampania(idCampania);
        cmp.crearDonante(rut,nombre,tipoSangre,donacion);
    }
    
    public void eliminarDonante(int idCampania, String rut){
        Campania cmp = gestor.buscarCampania(idCampania);
        cmp.eliminarDonante(rut);
    }
    
    public String mostrarDonantes(int idCampania){
        Campania cmp = gestor.buscarCampania(idCampania);
        return cmp.mostrarDonante();
    }
    
    public void modificarDonante(int idCampania,String rut, String nombreDonante, Sangre tipoSangre, int donacion){
        Campania cmp = gestor.buscarCampania(idCampania);
        cmp.modificarDonante(rut, nombreDonante, tipoSangre, donacion);
    }
}
