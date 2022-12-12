package com.example.firebase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.firebase.databinding.ActivitySignUpBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;

    private FirebaseAuth firebaseAuth;

    private ProgressDialog progressDialog;

    private String email="", password="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Creating you account...");
        progressDialog.setCanceledOnTouchOutside(false);

        binding.tvLogin.setOnClickListener(v -> startActivity(new Intent(SignUpActivity.this, LoginActivity.class)));

        binding.btnSignUp.setOnClickListener(v -> validateData());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); //got ot previous activity when back button of actionbar clicked
        return super.onSupportNavigateUp();
    }

    private void validateData() {
        email = binding.edEmail.getText().toString().trim();
        password = binding.edPassword.getText().toString().trim();

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.edEmail.setError("Invalid email format");
        }
        else if(TextUtils.isEmpty(password)){
            binding.edPassword.setError("Enter password");
        }
        else if(password.length()<8){
            binding.edPassword.setError("Password must at least 8 characters long");
        }
        else
        {
            firebaseSignUp();
        }
    }

    private void firebaseSignUp() {
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    progressDialog.dismiss();

                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                    assert firebaseUser != null;
                    String email = firebaseUser.getEmail();

                    Toast.makeText(SignUpActivity.this,"Account created\n"+email, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this, ProfileActivity.class));
                    finish();
                })
                .addOnFailureListener(e -> {
                    progressDialog.dismiss();
                    Toast.makeText(SignUpActivity.this,""+e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }
}