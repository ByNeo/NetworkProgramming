import java.io.*;
import java.net.*;


public class IkiClient
{
	public static void main(String[] args) throws IOException {

		Socket socket = null;
		PrintWriter out = null; // Character output , mesaj gondermek icin
		//BufferedReader in = null; // Character Input
		String host = "www.askubuntu.com";
		int port=80;
		try {
			socket = new Socket(host, port); // "localhost" ya da sunucu IP adresi
			// input stream ve output stream olusuyor
			
			out = new PrintWriter(socket.getOutputStream(), true); 
			//Creates a new PrintWriter, with automatic line flushing, from an existing OutputStream.
			
			//in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Sunucu bulunamadi");
			System.exit(1);
		} 
		/*catch (IOException e) {
			System.err.println("I/O exception:" + e.getMessage());
			System.exit(1);
		}*/
		System.out.println("Sunucuya baglanildi.");
		
		
		String message = "GET / HTTP/1.1\r\n\r\n";
		out.println( message );
             
		System.out.println("web istegi gönderildi");
		
		
		// klavyeden girdi: stdIn
		/*BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String userInput;
		System.out.println("Buyuk harflere cevrilmesi icin girdi bekleniyor (baglantiyi kesmek icin: end) ...");
		while (!(userInput = stdIn.readLine()).equals("end")) {
			out.println(userInput);
			System.out.println("Sunucudan gelen: " + in.readLine());
		}
		System.out.println("Baglanti kesiliyor...");

		out.close();
		in.close();
		stdIn.close();
		socket.close();*/
	}

}
