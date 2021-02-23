package com.example.assettracking.RegistrationSystem.SignIn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assettracking.R;
import com.example.assettracking.RegistrationSystem.SignUp.SignUp;
import com.google.android.material.textfield.TextInputEditText;

public class SignIn extends AppCompatActivity {

    private TextInputEditText LUsername, LPassword;
    private TextView NewUser;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_sign_in);


    }
    public void onLoginClick(View View){
        startActivity(new Intent(this,SignUp.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
    }
//
//        LUsername = findViewById(R.id.LUsername);
//        LPassword = findViewById(R.id.LPassword);
//        NewUser = findViewById(R.id.NewUser);
//        btnLogin = findViewById(R.id.btnLogin);
//
//        NewUser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(SignIn.this, SignUp.class);
//                startActivity(i);
//            }
//        });
//
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(!validate()){
//                    validate();
//                    return;
//                }
//                saveLogin();
//            }
//        });
//
//    }
//    private void saveLogin() {
//        SharedPreferences sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
//        editor.putString("username", LUsername.getText().toString());
//        editor.putString("password", LPassword.getText().toString());
//        editor.commit();
//
//        Toast.makeText(this, "Data has been saved Successfully", Toast.LENGTH_SHORT).show();
//    }
//
//    private boolean validate() {
//        boolean flag = true;
//
//        if (TextUtils.isEmpty(LUsername.getText().toString())) {
//            LUsername.setError("Please Enter Username");
//            LUsername.requestFocus();
//            flag = false;
//        } else if (TextUtils.isEmpty(LPassword.getText().toString())) {
//            LPassword.setError("Please enter Password");
//            LPassword.requestFocus();
//            flag = false;
//        }
//        return flag;
//    }
}