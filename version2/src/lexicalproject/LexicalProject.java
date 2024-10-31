/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalproject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
/**
 *
 * @author Abdo Gamal Ahmed Gaber
 */
public class LexicalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        // to generate the lixcal class from lixcal file
        //and i comment it to run correcty on your pc
       //JFlex.Main.generate(new File("E:\\fourth_year\\411\\compiler\\Abdo\\project\\first\\LexicalProject last version\\src\\lexicalproject\\Lexical.flex"));
       
         try{
              // to save token in it
              JavaTokens current;
              // object form generateted calss to give file of sourcse code  and return token
              javaScanner scanner;
               //path of file of sourcse code
              String inputPath = "E:\\fourth_year\\411\\compiler\\Abdo\\project\\first\\LexicalProject last version\\src\\lexicalproject\\TestCompilerCode.txt";
             // get the file from its path to geven it to lexcal class
              FileReader SourseCode= new FileReader(inputPath);
              //give file of source code to lixcal genrated class
              scanner=new javaScanner(SourseCode);
             //object form sambole table 
              SambolTable table=new SambolTable();
              while(true)
              {
                  //get nexet token from source code
                   current= scanner.nextToken();
                  //set the token in sambole table
                  table.sambolTable.put(current,table.count); 
                  //set the posiont of token in sambole table 
                  current.setInSampleTable(table.count++);
                  // if file of source code  end break
                  if(current.EndOfFile()==true)break;
              }
              //clode file of soure code
              SourseCode.close();
              //function in sambole table calss to show all element of sambole table by order in source code
              table.showAll();
         
        }catch(Exception ex)
        {
            //to handel errors in file read
           System.out.println(ex.toString());
        }
    }
    
}
