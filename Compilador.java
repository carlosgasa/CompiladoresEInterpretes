/*
 * Universidad Autonoma de Zacatecas
 * Ingenieria en Computacion
 * Carlos Galindo Sanchez
 * 
 * @https://github.com/carlosgasa/CompiladoresEInterpretes
 * */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Compilador{

	private static ArrayList<String> tokens = new ArrayList<String>();
	private static ArrayList<Simbolo> tablaSimbolos = new ArrayList<>();
	private static String nombreCodigo = "error";//"prog1.p10";
	
	public static void main(String[] args){

		cargarTokens();//Se cargan los tokens para poder hacer la comparacion y saber si un token es un lexema
		
		//entrada con el nombre del archivo a analizar
		if(args.length != 0) nombreCodigo = args[0];;
		try {//Intentar abrir el archivo .p10
			 FileReader codigo = new FileReader(nombreCodigo);//Leer archivo a analizar
			 BufferedReader buffer = new BufferedReader(codigo);//Pasar al buffer los datos leidos en "codigo"
			 AnalizadorLexico analizador = new AnalizadorLexico(buffer); //crear el analizador para poder acceder a los tokens
			 
			 Yytoken token = null;//Tipo de dato para poder acceder a cada token de los guardados en 'analizador'
			 if(buffer != null) System.out.println("#TOKEN\t\tLEXEMA");//Imprimir el nombre de las columnas, si se logro abrir el archivo,sino pasa hasta el catch
			 do {
				 token = analizador.nextToken();//Avanzar al siguiente token, extrayendolo de analizador
				 if(!token.tipo.equals("-1")){//Ver si hay un token desconocido
					if(esLexema(token.token)){
						tablaSimbolos.add(new Simbolo(token.token, token.tipo));//Agregar a la tabla de simbolos
						System.out.println(token.tipo +"\t\t" +token.token); //Token tiene las propiedades  (int numToken,String token, String tipo, int linea, int columna)
																																															//contador de tokens, token,    tipo de token, linea,    columna#E31010
					}
					else{//Sino es un lexema, solo poner tipo de token
						System.out.println(token.tipo);
					} 
				}
				else{
					System.out.println(error(token.linea,token.columna));
					break;//Detener el ciclo while
				} 
			} while (token != null);
		}
		catch (Exception ex) {
			System.out.println("Error al abrir el archivo de codigo");
		} 
	}

	public static boolean esLexema(String token){//Este metodo solo es para entender mejor el contexto del programa
		return !tokens.contains(token);
	}

	public static void cargarTokens(){
	
		tokens.add("CONST");
		tokens.add("VAR");
		tokens.add("PROC");
		tokens.add("INICIO");
		tokens.add("FIN");
		tokens.add("ESCRIBIR");
		tokens.add("LEER");
		tokens.add("LLAMAR");
		tokens.add("SI");
		tokens.add("MIENTRAS");
		tokens.add("PARA");
		tokens.add(".");
		tokens.add("=");
		tokens.add(",");
		tokens.add(";");
		tokens.add("(");
		tokens.add(")");
		tokens.add("&");
		tokens.add("%");
		tokens.add("==");
		tokens.add("#");
		tokens.add("<");
		tokens.add(">");
		tokens.add("<=");
		tokens.add(">=");
		tokens.add("+");
		tokens.add("-");
		tokens.add("*");
		tokens.add("/");
	}
	public static String error(int linea, int columna){
		
		ArrayList<String> lineas = new ArrayList<String>();
		String localizacion = "";
		try{
			
			FileReader codigo = new FileReader(nombreCodigo);//Lee otra vez el archivo para imprimir la linea, ya que el primer buffer de el metodo main se pierde al leerlo
			BufferedReader buffer = new BufferedReader(codigo);
			String _linea = "";
			
			while((_linea = buffer.readLine()) != null){//Leer todas las lineas
				lineas.add(_linea);
			}
			int i = 0;
			char caracter;
			String cadenaAnalizar = lineas.get(linea);
			while(i<columna){//Encontrar el error
				caracter = cadenaAnalizar.charAt(i);//Se obtiene caracter por caracter de la linea que se esta analizando
				if(caracter == '\t') localizacion += '\t';//Si el caracter es un tabulador, entonces se suma un \t a la cadena de localizacion
				else localizacion += " "; //Si es un caracter cualquiera, solo se suma un espacio, asi se garantiza la localizacion correcta del error
				i++;
			};
		}
		catch (Exception ex){
			return "error";
		}
		
		//A continuacion, se regresa una cadena con toda la informacion del error
		return nombreCodigo + ": Error en la linea " + (linea + 1) +  " :  Elemento No Valido\n" +
		lineas.get(linea) +
		"\n" + localizacion + "^";
	}
}
