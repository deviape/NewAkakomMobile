package id.antarmukamobile.akakommobile.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.antarmukamobile.akakommobile.R;
import id.antarmukamobile.akakommobile.RestAPI.RestAPIInfo;
import id.antarmukamobile.akakommobile.adapter.RecyclerViewBeritaDanInfo;
import id.antarmukamobile.akakommobile.modelAPI.BeritaDanInfo;
import id.antarmukamobile.akakommobile.modelAPI.DataBeritaDanInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InfoActivity extends AppCompatActivity {
    RecyclerView recyclerViewInfo;
    RecyclerViewBeritaDanInfo adapterInfo;
    ArrayList<String> authorInfoList =new ArrayList<>();
    ArrayList<String> judulInfoList =new ArrayList<>();
    ArrayList<String> linkInfoList=new ArrayList<>();
    public static final String BASE_URL="http://simulasi-akakom.000webhostapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        getSupportActionBar().setTitle("Info Akakom");

        recyclerViewInfo =(RecyclerView)findViewById(R.id.recyclerViewInfo);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(true);
        recyclerViewInfo.setLayoutManager(mLayoutManager);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RestAPIInfo apiInfo=retrofit.create(RestAPIInfo.class);
        Call<BeritaDanInfo> call=apiInfo.getDataInfo();
        call.enqueue(new Callback<BeritaDanInfo>() {
            @Override
            public void onResponse(Call<BeritaDanInfo> call, Response<BeritaDanInfo> response) {
                List<DataBeritaDanInfo> dataBeritaDanInfoList =response.body().getData();
                authorInfoList.clear();
                judulInfoList.clear();
                linkInfoList.clear();
                for (int i = 0; i< dataBeritaDanInfoList.size(); i++){
                    String author=response.body().getData().get(i).getAuthor();
                    String judul=response.body().getData().get(i).getJudul();
                    String link=response.body().getData().get(i).getLink();

                    authorInfoList.add(author);
                    judulInfoList.add(judul);
                    linkInfoList.add(link);
                }

                adapterInfo =new RecyclerViewBeritaDanInfo(InfoActivity.this, authorInfoList, judulInfoList, linkInfoList, "info");
                recyclerViewInfo.setAdapter(adapterInfo);
                adapterInfo.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<BeritaDanInfo> call, Throwable t) {

            }
        });
    }
}
