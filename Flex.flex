/*Seccion de codigo de usuario*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//clase de los token devueltos
class Yytoken {
    Yytoken (int numToken,String token, String tipo, int linea, int columna){
        //Contador para el número de tokens reconocidos
        this.numToken = numToken;
        //String del token reconocido
        this.token = new String(token);
        //Tipo de componente léxico encontrado
        this.tipo = tipo;
        //Número de linea
        this.linea = linea;
        //Columna donde empieza el primer carácter del token
        this.columna = columna;
    }
    //Métodos de los atributos de la clase
    public int numToken;
    public String token;
    public String tipo;
    public int linea;
    public int columna;
    //Metodo que devuelve los datos necesarios que escribiremos en un archive de salida
    public String toString() {
		return tipo + " " + token;
        /*return "Token #"+numToken+": "+token+" C.Lexico: "+tipo+" ["+linea
        + "," +columna + "]";*/
    }
}

/* Seccion de opciones y declaraciones de JFlex */
%% //inicio de opciones
//Cambiamos el nombre la funcion para el siguiente token por nextToken
%function nextToken
//Clase publica
%public
//Cambiamos el nombre de la clase del analizador
%class AnalizadorLexico
//Agregamos soporte a unicode
%unicode
//Codigo java
%{
	
    private int contador;
    private ArrayList<Yytoken> tokens;

	private void writeOutputFile() throws IOException{
			/*String filename = "file.out";
			BufferedWriter out = new BufferedWriter(
				new FileWriter(filename));
            System.out.println("\n*** Tokens guardados en archivo ***\n");
			for(Yytoken t: this.tokens){
				System.out.println(t);
				out.write(t + "\n");
			}
			out.close();*/
	}
%}
//Creamos un contador para los tokens
%init{
    contador = 0;
	tokens = new ArrayList<Yytoken>();
%init}
//Cuando se alcanza el fin del archivo de entrada
%eof{
	try{
		this.writeOutputFile();
        System.exit(0);
	}catch(IOException ioe){
		ioe.printStackTrace();
	}
%eof}
//Activar el contador de lineas, variable yyline
%line
//Activar el contador de columna, variable yycolumn
%column
//Fin de opciones

//Expresiones regulares
//Declaraciones
EXP_ALPHA=[A-Za-z]
EXP_DIGITO=[0-9]
EXP_ALPHANUMERIC={EXP_ALPHA}|{EXP_DIGITO}
NUMERO=({EXP_DIGITO})+
IDENTIFICADOR={EXP_ALPHA}({EXP_ALPHANUMERIC})*
ESPACIO=" "
COMENTARIO_LINEAL=\/\/.*
COMENTARIO_BLOQUE=\{(\*(\/)|[^}])*\}
SALTO=\n|\r|\r\n
TABULADOR=\t
TOKEN_DESCONOCIDO=[^a-zA-Z0-9.=,;()&#<>+-/\/{}\*\t ]
//fin declaraciones

/* Seccion de reglas lexicas */
%% 
//Regla     {Acciones}

"CONST"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"1",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"VAR"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"2",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"PROC"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"3",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"INICIO"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"4",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"FIN"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"5",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"ESCRIBIR"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"6",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"LEER"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"7",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"LLAMAR"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"8",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"SI"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"9",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"MIENTRAS"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"10",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"PARA"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"11",yyline,yycolumn);
    tokens.add(t);
    return t;
}
{IDENTIFICADOR}   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"12",yyline,yycolumn);
    tokens.add(t);
    return t;
}
{NUMERO}    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"13",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"."  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"14",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"="  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"15",yyline,yycolumn);
    tokens.add(t);
    return t;
}
","  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"16",yyline,yycolumn);
    tokens.add(t);
    return t;
}
";"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"17",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"("  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"18",yyline,yycolumn);
    tokens.add(t);
    return t;
}
")"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"19",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"&"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"20",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"%"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"21",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"=="  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"22",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"#"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"23",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"<"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"24",yyline,yycolumn);
    tokens.add(t);
    return t;
}
">"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"25",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"<="  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"26",yyline,yycolumn);
    tokens.add(t);
    return t;
}
">="  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"27",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"+"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"28",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"-"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"29",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"*"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"30",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"/"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"31",yyline,yycolumn);
    tokens.add(t);
    return t;
}

/*Los metacaracteres es necesario usar la secuencia de escape */
{ESPACIO} {
 	//ignorar
}
{SALTO} {
   //iGNORAR
}
{COMENTARIO_LINEAL} {
	//IGNORAR COMENTARIO LINEAL
}
{TABULADOR} {
	//IGNORAR UN TABULADOR
}
{COMENTARIO_BLOQUE} {
	//IGNORAR COMENTARIOS MULTILINEAS
}
{TOKEN_DESCONOCIDO} {
	contador++;
    Yytoken t = new Yytoken(contador,yytext(),"-1",yyline,yycolumn);
    tokens.add(t);
    return t;
}
