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
 * @author Adnan
 */
public class SambolTable {
    public   Hashtable<JavaTokens, Integer>  sambolTable;
    public      int count;
         
    public SambolTable(){
         count=0;
         sambolTable =  new Hashtable<JavaTokens, Integer>();  
    }
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
                // < lexeme(null) Token_Name(EndFile) Position(1) >
                 System.out.println("< lexeme("+key.splling+") Token_Name("+key.kind
                         +") Position("+list1.get(i).toString()+")>");
             }
        } 
        }
        
      
    }
}
