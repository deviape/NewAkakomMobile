package id.antarmukamobile.akakommobile.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import id.antarmukamobile.akakommobile.R;
import id.antarmukamobile.akakommobile.RestAPI.RestAPIDetailBerita;
import id.antarmukamobile.akakommobile.modelAPI.DetailBerita;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailBeritaActivity extends AppCompatActivity {
    public static final String BASE_URL="http://simulasi-akakom.000webhostapp.com/";
    private TextView textViewJudulBerita, textViewContentBerita;
    private ImageView imageViewBerita;
    private ProgressBar progressBarDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);

        textViewJudulBerita=(TextView)findViewById(R.id.judulBerita);
        textViewContentBerita=(TextView)findViewById(R.id.contentBerita);
        imageViewBerita=(ImageView)findViewById(R.id.imageBerita);
        progressBarDetail=(ProgressBar)findViewById(R.id.progressBarDetailBerita);

        Intent intent=getIntent();
        String link=intent.getStringExtra("link");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("Akakom Mobile");

        collapsingToolbarLayout.setCollapsedTitleTextColor(
                ContextCompat.getColor(this, R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(
                ContextCompat.getColor(this, R.color.transparant));

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RestAPIDetailBerita restAPIDetailBerita=retrofit.create(RestAPIDetailBerita.class);
        Call<DetailBerita> call=restAPIDetailBerita.getDetailBerita(link);
        call.enqueue(new Callback<DetailBerita>() {
            @Override
            public void onResponse(Call<DetailBerita> call, Response<DetailBerita> response) {
                progressBarDetail.setVisibility(View.GONE);
                String gambar=response.body().getData().getGambar();
                String judul=response.body().getData().getJudul();
                String conten=response.body().getData().getContent();

                System.out.println(gambar);
                System.out.println(judul);
                System.out.println(conten);

                textViewJudulBerita.setText(judul);
                textViewContentBerita.setText(conten);
                Picasso.with(DetailBeritaActivity.this)
                        .load(gambar).error(getResources().getDrawable(R.drawable.logo))
                        .fit()
                        .into(imageViewBerita);
            }

            @Override
            public void onFailure(Call<DetailBerita> call, Throwable t) {

            }
        });
    }
}
