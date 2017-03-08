import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;

public class Compilador{

	public static void main(String[] args){

		 try {
			 BufferedReader bf = leerCodigo("prog1.p10");
			 AnalizadorLexico a = new AnalizadorLexico(bf);
			 Yytoken token = null;
			 if(bf != null) System.out.println("#TOKEN\t\tLEXEMA");
			 do {
				 token = a.nextToken();
				 System.out.println(token.tipo +"\t\t" +token.token);
			} while (token != null);
		}
		catch (Exception ex) {
			System.out.println("Error al abrir el archivo de codigo");
		} 
	}
	
	public static BufferedReader leerCodigo(String nombre){
		
		try{
			FileReader codigo = new FileReader(nombre);
			BufferedReader buffer = new BufferedReader(codigo);
			return buffer;
		}catch(Exception ex){
			return null;
		}
	}
}
