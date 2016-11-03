import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

//Mohamed Walis SAMAI

public class Kasiski {

	public static  String readfile (String file) throws IOException {
		File fichier= new File (file);
		int l = (int)fichier.length();
		byte[] buffer= new byte[l];
		FileInputStream fis = new FileInputStream(fichier);//01
		fis.read(buffer);//02
		String texte= new String(buffer);
		fis.close();	
		return texte;
	
	}
	
	public static ArrayList<Integer> kasiski(String file, int c ) throws IOException {
		String texte= readfile(file);
		texte=texte.replaceAll(" ","");
		texte=texte.replaceAll("\n","");
		ArrayList<Integer> L = new ArrayList<Integer>(); 
		HashMap<String, Integer> H = new HashMap <String, Integer>();
		for(int i=0; i< texte.length()-c; i++){
			String t = texte.substring(i,i+c);
			if(H.containsKey(t)==false)
			{
				H.put(t,i+c);
			}
			else {
				L.add(i-H.get(t));
				H.remove(t);
				H.put(t,i+c);
			}
			
		}

		return L;
		
	}

public static void main(String[] args) throws IOException{
	long debut = System.currentTimeMillis();
	 
	//String texte = readfile("cipher.txt");
	ArrayList<Integer> L= kasiski("cipher.txt",8);
	 
	System.out.println(System.currentTimeMillis()-debut);
	
	for(int i =0; i<L.size();i++){
		System.out.println(L.get(i));
	}
	
}
}
