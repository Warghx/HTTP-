import java.io.BufferedReader;
import java.io.IOException;
/**
 * 
 * @author Wargh
 * Conté les funciones necesaries per tractar els cassos html
 */

public class HTML {

	/**
	 * 
	 * @param br
	 * @param content
	 * @return
	 * @throws IOException
	 * Funcio que tracta les dades a enviar en cas que es demani html simple.Buce mentre anem fent append amb les dades del fitxer demanat, una vegada acabat afegim la capçalera
	 * corresponent.s
	 */
	public static String TractamentHTML(BufferedReader br,StringBuilder content) throws IOException{
	
		String z;
		String h;
		z= "<";
		while((h=br.readLine())!=null)
		{
		
			content.append(h);
			z= z+h;
			
	    }
		z = "\n"+ z;
		z = "Content-Disposition: filename="+"\"index.html\""+" \n" +z;
	    z = "Content-Type: html\n" +z;
	    z = "HTTP/1.1 200 OK\n" +z ;
	    System.out.println(z);
		
	
	    return(z);
		}
	
	
	
	
	
}
	