package hu.domparse.trna8a;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomQueryTRNA8A {
    public static void QueryVasarlo() throws SAXException,
            IOException, ParserConfigurationException {
        File xmlFile = new File("XMLTRNA8A.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();

        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("vasarlo");

        for (int i = 0;i < nList.getLength();i++){
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;
                String vid = elem.getAttribute("vid");

                Node node1 = elem.getElementsByTagName("vezeteknev").item(0);
                String veznev = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("keresztnev").item(0);
                String kernev = node2.getTextContent();

                Node node3 = elem.getElementsByTagName("varos").item(0);
                String varos = node3.getTextContent();

                Node node4 = elem.getElementsByTagName("utca").item(0);
                String utca = node4.getTextContent();

                Node node5 = elem.getElementsByTagName("hazszam").item(0);
                String hazszam = node5.getTextContent();

                Node node6 = elem.getElementsByTagName("telefonszam").item(0);
                String telszam = node6.getTextContent();

                System.out.println("ID: " + vid);
                System.out.println("Vezeteknev: " + veznev);
                System.out.println("Keresztnev: " + kernev);
                System.out.println("Varos: " + varos);
                System.out.println("Utca: " + utca);
                System.out.println("Hazszam: " + hazszam);
                System.out.println("Telefonszam: " + telszam);
                System.out.println();
            }
        }
    }

    public static void QueryTermek() throws SAXException,
            IOException, ParserConfigurationException {
        File xmlFile = new File("XMLTRNA8A.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();

        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("termek");

        for (int i = 0;i < nList.getLength();i++){
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;
                String tid = elem.getAttribute("tid");

                Node node1 = elem.getElementsByTagName("elnevezes").item(0);
                String elnevezes = node1.getTextContent();

                String leiras = "-";
                if (elem.getChildNodes().item(3).getNodeName() == "leiras") {
                    Node node2 = elem.getElementsByTagName("leiras").item(0);
                    leiras = node2.getTextContent();
                }

                Node node3 = elem.getElementsByTagName("ar").item(0);
                String ar = node3.getTextContent();

                System.out.println("ID: " + tid);
                System.out.println("Elnevezes: " + elnevezes);
                System.out.println("Leiras: " + leiras);
                System.out.println("Ar: " + ar);
                System.out.println();

            }
        }
    }

    public static void QueryFutarceg() throws SAXException,
            IOException, ParserConfigurationException {
        File xmlFile = new File("XMLTRNA8A.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();

        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("futarceg");

        for (int i = 0;i < nList.getLength();i++){
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;
                String fid = elem.getAttribute("fid");

                Node node1 = elem.getElementsByTagName("nev").item(0);
                String nev = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("cim").item(0);
                String cim = node2.getTextContent();

                Node node3 = elem.getElementsByTagName("szallitasiido").item(0);
                String szallitasiIdo = node3.getTextContent();

                Node node4 = elem.getElementsByTagName("ar").item(0);
                String ar = node4.getTextContent();

                System.out.println("ID: " + fid);
                System.out.println("Nev: " + nev);
                System.out.println("cim: " + cim);
                System.out.println("Szallitasi ido: " + szallitasiIdo);
                System.out.println("Ar: " + ar);
                System.out.println();
            }
        }
    }


    public static void QueryOlcsobbTermekMint(int input){
        try {
            File file = new File("XMLTRNA8A.xml");

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            document.getDocumentElement().normalize();

            System.out.println(input + " Ft-nál olcsóbb termékek: ");
            NodeList nList2 = document.getElementsByTagName("termek");

            for (int i = 0; i < nList2.getLength(); i++) {

                Node nNode = nList2.item(i);

                if (nNode.getNodeType()==Node.ELEMENT_NODE) {

                    Element elem = (Element) nNode;
                    NodeList childNodes = nNode.getChildNodes();

                    for (int j = 0; j < childNodes.getLength(); j++) {

                        Node childNode = childNodes.item(j);

                        if ("ar".equals(childNode.getNodeName())) {

                            if (Integer.valueOf(childNode.getTextContent()) < input) {

                                String tid = elem.getAttribute("tid");
                                Node node1 = elem.getElementsByTagName("elnevezes").item(0);
                                String elnevezes = node1.getTextContent();
                                Node node2 = elem.getElementsByTagName("leiras").item(0);
                                String leiras = node2.getTextContent();
                                Node node3 = elem.getElementsByTagName("ar").item(0);
                                String ar = node3.getTextContent();

                                System.out.println("TID: " + tid);
                                System.out.println("Elnevezés: " + elnevezes);
                                System.out.println("Leírás: " + leiras);
                                System.out.println("Ár: " + ar);

                            }
                        }
                    }

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }


}
