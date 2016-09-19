package visualbasiccompilador;

import java_cup.runtime.*;

%%
%class VisualBasicLexer
%unicode
%line
%column
%extends sym
%public
%int
%cup

%{
  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }
  String stringtmp = "";
  String alojarstring = "";
%}

Integer = "Integer"
Boolean	= "Boolean"
String 	= "String"
ByVal = "ByVal"
ByRef = "ByRef"

Dim = "Dim"
As = "As"

True = "True"
False = "False"

For	= "For"
To = "To"
If = "If"
Then = "Then"
ElseIf = "ElseIf"
Else = "Else"
Loop = "Loop"
Do = "Do"
While = "While"
End = "End"
Until = "Until"
Next = "Next"


Function = "Function"
Sub = "Sub"
Exit = "Exit"
Return = "Return"

Structure = "Structure"

Sum = "+"
Minus = "-"
Product = "*"
Division = "/"

GreaterThan = ">"
LessThan = "<"
GreaterEqual = ">="
LessEqual = "<="
NotEqual = "<>"
And = "And"
Or = "Or"
Not = "Not"
Xor = "Xor"
Equals = "="


comma = ","
parIn = "("
parOut = ")"
ampersand = "&"


id = {letter}({letter}|{digit})*
Number = {digit}+

letter = [a-zA-Z]
stringval = "\""[a-zA-Z0-9\s\t\f]*"\""
digit = [0-9]
comment = "'"
linebreak = [\r|\n|\r\n]+
whitespace = {linebreak} | [\s\t\f]

%state COMMENTS
%state STRING
%%

<YYINITIAL>{   
        
	{Integer}						{return symbol(sym.TK_INTEGER);}
	{Boolean}						{return symbol(sym.TK_BOOLEAN);}
	{String}						{return symbol(sym.TK_STRING);}
	{ByVal}							{return symbol(sym.TK_BYVAL);}
	{ByRef}							{return symbol(sym.TK_BYREF);}
	{Dim}							{return symbol(sym.TK_DIM);}
	{As}							{return symbol(sym.TK_AS);}
	{True}							{return symbol(sym.TK_TRUE);}
	{False}							{return symbol(sym.TK_FALSE);}
	{For}							{return symbol(sym.TK_FOR);}
	{To}							{return symbol(sym.TK_TO);}
	{Next}							{return symbol(sym.TK_NEXT);}
	{If}							{return symbol(sym.TK_IF);}
	{Then}							{return symbol(sym.TK_THEN);}
	{ElseIf}						{return symbol(sym.TK_ELSEIF);}
	{Else}							{return symbol(sym.TK_ELSE);}
	{Loop}							{return symbol(sym.TK_LOOP);}
	{Do}							{return symbol(sym.TK_DO);}
	{While}							{return symbol(sym.TK_WHILE);}
	{End}							{return symbol(sym.TK_END);}
	{Until}							{return symbol(sym.TK_UNTIL);}
	{Function}						{return symbol(sym.TK_FUNCTION);}
	{Sub}							{return symbol(sym.TK_SUB);}
	{Exit}							{return symbol(sym.TK_EXIT);}
	{Return}						{return symbol(sym.TK_RETURN);}
	{Structure}						{return symbol(sym.TK_STRUCTURE);}
	{Sum}							{return symbol(sym.TK_SUM);}
        {ampersand}                                             {return symbol(sym.TK_AMPERSAND);}
	{stringval}						{stringtmp=yytext();return symbol(sym.TK_STRINGVAL,stringtmp.substring(1,stringtmp.length()-2));}
	{Minus}							{return symbol(sym.TK_MINUS);}
	{Product}						{return symbol(sym.TK_PRODUCT);}
	{Division}						{return symbol(sym.TK_DIVISION);}
	{GreaterThan}                                           {return symbol(sym.TK_GREATERTHAN);}
	{LessThan}						{return symbol(sym.TK_LESSTHAN);}
	{GreaterEqual}                                          {return symbol(sym.TK_GREATEREQUAL);}
	{LessEqual}						{return symbol(sym.TK_LESSEQUAL);}
        {NotEqual}						{return symbol(sym.TK_NOTEQUAL);}
	{And}							{return symbol(sym.TK_AND);}
	{Or}							{return symbol(sym.TK_OR);}
	{Not}							{return symbol(sym.TK_NOT);}
	{Xor}							{return symbol(sym.TK_XOR);}
	{Equals}						{return symbol(sym.TK_EQUALS);}	
	{comma}							{return symbol(sym.TK_COMMA);}
	{parIn}							{return symbol(sym.TK_PARIN);}
	{parOut}						{return symbol(sym.TK_PAROUT);}
	{id}							{return symbol(sym.TK_ID,new OBJID(yytext()));}
	{Number}						{return symbol(sym.TK_NUMBER, new Integer(Integer.parseInt(yytext())));}
	{comment}						{yybegin(COMMENTS);}
        <<EOF>>                                                 {return new Symbol(sym.EOF,yyline,yycolumn);}
        {whitespace}                                            {                                            }
        {linebreak}						{                                            }       
	.							{System.err.println("Symbol not found: "+yytext()+" at line "+yyline);}
}

<COMMENTS>{
	{linebreak}						{yybegin(YYINITIAL);						}
	.							{                   						}
}
