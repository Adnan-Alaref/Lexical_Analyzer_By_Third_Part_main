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
 * @author Adnan
 */
public class LexicalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       JFlex.Main.generate(new File("C:\\Users\\Adnan.DESKTOP-DBG87M9\\Documents\\NetBeansProjects\\LexicalProject\\src\\lexicalproject\\Lexical.flex"));
       
         try{
         
              JavaTokens current;
              javaScanner scanner;
         
              String inputPath = "C:\\Users\\Adnan.DESKTOP-DBG87M9\\Documents\\NetBeansProjects\\LexicalProject\\src\\lexicalproject\\TestCompilerCode.txt";
              FileReader SourseCode= new FileReader(inputPath);
              scanner=new javaScanner(SourseCode);
             
              SambolTable table=new SambolTable();
              while(true)
              {
                   current= scanner.nextToken();
                     current.setInSampleTable(table.count);
                 table.sambolTable.put(current,table.count++);
                
                 // System.out.println(" token :<"+current.toString()+">");
            
                  if(current.EndOfFile()==true)break;
              }
              SourseCode.close();
              table.showAll();
         
        }catch(Exception ex)
        {
           System.out.println(ex.toString());
        }
    }
    
}
