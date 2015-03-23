/**
 *  UDP sunucu
 *  İstemciden gelen mesajı ekrana yazdırdıktan sonra büyük harflere dönüştürüp geriye
 *  döndürüyor. 
 */


//package edu.cc.networkprogramming;

import java.net.*;
import java.util.logging.*;
import java.io.*;

public class UDPServer {

	private final static int PORT = 8080;
	private final static Logger audit = Logger.getLogger("requests");
	private final static Logger errors = Logger.getLogger("errors");

	public static void main(String[] args) 
	{
		DatagramSocket socketServer=null;
		try
		{
			//Log dosyası belirleniyor...
			
			FileHandler handler = new FileHandler("server.log", 100000, 10000);
			Logger.getLogger("").addHandler(handler);
			
			socketServer = new DatagramSocket(PORT);
			
			
			String outputLine;

			while (true) {
				try {
					
					// Giriş ve çıkışlar için oluşturulacak DatagramPacket içerisinde kullanılmak üzere tampon bellek oluşturuluyor. 
					// TCP deki stream yerine DatagramPacket kullanılıyor.
					
					byte[] in = new byte[1024]; 
					byte[] out  = new byte[1024];
					
					DatagramPacket request = new DatagramPacket(in, in.length);

					socketServer.receive(request);

					String inputLine = new String(request.getData());
					InetAddress IPAddress = request.getAddress(); 

					int port = request.getPort(); 

					System.out.println ("From: " + IPAddress + ":" + port);
					System.out.println ("Message: " + inputLine);

					outputLine = inputLine.toUpperCase(); 
					out= outputLine.getBytes();
					
					DatagramPacket response = new DatagramPacket(out, out.length, request.getAddress(), request.getPort());
					socketServer.send(response);
					audit.info("Adres:"+IPAddress);			

					if (outputLine.equals("end")) // 
						break;



				} catch (IOException | RuntimeException ex) {
					errors.log(Level.SEVERE, ex.getMessage(), ex);
				}
			}
		} catch (IOException ex) 
		{
			errors.log(Level.SEVERE, ex.getMessage(), ex);
		}finally
		{
			socketServer.close();
		}
	} 
}
