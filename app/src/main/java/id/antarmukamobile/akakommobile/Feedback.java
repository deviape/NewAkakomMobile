package id.antarmukamobile.akakommobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Feedback extends AppCompatActivity {
    private EditText editTextSubjek, editTextPesan;
    private Button buttonSubmit, buttonReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        editTextSubjek=(EditText)findViewById(R.id.editTextSubjek);
        editTextPesan=(EditText)findViewById(R.id.editTextPesan);
        buttonSubmit=(Button)findViewById(R.id.buttonSubmit);
        buttonReset=(Button)findViewById(R.id.buttonReset);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "info@akakom.ac.id");
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
