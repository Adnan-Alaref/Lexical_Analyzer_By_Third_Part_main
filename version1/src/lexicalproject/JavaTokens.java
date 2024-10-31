/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalproject;

import javax.tools.Diagnostic;

/**
 *
 * @author Adnan
 */
public class JavaTokens {
 
    public TokenKind kind;
    public int lcationAtSamobolTable;   //for num only
    public String value;   //for num only
    public String splling;//for id
    
    //Decleration Constracors
    public JavaTokens(){kind = TokenKind.Unknown;}
    public JavaTokens(TokenKind k){kind = k;}
    public JavaTokens(TokenKind k ,String str ){kind = k;value = str;}
    public JavaTokens(TokenKind k,String v, String s){kind=k;value=v;splling=s;}
    
    // Functions
    public void setInSampleTable(int postion)
    {
        this.lcationAtSamobolTable = postion;
    }
    
    //public String ToString()
    //{
    // return new String(" Kind :"+this.kind+" value :"+this.value+" spling :"+
    // this.splling+" lcationInST :"+this.lcationAtSamobolTable);
    //}

    public Boolean EndOfFile()
    {
        /*boolean x =(this.kind == TokenKind.EndFile)? true : false;
        return x;*/
        if(this.kind==TokenKind.EndFile) 
            return true;
        else 
            return false;
    }
    public enum TokenKind {
    RW_if, RW_else, RW_elseIF,   RW_for, RW_while,BooleanLiteral,Separator,Operator,StringLiterals,CharacterLiterals,
     sym_assuune,  sym_eq,sym_Division,sym_Multiplicacion, sym_sum, sym_sub,sym_Suma,WhiteSpace,
    Resta,Identificador,Numero,
    keyword,Comparsion,smallthan,graterthan,dot,Comma,TextBlock,
     
    ERROR,Defaut, End,Unknown,EndFile,
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
