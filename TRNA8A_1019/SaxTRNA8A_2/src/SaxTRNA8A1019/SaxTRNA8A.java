package SaxTRNA8A1019;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxTRNA8A {
    public static void Main(){
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SaxHandler handler = new SaxHandler();
            saxParser.parse(new File("kk_kurzusfelvetel.xml"), handler);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class SaxHandler extends DefaultHandler {
    private int indent = 0;
    private String formatAttributes(Attributes attributes){
        int attrLength = attributes.getLength();
        if (attrLength == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(", {");
        for (int i = 0;i<attrLength;i++){
            sb.append(attributes.getLocalName(i) + "-" + attributes.getValue(i));
            if (i < attrLength-1){
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }
    private void indent(){
        for (int i=0;i<indent;i++){
            System.out.print(" ");
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        //indent++;
        //indent();
        System.out.print(qName + formatAttributes(attributes) + ": ");
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        //indent();
        //indent--;
        //System.out.println(qName + "");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String chars = new String(ch, start, length).trim();
        if (!chars.isEmpty()) {
            indent++;
            indent();
            indent--;
            System.out.println(chars);
        }
    }
}
