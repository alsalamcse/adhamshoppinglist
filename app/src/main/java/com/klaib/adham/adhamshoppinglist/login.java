package com.klaib.adham.adhamshoppinglist;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.klaib.adham.adhamshoppinglist.mainlistavtivity.Mainlist;

public class login extends AppCompatActivity implements View.OnClickListener {
    public static final String PREF_FILE_NAME = "AdhamPref";
    private EditText ETEMAIL;
    private EditText ETPASSWPRD;
    private Button BTNLOGIN;
    private Button BTNSIGNUP;
    private Button BTNFORGETPASS;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        ETEMAIL = (EditText) findViewById(R.id.ETEMAIL);
        ETPASSWPRD = (EditText) findViewById(R.id.ETPASSWORD);
        BTNLOGIN = (Button) findViewById(R.id.BTNLOGIN);
        BTNFORGETPASS = (Button) findViewById(R.id.BTNFORGETPASS);
        BTNSIGNUP = (Button) findViewById(R.id.BTNSIGNUP);
        BTNLOGIN.setOnClickListener(this);
        BTNSIGNUP.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (BTNLOGIN == view) {
            dataHandler();

        }
        if (BTNSIGNUP == view) {
            Intent intent = new Intent(this, signup.class);
            startActivity(intent);
        }
    }

    public static class signin extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signin);
        }
    }

    private void signIn(String email, String passw) {
        auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(login.this, "signIn Successful.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this, Mainlist.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(login.this, "signIn failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }

    private void dataHandler() {
        String stEmail = ETEMAIL.getText().toString();
        String stPass = ETPASSWPRD.getText().toString();
        boolean isok = true;//to chrck if all feilds are filled correctly
        if (stEmail.length() == 0 || stEmail.indexOf('@') < 1) {
            ETEMAIL.setError("wrong Email");
            isok = false;
        }

        signIn(stEmail, stPass);

    }
}



    



