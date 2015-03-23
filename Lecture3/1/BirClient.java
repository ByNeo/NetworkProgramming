import java.io.*;
import java.net.*;


public class BirClient
{
	public static void main(String[] args) throws IOException {

		Socket socket = null;
		//PrintWriter out = null; // Character output, mesaj gondermek icin
		//BufferedReader in = null; // Character Input
		String host = "www.google.com"; // "www.google.com"
		int port=80;
		try {
			socket = new Socket(host, port); // "localhost" ya da sunucu IP adresi
			// input stream ve output stream olusuyor
			//out = new PrintWriter(socket.getOutputStream(), true);
			//in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Sunucu bulunamadi");
			System.exit(1);
		} 
		
		System.out.println("Sunucuya baglanildi."+socket.getLocalSocketAddress());
		
		socket.close();
	}

}
