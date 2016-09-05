import java.io.*;
import java.lang.*;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Array;

public class compareHomes {
    
    
    
    public static void main(String[] args) {
    
        String fileName = "C:\\Users\\kaust\\introcs\\compareHomes\\houseValues.txt";
        String line = null;
        int lineCount = 0;
        
        try {
            FileReader lineCounter = new FileReader(fileName);
            BufferedReader lineReader = new BufferedReader(lineCounter);
            
            while((line = lineReader.readLine()) != null) {
                lineCount++;
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open " + fileName + " .");
        }
        catch(IOException ex) {
            System.out.println("Error reading file " + fileName + " .");
        }    
            
            
        String[] houseName = new String[lineCount];
        double[] bidPrice = new double[lineCount];
        double[] holdPeriod = new double[lineCount];
        double[] exitPrice = new double[lineCount];
        double investmentReturn[] = new double[lineCount];
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
                investmentReturn[i] = (1.0*Math.round((100*(100*((Math.pow((exitPrice[i]/bidPrice[i]), (1/holdPeriod[i])))-1))))/100);
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
        
        double max = investmentReturn[0];
        String maxHouse = houseName[0];
        int n;
        for (n = 1; n < investmentReturn.length; n++) {
            if (Array.getDouble(investmentReturn, n) > max) {
                max = Array.getDouble(investmentReturn, n);
                maxHouse = houseName[n];
            }
        }
         
        System.out.println("The best investment is " + maxHouse + ", offering a " + max + "% return.");
        
        
    }
}