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

public class DomReadTRNA8A {
    public static void ReadXML() throws IOException, ParserConfigurationException, SAXException {
        DomReadTRNA8A.ReadVasarlo();
        DomReadTRNA8A.ReadTermek();
        DomReadTRNA8A.ReadFutarceg();
        DomReadTRNA8A.ReadRaktar();
        DomReadTRNA8A.ReadRendeles();
    }
    public static void ReadVasarlo() throws SAXException,
            IOException, ParserConfigurationException {
        File xmlFile = new File("XMLTRNA8A.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();

        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("vasarlo");
        Vasarlo.CreateArray(nList.getLength());
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
                /*
                System.out.println("ID: " + vid);
                System.out.println("Vezeteknev: " + veznev);
                System.out.println("Keresztnev: " + kernev);
                System.out.println("Varos: " + varos);
                System.out.println("Utca: " + utca);
                System.out.println("Hazszam: " + hazszam);
                System.out.println("Telefonszam: " + telszam);
                */
                Vasarlo.AddToArray(new Vasarlo(vid, veznev, kernev, varos, utca, hazszam, telszam),i);
            }
        }
    }

    public static void ReadTermek() throws SAXException,
            IOException, ParserConfigurationException {
        File xmlFile = new File("XMLTRNA8A.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();

        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("termek");
        Termek.CreateArray(nList.getLength());
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

                Termek.AddToArray(new Termek(tid, elnevezes, leiras, Integer.parseInt(ar)),i);
            }
        }
    }

    public static void ReadFutarceg() throws SAXException,
            IOException, ParserConfigurationException {
        File xmlFile = new File("XMLTRNA8A.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();

        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("futarceg");
        Futarceg.CreateArray(nList.getLength());
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


                Futarceg.AddToArray(new Futarceg(fid, nev, cim, szallitasiIdo, Integer.parseInt(ar)),i);
            }
        }
    }

    public static void ReadRaktar() throws SAXException,
            IOException, ParserConfigurationException {
        File xmlFile = new File("XMLTRNA8A.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();

        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("nyilvantartas");

        for (int i = 0;i < nList.getLength();i++){
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;
                String tid = elem.getAttribute("tid_f");

                Node node1 = elem.getElementsByTagName("mennyiseg").item(0);
                String mennyiseg = node1.getTextContent();

                Termek.SetRaktarMennyiseg(Integer.parseInt(mennyiseg),tid);
            }
        }
    }

    public static void ReadRendeles() throws SAXException,
            IOException, ParserConfigurationException {
        File xmlFile = new File("XMLTRNA8A.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();

        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("rendeles");
        Rendeles.CreateArray(nList.getLength());
        for (int i = 0;i < nList.getLength();i++){
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;
                String rid = elem.getAttribute("rid");
                String vid = elem.getAttribute("vid_f");

                Node node1 = elem.getElementsByTagName("ev").item(0);
                String ev = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("honap").item(0);
                String honap = node2.getTextContent();

                Node node3 = elem.getElementsByTagName("nap").item(0);
                String nap = node3.getTextContent();

                Node node4 = elem.getElementsByTagName("ora").item(0);
                String ora = node4.getTextContent();

                Node node5 = elem.getElementsByTagName("perc").item(0);
                String perc = node5.getTextContent();

                NodeList tList = elem.getElementsByTagName("arucikk");
                RendeltTermek[] rendeltTermekek = new RendeltTermek[tList.getLength()];
                for (int j = 0;j<tList.getLength();j++){
                    Node tNode = tList.item(j);
                    if (tNode.getNodeType() == Node.ELEMENT_NODE){
                        Element tElem = (Element) tNode;
                        Node node6 = tElem.getElementsByTagName("tid_f").item(0);
                        String tid = node6.getTextContent();

                        Node node7 = tElem.getElementsByTagName("mennyiseg").item(0);
                        String mennyiseg = node7.getTextContent();
                        rendeltTermekek[j] = new RendeltTermek(Termek.getTermekById(tid), Integer.parseInt(mennyiseg));
                    }

                }
                /*
                Node node6 = elem.getElementsByTagName("tid_f").item(0);
                String tid = node6.getTextContent();

                Node node7 = elem.getElementsByTagName("mennyiseg").item(0);
                String mennyiseg = node7.getTextContent();
                */
                Node node8 = elem.getElementsByTagName("vegosszeg").item(0);
                String vegosszeg = node8.getTextContent();

                Node node9 = elem.getElementsByTagName("fid_f").item(0);
                String fid = node9.getTextContent();

                Node node10 = elem.getElementsByTagName("felvetel").item(0);
                String felvetel = node10.getTextContent();

                Node node11 = elem.getElementsByTagName("kezbesites").item(0);
                String kezbesites = node11.getTextContent();

                String datum = ev + "-" + honap + "-" + nap + "-" + ora + "-" + perc;

                Rendeles.AddToArray(new Rendeles(rid, vid, datum, rendeltTermekek, Integer.parseInt(vegosszeg), fid, felvetel, kezbesites),i);
            }
        }
    }
}
