package id.antarmukamobile.akakommobile.modelAPI;

/**
 * Created by Yudis on 12/28/2017.
 */

public class FeedBackFirebaseModel {
    private String komentar;
    private String nama;
    private int rating;

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
