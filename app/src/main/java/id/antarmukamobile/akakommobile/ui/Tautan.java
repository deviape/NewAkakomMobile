package id.antarmukamobile.akakommobile.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

import id.antarmukamobile.akakommobile.R;
import id.antarmukamobile.akakommobile.adapter.RecyclerViewAdapterTautan;

public class Tautan extends AppCompatActivity {

    RecyclerView recyclerViewTautan;
    ArrayList<String> link = new ArrayList<>();
    ArrayList<String> nama = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tautan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerViewTautan = (RecyclerView)findViewById(R.id.rviewTautan);

        link.add("http://www.widyabaktiyk.or.id/");
        link.add("http://pmb.akakom.ac.id/");
        link.add("http://blog.akakom.ac.id/");
        link.add("http://siakad.akakom.ac.id/");
        link.add("http://lab.akakom.ac.id/");
        link.add("http://acc.akakom.ac.id/");
        link.add("http://ika.akakom.ac.id/");
        link.add("http://olimpiade.akakom.ac.id/");
        link.add("http://sriti.akakom.ac.id/");
        link.add("http://pjm.akakom.ac.id/index1.html");
        link.add("http://perpus.akakom.ac.id/");
        link.add("http://dikti.go.id/");
        link.add("http://puslitbang.akakom.ac.id/");
        link.add("http://ejournal.akakom.ac.id/index.php/jiko");
        link.add("http://itfest.akakom.ac.id/");

        nama.add("Yayasan Pendidikan");
        nama.add("Pendaftaran Mahasiswa");
        nama.add("Blog Mahasiswa");
        nama.add("Portal Akademik");
        nama.add("Laboratorium Akakom");
        nama.add("Caree Center");
        nama.add("Ikatan Keluarga Alumni");
        nama.add("Olimpiade Komputer");
        nama.add("SRITI Akakom");
        nama.add("Pusat Jaminan Mutu");
        nama.add("Perpustakaan Akakom");
        nama.add("DIKTI");
        nama.add("Puslitbag AKAKOM");
        nama.add("Jiko-Akakom");
        nama.add("AKakom IT Fest 2016");

        recyclerViewTautan.setLayoutManager(new LinearLayoutManager(Tautan.this,LinearLayoutManager.VERTICAL,false));
        RecyclerViewAdapterTautan adapterTautan = new RecyclerViewAdapterTautan(Tautan.this,link,nama);
        recyclerViewTautan.setAdapter(adapterTautan);
        adapterTautan.notifyDataSetChanged();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}
