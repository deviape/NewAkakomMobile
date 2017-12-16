package id.antarmukamobile.akakommobile.modelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kikiosha on 12/14/17.
 */

public class DataBeritaDanInfo {
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("link")
    @Expose
    private String link;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
