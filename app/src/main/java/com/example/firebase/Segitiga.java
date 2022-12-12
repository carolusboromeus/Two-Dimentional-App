package com.example.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Segitiga extends AppCompatActivity {
    TextView txtAuthor, txtDesc;
    EditText edAlasSegitiga, edTinggiSegitiga, edLuasSegitiga, edKelilingSegitiga;
    Button btnHitung, btnHapus, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);
        initViews();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!=null){
            txtAuthor.setText(bundle.getString("author"));
            txtDesc.setText(bundle.getString("description"));
        }

        btnHitung.setOnClickListener(view->{
            if(edAlasSegitiga.length()==0){
                Toast.makeText(getApplication(), "alas belum di Input", Toast.LENGTH_LONG).show();
            }
            else if(edTinggiSegitiga.length()==0){
                Toast.makeText(getApplication(), "tinggi belum di Input", Toast.LENGTH_LONG).show();
            }
            else{
                hitungLuasSegitiga();
                hitungKelilingSegitiga();
            }
        });

        btnHapus.setOnClickListener(view-> hapus());

        btnBack.setOnClickListener(view-> back());
    }

    private void hitungLuasSegitiga(){
        String alasSegitiga = edAlasSegitiga.getText().toString();
        String tinggiSegitiga = edTinggiSegitiga.getText().toString();
        double alas = Double.parseDouble(alasSegitiga);
        double tinggi = Double.parseDouble(tinggiSegitiga);
        double hasil = (alas * tinggi) / 2;
        edLuasSegitiga.setText(String.valueOf(hasil));
    }

    private void hitungKelilingSegitiga(){
        String alasSegitiga = edAlasSegitiga.getText().toString();
        double alas = Double.parseDouble(alasSegitiga);
        double hasil = alas * 3;
        edKelilingSegitiga.setText(String.valueOf(hasil));
    }

    private void hapus(){
        edAlasSegitiga.getText().clear();
        edTinggiSegitiga.getText().clear();
        edLuasSegitiga.getText().clear();
        edKelilingSegitiga.getText().clear();
    }

    private void back(){
        Intent intent = new Intent(Segitiga.this, ProfileActivity.class);
        startActivity(intent);
        finish();
    }

    private void initViews(){
        txtAuthor = findViewById(R.id.txtAuthor);
        txtDesc = findViewById(R.id.txtDesc);
        edAlasSegitiga = findViewById(R.id.edAlasSegitiga);
        edTinggiSegitiga = findViewById(R.id.edTinggiSegitiga);
        edLuasSegitiga = findViewById(R.id.edLuasSegitiga);
        edKelilingSegitiga = findViewById(R.id.edKelilingSegitiga);
        btnHitung = findViewById(R.id.btnHitung);
        btnHapus = findViewById(R.id.btnHapus);
        btnBack = findViewById(R.id.btnBack);
    }
}
