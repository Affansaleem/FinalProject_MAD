package com.example.fianlproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {
    FirebaseAuth mAuth;
    TextInputEditText etRegEmail,etRegPass;
    Button btnReg;
    TextView tvLogin;

//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser != null){
//            Intent i=new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(i);
//            finish();
//        }
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etRegEmail=findViewById(R.id.etRegEmail);
        etRegPass=findViewById(R.id.etRegPass);
        btnReg=findViewById(R.id.btnReg);
        tvLogin=findViewById(R.id.tvLogin);


        mAuth = FirebaseAuth.getInstance();

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SignUp.this,Login.class);
                startActivity(i);
                finish();
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=etRegEmail.getText().toString().trim();
                String pass=etRegPass.getText().toString().trim();

                if(email.isEmpty())
                {
                    etRegEmail.setError("Please enter email");

                }
                if(pass.isEmpty())
                {
                    etRegPass.setError("Please enter password");

                }
                else {

                    mAuth.createUserWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information

                                        Toast.makeText(getApplicationContext(), "Sign up Successful", Toast.LENGTH_SHORT).show();

                                    }
                                    else {
                                        // If sign in fails, display a message to the user.

                                        Toast.makeText(getApplicationContext(), "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                }
            }
        });


    }
}