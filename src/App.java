import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;
import services.CalculationService;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();
        Path currentDirectory = Paths.get(System.getProperty("user.dir"));
        Path filePath = currentDirectory.resolve("in.txt");
        String path = filePath.toString();
        // String path = "C:\\Users\\bruno\\Projetos\\estudos\\java-generics\\java-generics\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            
            String line = br.readLine();
            while (line != null){
                String [] fields = line.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }

            Product x = CalculationService.max(list);
            System.out.println("Max price Product: ");
            System.out.println(x);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
