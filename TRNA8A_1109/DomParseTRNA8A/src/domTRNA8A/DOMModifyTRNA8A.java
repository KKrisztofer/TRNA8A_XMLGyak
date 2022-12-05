package domTRNA8A;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMModifyTRNA8A {

	public static void main(String[] args) {
		try {
			File inputFile = new File ("carsTRNA8A.xml");
			
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = documentBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
			
			Node cars = doc.getFirstChild();
			Node supercar = doc.getElementsByTagName("supercars").item(0);
			
			NamedNodeMap attr = supercar.getAttributes();
			Node nodeAttr = attr.getNamedItem("company");
			nodeAttr.setTextContent("Lamborghini");
			
			NodeList list = supercar.getChildNodes();
			
			for (int temp = 0; temp < list.getLength(); temp++) {
				Node node = list.item(temp);
				
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					
					if ("carname".equals(eElement.getNodeName())) {
						if ("Ferrari 01".equals(eElement.getTextContent())) {
							eElement.setTextContent("Lamborghini 01");
						}
					}
				}
			}
			
			NodeList childNodes = cars.getChildNodes();

            for (int j = 0; j < childNodes.getLength(); j++) {
                Node node = childNodes.item(j);

                if ("luxurycars".equals(node.getNodeName())) {
                    cars.removeChild(node);
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(doc);

            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);

        } catch (Exception e ) {
            e.printStackTrace();
        }

	}

}
