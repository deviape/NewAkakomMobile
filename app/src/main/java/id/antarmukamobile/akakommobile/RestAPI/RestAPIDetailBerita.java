package id.antarmukamobile.akakommobile.RestAPI;

import id.antarmukamobile.akakommobile.modelAPI.DetailBerita;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kikiosha on 12/18/17.
 */

public interface RestAPIDetailBerita {
    @GET("api/detail_berita.php")
    Call<DetailBerita> getDetailBerita(
            @Query("link") String link
    );
}
