package com.example.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PersegiPanjang extends AppCompatActivity {
    TextView txtAuthor, txtDesc;
    EditText edPanjangPersegiPanjang, edLebarPersegiPanjang, edLuasPersegiPanjang, edKelilingPersegiPanjang;
    Button btnHitung, btnHapus, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi_panjang);
        initViews();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!=null){
            txtAuthor.setText(bundle.getString("author"));
            txtDesc.setText(bundle.getString("description"));
        }

        btnHitung.setOnClickListener(view->{
            if(edPanjangPersegiPanjang.length()==0){
                Toast.makeText(getApplication(), "Panjang belum di Input", Toast.LENGTH_LONG).show();
            }
            else if(edLebarPersegiPanjang.length()==0){
                Toast.makeText(getApplication(), "Lebar belum di Input", Toast.LENGTH_LONG).show();
            }
            else{
                hitungLuasPersegiPanjang();
                hitungKelilingPersegiPanjang();
            }
        });

        btnHapus.setOnClickListener(view-> hapus());

        btnBack.setOnClickListener(view-> back());
    }

    private void hitungLuasPersegiPanjang(){
        String PanjangPersegiPanjang = edPanjangPersegiPanjang.getText().toString();
        String LebarPersegiPanjang = edLebarPersegiPanjang.getText().toString();
        double Panjang = Double.parseDouble(PanjangPersegiPanjang);
        double Lebar = Double.parseDouble(LebarPersegiPanjang);
        double hasil = Panjang * Lebar;
        edLuasPersegiPanjang.setText(String.valueOf(hasil));
    }

    private void hitungKelilingPersegiPanjang(){
        String PanjangPersegiPanjang = edPanjangPersegiPanjang.getText().toString();
        String LebarPersegiPanjang = edLebarPersegiPanjang.getText().toString();
        double Panjang = Double.parseDouble(PanjangPersegiPanjang);
        double Lebar = Double.parseDouble(LebarPersegiPanjang);
        double hasil = 2 * (Panjang + Lebar);
        edKelilingPersegiPanjang.setText(String.valueOf(hasil));
    }

    private void hapus(){
        edPanjangPersegiPanjang.getText().clear();
        edLebarPersegiPanjang.getText().clear();
        edLuasPersegiPanjang.getText().clear();
        edKelilingPersegiPanjang.getText().clear();
    }

    private void back(){
        Intent intent = new Intent(PersegiPanjang.this, ProfileActivity.class);
        startActivity(intent);
        finish();
    }

    private void initViews(){
        txtAuthor = findViewById(R.id.txtAuthor);
        txtDesc = findViewById(R.id.txtDesc);
        edPanjangPersegiPanjang = findViewById(R.id.edPanjangPersegiPanjang);
        edLebarPersegiPanjang = findViewById(R.id.edLebarPersegiPanjang);
        edLuasPersegiPanjang = findViewById(R.id.edLuasPersegiPanjang);
        edKelilingPersegiPanjang = findViewById(R.id.edKelilingPersegiPanjang);
        btnHitung = findViewById(R.id.btnHitung);
        btnHapus = findViewById(R.id.btnHapus);
        btnBack = findViewById(R.id.btnBack);
    }
}
