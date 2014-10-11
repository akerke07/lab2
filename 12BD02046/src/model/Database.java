package model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.StringTokenizer;
import java.util.Vector;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;



public class Database{

	public static Vector<User> userBase = new Vector<>();
	public static void addNewUser(Vector<String> regData){
		String login = regData.get(1);
		String name = regData.get(3);
		String password = regData.get(5);
		User newUser = new User(name,login,password);
		userBase.add(newUser);
	}
}
