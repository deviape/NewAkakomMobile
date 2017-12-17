package id.antarmukamobile.akakommobile.modelAPI;

/**
 * Created by asus on 17/12/2017.
 */

public class FeedModel {

    private int gambarId;
    private  String nama;
    private String komentar;

    public FeedModel(int gambarId, String nama, String komentar) {
        this.gambarId = gambarId;
        this.nama = nama;
        this.komentar = komentar;
    }

    public int getGambarId() {
        return gambarId;
    }

    public void setGambarId(int gambarId) {
        this.gambarId = gambarId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }
}
