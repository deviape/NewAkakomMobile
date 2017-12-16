package id.antarmukamobile.akakommobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.antarmukamobile.akakommobile.RestAPI.RestAPIBerita;
import id.antarmukamobile.akakommobile.adapter.RecyclerViewBeritaDanInfo;
import id.antarmukamobile.akakommobile.modelAPI.BeritaDanInfo;
import id.antarmukamobile.akakommobile.modelAPI.DataBeritaDanInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BeritaActivity extends AppCompatActivity {
    RecyclerView recyclerViewBerita;
    RecyclerViewBeritaDanInfo adapterBerita;
    ArrayList<String> authorBeritaList=new ArrayList<>();
    ArrayList<String> judulBeritaList=new ArrayList<>();
    public static final String BASE_URL="http://simulasi-akakom.000webhostapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);

        getSupportActionBar().setTitle("Berita Akakom");

        recyclerViewBerita=(RecyclerView)findViewById(R.id.recyclerViewBerita);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(true);
        recyclerViewBerita.setLayoutManager(mLayoutManager);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RestAPIBerita apiBerita=retrofit.create(RestAPIBerita.class);
        Call<BeritaDanInfo> call=apiBerita.getDataBerita();
        call.enqueue(new Callback<BeritaDanInfo>() {
            @Override
            public void onResponse(Call<BeritaDanInfo> call, Response<BeritaDanInfo> response) {
                List<DataBeritaDanInfo> dataBeritaDanInfoList =response.body().getData();
                authorBeritaList.clear();
                judulBeritaList.clear();
                for (int i = 0; i< dataBeritaDanInfoList.size(); i++){
                    String author=response.body().getData().get(i).getAuthor();
                    String judul=response.body().getData().get(i).getJudul();

                    authorBeritaList.add(author);
                    judulBeritaList.add(judul);
                }

                adapterBerita=new RecyclerViewBeritaDanInfo(BeritaActivity.this, authorBeritaList, judulBeritaList, "berita");
                recyclerViewBerita.setAdapter(adapterBerita);
                adapterBerita.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<BeritaDanInfo> call, Throwable t) {

            }
        });
    }
}
