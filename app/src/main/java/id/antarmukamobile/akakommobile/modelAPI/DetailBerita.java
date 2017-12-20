package id.antarmukamobile.akakommobile.modelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kikiosha on 12/18/17.
 */

public class DetailBerita {
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("data")
    @Expose
    private DataDetailBerita data;
    @SerializedName("copyright")
    @Expose
    private String copyright;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public DataDetailBerita getData() {
        return data;
    }

    public void setData(DataDetailBerita data) {
        this.data = data;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
}
