package id.antarmukamobile.akakommobile.RestAPI;

import id.antarmukamobile.akakommobile.modelAPI.BeritaDanInfo;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kikiosha on 12/14/17.
 */

public interface RestAPIInfo {
    @GET("api/info.php")
    Call<BeritaDanInfo> getDataInfo();
}
