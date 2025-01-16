import java.io.*;
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

                        if (jmeno.equals("Ivana") && id < 50) {
                            System.out.println(id);
                        }
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Soubor nebyl nalezen.");
                System.exit(404);
            } catch (IOException e) {
                System.out.println("Chyba se souborem, soubor je možná poškozený.");
                System.exit(100);
            }
        }
    }
}
