package xpathtrna8a;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;

public class xPathTRNA8A {

	public static void main(String[] args) {
		
		try {
			File xmlFile = new File ("studentTRNA8A.xml");
			
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		
			Document document = documentBuilder.parse("studentTRNA8A.xml");
			
			document.getDocumentElement().normalize();
			
			XPath xPath = XPathFactory.newInstance().newXPath();
			
			String expression = "class/student/keresztnév | class/student/vezetéknév";
		
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document,XPathConstants.NODESET);
			
			for (int i = 0; i< nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				
				System.out.println("\nAktuális elem: " + node.getNodeName());
				if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
					
					System.out.println("Hallgató ID: " + element.getAttribute("id"));
					System.out.println("Keresztnév: " + element.getElementsByTagName("keresztnév").item(0).getTextContent());
					System.out.println("Vezetéknév: " + element.getElementsByTagName("vezetéknév").item(0).getTextContent());
					System.out.println("Becenév: " + element.getElementsByTagName("becenév").item(0).getTextContent());
					System.out.println("Kor: " + element.getElementsByTagName("kor").item(0).getTextContent());				
				}
				
			}
			
		}	catch(ParserConfigurationException e)	{
			e.printStackTrace();
		}	catch(SAXException e)	{
			e.printStackTrace();
		}	catch(IOException e)	{
			e.printStackTrace();
		}	catch(XPathExpressionException e)	{
			e.printStackTrace();
		}
		
	}

}
