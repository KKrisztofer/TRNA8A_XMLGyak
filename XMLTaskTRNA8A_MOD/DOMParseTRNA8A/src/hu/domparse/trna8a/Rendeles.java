package hu.domparse.trna8a;

import java.util.Arrays;

public class Rendeles {
    private String rid;
    private String vid;
    private String datum;
    private RendeltTermek[] rendeltTermekek;
    private int vegosszeg;
    private String fid;
    private String felvetel;
    private String kezbesites;

    private static Rendeles[] rendelesek;

    public Rendeles(String rid, String vid, String datum, int termekekSzama, int vegosszeg, String fid, String felvetel, String kezbesites){
        this.rid = rid;
        this.vid = vid;
        this.datum = datum;
        this.vegosszeg = vegosszeg;
        this.fid = fid;
        this.felvetel = felvetel;
        this.kezbesites = kezbesites;
        this.rendeltTermekek = new RendeltTermek[termekekSzama];
    }
    public Rendeles(String rid, String vid, String datum, RendeltTermek[] rendeltTermekek, int vegosszeg, String fid, String felvetel, String kezbesites){
        this.rid = rid;
        this.vid = vid;
        this.datum = datum;
        this.vegosszeg = vegosszeg;
        this.fid = fid;
        this.felvetel = felvetel;
        this.kezbesites = kezbesites;
        this.rendeltTermekek = rendeltTermekek;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public RendeltTermek[] getRendeltTermekek() {
        return rendeltTermekek;
    }

    public void setRendeltTermekek(RendeltTermek[] rendeltTermekek) {
        this.rendeltTermekek = rendeltTermekek;
    }

    public int getVegosszeg() {
        return vegosszeg;
    }

    public void setVegosszeg(int vegosszeg) {
        this.vegosszeg = vegosszeg;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFelvetel() {
        return felvetel;
    }

    public void setFelvetel(String felvetel) {
        this.felvetel = felvetel;
    }

    public String getKezbesites() {
        return kezbesites;
    }

    public void setKezbesites(String kezbesites) {
        this.kezbesites = kezbesites;
    }

    public static Rendeles[] getRendelesek() {
        return rendelesek;
    }

    public static void setRendelesek(Rendeles[] rendelesek) {
        Rendeles.rendelesek = rendelesek;
    }

    @Override
    public String toString() {
        return "Rendeles{" +
                "rid='" + rid + '\'' +
                ", vid='" + vid + '\'' +
                ", datum='" + datum + '\'' +
                ", rendeltTermekek=" + Arrays.toString(rendeltTermekek) +
                ", vegosszeg=" + vegosszeg +
                ", fid='" + fid + '\'' +
                ", felvetel='" + felvetel + '\'' +
                ", kezbesites='" + kezbesites + '\'' +
                '}';
    }

    public static void CreateArray(int size){
        Rendeles.rendelesek = new Rendeles[size];
    }
    public static void AddToArray(Rendeles rendeles, int i){
        Rendeles.rendelesek[i] = rendeles;
    }
}
