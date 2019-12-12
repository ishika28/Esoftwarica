package com.example.esoftwarica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.esoftwarica.ui.home.HomeFragment;

public class LoginActivity extends AppCompatActivity {
    private EditText etusername;
    private EditText etpassword;
    private Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etusername=findViewById(R.id.etusername);
        etpassword=findViewById(R.id.etpassword);
        btnlogin=findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etusername.getText().toString().equals("softwarica")&& etpassword.getText().toString().equals("coventry")){
                    Login();
                    Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(LoginActivity.this, BottmNavigationActivity.class );
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Invalid username and password",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
    private void Login(){
        SharedPreferences sharedPreferences= getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("username",etusername.getText().toString().trim());
        editor.putString("Password",etpassword.getText().toString().trim());
        editor.commit();


    }
}
