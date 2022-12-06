import hu.domparse.trna8a.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException {
        DomReadTRNA8A.ReadXML();

        /*
        for (Termek termek:Termek.getTermekek()) {
            System.out.println(termek);
        }
        for (Vasarlo vasarlo:Vasarlo.getVasarlok()) {
            System.out.println(vasarlo);
        }
        for (Rendeles rendeles:Rendeles.getRendelesek()) {
            System.out.println(rendeles);
        }
        for (Futarceg futarceg:Futarceg.getFutarcegek()) {
            System.out.println(futarceg);
        }
         */

        //DomModifyTRNA8A.FoxpostAtnevezese();
        //DomModifyTRNA8A.TermekArModositas("t001","10000");
        //DomModifyTRNA8A.VasarloTelefonszamModositas("v001", "06123456789");
        //DomModifyTRNA8A.FutarcegArModositas("f01", "300");
        //DomModifyTRNA8A.RaktarBovites("t001", 5);

        //DomQueryTRNA8A.QueryVasarlo();
        //DomQueryTRNA8A.QueryTermek();
        //DomQueryTRNA8A.QueryFutarceg();
        //DomQueryTRNA8A.QueryOlcsobbTermekMint(200000);
        //DomQueryTRNA8A.QueryTermek("t002");
        //DomQueryTRNA8A.QueryVasarloVarosAlapjan("Miskolc");
        //DomQueryTRNA8A.QueryRendelesek2022ben();

    }
}