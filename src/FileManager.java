import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class FileManager {


    File soubor = new File("text.txt");


    public void scan() {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("text.txt")))) {
            while (scanner.hasNextLine()) {
                String radek = scanner.nextLine();
                String[] hodnoty = radek.split(";");

                for (String hodnota : hodnoty) {
                    String[] idJmeno = hodnota.split(" ");
                    int id = Integer.parseInt(idJmeno[0]);
                    String jmeno = idJmeno[1];
                    String prijmeni = idJmeno[2];

                    System.out.println(id + " " + jmeno);

                    if (Objects.equals(jmeno, "Ivana")) {
                        System.out.println("\nID zákazníků s jmenem Ivana: " + id);
                    }

                    if (id < 50) {
                        System.out.println("\nID zákazníků, které mají ID menší než 50: " + id);
                    }


                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Soubor nebyl nalezen.");
            System.exit(404);
        } catch (NumberFormatException e) {
            System.out.println("Chybná číslová hodnota.");
            System.exit(100);
        }
    }
}
