
package gestorcampania;

import gestorcampania.herramientas.excepciones.DonarException;


/*Clase que sirve como controlador para todo lo que tenga que ver con el donante*/
public class ControladorDonantes {
    private GestorCampania gestor;
    
    /*Constructor usado para resibir el gestor de campaña*/
    public ControladorDonantes(GestorCampania gestor){
        this.gestor = gestor;
    }
    /*
    Crea y registra un donante en una campaña en especifica
    */
    public void crearDonante(int idCampania, String rut, String nombre, Sangre tipoSangre, int donacion){
        Campania cmp = gestor.buscarCampania(idCampania);
        if(cmp != null){
            cmp.crearDonante(rut,nombre,tipoSangre,donacion);
        }
    }
    
    /*
    Elimina un donante en especifico
    */
    public void eliminarDonante(int idCampania, String rut){
        Campania cmp = gestor.buscarCampania(idCampania);
        if(cmp != null){
            cmp.eliminarDonante(rut);
        }
    }
    
    /*Muestra un donante en especifico*/
    public String mostrarDonantes(int idCampania){
        Campania cmp = gestor.buscarCampania(idCampania);
        if(cmp != null){
            return cmp.mostrarDonante();
        }
        return "No existe campaña";
    }
    
    /*Modifica un donante en especifico*/
    public void modificarDonante(int idCampania,String rut, String nombreDonante, Sangre tipoSangre){
        Campania cmp = gestor.buscarCampania(idCampania);
        if(cmp != null){
            cmp.modificarDonante(rut, nombreDonante, tipoSangre);
        }
    }
    
    /*Metodo que sirve para aumentar la cantida de donacion de un donante*/
    public void donar(int idCampania, String rut, int cantDonacion) throws DonarException{
        Campania campania = gestor.buscarCampania(idCampania);
        if(campania != null){
            Donante donante = campania.buscarDonante(rut);
            if(donante == null){
               throw new DonarException("ERROR, no se encontro el donante ");/*Lanza un throw si no existe un donante*/
            }
            donante.donar(cantDonacion);
        }
    }
    
    /*Metodo para buscar un donante en especifico en una campaña en especifia (ya que un donante puede estar en mas de una campaña*/
    public String buscarDonante(int idCampania, String rut) {
        Campania campania = gestor.buscarCampania(idCampania);
        if(campania != null){
            try{
                Donante donante = campania.buscarDonante(rut);
                return donante.mostrar();
            }catch(DonarException e){   /*Recibe el throw del buscarDonate y imprime el error que dio*/
                return e.getMessage();
            }
           
            
            
        }
        return "No se encontro campaña";
    }
}
