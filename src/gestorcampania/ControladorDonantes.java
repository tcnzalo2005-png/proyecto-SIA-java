
package gestorcampania;

import gestorcampania.herramientas.excepciones.DonarException;


public class ControladorDonantes {
    private GestorCampania gestor;
    
    public ControladorDonantes(GestorCampania gestor){
        this.gestor = gestor;
    }
    
    public void crearDonante(int idCampania, String rut, String nombre, Sangre tipoSangre, int donacion){
        Campania cmp = gestor.buscarCampania(idCampania);
        if(cmp != null){
            cmp.crearDonante(rut,nombre,tipoSangre,donacion);
        }
    }
    
    public void eliminarDonante(int idCampania, String rut){
        Campania cmp = gestor.buscarCampania(idCampania);
        if(cmp != null){
            cmp.eliminarDonante(rut);
        }
    }
    
    public String mostrarDonantes(int idCampania){
        Campania cmp = gestor.buscarCampania(idCampania);
        if(cmp != null){
            return cmp.mostrarDonante();
        }
        return "No existe campaña";
    }
    
    public void modificarDonante(int idCampania,String rut, String nombreDonante, Sangre tipoSangre){
        Campania cmp = gestor.buscarCampania(idCampania);
        if(cmp != null){
            cmp.modificarDonante(rut, nombreDonante, tipoSangre);
        }
    }
    
    public void donar(int idCampania, String rut, int cantDonacion) throws DonarException{
        Campania campania = gestor.buscarCampania(idCampania);
        if(campania != null){
            Donante donante = campania.buscarDonante(rut);
            if(donante == null){
               throw new DonarException("ERROR, no se encontro el donante ");
            }
            donante.donar(cantDonacion);
        }
    }
    
    public String buscarDonante(int idCampania, String rut) {
        Campania campania = gestor.buscarCampania(idCampania);
        if(campania != null){
            try{
                Donante donante = campania.buscarDonante(rut);
                return donante.mostrar();
            }catch(DonarException e){
                return e.getMessage();
            }
           
            
            
        }
        return "No se encontro campaña";
    }
}
