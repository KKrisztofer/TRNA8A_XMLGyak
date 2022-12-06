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

    //Összes vásárló lekérdezése
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

    //Összes termék lekérdezése
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

    //Összes futárcég lekérdezése
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

    //A paraméterben átadott árnál olcsóbb termékek lekérdezése
    public static void QueryOlcsobbTermekMint(int input){
        try {
            File file = new File("XMLTRNA8A.xml");

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            document.getDocumentElement().normalize();

            System.out.println(input + " Ft-nál olcsóbb termékek: ");
            NodeList nList = document.getElementsByTagName("termek");

            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);

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

    //Termék adatainak lekérdezése paraméterben átadott azonosító alapján
    public static void QueryTermekAzonositoAlapjan(String input){
        try {
            File file = new File("XMLTRNA8A.xml");

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            document.getDocumentElement().normalize();

            System.out.println("A lekérdezett termék: ");
            NodeList nList = document.getElementsByTagName("termek");

            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);

                if (nNode.getNodeType()==Node.ELEMENT_NODE) {

                    Element elem = (Element) nNode;

                    if (elem.getAttribute("tid").equals(input)) {

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
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    //Vásárló adatainak lekérdezése paraméterben átadott város alapján
    public static void QueryVasarloVarosAlapjan(String input){
        try {
            File file = new File("XMLTRNA8A.xml");

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            document.getDocumentElement().normalize();

            System.out.println("A lekérdezett vásárló: ");
            NodeList nList = document.getElementsByTagName("vasarlo");

            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);

                if (nNode.getNodeType()==Node.ELEMENT_NODE) {

                    Element elem = (Element) nNode;
                    Node node = elem.getElementsByTagName("varos").item(0);

                    if (node.getTextContent().equals(input)) {

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

    //A 2022-ben történt rendelések lekérdezése
    public static void QueryRendelesek2022ben(){
        try {
            File file = new File("XMLTRNA8A.xml");

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            document.getDocumentElement().normalize();

            System.out.println("A lekérdezett rendelés(ek): ");
            NodeList nList = document.getElementsByTagName("rendeles");

            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);

                if (nNode.getNodeType()==Node.ELEMENT_NODE) {

                    Element elem = (Element) nNode;
                    Node node = elem.getElementsByTagName("ev").item(0);

                    if (node.getTextContent().equals("2022")) {

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
                        Node node8 = elem.getElementsByTagName("vegosszeg").item(0);
                        String vegosszeg = node8.getTextContent();

                        Node node9 = elem.getElementsByTagName("fid_f").item(0);
                        String fid = node9.getTextContent();

                        Node node10 = elem.getElementsByTagName("felvetel").item(0);
                        String felvetel = node10.getTextContent();

                        Node node11 = elem.getElementsByTagName("kezbesites").item(0);
                        String kezbesites = node11.getTextContent();

                        System.out.println("RID: " + rid);
                        System.out.println("VID: " + vid);
                        System.out.println("Ev: " + ev);
                        System.out.println("Honap: " + honap);
                        System.out.println("Nap: " + nap);
                        System.out.println("Ora: " +ora);
                        System.out.println("Perc: " + perc);
                        for (int j=0;j<rendeltTermekek.length;j++){
                            System.out.println((j+1) + ". termek: ");
                            System.out.println("\tTID:" + rendeltTermekek[j].getTid());
                            System.out.println("\tMennyiseg:" + rendeltTermekek[j].getRendeltMennyiseg());
                        }
                        System.out.println("Vegosszeg: " + vegosszeg);
                        System.out.println("FID: " + fid);
                        System.out.println("Felvetel: " + felvetel);
                        System.out.println("Kezbesites: " + kezbesites);
                        System.out.println();

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
