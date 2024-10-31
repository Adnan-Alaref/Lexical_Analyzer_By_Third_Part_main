    //=>Definitions
    package lexicalproject;
    import static lexicalproject.JavaTokens.*;
    import java.util.Hashtable;
    import java.util.*;
%%
                  //=>Acronyms
    %function nextToken
    %class javaScanner
    %type JavaTokens

    DoubleQuotation = "\""
   
    SingleQuotation = "\'"
    uniDigit=[a-zA-Z0-9 \u0080-\u9fff]{4}

    Digit = [0-9]
    Escape = "\\"|"\'"|"\t"|"\u03a9"|"\uFFFF"|"\177"
    WhiteSpace = "\ "|"\n"|"\t"|"\r"|"\f"|"\r\n"
    Separator = "("|")"|"{"|"}"|"["|"]"|";"|","|"."|"..."|"@"|"::"  

    Operator  = "="|">"|"<"|"!"|"~"|"?"|":"|"->"|"=="|">="|"<="|"!="|"&&"|"||"|"++"|"--"|"+"|"-"|"*"|"/"|"&"|"|"|"^"|"%"|"<<"|">>"|"+="|"-="|"*="|"/="|"&="|"|="|"^="|"%="|":="
       textBlock =\"{3}.\"{3} 
       textBlock =\"{3}[^\n]\"{3} 
	
	    StringLiterals = [^\"\\\n\r] | {EscChar}
       StringLiterals = [\"]({Letter}|{Digit}|{Operator}|{Separator}|{Escape}|"\ ")*[\"]

       SingleChar = "/"|"|"|">"|"<"|"="|"-"|"+"|"*"|"%"|"!"|"?"|"("|")"|"{"|"}"|"["|"]"|";"|","|"."|"@"

     Letter = [a-zA-Z_]
     CharacterLiterals = [^\'\\\n\r] | {EscChar}
    CharacterLiterals = {SingleQuotation}(" "|{Letter}|{Digit}|{SingleChar}){SingleQuotation}
    T = "true"
    F = "false"
    sign = [+-]
    BooleanLiteral = {T}|{F}
    InputChar = [^\n\r]  
    SpaceChar = [\ \t]
    LineChar = \n|\r|\r\n
    Zero = 0
    DecInt = [1-9][0-9]*
    OctalInt = 0[0-7]+
    HexInt = 0[xX][0-9a-fA-F]+
    BinaryInt =0[bB][0-1]+
    Integer = ( {Zero} | {DecInt} | {OctalInt} | {HexInt} | {BinaryInt})[lL]?
    Exponent = [eE] [\+\-]? [0-9]+
    Float1 = [0-9]+ \. [0-9]+ {Exponent}?
    Float2 = \. [0-9]+ {Exponent}?
    Float3 = [0-9]+ \. {Exponent}?
    Float4 = [0-9]+ {Exponent}
    Float = ( {Float1} | {Float2} | {Float3} | {Float4} ) [fFdD]? | [0-9]+ [fFDd]
    Identfier = [A-Za-z_$] [A-Za-z_$0-9]*
 
    EscChar = \\[ntbrf\\\'\"] | {OctalEscape}
    OctalEscape = \\[0-7] | \\[0-7][0-7] | \\[0-3][0-7][0-7]
    CommentmultiLine = \/\*[^\*\/]\*\/ 
    CommentSingleLine = \/\/[^\n\r]+

    keyword= abstract| continue| for| new |switch|
    assert |default| if| package| synchronized|
    boolean| do |goto| private| this|
    break |double| implements| protected| throw|
    byte |else |import| public| throws|
    case |enum |instanceof| return| transient|
    catch |extends| int |short |try|
    char |final| interface| static |void|out|
    class |finally| long |strictfp |volatile|
    const| float| native| super |while|main|String|throws 
%%
                             //=>Rules
    {keyword}                   {return  new JavaTokens(TokenKind.keyword,"",yytext());}
    {BooleanLiteral} 	        {return  new JavaTokens(TokenKind.BooleanLiteral,"",yytext());}
    {Operator}  		{return  new JavaTokens(TokenKind.Operator,"",yytext());}
    {WhiteSpace} 		{                                                     }
     "\\u"{uniDigit}            {return  new JavaTokens(TokenKind.uniDigit,"",yytext());} 
    "\"\"\""~"\"\"\""            {return new JavaTokens(TokenKind.TextBlock,"",yytext());}
    {textBlock}                  {return new JavaTokens(TokenKind.TextBlock,"",yytext());}

    "(" 			{return  new JavaTokens(TokenKind.LEFT,"nothing","(");}
    ")" 			{return  new JavaTokens(TokenKind.RIGHT,"nothing",")");}
    "{" 			{return  new JavaTokens(TokenKind.LEFTCURLY,"nothing","{");}
    "}" 			{return  new JavaTokens(TokenKind.RIGHTCURLY,"nothing","}");}
    "["			        {return  new JavaTokens(TokenKind.LEFTSQ,"nothing","["); }
    "]" 			{return  new JavaTokens(TokenKind.RIGHTSQ,"nothing","]"); }


    ";" 			{return  new JavaTokens(TokenKind.sym_Suma,"nothing",";"); }
    "," 			{return  new JavaTokens(TokenKind.Comma,"nothing",",");}
    "=" 			{return  new JavaTokens(TokenKind.Equal,"nothing","="); }
    "<" 			{return  new JavaTokens(TokenKind.graterthan,"nothing","<"); }
    ">" 			{return  new JavaTokens(TokenKind.smallthan,"nothing",">"); }

    "<=" 			{return  new JavaTokens(TokenKind.LESSTHANOREQUAL,"nothing","<=");}
    ">=" 			{return  new JavaTokens(TokenKind.GREATERTHANOREQUAL,"nothing",">=");}
    "==" 			{return  new JavaTokens(TokenKind.EQUALEQUAL,"nothing","==");}
   {Separator}	                {return  new JavaTokens(TokenKind.Separator,"",yytext());}

    …
    "&" 			{return  new JavaTokens(TokenKind.AMPERSAND,"nothing","&");}
    "!" 			{return  new JavaTokens(TokenKind.Defaut,"nothing","!"); }
    "~" 			{return  new JavaTokens(TokenKind.TILDE,"nothing","~"); }
    true 			{return  new JavaTokens(TokenKind.BOOLEANLIT,"nothing","true"); }
    false 			{return  new JavaTokens(TokenKind.BOOLEANLIT,"nothing","flase");}
    null 			{return  new JavaTokens(TokenKind.NULLLIT,"nothing","null"); }
    {Integer} 		        {return  new JavaTokens(TokenKind.INTEGERLIT,"nothing",yytext()); }
    {Float} 		        {return  new JavaTokens(TokenKind.FLOATLIT,"nothing",yytext() );}

 \'{CharacterLiterals}\'     {return  new JavaTokens(TokenKind.CHARLIT,"",yytext());}
    \"{StringLiterals}*\" 	{return  new JavaTokens(TokenKind.STRINGLIT,"",yytext());}
    {Identfier} 		{return  new JavaTokens(TokenKind.IDENT,"nothing",yytext()); }

    "//"{InputChar}* 	         {                                          }
    "/*"~"*/"                    {                                          }
    {CommentSingleLine}          {                                          }	
    {CommentmultiLine}           {                                          }
    {LineChar}                   {                                            }
    {SpaceChar}      	         {                                            }
    <<EOF>>                      {return  new JavaTokens(TokenKind.EndFile);}
    "."                          {return  new JavaTokens(TokenKind.dot,"",".");    }
     .                           {return  new JavaTokens(TokenKind.Unknown);}




