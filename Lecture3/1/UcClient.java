import java.io.*;
import java.net.*;


public class UcClient
{
	public static final String sERVER = "time.nist.gov";
	public static final int pORT = 13;
	public static final int tIMEOUT = 10000;
	
	public static void main(String[] args) throws IOException {

		Socket socket = null;
		PrintWriter out = null; // Character output , mesaj gondermek icin
		BufferedReader in = null; // Character Input
		
		try {
			socket = new Socket(sERVER, pORT); // "localhost" ya da sunucu IP adresi
			// input stream  olusuyor
						
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Sunucu bulunamadi");
			System.exit(1);
		} 
		System.out.println("Sunucuya baglanildi. zaman alınıyor...\n"+in.readLine());
		in.close();
		socket.close();
	}

}
