
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 */

/**
 * @author Alex Ponce Pacheco <3
 *
 */

public class WServer {

	public static void main(String[] args) {

		ServerSocket serverSocket;
		Socket clientSocket;
		InputStream is;
		OutputStream os;
		Cortar cortar = new Cortar();
		WServer wserver = new WServer();
		String direccion = "C:/Users/Usuari SID/Downloads/java/files";
		String aux;
		String salida = null;
		int format;
		try {

			serverSocket = new ServerSocket(8303);
			while (true) {

				clientSocket = serverSocket.accept(); //socket per comunicarnos amb client
				is = clientSocket.getInputStream();
				os = clientSocket.getOutputStream();
				BufferedReader br1 = new BufferedReader(new InputStreamReader(is));
				aux= cortar.CortarEspacio(br1);
				aux= cortar.CortarInterrogante(aux);
				
				
				format = wserver.Comprovacio(aux);
				
				switch(format){
				
					
					case 1:	FileReader file = new FileReader(direccion+aux); //carguem el ficher
							int lenght=file.read(); //longitut del ficher
							BufferedReader br= new BufferedReader(file);
							StringBuilder content=new StringBuilder(lenght+1);
							salida = HTML.TractamentHTML(br,content);
							break;
					
				
				}
					Enviar(salida,os,clientSocket);
				  
				}
				
						
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param aux
	 * @return
	 * Funcio que comprova quin tipus de fitxer esta demanant el servidor(html,jpg,xml)
	 * @throws IOException 
	 */
	public int Comprovacio(String aux) throws IOException{
		String codi1="html";
		String codi2="jpg";
		String codi3="xml";
		Cortar cortar = new Cortar();
		String prova;
		
		prova = cortar.CortarPunto(aux);
		
	    System.out.println(prova);


		if(prova.equals(codi1)){
			return 1;
			}
		else if(prova.equals(codi2)){
			return 2;
			}
		else if(prova.equals(codi3)){
			return 3;
			}	
		else{
			return 0;
			}	
		}
		
	/**
	 * 
	 * @param salida Dades a enviar
	 * @param os	
	 * @param clientSocket
	 * @throws IOException
	 * Funció que envia al client el resultat de la seva petició
	 */
		
	 public static void Enviar(String salida,OutputStream os,Socket clientSocket) throws IOException{
		 
		 
		    OutputStreamWriter out = new OutputStreamWriter(os);
			out.write(salida);
			out.flush();
			os.close();
			clientSocket.close();
	 }
}
;
	


		
	
	



