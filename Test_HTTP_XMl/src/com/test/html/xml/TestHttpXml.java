package com.test.html.xml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class TestHttpXml {
	
	public static void main(String[] args) throws IOException {
		
		TestHttpXml oHttpXml = new TestHttpXml();
		oHttpXml.get_Respone();
	}
	
	public void get_Respone() throws IOException {
		
		
		String urlString="http://restapi.adequateshop.com/api/Traveler?page=1";
		
		URL objUrl = new URL(urlString);
		
		HttpURLConnection connection = (HttpURLConnection) objUrl.openConnection();
		
		int xmlResponse = connection.getResponseCode();
		
		System.out.println("XML Respone from REST API: " + xmlResponse);
		
		try(BufferedReader br  = new BufferedReader(new InputStreamReader(connection.getInputStream()));){
			String inputString;
			StringBuffer response = new StringBuffer();
			while((inputString=br.readLine())!=null) {
				response.append(inputString);
			}
			
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(new InputSource(new StringReader(response.toString())));
			
			NodeList errNodes = doc.getElementsByTagName("TravelerinformationResponse");
		
			Element err = (Element) errNodes.item(0);

			
			if(errNodes.getLength()>0) {
				err = (Element) errNodes.item(0);
				System.out.println("\nPage No: " + err.getElementsByTagName("page").item(0).getTextContent());
				System.out.println("Total Record: " + err.getElementsByTagName("totalrecord").item(0).getTextContent());
				System.out.println("No of Travellers Per Page: " + err.getElementsByTagName("per_page").item(0).getTextContent());
				System.out.println("Total Pages: " + err.getElementsByTagName("total_pages").item(0).getTextContent());
			}else {
			}
			
			errNodes = doc.getElementsByTagName("travelers");

			String x = err.getElementsByTagName("per_page").item(0).getTextContent();
			int y = Integer.parseInt(x);
			System.out.println(errNodes.getLength());
			
			for(int i=0; i<y; i++) {
				err = (Element) errNodes.item(0);
				System.out.println("\nTraveler Information: " + (i + 1));
				System.out.println("Traveler ID         : " + err.getElementsByTagName("id").item(i).getTextContent());
				System.out.println("Traveler Name       : " + err.getElementsByTagName("name").item(i).getTextContent());
				System.out.println("Traveler Email      : " + err.getElementsByTagName("email").item(i).getTextContent());
				System.out.println("Traveler Address    : " + err.getElementsByTagName("adderes").item(i).getTextContent());
				System.out.println("Creation Date       : " + err.getElementsByTagName("createdat").item(i).getTextContent());
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		

		
	}

}
