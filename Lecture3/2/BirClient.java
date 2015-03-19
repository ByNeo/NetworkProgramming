import java.io.*;
import java.net.*;


public class BirClient
{
	public static void main(String[] args) throws IOException {

		Socket socket = null;
		PrintWriter out = null; // Character output , mesaj gondermek icin
		BufferedReader in = null; // Character Input
		String host = "localhost";
		int port=8080;
		try {
			socket = new Socket(host,port); // "localhost" ya da sunucu IP adresi
			
			//socket.connect(new InetSocketAddress(host, port), 5000);
			
			
			//socket.setSoTimeout(15000); // Faaliyet olmadığı durumda read işlemi için timeout
			
						
			// input stream ve output stream olusuyor
			
			//s.bind(new InetSocketAddress("172.16.1.102", 5000));
			
			
			out = new PrintWriter(socket.getOutputStream(), true); 
			//Creates a new PrintWriter, without (if true then with) automatic line flushing, from an existing OutputStream.
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Sunucu bulunamadi");
			System.exit(1);
		} 
		/*catch (IOException e) {
			System.err.println("I/O exception:" + e.getMessage());
			System.exit(1);
		}*/
		System.out.println("Sunucuya baglanildi.");
		
		
		// klavyeden girdi: stdIn
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String userInput;
		System.out.println("Buyuk harflere cevrilmesi icin girdi bekleniyor (baglantiyi kesmek icin: end) ...");
		while (!(userInput = stdIn.readLine()).equals("end")) {
			out.println(userInput);
			System.out.println("Sunucudan gelen: " + in.readLine());
		}
		System.out.println("Baglanti kesiliyor...");
		
		
		stdIn.close();
		out.close();
		in.close();
		socket.close();
	}

}
