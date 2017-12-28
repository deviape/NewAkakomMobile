package id.antarmukamobile.akakommobile.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.widget.LinearLayoutManager;
import  android.support.v7.widget.RecyclerView;
import android.support.annotation.Nullable;
import android.widget.RatingBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.UUID;

import id.antarmukamobile.akakommobile.R;
import id.antarmukamobile.akakommobile.adapter.RecyclerViewFeed;
import id.antarmukamobile.akakommobile.modelAPI.FeedBackFirebaseModel;
import id.antarmukamobile.akakommobile.modelAPI.FeedModel;
import id.antarmukamobile.akakommobile.modelAPI.ListFeed;

public class    Feedback extends AppCompatActivity {
    LinearLayoutManager layoutManager;
    ArrayList<FeedModel> models;
    ArrayList<FeedBackFirebaseModel> modelFeed = new ArrayList<>();
    RecyclerViewFeed feedAdapter;
    RecyclerView recyclerView;
    FeedBackFirebaseModel  model =new FeedBackFirebaseModel();
    DatabaseReference databaseReference;
    private RatingBar ratingBar;
    private  EditText editTextSubjek, editTextPesan;
    private Button buttonSubmit, buttonReset;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.rv_feed);
        models = ListFeed.getlist();

        ratingBar = (RatingBar)findViewById(R.id.ratingBar);

        editTextSubjek=(EditText)findViewById(R.id.editTextSubjek);
        editTextPesan=(EditText)findViewById(R.id.editTextPesan);
        buttonSubmit=(Button)findViewById(R.id.buttonSubmit);
        buttonReset=(Button)findViewById(R.id.buttonReset);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("Feedback").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                modelFeed.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    FeedBackFirebaseModel firebaseModel =dataSnapshot1.getValue(FeedBackFirebaseModel.class);
                    modelFeed.add(firebaseModel);
                }
                layoutManager = new LinearLayoutManager(Feedback.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setHasFixedSize(true);
                feedAdapter = new RecyclerViewFeed(Feedback.this, modelFeed);
                recyclerView.setAdapter(feedAdapter);
                feedAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int nilai = Math.round(ratingBar.getRating());
                Log.d("nilai",nilai + "");
                model.setKomentar(editTextPesan.getText().toString());
                model.setNama(editTextSubjek.getText().toString());
                model.setRating(nilai);
                String  id = UUID.randomUUID().toString();
                databaseReference.child("Feedback").child(editTextSubjek.getText().toString()).setValue(model);
                editTextSubjek.setText("");
                editTextPesan.setText("");
                ratingBar.setStepSize(0);
                Log.i("Send email", "");

//                String[] TO = {"info@akakom.ac.id"};
//
//                Intent intent = new Intent(Intent.ACTION_SEND);
//                intent.setData(Uri.parse("mailto:"));
//                intent.setType("text/html");
//                intent.putExtra(Intent.EXTRA_EMAIL, TO);
//                intent.putExtra(Intent.EXTRA_SUBJECT, editTextSubjek.getText().toString());
//                intent.putExtra(Intent.EXTRA_TEXT, editTextPesan.getText().toString());
//
//                startActivity(Intent.createChooser(intent, "Send Feedback"));
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

