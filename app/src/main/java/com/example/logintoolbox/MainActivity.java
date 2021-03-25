package com.example.logintoolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText txtName, txtPassword;
    public Login l = new Login();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnLogin);
        txtName = findViewById(R.id.txtNameSearch);
        txtPassword = findViewById(R.id.txtPassword);

        l.setArray(50);


        btnLogin.setOnClickListener(new View.OnClickListener()
                                    {

                                        public void onClick(View v) {
                                            String strName = txtName.getText().toString();

                                            String iPassword = txtPassword.getText().toString();

                                            if (l.Valid(strName, iPassword)) {
                                                Toast.makeText(getApplicationContext(), "You are the real " + strName,
                                                        Toast.LENGTH_LONG).show();

                                                startActivity(new Intent(MainActivity.this, ViewUsers.class));

                                            } else {
                                                Toast.makeText(getApplicationContext(), "You are not my " + strName +
                                                                " .....",
                                                        Toast.LENGTH_LONG).show();
                                            }

                                        }
                                    }
        );
    }
    public void RegPage(View view)
    {
        Intent intent = new Intent(this, RegActivity.class);
        startActivity(intent);
    }
}