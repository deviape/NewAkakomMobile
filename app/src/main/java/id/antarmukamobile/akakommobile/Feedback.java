package id.antarmukamobile.akakommobile;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.widget.LinearLayoutManager;
import  android.support.v7.widget.RecyclerView;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import id.antarmukamobile.akakommobile.adapter.RecyclerViewFeed;
import id.antarmukamobile.akakommobile.modelAPI.FeedModel;
import id.antarmukamobile.akakommobile.modelAPI.ListFeed;

public class    Feedback extends AppCompatActivity {
    LinearLayoutManager layoutManager;
    ArrayList<FeedModel> models;
    RecyclerViewFeed feedAdapter;
    RecyclerView recyclerView;

    private  EditText editTextSubjek, editTextPesan;
    private Button buttonSubmit, buttonReset;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        recyclerView = (RecyclerView) findViewById(R.id.rv_feed);
        models = ListFeed.getlist();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        feedAdapter = new RecyclerViewFeed(Feedback.this, models);
        recyclerView.setAdapter(feedAdapter);

        editTextSubjek=(EditText)findViewById(R.id.editTextSubjek);
        editTextPesan=(EditText)findViewById(R.id.editTextPesan);
        buttonSubmit=(Button)findViewById(R.id.buttonSubmit);
        buttonReset=(Button)findViewById(R.id.buttonReset);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Send email", "");

                String[] TO = {"info@akakom.ac.id"};

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, TO);
                intent.putExtra(Intent.EXTRA_SUBJECT, editTextSubjek.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, editTextPesan.getText().toString());

                startActivity(Intent.createChooser(intent, "Send Feedback"));
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextSubjek.setText("");
                editTextPesan.setText("");
            }
        });

    }
}
