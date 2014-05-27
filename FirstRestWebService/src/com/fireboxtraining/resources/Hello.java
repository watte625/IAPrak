package com.fireboxtraining.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.*;

@Path("/hello")
public class Hello {
	
	static boolean debug = true;
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello World!";
	}
	
	@GET
	@Produces(MediaType.TEXT_XML) 
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Dave" + "</hello>";
	}
	

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHTMLHello() {

		String returnString = "";
		
		try {
			//FileReader reader = new FileReader(new File("/FirstRestWebService/resources/index.html"));
			FileReader reader = new FileReader(new File("D:/resources/index.html"));
			BufferedReader br= new BufferedReader(reader);
			
			String temp = br.readLine();
			while(temp != null) {
				returnString += temp;
				temp = br.readLine();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnString;
	} 
	
	/*
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String htmlHallo() {
		String html = "<!DOCTYPE html>"+
		"<html>" +
		  "<head>" +
		    "<style>" +
				".center"+
				"{" +
				"margin: 20px auto;"+
				"width: 20%;"+
				"}"+
				
				".logo { " +
					"margin: 80px auto;" +
					"width: 20%;"+
				"}"+
		"</style>" +
		    "<title>Hallo</title>"+
		  "</head>" + 
		 "<body>" + 
			"<div class=\"logo\">" +
				//"<img src=\"/FirstRestWebService/resources/logo.png\" alt=\"Woogje\">"+
			"</div>"+
		    "<div class=\"center\">"+
		      "<form action=\"input_text.htm\">" +
				"<input name=\"search\" type=\"text\" size=\"62\" maxlength=\"30\"></p>" + 
			"</form>" + 
		    "</div>" +
		 " </body>"+
		"</html>";

		
		return html;
	} */
	
	public static void out(Object input) {
		if(debug)
			System.out.println(input);
	}
}
