import java.io.BufferedReader ;
import java.io.FileReader;

public class AnalizadorLexico{

	public static void main(String[] a){
		
		leerCodigo("prog1.p10");
	}
	
	public static void leerCodigo(String nombre){
		try{
			FileReader codigo = new FileReader(nombre);
			BufferedReader buffer = new BufferedReader(codigo);
			String codigoString;
			
			while((codigoString = buffer.readLine()) != null){
				System.out.println(codigoString + "");
			}
		}catch(Exception ex){
			System.out.println("Error al abrir el archivo");
		}
	}
}
