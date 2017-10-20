%{
#include <stdio.h>
#include <conio.h>
%}

%option yylineno
%option noyywrap


ignora " "|\t
caracter [A-Za-z]
digito [0-9]
entrada "entrada"
main "main"
programa "programa"
constante "constante"
salida "salida"
hacersi "hacer si"
mientras "mientras"
hacer "hacer"
ciclo "ciclo"
bits "&="|"|="|"^="|"<<"|">>"|"&"|"|"|"^"|"~"
logicos "||"|"&&"|"!"
matematicos "="|"+"|"*"|"/"|"%"
matematicoresta "-"
incremento "++"
decremento "--"
comparador "<"|">"|"<="|">="|"=="|"!="
abreparentesis "("
cierraparentesis ")"
abrellave "{"
cierrallave "}"
coma ","
puntoycoma ";"
punto "."
comillasimple "'"
comillas "\""
abrecorchete "["
cierracorchete "]"
delimitator "\n"
comentario "#"
tipodedato "int"|"flotante"|"booleano"|"car"|"palabra"|"doble"|"vacio"
boleano "verdad"|"falso"

%%

{ignora}*				{;}
{entrada} {ECHO;printf(" ------>Palabra reservada\n");}
{main}    {ECHO;printf(" ------>Palabra reservada\n");}
{programa} {ECHO;printf(" ------>Palabra reservada\n");}
{constante} {ECHO;printf(" ------>Palabra reservada\n");}
{salida}    {ECHO;printf(" ------>Palabra reservada\n");}
{hacersi}   {ECHO;printf(" ------>Palabra reservada\n");}
{mientras}  {ECHO;printf(" ------>Palabra reservada\n");}
{hacer}    {ECHO;printf(" ------>Palabra reservada\n");}
{ciclo}		{ECHO;printf(" ------>Palabra reservada\n");}
{bits}	{ECHO;printf(" ------>Operador de bits\n");}
{logicos} {ECHO;printf(" ------>Operador logico\n");}
{matematicos}	{ECHO;printf(" ------>Operador matematico\n");}
{matematicoresta}	{ECHO;printf(" ------>Operador matematico\n");}
{incremento}	{ECHO;printf(" ------>Operador matematico incremento\n");}
{decremento}    {ECHO;printf(" ------>Operador matematico decremento\n");}
{comparador}	{ECHO;printf(" ------>Comparador logico\n");}
{abreparentesis} {ECHO;printf(" ------>Delimitador\n");}
{cierraparentesis} {ECHO;printf(" ------>Delimitador\n");}
{abrellave}	{ECHO;printf(" ------>Delimitador\n");}
{cierrallave} {ECHO;printf(" ------>Delimitador\n");}
{coma}	{ECHO;printf(" ------>Delimitador\n");}
{puntoycoma} {ECHO;printf(" ------>Delimitador\n");}
{punto} {ECHO;printf(" ------>Delimitador\n");}
{comillasimple} {ECHO;printf(" ------>Delimitador\n");}
{comillas} {ECHO;printf(" ------>Delimitador\n");}
{abrecorchete} {ECHO;printf(" ------>Delimitador\n");}
{cierracorchete} {ECHO;printf(" ------>Delimitador\n");}
{delimitator} 	{ECHO;printf(" ------>Delimitador de linea\n");}
{tipodedato}			{ECHO;printf(" ------>Tipo de dato\n");}
{boleano}	{ECHO;printf(" ------>Booleano\n");}
{digito}+	{ECHO;printf(" ------>Numero entero\n");}
{matematicoresta}{digito}+	{ECHO;printf(" ------>Numero entero negativo\n");}
{digito}+{punto}{digito}+	{ECHO;printf(" ------>Numero decimal\n");}
{comillasimple}{caracter}{comillasimple} {ECHO;printf(" ------>Caracter\n");}
{comillas}({digito}|{caracter}|" ")*{comillas} {ECHO;printf(" ------>Cadena de caracteres\n");}
{comentario}+(({caracter}|" "|{digito})?)*	{ECHO;printf(" ------>Comentario\n");}
{caracter}({caracter}|{digito})*	{ECHO;printf(" ------>Identificador\n");}
.           {ECHO;printf(" ------>Token invalido en la linea %d\n",yylineno);}
%%

int main(int argc, char *argv[]){
yyin=fopen(argv[1],"rt");
if(yyin==NULL)
printf("\nNo se pudo leer el archivo");
else
yylex();
fclose(yyin);
return 0;
}