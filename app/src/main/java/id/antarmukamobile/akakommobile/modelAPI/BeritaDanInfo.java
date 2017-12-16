package id.antarmukamobile.akakommobile.modelAPI;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kikiosha on 12/14/17.
 */

public class BeritaDanInfo {
    @SerializedName("data")
    @Expose
    private List<DataBeritaDanInfo> data = null;
    @SerializedName("copyright")
    @Expose
    private String copyright;

    public List<DataBeritaDanInfo> getData() {
        return data;
    }

    public void setData(List<DataBeritaDanInfo> data) {
        this.data = data;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
}
