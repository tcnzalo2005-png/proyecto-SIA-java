package gestorcampania;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class CSV {

    private String archivo;

    public CSV(String archivo) {
        this.archivo = archivo;
    }

    public void guardarCSV(GestorCampania gestor) {

        try {
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("idCampania,nombreCampania,fecha,tipoCampania,ubicacion,rut,nombreDonante,tipoSangre,donacion");
            bw.newLine();

            for (Campania campania : gestor.getListaCampanias()) {

                String tipoCampania;
                String ubicacion = "";

                if (campania instanceof CampaniaFija) {
                    tipoCampania = "Fija";
                    ubicacion = ((CampaniaFija) campania).getUbicacion();
                } else {
                    tipoCampania = "Movil";

                    CampaniaMovil movil = (CampaniaMovil) campania;

                    for (String u : movil.getUbicaciones()) {
                        if (ubicacion.equals("")) {
                            ubicacion = u;
                        } else {
                            ubicacion += "|" + u;
                        }
                    }
                }

                if (campania.getDonantes().isEmpty()) {

                    bw.write(
                        campania.getIdCampania() + "," +
                        campania.getNombreCampania() + "," +
                        campania.getFecha() + "," +
                        tipoCampania + "," +
                        ubicacion + ",,,,"
                    );

                    bw.newLine();

                } else {

                    for (Donante donante : campania.getDonantes().values()) {

                        bw.write(
                            campania.getIdCampania() + "," +
                            campania.getNombreCampania() + "," +
                            campania.getFecha() + "," +
                            tipoCampania + "," +
                            ubicacion + "," +
                            donante.getRut() + "," +
                            donante.getNombreDonante() + "," +
                            donante.getTipoSangre() + "," +
                            donante.getDonacion()
                        );

                        bw.newLine();
                    }
                }
            }

            bw.close();

            System.out.println("Archivo CSV guardado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar el archivo CSV.");
        }
    }

    public void cargarCSV(GestorCampania gestor) {

        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String linea = br.readLine();

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",", -1);

                int idCampania = Integer.parseInt(datos[0]);
                String nombreCampania = datos[1];
                LocalDate fecha = LocalDate.parse(datos[2]);
                String tipoCampania = datos[3];
                String ubicacion = datos[4];

                Campania campania = gestor.buscarCampania(idCampania);

                if (campania == null) {

                    if (tipoCampania.equals("Fija")) {

                        gestor.crearCampaniaFija(
                            idCampania,
                            nombreCampania,
                            fecha,
                            ubicacion
                        );

                    } else {

                        String[] ubicaciones = ubicacion.split("\\|");

                        gestor.crearCampaniaMovil(
                            idCampania,
                            nombreCampania,
                            fecha,
                            ubicaciones[0]
                        );

                        campania = gestor.buscarCampania(idCampania);

                        CampaniaMovil movil = (CampaniaMovil) campania;

                        for (int i = 1; i < ubicaciones.length; i++) {
                            movil.setUbicacion(ubicaciones[i]);
                        }
                    }

                    campania = gestor.buscarCampania(idCampania);
                }

                if (!datos[5].equals("")) {

                    String rut = datos[5];
                    String nombreDonante = datos[6];
                    Sangre tipoSangre = Sangre.valueOf(datos[7]);
                    int donacion = Integer.parseInt(datos[8]);

                    campania.crearDonante(
                        rut,
                        nombreDonante,
                        tipoSangre,
                        donacion
                    );
                }
            }

            br.close();

            System.out.println("Archivo CSV cargado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al cargar el archivo CSV.");

        } catch (Exception e) {
            System.out.println("Error en los datos del archivo CSV.");
        }
    }
}
