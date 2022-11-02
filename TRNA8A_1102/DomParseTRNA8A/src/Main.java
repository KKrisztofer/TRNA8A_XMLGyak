import domtrna8a.DomReadTRNA8A;
import domtrna8a.DomWriteTRNA8A;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException {
        DomReadTRNA8A.main();
        DomWriteTRNA8A.main();
    }
}