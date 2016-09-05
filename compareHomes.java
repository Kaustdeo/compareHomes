import java.io.*;
import java.lang.*;
import java.util.List;
import java.util.ArrayList;

public class compareHomes {
    
    
    
    public static void main(String[] args) {
    
        String fileName = "C:\\Users\\kaust\\introcs\\compareHomes\\houseValues.txt";
        String line = null;
        String[] houseName = new String[3];
        double[] bidPrice = new double[3];
        double[] holdPeriod = new double[3];
        double[] exitPrice = new double[3];
        double investmentReturn[] = new double[3];
        int i = 0;
        
        try {
            FileReader lineReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(lineReader);
            
            while((line = bufferedReader.readLine()) != null) {
                String columns[] = line.split(" ");
                houseName[i] = columns[0];
                bidPrice[i] = Double.parseDouble(columns[1]);
                holdPeriod[i] = Double.parseDouble(columns[2]);
                exitPrice[i] = Double.parseDouble(columns[3]);
                investmentReturn[i] = (Math.round((100*(100*((Math.pow((exitPrice[i]/bidPrice[i]), (1/holdPeriod[i])))-1))))/100);
                System.out.println(houseName[i] + " can be bought for " + bidPrice[i] + " and held for " + holdPeriod[i] + " years, to be sold at " + exitPrice[i] + ".");
                System.out.println("Expected Return = " + investmentReturn[i] + "%.");
                i++;
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