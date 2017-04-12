package jf;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        //Exercice 7
        System.out.println("Importation Eclipse");
        
        //Exercice 9
        System.out.println("Le max entre 4 et 5 est : " + max(4,5));
        
        
        //Exercice 20
        int monmax = 0 ;
        try {
        	CSVReader reader = new CSVReader(new FileReader("data.csv")) ;
        	List<String[]> myEntries = reader.readAll();
        	for (String[] ligne : myEntries){
        		for (String Caractere : ligne){
    				int nombre = Integer.parseInt(Caractere);
    				monmax = max(monmax, nombre);
    				//System.out.println("Nombre lu : " + nombre);
    			}
        		
        		
        		//Exercie 27
        		List<String> list = Arrays.asList(ligne);
        		

				
        		//Exercice 28
				Vector<String> out = new Vector<String>() ;
				CollectionUtils.select(list, new Predicate<String>(){

					@Override
					public boolean evaluate(String arg0) {
						// TODO Auto-generated method stub
						if (Integer.parseInt(arg0) >= 50){
							return false;
						}
						return true;
					}
				}, out) ;
				System.out.println("OUT :" + out);
				
				CSVWriter writer = new CSVWriter(new FileWriter("data-filtered.csv"), ',', CSVWriter.NO_QUOTE_CHARACTER);
				String[] str = out.toArray(new String[0]);
				writer.writeNext(str);
					
    		writer.close();
    		}
        
        reader.close();
        }
        catch (IOException e){
        	System.out.println("Erreur");
        }
        
        //Exercice21
    	System.out.println("Le maximum est : " + monmax);
    }
    
    //Exercice 8
    public static int max(int a, int b){
    	return a>b ? a:b;
    	
    	//Exercice 15
    	//return a;
    }
    
  
}
