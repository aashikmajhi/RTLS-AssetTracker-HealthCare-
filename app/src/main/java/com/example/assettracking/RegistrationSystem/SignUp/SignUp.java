package com.example.assettracking.RegistrationSystem.SignUp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.assettracking.Database.User;
import com.example.assettracking.R;
import com.example.assettracking.RegistrationSystem.SignIn.SignIn;
import com.example.assettracking.Sensor.Vibration;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

public class SignUp extends AppCompatActivity {
    private EditText editTextName, editTextEmail, editTextMobile, editTextPassword;
    private CircularProgressButton cirRegisterButton;
    private FirebaseAuth authentication;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextMobile = findViewById(R.id.editTextMobile);
        editTextPassword = findViewById(R.id.editTextPassword);

        cirRegisterButton = findViewById(R.id.cirRegisterButton);

        progressDialog = new ProgressDialog(this);

        authentication = FirebaseAuth.getInstance();

        cirRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validate()) {
                    validate();
                    saveRegister();
                    return;
                }
                UserReg();
            }
        });
    }

    private void UserReg() {
        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String mobileno = editTextMobile.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        authentication.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    User user = new User(name, email, mobileno,password);

                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignUp.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(SignUp.this,SignIn.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(SignUp.this, "Failed to register", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(SignUp.this, "Failed to Register, please try again ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
            window.setStatusBarColor(getResources().getColor(R.color.register_bk_color));
        }
    }

    public void onLoginClick(View view) {
        startActivity(new Intent(this, SignIn.class));
        overridePendingTransition(R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    private boolean validate() {
        boolean flag = true;
        if (TextUtils.isEmpty(editTextName.getText().toString())) {
            Vibration.getVibration(getBaseContext());
            editTextName.setError("Enter your first name");
            editTextName.requestFocus();
            flag = false;
        } else if (TextUtils.isEmpty(editTextEmail.getText().toString())) {
            Vibration.getVibration(getBaseContext());
            editTextEmail.setError("Enter yor last name");
            editTextEmail.requestFocus();
            flag = false;
        } else if (TextUtils.isEmpty(editTextMobile.getText().toString())) {
            Vibration.getVibration(getBaseContext());
            editTextMobile.setError("Please Enter Username");
            editTextMobile.requestFocus();
            flag = false;
        } else if (TextUtils.isEmpty(editTextPassword.getText().toString())) {
            Vibration.getVibration(getBaseContext());
            editTextPassword.setError("Please enter Password");
            editTextPassword.requestFocus();
            flag = false;
        }
        return flag;
    }

    private void saveRegister() {
        SharedPreferences sharedPreferences = getSharedPreferences("UserRegistrationDetails", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("username", editTextName.getText().toString());
        editor.putString("password", editTextMobile.getText().toString());
        editor.putString("firstName", editTextMobile.getText().toString());
        editor.putString("lastName", editTextPassword.getText().toString());
        editor.commit();

        Toast.makeText(this, "Data has been saved Successfully", Toast.LENGTH_SHORT).show();
    }
}