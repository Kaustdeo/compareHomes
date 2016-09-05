import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class compareHomes {
    
    public static void main(String[] args) {
    
    String fileName = "C:\\Users\\kaust\\introcs\\compareHomes\\houseValues.txt";
    String line = null;
    String[] houseName = new String[10];
    int bidPrice;
    int holdPeriod;
    int exitPrice;
    int i=0;
    
    try {
        FileReader lineReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(lineReader);
        
        while((line = bufferedReader.readLine()) != null) {
            String columns[] = line.split(" ");
            houseName[i] = columns[0];
            bidPrice = Integer.parseInt(columns[1]);
            holdPeriod = Integer.parseInt(columns[2]);
            exitPrice = Integer.parseInt(columns[3]);
            System.out.println(houseName + "can be bought for " + bidPrice + " and held for " + holdPeriod + " years, to be sold at " + exitPrice + " .");
        }
    }
    catch(FileNotFoundException ex) {
            System.out.println("Unable to open " + fileName + " .");
        }
    catch(IOException ex) {
            System.out.println("Error reading file " + fileName + " .");
        }
    }
}