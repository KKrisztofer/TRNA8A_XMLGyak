package domTRNA8A;

import java.io.File;

import java.io.IOException;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomReadTRNA8A {
	
	public static void main(String argv[]) throws SAXException, IOException, ParserConfigurationException {
		File xmlFile = new File("usersTRNA8A.xml");
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		
		Document doc = dBuilder.parse(xmlFile);
		
		doc.getDocumentElement().normalize();
		
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
		
		NodeList nList = doc.getElementsByTagName("user");
		
		for (int i = 1; i < nList.getLength(); i++) {
			
			Node nNode = nList.item(i);
			
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if (nNode.getNodeType()==Node.ELEMENT_NODE) {
				
				Element elem = (Element) nNode;
				String uid = elem.getAttribute("id");
				
				Node node1 = elem.getElementsByTagName("firstname").item(0);
				String fname = node1.getTextContent();
				
				Node node2 = elem.getElementsByTagName("lastname").item(0);
				String lname = node2.getTextContent();
				
				Node node3 = elem.getElementsByTagName("profession").item(0);
				String pname = node3.getTextContent();	
				
				System.out.println("User id: " + uid);
				System.out.println("FirstName: " + fname);
				System.out.println("LastName: " + lname);
				System.out.println("Profession: " + pname);
			}
			
		}
	}

	
}
