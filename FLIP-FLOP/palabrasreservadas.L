%{
#include <stdio.h>
#include <conio.h>
%}

%option noyywrap
%option yylineno

ignora " "|\t|\n
caracter [A-Za-z]
digito [0-9]
boleano "true"|"false"

%%

{ignora}*				{;}
"."					{return ('.');}
"{"					{return ('{');}
"}"					{return ('}');}
";"					{return (';');}
","					{return (',');}
")"					{return (')');}
"("					{return ('(');}
"if"					{return IF;}
"else if"				{return IFELSE;}
"else"					{return ELSE;}
"for"					{return FOR;}
"while"					{return WHILE;}
"vacio"					{return VOID;}
"main"					{return MAIN;}
"integer"				{return T_ENTERO;}
"decimal"				{return T_DECIMAL;}
"bool"					{return T_BOLEANO;}
"string"				{return T_CADENA;}
"+"					{return SUMA;}
"-"					{return RESTA;}
"*"					{return MULTIPLICACION;}
"/"					{return DIVISION;}
"++"					{return INCREMENTAR;}
"--"					{return DECREMENTAR;}
"="					{return ASIGNADOR;}
">"					{return MAYOR;}
"<"					{return MENOR;}
"=="					{return IGUAL;}
">="					{return MAYORIGUAL;}
"<="					{return MENORIGUAL;}
"!="					{return DIFERENTE;}
{digito}+				{return ENTERO;}
{digito}+"."{digito}			{return DECIMAL;}
{boleano}				{return BOLEANDO;}
"\""({digito}|{caracter}|" ")*"\""	{return CADENA;}
{caracter}({caracter}|{digito})+)*	{return NOMBREVARIABLE;}
.					{printf("Error en linea: %d\n",yylineno);}


%%

yyerror(char * msg)
{
printf("%s\n",msg);
}

int main(void)
{
char NombreArchivo[50];
printf("Ruta del archivo: ");
gets(NombreArchivo);
yyin=fopen(NombreArchivo,"rt");
if(yyin==NULL)
printf("\nNo se puede leer el archivo");
else
yyparse();
fclose(yyin);
getch();
}
