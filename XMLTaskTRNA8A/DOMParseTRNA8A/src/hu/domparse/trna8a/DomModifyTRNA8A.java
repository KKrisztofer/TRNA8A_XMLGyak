package hu.domparse.trna8a;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class DomModifyTRNA8A {
    public static void WriteTermek(Termek[] newTermekek) throws ParserConfigurationException,
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
    }
}
