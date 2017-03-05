import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class AnalizadorLexico{

	
	public static void main(String[] a){
		PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		so.print("hello");
		//so.print("Imprime sin salto de linea");
		//so.println("Imprime con salto de linea");
		
		//Al finalizar
		so.close();
	}
}
