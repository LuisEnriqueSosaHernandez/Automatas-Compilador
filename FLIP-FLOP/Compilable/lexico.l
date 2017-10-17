%{
#include <stdio.h>
#include <conio.h>
%}


%option noyywrap


ignora " "|\t
caracter [A-Za-z]
digito [0-9]
reservada "entrada"|"main"|"programa"|"constante"|"salida"|"hacer si"|"contrario"|"mientras"|"hacer"|"ciclo"
bits "&="|"|="|"^="|"<<"|">>"|"&"|"|"|"^"|"~"
boleano "||"|"&&"|"!"|"verdad"|"falso"
matematicos "="|"++"|"--"|"-"|"+"|"*"|"/"|"%"
comparador "<"|">"|"<="|">="|"=="|"!="
delimitador "("|")"|"{"|"}"|","|"."|";"|"'"|"["|"]"|"\n"
datos "int"|"flotante"|"booleano"|"car"|"palabra"|"doble"|"vacio"

%%

{ignora}*				{;}
{reservada} {ECHO;printf(" ------>Palabra reservada\n");}
{bits}	{ECHO;printf(" ------>Operador de bits\n");}
{boleano}	{ECHO;printf(" ------>Operador logico\n");}
{matematicos}	{ECHO;printf(" ------>Operador matematico\n");}
{comparador}	{ECHO;printf(" ------>Comparador\n");}
{delimitador}	{ECHO;printf(" ------>Delimitador\n");}
{datos}			{ECHO;printf(" ------>Tipo de dato\n");}
{digito}+	{ECHO;printf(" ------>Numero entero\n");}
"-"{digito}+	{ECHO;printf(" ------>Numero entero negativo\n");}
{digito}+"."{digito}+	{ECHO;printf(" ------>Numero decimal\n");}
"'"{caracter}"'" {ECHO;printf(" ------>Caracter\n");}
"\""({digito}|{caracter}|" ")*"\"" {ECHO;printf(" ------>Cadena de caracteres\n");}
{caracter}({caracter}|{digito})*	{ECHO;printf(" ------>Identificador\n");}
.           {ECHO;printf(" ------>Error\n");}
%%


int main(void)
{
char NombreArchivo[50];
printf("Ruta del archivo: ");
gets(NombreArchivo);
yyin=fopen(NombreArchivo,"rt");
if(yyin==NULL)
printf("\nNo se puede leer el archivo");
else
yylex();
fclose(yyin);
return 0;
}