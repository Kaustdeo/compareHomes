import java.io.*;
import java.lang.*;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Array;

public class compareHomes {
    
    static class Property extends compareHomes {
    
       String houseName;
       double bidPrice;
       double holdPeriod;
       double exitPrice;
       double investmentReturn;
       
       public Property(String propertyName, double propertyBidPrice, double propertyHoldPeriod, double propertyExitPrice) {
            houseName = propertyName;
            bidPrice = propertyBidPrice;
            holdPeriod = propertyHoldPeriod;
            exitPrice = propertyExitPrice;
            investmentReturn = (1.0*Math.round((100*(100*((Math.pow((exitPrice/bidPrice), (1/holdPeriod)))-1))))/100);
       }
    }
        
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
            
        
        List<Property> propertyList = new ArrayList<Property>();
        int i = 0;
        
        try {
            FileReader lineReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(lineReader);
        
            while((line = bufferedReader.readLine()) != null) {
                String columns[] = line.split(" ");
                propertyList.add(new Property(columns[0], Double.parseDouble(columns[1]), Double.parseDouble(columns[2]), Double.parseDouble(columns[3])));
                i++;
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open " + fileName + " .");
        }
        catch(IOException ex) {
            System.out.println("Error reading file " + fileName + " .");
        }
        
        double max = propertyList.get(0).investmentReturn;
        String maxHouse = propertyList.get(0).houseName;
        int n;
        for (n = 1; n < lineCount; n++) {
            if (propertyList.get(n).investmentReturn > max) {
                max = propertyList.get(n).investmentReturn;
                maxHouse = propertyList.get(n).houseName;
            }
        }
         
        System.out.println("The best investment is " + maxHouse + ", offering a " + max + "% return.");
        
        
    }
}