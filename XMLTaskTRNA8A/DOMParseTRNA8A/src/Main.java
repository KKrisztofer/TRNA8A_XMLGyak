import hu.domparse.trna8a.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException {
        DomReadTRNA8A.ReadXML();

        //DomModifyTRNA8A.ModifyTermek();

        DomQueryTRNA8A.QueryVasarlo();
        DomQueryTRNA8A.QueryTermek();
        DomQueryTRNA8A.QueryFutarceg();
    }
}