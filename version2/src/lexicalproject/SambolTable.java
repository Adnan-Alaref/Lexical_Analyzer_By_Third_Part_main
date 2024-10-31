/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalproject;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jdk.management.resource.internal.ResourceNatives;
/**
 *
 * @author Abdo
 */
public class SambolTable {
    
    
    public   Hashtable<JavaTokens, Integer>  sambolTable;   //sambole table 
    public      int count;                                // like size of Hashtable 
         
    public SambolTable(){
         count=1;          
         sambolTable =  new Hashtable<JavaTokens, Integer>();  
    }
    
    // to show all elemement of sambole table in order of source code
    ArrayList<Integer> list1 = new ArrayList<Integer>();
    public void  showAll(){
        
        Set<JavaTokens> keys = sambolTable.keySet();
        for(JavaTokens key: keys){ 
            list1.add(sambolTable.get(key));
        }
        Collections.sort(list1);
        
        for(int i=0;i<list1.size();i++)
        {
          for( Iterator iter=sambolTable.keySet().iterator(); iter.hasNext(); ) {
             JavaTokens key = (JavaTokens) iter.next();
             int value = (int) sambolTable.get( key );
             if(value == list1.get(i))
             {
                 System.out.println("< lexeme("+key.splling+") Token_Name("+key.kind
                         +") Position("+list1.get(i).toString()+") >");
             }
        } 
        } 
    }
}
