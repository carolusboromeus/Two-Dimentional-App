package com.example.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Persegi extends AppCompatActivity {
    TextView txtAuthor, txtDesc;
    EditText edSisiPersegi, edLuasPersegi, edKelilingPersegi;
    Button btnHitung, btnHapus, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi);
        initViews();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!=null){
            txtAuthor.setText(bundle.getString("author"));
            txtDesc.setText(bundle.getString("description"));
        }

        btnHitung.setOnClickListener(view->{
            if(edSisiPersegi.length()==0){
                Toast.makeText(getApplication(), "Sisi belum di Input", Toast.LENGTH_LONG).show();
            }
            else{
                hitungLuasPersegi();
                hitungKelilingPersegi();
            }
        });

        btnHapus.setOnClickListener(view-> hapus());

        btnBack.setOnClickListener(view-> back());
    }

    private void hitungLuasPersegi(){
        String sisiPersegi = edSisiPersegi.getText().toString();
        double sisi = Double.parseDouble(sisiPersegi);
        double hasil = Math.pow(sisi, 2);
        edLuasPersegi.setText(String.valueOf(hasil));
    }

    private void hitungKelilingPersegi(){
        String sisiPersegi = edSisiPersegi.getText().toString();
        double sisi = Double.parseDouble(sisiPersegi);
        double hasil = sisi * 4;
        edKelilingPersegi.setText(String.valueOf(hasil));
    }

    private void hapus(){
        edSisiPersegi.getText().clear();
        edLuasPersegi.getText().clear();
        edKelilingPersegi.getText().clear();
    }

    private void back(){
        Intent intent = new Intent(Persegi.this, ProfileActivity.class);
        startActivity(intent);
        finish();
    }

    private void initViews(){
        txtAuthor = findViewById(R.id.txtAuthor);
        txtDesc = findViewById(R.id.txtDesc);
        edSisiPersegi = findViewById(R.id.edSisiPersegi);
        edLuasPersegi = findViewById(R.id.edLuasPersegi);
        edKelilingPersegi = findViewById(R.id.edKelilingPersegi);
        btnHitung = findViewById(R.id.btnHitung);
        btnHapus = findViewById(R.id.btnHapus);
        btnBack = findViewById(R.id.btnBack);
    }
}
