package id.antarmukamobile.akakommobile.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import id.antarmukamobile.akakommobile.R;
import id.antarmukamobile.akakommobile.RestAPI.RestAPIBerita;
import id.antarmukamobile.akakommobile.adapter.RecyclerViewBeritaDanInfo;
import id.antarmukamobile.akakommobile.modelAPI.BeritaDanInfo;
import id.antarmukamobile.akakommobile.modelAPI.DataBeritaDanInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BaseSliderView.OnSliderClickListener {

    RecyclerView recyclerViewHome;
    SliderLayout sliderLayoutl;
    RecyclerViewBeritaDanInfo adapterBerita;
    ArrayList<String> authorBeritaList=new ArrayList<>();
    ArrayList<String> judulBeritaList=new ArrayList<>();
    ArrayList<String> linkBeritaList=new ArrayList<>();
    public static final String BASE_URL="http://simulasi-akakom.000webhostapp.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        sliderLayoutl = (SliderLayout)findViewById(R.id.slider);
        recyclerViewHome = (RecyclerView)findViewById(R.id.rviewBerita);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(true);
        recyclerViewHome.setLayoutManager(mLayoutManager);
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
                linkBeritaList.clear();
                for (int i = 0; i< 6; i++){
                    String author=response.body().getData().get(i).getAuthor();
                    String judul=response.body().getData().get(i).getJudul();
                    String link=response.body().getData().get(i).getLink();

                    authorBeritaList.add(author);
                    judulBeritaList.add(judul);
                    linkBeritaList.add(link);
                }

                adapterBerita=new RecyclerViewBeritaDanInfo(MainActivity.this, authorBeritaList, judulBeritaList, linkBeritaList, "berita");
                recyclerViewHome.setAdapter(adapterBerita);
                adapterBerita.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<BeritaDanInfo> call, Throwable t) {

            }
        });

        addSlider();
    }

    private void addSlider() {


        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("BNN",R.drawable.bnn);
        file_maps.put("Perwakilan Ke Jepang",R.drawable.jepang);
        file_maps.put("Seminar OWASP",R.drawable.owasp);
        file_maps.put("PELEPASAN Purna", R.drawable.pelepasanpurna);
        file_maps.put("Kegiatan Wisuda", R.drawable.wisuda);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            sliderLayoutl.addSlider(textSliderView);
        }
        sliderLayoutl.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayoutl.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayoutl.setCustomAnimation(new DescriptionAnimation());
        sliderLayoutl.setDuration(4000);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_beranda) {

        } else if (id == R.id.nav_profile) {
            Intent intent=new Intent(this, ProfileVisi.class);
            startActivity(intent);
        } else if (id == R.id.nav_prodi) {
            Intent intent=new Intent(this, Prodi.class);
            startActivity(intent);
        } else if (id == R.id.nav_info_berita) {
            Intent intent=new Intent(this, BeritaActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_info_kampus) {
            Intent intent=new Intent(this, InfoActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_tautan){
            Intent intent=new Intent(this, Tautan.class);
            startActivity(intent);
        } else if (id == R.id.nav_feedback){
            Intent intent=new Intent(this, Feedback.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Saya Menggunakan Akakom Mobile Apps";
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}
