package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.StringTokenizer;
import java.util.Vector;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


public class Controller {

	public static void main(String[] args) throws Exception {
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		server.createContext("/", new MyHandler());
		server.setExecutor(null); // creates a default executor
		server.start();
	}

	static class MyHandler implements HttpHandler {
		public void handle(HttpExchange t) throws IOException {
			URI url=t.getRequestURI();

			String response = "";
			String path = url.toString();
			System.out.println(path);


			String template=readFile("template.html");
			if(!path.equals("/") ) {
				path=path.substring(1);
				String sub=readFile(path);
				response=template.replace("%content%", sub);
			}else if(path.equals("/")){
				String sub=readFile("file.html");
				response = template.replace("%content%", sub);
			}

			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
		public static Vector<String> readInput(HttpExchange t) throws IOException {
			URI url=t.getRequestURI();

			String response = "";
			String path = url.toString();
			if(path.equals("/reg")){
				InputStream is = t.getRequestBody();
				BufferedReader reader = new BufferedReader(new InputStreamReader(is));

				Vector<String> data = new Vector<>();
				String l; 
				l = reader.readLine();
				StringTokenizer st = new StringTokenizer(l, "=&");
				while (st.hasMoreTokens()) {
					data.add(st.nextToken());
				}
				return data;
			}
			return null;

		}
		private static String readFile(String a) throws FileNotFoundException{
			String response="";
			BufferedReader br = new BufferedReader(new FileReader(a));
			String line=" ";
			try {
				line=br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while (line!=null)
			{
				response=response+line+ "\n";
				try {
					line =br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return response;
		}
	}
	public static String readFromBuffer(BufferedReader br){
		String temp = "";
		try{
			temp=br.readLine();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s ="";
		while(temp!=null){
			s+=temp;
			try{
				temp=br.readLine();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} 
		return s;
	} 


}