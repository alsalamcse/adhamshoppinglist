package com.klaib.adham.adhamshoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.klaib.adham.adhamshoppinglist.R;

public class AddItem extends AppCompatActivity {
    private EditText ETNAME;
    private EditText ETAMOUNT;
    private EditText ETUNITS;
    private EditText ETPRICE;
    private Button BTNSAVE;
    private ImageButton IBTNIMAGE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        ETNAME = (EditText) findViewById(R.id.ETNAME);
        ETAMOUNT = (EditText) findViewById(R.id.ETAMOUNT);
        ETUNITS = (EditText) findViewById(R.id.ETUNITS);
        ETPRICE = (EditText) findViewById(R.id.ETPRICE);
        BTNSAVE = (Button) findViewById(R.id.BTNSAVE);
        IBTNIMAGE = (ImageButton) findViewById(R.id.IBTNIMAGE);
        BTNSAVE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });
    }
    public void dataHandler()
    {
        String STNAME=ETNAME.getText().toString();
        String STAMOUNT=ETAMOUNT.getText().toString();
        String STUNITS=ETUNITS.getText().toString();
        String STPRICE=ETPRICE.getText().toString();
        double amount=Double.parseDouble(STAMOUNT);
        double price=Double.parseDouble(STPRICE);
        DatabaseReference reference;
        //todo לקבלת קישור למסד הניתונים שלנו
        //todo קישור הינו לשורש של המסד שלנו
        reference= FirebaseDatabase.getInstance().getReference();
        reference.child("list").setPriority("koko");


    }
}

