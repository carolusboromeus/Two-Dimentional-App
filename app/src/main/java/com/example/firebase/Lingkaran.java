package com.example.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Lingkaran extends AppCompatActivity {
    TextView txtAuthor, txtDesc;
    EditText edJariLingkaran, edLuasLingkaran, edKelilingLingkaran;
    Button btnHitung, btnHapus, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkaran);
        initViews();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!=null){
            txtAuthor.setText(bundle.getString("author"));
            txtDesc.setText(bundle.getString("description"));
        }

        btnHitung.setOnClickListener(view->{
            if(edJariLingkaran.length()==0){
                Toast.makeText(getApplication(), "jari belum di Input", Toast.LENGTH_LONG).show();
            }
            else{
                hitungLuasLingkaran();
                hitungKelilingLingkaran();
            }
        });

        btnHapus.setOnClickListener(view-> hapus());

        btnBack.setOnClickListener(view-> back());
    }

    private void hitungLuasLingkaran(){
        String jariLingkaran = edJariLingkaran.getText().toString();
        double jari = Double.parseDouble(jariLingkaran);
        double hasil = Math.PI * Math.pow(jari, 2);
        edLuasLingkaran.setText(String.valueOf(hasil));
    }

    private void hitungKelilingLingkaran(){
        String jariLingkaran = edJariLingkaran.getText().toString();
        double jari = Double.parseDouble(jariLingkaran);
        double hasil = 2 * Math.PI * jari;
        edKelilingLingkaran.setText(String.valueOf(hasil));
    }

    private void hapus(){
        edJariLingkaran.getText().clear();
        edLuasLingkaran.getText().clear();
        edKelilingLingkaran.getText().clear();
    }

    private void back(){
        Intent intent = new Intent(Lingkaran.this, ProfileActivity.class);
        startActivity(intent);
        finish();
    }

    private void initViews(){
        txtAuthor = findViewById(R.id.txtAuthor);
        txtDesc = findViewById(R.id.txtDesc);
        edJariLingkaran = findViewById(R.id.edJariLingkaran);
        edLuasLingkaran = findViewById(R.id.edLuasLingkaran);
        edKelilingLingkaran = findViewById(R.id.edKelilingLingkaran);
        btnHitung = findViewById(R.id.btnHitung);
        btnHapus = findViewById(R.id.btnHapus);
        btnBack = findViewById(R.id.btnBack);
    }
}
