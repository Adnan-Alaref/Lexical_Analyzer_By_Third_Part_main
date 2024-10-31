/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalproject;

import javax.tools.Diagnostic;

/**
 *
 * @author Abdo Gamal Ahmed
 */
public class JavaTokens {
 
     public TokenKind kind;                  // kind of token
    public int lcationAtSamobolTable;        //for id and number and sambol i but all token in sambol table not noly identifer  x=4
    public String value;                     //for num only x=3
    public String splling;                   //for liem for  id
    
    
    //Decleration Constracors
    //default constracot  not  use
    public JavaTokens(){kind = TokenKind.Unknown;}
   //to set TokenKind only if the token  ex sambole,oprator
    public JavaTokens(TokenKind k){kind = k;}
       //to set TokenKind and value if the token  ex x=4
    public JavaTokens(TokenKind k ,String str ){kind = k;value = str;}
      //to set TokenKind and lexim  if the token  is identifer
    public JavaTokens(TokenKind k,String v, String s){kind=k;value=v;splling=s;}
    
    // Functions set location of token in sambole table
    public void setInSampleTable(int postion)
    {
        this.lcationAtSamobolTable = postion;
    }
    
 
// to  kowen if the file end return true if file 
    public Boolean EndOfFile()
    {
     //return 1 if file of source code end
        if(this.kind==TokenKind.EndFile) 
            return true;
         //return 0 if file of source code not  end
        else 
            return false;
    }
    // all kind of java keyword,sambole....
    public enum TokenKind {
    RW_if, RW_else, RW_elseIF,   RW_for, RW_while,BooleanLiteral,Separator,Operator,StringLiterals,CharacterLiterals,
     sym_assuune,  sym_eq,sym_Division,sym_Multiplicacion, sym_sum, sym_sub,sym_Suma,WhiteSpace,
    Resta,Identificador,Numero,
    keyword,Comparsion,smallthan,graterthan,dot,Comma,TextBlock,
     
    ERROR,Defaut, End,Unknown,EndFile,uniDigit,
    ABSTRACT ,BOOLEAN,BREAK,TRANSIENT,TRY,VOID,VOLATILE,WHILE, BOOLEANLIT,NULLLIT,INTEGERLIT,
    FLOATLIT,CHARLIT,STRINGLIT,IDENT,
    
    Abstract ,Continue, For, New, Switch,Equal,
    Assert ,Default ,If, Sackage ,Synchronized,
    Boolean ,Do, Goto ,Private, This,
    Break ,Double, Implements ,Protected, Throw,
    Byte ,Else ,Import ,Public, Throws,
    Case ,Enum ,Instanceof, Return ,Transient,
    Catch ,Extends, Ent ,Short, Try,out,
    Char ,Final ,Interface ,Static, Void,
    Class ,Finally ,Long ,Strictfp ,Volatile,
    Const ,Float ,Native ,Super ,While,LEFT,RIGHT,LEFTCURLY,RIGHTCURLY,LEFTSQ,RIGHTSQ,TILDE,AMPERSAND,LESSTHANOREQUAL,
    GREATERTHANOREQUAL,EQUALEQUAL
  }  
}
