import java.net.*;
import java.io.*;

public class BirServer {
	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		PrintWriter out = null; // Character output , mesaj gondermek icin
		BufferedReader in = null; // Character Input
		//String host = "localhost";
		int port=8080;
		
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.err.println("I/O exception: " + e.getMessage());
			System.exit(1);
		}
		System.out.println("Sunucu baslatildi. Baglanti bekleniyor...");
		
		try {
			clientSocket = serverSocket.accept(); 
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}
		
		System.out.println(clientSocket.getInetAddress().getHostName() + " : " + clientSocket.getPort()+ " baglandi.");
		
		// input stream ve output stream olustur
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	
		String inputLine, outputLine;
		System.out.println("istemciden girdi bekleniyor...");
		while ((inputLine = in.readLine()) != null) { // istemciden gelen string okunuyor...
			System.out.println("istemciden gelen :" + inputLine);
			outputLine = inputLine.toUpperCase(); // 
			
			out.println(outputLine); // 
			if (outputLine.equals("end")) // 
				break;
		}
		System.out.println(clientSocket.getLocalSocketAddress() + " baglantisi kesildi.");
		// stream ve socketleri kapat.
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}
}
