package com.example.assettracking.RegistrationSystem.SignIn;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.assettracking.Dashboard.Dashboard;
import com.example.assettracking.R;
import com.example.assettracking.RegistrationSystem.SignUp.SignUp;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

public class SignIn extends AppCompatActivity {

    private EditText username, userPassword;
    private CircularProgressButton cirLoginButton;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_sign_in);
        username = findViewById(R.id.editTextEmail);
        userPassword = findViewById(R.id.editTextPassword);


        cirLoginButton = findViewById(R.id.cirLoginButton);

        auth = FirebaseAuth.getInstance();

        cirLoginButton.setOnClickListener(view -> {

            LoginUser();
                Intent i = new Intent(SignIn.this, Dashboard.class);
                startActivity(i);
        });


    }
    private void LoginUser() {

        String email = username.getText().toString().trim();
        String password = userPassword.getText().toString().trim();

        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

                            if (firebaseUser.isEmailVerified()) {

                                Intent intent = new Intent(SignIn.this, SignUp.class);
                                Toast.makeText(SignIn.this, "LogIn Successful", Toast.LENGTH_SHORT).show();
                                startActivity(intent);

                            } else {
                                firebaseUser.sendEmailVerification();
                                Toast.makeText(SignIn.this, "Check your email to verify your account", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(SignIn.this, "Email or Password don't Match", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void onLoginClick(View View) {
        startActivity(new Intent(this, SignUp.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.stay);
    }
}