package gestorcampania;

import java.time.LocalDate;

public class DatosEjemplo
{
    public static void poblar()
    {
        CampaniaFija campania = new CampaniaFija(
            0,
            "Donadores de la historia",
            LocalDate.of(2000, 1, 1),
            "Santiago de Chile"
        );

        campania.crearDonante("11.111.111-1", "Bernardo O'Higgins", Sangre.O_POSITIVO, 450);
        campania.crearDonante("22.222.222-2", "José Miguel Carrera", Sangre.A_POSITIVO, 400);
        campania.crearDonante("33.333.333-3", "Manuel Rodríguez", Sangre.B_POSITIVO, 450);
        campania.crearDonante("44.444.444-4", "Diego Portales", Sangre.A_NEGATIVO, 350);
        campania.crearDonante("55.555.555-5", "Arturo Prat", Sangre.O_NEGATIVO, 450);
        campania.crearDonante("66.666.666-6", "José de San Martín", Sangre.A_POSITIVO, 400);
        campania.crearDonante("77.777.777-7", "Andrés Bello", Sangre.B_POSITIVO, 450);
        campania.crearDonante("88.888.888-8", "Claudio Gay", Sangre.O_POSITIVO, 350);
        campania.crearDonante("99.999.999-9", "Ignacio Domeyko", Sangre.A_POSITIVO, 450);
        campania.crearDonante("10.101.010-1", "Benjamín Vicuña Mackenna", Sangre.A_NEGATIVO, 400);
        campania.crearDonante("20.202.020-2", "José Victorino Lastarria", Sangre.B_POSITIVO, 350);
        campania.crearDonante("30.303.030-3", "Domingo Faustino Sarmiento", Sangre.O_POSITIVO, 450);
        campania.crearDonante("40.404.040-4", "Gabriela Mistral", Sangre.A_POSITIVO, 400);
        campania.crearDonante("50.505.050-5", "Pablo Neruda", Sangre.O_NEGATIVO, 450);
        campania.crearDonante("60.606.060-6", "Violeta Parra", Sangre.B_NEGATIVO, 350);
        campania.crearDonante("70.707.070-7", "Clotario Blest", Sangre.A_POSITIVO, 400);
        campania.crearDonante("80.808.080-8", "Salvador Allende", Sangre.O_POSITIVO, 450);
        campania.crearDonante("90.909.090-9", "Arturo Alessandri Palma", Sangre.A_NEGATIVO, 400);
        campania.crearDonante("12.345.678-5", "Pedro Aguirre Cerda", Sangre.B_POSITIVO, 350);
        campania.crearDonante("98.765.432-1", "Jorge Alessandri Rodríguez", Sangre.O_POSITIVO, 450);
    }
}