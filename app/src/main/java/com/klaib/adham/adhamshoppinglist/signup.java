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
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity implements View.OnClickListener
{
    private EditText ETNAME;
    private EditText ETEMAIL1;
    private EditText ETPASSWORD1;
    private EditText ETREPASS;
    private Button BTNSAVE;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ETNAME = (EditText) findViewById(R.id.ETNAME);
        ETEMAIL1 = (EditText) findViewById(R.id.ETEMAIL1);
        ETPASSWORD1 = (EditText) findViewById(R.id.ETPASSWORD1);
        ETREPASS = (EditText) findViewById(R.id.ETREPASS);
        BTNSAVE = (Button) findViewById(R.id.BTNSAVE);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
    }

    public void onClick(View v)
    {
        dataHandler();

    }
    /**
     * to deal with input data
     */
    private void dataHandler()
    {
        String STEMAIL=ETEMAIL1.getText().toString();
        String STNAME=ETNAME.getText().toString();
        String STPASSWORD=ETPASSWORD1.getText().toString();
        String STREPASSWORD=ETREPASS.getText().toString();
        boolean isok=true;//to chrck if all feilds are filled correctly
        if (STEMAIL.length()==0 || STEMAIL.indexOf('@')<1){
            ETEMAIL1.setError("wrong Email");
            isok=false;
        }
        if (STPASSWORD.length()<8){
            ETPASSWORD1.setError("Bad Password");
            isok=false;
        }
        if(isok)
            creatAcount(STEMAIL,STPASSWORD);
    }
    private void creatAcount(String email, String passw) {
        auth.createUserWithEmailAndPassword(email,passw).addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(signup.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();
                    //updateUserProfile(task.getResult().getUser());
                    finish();
                }
                else
                {
                    Toast.makeText(signup.this, "Authentication failed."+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }
}
