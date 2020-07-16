package failai;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {


    public static void main(String[] args) {
        uzduotis1();
        
    }




        public static void uzduotis1() {
            try (BufferedReader reader = Files.newBufferedReader(Paths.get("src", "failai", "vardas"));
                 BufferedWriter writer = Files.newBufferedWriter(Paths.get("src", "failai", "vardas_out")))
            {
                String line;
                while((line = reader.readLine()) != null)
                {
                    String[] parts = line.split(" ");
                    writer.write(String.format("%s %s", new StringBuffer(parts[0]).reverse(), new StringBuffer(parts[1]).reverse()));
                    writer.newLine();
                }
            }   catch (IOException ex) {
                ex.printStackTrace();
            }

        }




}

