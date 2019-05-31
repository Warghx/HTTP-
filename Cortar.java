import java.io.BufferedReader;
import java.io.IOException;

/**
 * 
 * @author Alex Ponce Pacheo
 * Conté les funciones per els diferents tipus de splits que podrem necesitar.
 *
 */
public class Cortar {
		/**
		 * 
		 * @param br1
		 * @return
		 * @throws IOException
		 * Funció que talla la petició del servidor mirant els espais
		 */
	
		public String  CortarEspacio( BufferedReader br1 ) throws IOException{
		String s = " ";//separador
		String t = null;//donde guardamos los caracteres al cortar
		String[] b = null;	
		if((t = br1.readLine()) != null) {
		b = t.split(s);
		System.out.println(b[1]);
		}
		
		return(b[1]);
		
		}
		/**
		 * 
		 * @param aux
		 * @return
		 * @throws IOException
		 * Funcio que talla i envia el tipus d'arxiu que demana el client
		 */
		public String  CortarInterrogante( String aux ) throws IOException{
			for ( int i = 0; i <= aux.length() - 1; i++) {
				
				
				if (aux.contains("\\?")){
					String[] b = null;	
					
					b = aux.split("\\?");
					System.out.println(b[1]);
					
					return(b[1]);
				}
				else {
					return ();
				}
				}
				

			
				
				
			
		}
		/**
		 * 
		 * @param aux
		 * @return
		 * @throws IOException
		 * Funcio que talla i envia el tipus d'arxiu que demana el client
		 */
		public String  CortarPunto( String aux ) throws IOException{
			String[] b = null;	
			b = aux.split("\\.");
			
			
			return(b[1]);
			
}
}
		



