import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.List;

public class OrdinadorLogic {
    public void serializeOrdinador(Ordinador ordinador, String filename) {
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)))) {
            encoder.writeObject(ordinador);
            System.out.println("Ordinador serialitzat a XML: " + filename);
        } catch (IOException e) {
            System.err.println("Error en serialitzar: " + e.getMessage());
        }
    }


    public Ordinador deserializeOrdinador(String filename) {
        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)))) {
            return (Ordinador) decoder.readObject();
        } catch (IOException e) {
            System.err.println("Error en deserialitzar: " + e.getMessage());
            return null;
        }
    }

    public void serializeOrdinadors(List<Ordinador> ordinadors, String filename) {
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)))) {
            encoder.writeObject(ordinadors);
            System.out.println("Llista d'Ordinadors serialitzada a XML: " + filename);
        } catch (IOException e) {
            System.err.println("Error en serialitzar" + e.getMessage());
        }
    }
    public List<Ordinador> deserializeOrdinadors(String filename) {
        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)))) {
            return (List<Ordinador>) decoder.readObject();
        } catch (IOException e) {
            System.err.println("Error en deserialitzar" + e.getMessage());
            return null;
        }
    }
}

