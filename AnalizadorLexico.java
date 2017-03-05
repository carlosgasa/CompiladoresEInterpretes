import java.io.BufferedReader ;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.io.FileReader;

public class AnalizadorLexico{

	private static ArrayList<String> codigoString = new ArrayList<String>();
	private static Map<Integer, String> tokens = new TreeMap<Integer, String>(); 
	
	public static void main(String[] a){
		
		cargarTokens();
		if(leerCodigo("prog1.p10") == 1){//Si el archivo se pudo leer
			
			print("true, total de lines : " + codigoString.size());
			
		}
		else{
			print("Error al leer el archivo");
		}
	}
	
	public static int leerCodigo(String nombre){
		
		try{
			FileReader codigo = new FileReader(nombre);
			BufferedReader buffer = new BufferedReader(codigo);
			
			String linea = "";
			while((linea = buffer.readLine()) != null){
				codigoString.add(linea);
			}
			return 1;
		}catch(Exception ex){
			return 0;
		}
	}
	
	public static void print(String s){
		System.out.print(s);
	}
	
	public static void cargarTokens(){
		tokens.put(1,"CONST");
		tokens.put(2,"VAR");
		tokens.put(3,"PROC");
		tokens.put(4,"INICIO");
		tokens.put(5,"FIN");
		tokens.put(6,"ESCRIBIR");
		tokens.put(7,"LEER");
		tokens.put(8,"LLAMAR");
		tokens.put(9,"SI");
		tokens.put(10,"MIENTRAS");
		tokens.put(11,"PARA");
		tokens.put(12,"(id)identificador");
		tokens.put(13,"(num)NumeroEntero");
		tokens.put(14,".");
		tokens.put(15,"=");
		tokens.put(16,",");
		tokens.put(17,";");
		tokens.put(18,"(");
		tokens.put(19,")");
		tokens.put(20,"&");
		tokens.put(21,"%");
		tokens.put(22,"==");
		tokens.put(23,"#");
		tokens.put(24,"<");
		tokens.put(25,">");
		tokens.put(26,"<=");
		tokens.put(27,">=");
		tokens.put(28,"+");
		tokens.put(29,"-");
		tokens.put(30,"*");
		tokens.put(31,"/");
		
		/*for(int i = 0; i<tokens.size() + 1; i++){
			print(i + " -> " + tokens.get(i) + "\n");
		}*/
		
	}
}
