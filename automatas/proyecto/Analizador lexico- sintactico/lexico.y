%{
int yystopparser=0;
%}

%token VOID MAIN NOMBREVARIABLE ENTERO DECIMAL BOLEANDO CADENA T_ENTERO T_DECIMAL T_BOLEANO T_CADENA SUMA RESTA MULTIPLICACION DIVISION INCREMENTAR DECREMENTAR ASIGNADOR MAYOR MENOR IGUAL MAYORIGUAL MENORIGUAL DIFERENTE IF ELSE IFELSE FOR WHILE

%start programa

%%

programa		: principal funciones | principal;

principal		: VOID MAIN '(' VOID ')' '{' lineascodigos '}';

lineascodigos		: lineacodigo |;

lineacodigo		: lineacodigo linea | linea;

linea			: llamarmetodo ';' | crearvariable ';' | cambiarvalor ';' | ciclocondicion;

llamarmetodo		: NOMBREVARIABLE '(' parametrosenvio ')';

parametrosenvio		: parenvio |;

parenvio		: parenvio ',' penvio | penvio;

penvio			: valor | NOMBREVARIABLE;

valor			: ENTERO | DECIMAL | BOLEANDO | CADENA;

crearvariable		: tipodato NOMBREVARIABLE | tipodato NOMBREVARIABLE asignarvalor;

tipodato		: T_ENTERO | T_DECIMAL | T_BOLEANO | T_CADENA;

asignarvalor		: ASIGNADOR operasignacion | ASIGNADOR valor | ASIGNADOR NOMBREVARIABLE;

operasignacion		: aritmetico | llamarmetodo | incredismivariable;

aritmetico		: oprcomun | oprcomun oprcomplemento;

oprcomun		: valor tipoopr valor | valor tipoopr NOMBREVARIABLE | NOMBREVARIABLE tipoopr valor | NOMBREVARIABLE tipoopr NOMBREVARIABLE;

tipoopr 		: SUMA | RESTA | MULTIPLICACION | DIVISION;

oprcomplemento		: oprcomplemento oprcom | oprcom;

oprcom			: tipoopr valor | tipoopr NOMBREVARIABLE;

incredismivariable	: NOMBREVARIABLE indis;

indis			: INCREMENTAR | DECREMENTAR;

cambiarvalor		: NOMBREVARIABLE ASIGNADOR cambvalor;

cambvalor		: valor | operasignacion | NOMBREVARIABLE;

ciclocondicion		: condicionif | ciclofor | ciclowhile;

condicionif		: condicionsi | condicionsi condicionno | condicionsi condicionessino condicionno;

condicionsi		: IF '(' condicion ')' '(' lineascodigos ')';

condicion		: valor condicional valor | valor condicional NOMBREVARIABLE | NOMBREVARIABLE condicional valor | NOMBREVARIABLE condicional NOMBREVARIABLE;

condicional		: MAYOR | MENOR | IGUAL | MAYORIGUAL | MENORIGUAL | DIFERENTE;

condicionno		: ELSE '(' lineascodigos ')';

condicionessino		: condicionessino condicionsino | condicionsino;

condicionsino		: IFELSE '(' condicion ')' '(' lineascodigos ')';

ciclofor		: FOR '(' iniciafor ';' condicion ';' incredismivariable ')' '(' lineascodigos ')';

iniciafor		: tipodato NOMBREVARIABLE asignarvalor;

ciclowhile		: WHILE '(' condicion ')' '(' lineascodigos ')';

funciones		: funciones funcion | funcion;

funcion			: tiporetorno NOMBREVARIABLE '(' parametrosin ')' '{' lineascodigos '}';

tiporetorno 		: tipodato | VOID;

parametrosin		: parametros |;

parametros		: parametros ',' parametro | parametro;

parametro		: tipodato NOMBREVARIABLE;
