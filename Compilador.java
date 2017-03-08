import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Compilador{

	public static void main(String[] args){

		 try {//Intentar abrir el archivo .p10
			 FileReader codigo = new FileReader("prog1.p10");//Leer archivo a analizar
			 BufferedReader buffer = new BufferedReader(codigo);//Pasar al buffer los datos leidos en "codigo"
			 AnalizadorLexico analizador = new AnalizadorLexico(buffer); //crear el analizador para poder acceder a los tokens
			 Yytoken token = null;//Tipo de dato para poder acceder a cada token de los guardados en 'analizador'
			 if(buffer != null) System.out.println("#TOKEN\t\tLEXEMA");//Imprimir el nombre de las columnas, si se logro abrir el archivo,sino pasa hasta el catch
			 do {
				 token = analizador.nextToken();//Avanzar al siguiente token, extrayendolo de a
				 System.out.println(token.tipo +"\t\t" +token.token); //Token tiene las propiedades  (int numToken,String token, String tipo, int linea, int columna)
			} while (token != null);															//																contador de tokens, token,    tipo de token, linea,    columna
		}
		catch (Exception ex) {
			System.out.println("Error al abrir el archivo de codigo");
		} 
	}
}
