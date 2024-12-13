import java.util.ArrayList;
import java.util.List;
import java.io.File;
public class Main {
    private static final String FITXER_INDIVIDUAL = "Fitxers/ordinador.xml";
    private static final String FITXER_LLISTA = "Fitxers/ordinadors.xml";
    public static void main(String[] args) {
        File directory = new File("Fitxers");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        OrdinadorLogic ordinadorlogic = new OrdinadorLogic();
        try {
            Ordinador ordinador = new Ordinador(1, "Asus", "Vivobook", 8, 1000, "Intel Core i7-9700K");

            List<Ordinador> ordinadors = new ArrayList<>();
            ordinadors.add(ordinador);
            ordinadors.add(new Ordinador(2, "MSI", "Katana", 32, 256, "Inter Core i9-9900K"));
            ordinadors.add(new Ordinador(3, "Acer", "Predator", 64, 512, "AMD Ryzen 9 3950X"));

            ordinadorlogic.serializeOrdinador(ordinador, FITXER_INDIVIDUAL);

            ordinadorlogic.serializeOrdinadors(ordinadors, FITXER_LLISTA);

            Ordinador deserializedAlumne = ordinadorlogic.deserializeOrdinador(FITXER_INDIVIDUAL);
            System.out.println("\nOrdinador deserialitzat des de fitxer XML:");
            System.out.println(deserializedAlumne);

            List<Ordinador> deserializedAlumnes = ordinadorlogic.deserializeOrdinadors(FITXER_LLISTA);
            System.out.println("\nLlista d'Ordinadors deserialitzats des de fitxer XML:");
            for (Ordinador it : deserializedAlumnes) {
                System.out.println(it);
            }
        }
        catch (Exception e){
        System.out.println(e.getMessage());
        }
    }
}