import java.io.*;
import java.net.*;


public class IkiClient
{
	public static void main(String[] args) throws IOException {

		Socket socket = null;
		PrintWriter out = null; // Character output , mesaj gondermek icin
		BufferedReader in = null; // Character Input
		String host = "www.linux.org.tr";
		int port=80;
		try {
			socket = new Socket(host, port); // "localhost" ya da sunucu IP adresi
			// input stream ve output stream olusuyor
			
			//s.bind(new InetSocketAddress("172.16.1.102", 5000));
			
			
			out = new PrintWriter(socket.getOutputStream(), false); 
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
		
		
		//String message = "GET / HTTP/1.1\r\n\r\n";
		out.println("GET / HTTP/1.1");
		out.println("Host: localhost");
		out.println("");
		out.flush();
		
		//out.println( message );
             
		System.out.println("web istegi gönderildi");
		
		
		
		 //Get response from server
		String response;
		while ((response = in.readLine()) != null)
		{
			System.out.println( response );
		}
		
		out.close();
		in.close();
		socket.close();
	}

}
