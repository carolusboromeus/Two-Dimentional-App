package com.example.firebase;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.firebase.databinding.ActivityProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {
    CardView cvPersegi, cvLingkaran, cvSegitiga, cvPersegiPanjang;
    private ActivityProfileBinding binding;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth = FirebaseAuth.getInstance();
        checkUser();
        initViews();

        cvPersegi.setOnClickListener(view-> hasilPersegi());
        cvLingkaran.setOnClickListener(view-> hasilLingkaran());
        cvSegitiga.setOnClickListener(view-> hasilSegitigaSamaSisi());
        cvPersegiPanjang.setOnClickListener(view-> hasilPersegiPanjang());

        binding.btnLogout.setOnClickListener(v -> {
            firebaseAuth.signOut();
            checkUser();
        });
    }

    private void hasilPersegi(){
        Intent intentPersegi = new Intent(ProfileActivity.this, Persegi.class);
        intentPersegi.putExtra("author", "Created By : Kelompok 1");
        intentPersegi.putExtra("description", "Menghitung Luas dan Keliling Persegi");
        startActivity(intentPersegi);
        finish();
    }

    private void hasilLingkaran(){
        Intent intentLingkaran = new Intent(ProfileActivity.this, Lingkaran.class);
        intentLingkaran.putExtra("author", "Created By : Kelompok 1");
        intentLingkaran.putExtra("description", "Menghitung Luas dan Keliling Lingkaran");
        startActivity(intentLingkaran);
        finish();
    }

    private void hasilSegitigaSamaSisi(){
        Intent intentSegitiga = new Intent(ProfileActivity.this, Segitiga.class);
        intentSegitiga.putExtra("author", "Created By : Kelompok 1");
        intentSegitiga.putExtra("description", "Menghitung Luas dan Keliling Segitiga Sama Sisi");
        startActivity(intentSegitiga);
        finish();
    }

    private void hasilPersegiPanjang(){
        Intent intentPersegiPanjang = new Intent(ProfileActivity.this, PersegiPanjang.class);
        intentPersegiPanjang.putExtra("author", "Created By : Kelompok 1");
        intentPersegiPanjang.putExtra("description", "Menghitung Luas dan Keliling Persegi Panjang");
        startActivity(intentPersegiPanjang);
        finish();
    }

    private void checkUser() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser == null){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
        else{
            String email= firebaseUser.getEmail();
            binding.tvEmail.setText(email);
        }
    }

    private void initViews(){
        cvPersegi = findViewById(R.id.cvSquare);
        cvLingkaran = findViewById(R.id.cvCircle);
        cvSegitiga = findViewById(R.id.cvTriangle);
        cvPersegiPanjang = findViewById(R.id.cvRectangle);
    }
}