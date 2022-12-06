package hu.domparse.trna8a;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DomModifyTRNA8A {
    /*public static void WriteTermek(Termek[] newTermekek) throws ParserConfigurationException,
            TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.newDocument();

        Element root = doc.createElementNS("DOMTRNA8A", "termekek");
        doc.appendChild(root);

        for (int i = 0;i<newTermekek.length;i++){
            root.appendChild(createTermek(doc, newTermekek[i].getTid(), newTermekek[i].getElnevezes(), newTermekek[i].getLeiras(), newTermekek[i].getAr()));
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transf = transformerFactory.newTransformer();

        transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transf.setOutputProperty(OutputKeys.INDENT, "yes");
        transf.setOutputProperty("{http://xml.apache.org/xslt}indent=amount", "2");

        DOMSource source = new DOMSource(doc);
        File myFile = new File("termekek.xml");

        StreamResult console = new StreamResult(System.out);
        StreamResult file = new StreamResult(myFile);

        transf.transform(source, console);
        transf.transform(source, file);
    }

    private static Node createTermek(Document doc, String tid, String elnevezes, String leiras, int ar) {
        Element termek = doc.createElement("termek");
        termek.setAttribute("tid", tid);
        termek.appendChild(createTermekElement(doc, "elnevezes", elnevezes));
        termek.appendChild(createTermekElement(doc, "leiras", leiras));
        termek.appendChild(createTermekElement(doc, "ar", String.valueOf(ar)));

        return termek;
    }

    private static Node createTermekElement(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));

        return node;
    }

    public static void ModifyTermek() throws ParserConfigurationException, TransformerException {
        for (Termek termek:Termek.getTermekek()) {
            System.out.println(termek.getTid() + " - " + termek.getElnevezes());
        }
        System.out.print("\nAdd meg a módosítandó termék azonosítóját: ");
        Scanner scanner = new Scanner(System.in);
        String tid = scanner.nextLine();

        Termek[] termekek = Termek.getTermekek();

        Termek newTermek = Termek.getTermekById(tid);

        System.out.println(newTermek);

        System.out.println("Add meg a termék új adatait. Ha az adat nem változik, hagyd üresen.");

        System.out.print("\nAdd meg a termék új nevét: ");
        String elnevezes = scanner.nextLine();
        System.out.print("Add meg a termék új leírását: ");
        String leiras = scanner.nextLine();
        System.out.print("Add meg a termék új árát: ");
        String ar = scanner.nextLine();
        if (elnevezes.isEmpty()){
            elnevezes = newTermek.getElnevezes();
        }
        if (leiras.isEmpty()){
            leiras = newTermek.getLeiras();
        }
        if (ar.isEmpty()){
            ar = String.valueOf(newTermek.getAr());
        }

        newTermek.setElnevezes(elnevezes);
        newTermek.setLeiras(leiras);
        newTermek.setAr(Integer.parseInt(ar));

        for (int i = 0;i < termekek.length;i++){
            if (termekek[i].getTid().equals(tid)){
                termekek[i] = newTermek;
            }
        }

        DomModifyTRNA8A.WriteTermek(termekek);
    }*/

    //A Foxpost futárcég neve átírása "Foxpost Kft."-re
    public static void FoxpostAtnevezese() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        File file = new File("XMLTRNA8A.xml");

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(file);

        document.getDocumentElement().normalize();

        NodeList NList = document.getElementsByTagName("futarceg");
        for (int i = 0; i < NList.getLength(); i++) {
            Node node = NList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                NodeList childNodes = node.getChildNodes();

                for (int j = 0; j < childNodes.getLength(); j++) {

                    Node childNode = childNodes.item(j);

                    if ("nev".equals(childNode.getNodeName())) {

                        if ("FOXPOST".equals(childNode.getTextContent())) {
                            childNode.setTextContent("Foxpost Kft.");
                        }
                    }
                }
            }
        }

        File newFile = new File("XMLTRNA8A.xml");

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(document);

        System.out.println("Módosítás eredménye:");

        StreamResult consoleResult = new StreamResult(System.out);
        StreamResult resultModFile = new StreamResult(newFile);

        transformer.transform(source, consoleResult);
        transformer.transform(source, resultModFile );
    }

    //Termék árának módosítása
    public static void TermekArModositas(String tid, String newAr) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        File file = new File("XMLTRNA8A.xml");

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(file);

        document.getDocumentElement().normalize();

        NodeList NList = document.getElementsByTagName("termek");
        for (int i = 0; i < NList.getLength(); i++) {
            Node node = NList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;
                if (elem.getAttribute("tid").equals(tid)) {
                    NodeList childNodes = node.getChildNodes();

                    for (int j = 0; j < childNodes.getLength(); j++) {

                        Node childNode = childNodes.item(j);

                        if ("ar".equals(childNode.getNodeName())) {
                            childNode.setTextContent(newAr);
                        }
                    }
                }
            }
        }

        File newFile = new File("XMLTRNA8A.xml");

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(document);

        System.out.println("Módosítás eredménye:");

        StreamResult consoleResult = new StreamResult(System.out);
        StreamResult resultModFile = new StreamResult(newFile);

        transformer.transform(source, consoleResult);
        transformer.transform(source, resultModFile );
    }

    //A vásárló telefonszámának módosíása
    public static void VasarloTelefonszamModositas(String vid, String newTelszam) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        File file = new File("XMLTRNA8A.xml");

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(file);

        document.getDocumentElement().normalize();

        NodeList NList = document.getElementsByTagName("vasarlo");
        for (int i = 0; i < NList.getLength(); i++) {
            Node node = NList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;
                if (elem.getAttribute("vid").equals(vid)) {
                    NodeList childNodes = node.getChildNodes();

                    for (int j = 0; j < childNodes.getLength(); j++) {

                        Node childNode = childNodes.item(j);

                        if ("telefonszam".equals(childNode.getNodeName())) {
                            childNode.setTextContent(newTelszam);
                        }
                    }
                }
            }
        }

        File newFile = new File("XMLTRNA8A.xml");

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(document);

        System.out.println("Módosítás eredménye:");

        StreamResult consoleResult = new StreamResult(System.out);
        StreamResult resultModFile = new StreamResult(newFile);

        transformer.transform(source, consoleResult);
        transformer.transform(source, resultModFile );
    }

    //Futarcég árának módosítása
    public static void FutarcegArModositas(String fid, String newAr) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        File file = new File("XMLTRNA8A.xml");

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(file);

        document.getDocumentElement().normalize();

        NodeList NList = document.getElementsByTagName("futarceg");
        for (int i = 0; i < NList.getLength(); i++) {
            Node node = NList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;
                if (elem.getAttribute("fid").equals(fid)) {
                    NodeList childNodes = node.getChildNodes();

                    for (int j = 0; j < childNodes.getLength(); j++) {

                        Node childNode = childNodes.item(j);

                        if ("ar".equals(childNode.getNodeName())) {
                            childNode.setTextContent(newAr);
                        }
                    }
                }
            }
        }

        File newFile = new File("XMLTRNA8A.xml");

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(document);

        System.out.println("Módosítás eredménye:");

        StreamResult consoleResult = new StreamResult(System.out);
        StreamResult resultModFile = new StreamResult(newFile);

        transformer.transform(source, consoleResult);
        transformer.transform(source, resultModFile );
    }

    //Raktár bővítése
    public static void RaktarBovites(String tid, int mennyiseg) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        File file = new File("XMLTRNA8A.xml");

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(file);

        document.getDocumentElement().normalize();

        NodeList NList = document.getElementsByTagName("nyilvantartas");
        for (int i = 0; i < NList.getLength(); i++) {
            Node node = NList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;
                if (elem.getAttribute("tid_f").equals(tid)) {
                    NodeList childNodes = node.getChildNodes();

                    for (int j = 0; j < childNodes.getLength(); j++) {

                        Node childNode = childNodes.item(j);

                        if ("mennyiseg".equals(childNode.getNodeName())) {
                            childNode.setTextContent(String.valueOf(Integer.parseInt(childNode.getTextContent())+mennyiseg));
                        }
                    }
                }
            }
        }

        File newFile = new File("XMLTRNA8A.xml");

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(document);

        System.out.println("Módosítás eredménye:");

        StreamResult consoleResult = new StreamResult(System.out);
        StreamResult resultModFile = new StreamResult(newFile);

        transformer.transform(source, consoleResult);
        transformer.transform(source, resultModFile );
    }
}
