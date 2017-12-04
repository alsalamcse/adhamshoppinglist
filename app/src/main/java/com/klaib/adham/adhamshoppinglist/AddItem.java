package com.klaib.adham.adhamshoppinglist;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.klaib.adham.adhamshoppinglist.R;
import com.klaib.adham.adhamshoppinglist.data.Product;

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
        //1.get data from the fields
        String STNAME=ETNAME.getText().toString();
        String STAMOUNT=ETAMOUNT.getText().toString();
        String STUNITS=ETUNITS.getText().toString();
        String STPRICE=ETPRICE.getText().toString();
        //2. todo Validate fields input
        //isok=true;......

        //3. data manipulation
        double amount=Double.parseDouble(STAMOUNT);
        double price=Double.parseDouble(STPRICE);
        //4. building data object
        Product p=new Product();
        p.setName(STNAME);
        p.setAmount(amount);
        p.setPrice(price);
        p.setCompleted(false);
        //5.to get user email
        FirebaseAuth auth=FirebaseAuth.getInstance();
        FirebaseUser user=auth.getCurrentUser();
        String email=user.getEmail();
        email=email.replace('.','*');
        //6.building data reference= data path=data address
        DatabaseReference reference;
        //todo לקבלת קישור למסד הניתונים שלנו
        //todo קישור הינו לשורש של המסד שלנו
        reference= FirebaseDatabase.getInstance().getReference();
        //7.saving data on the firebase database
        reference.child(email).child("MyList").push().setValue(p).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(AddItem.this,"Add Product Succesful",Toast.LENGTH_SHORT);
                }
                else
                {
                    Toast.makeText(AddItem.this,"Add Product Failed",Toast.LENGTH_LONG);
                }
            }
        });
        //todo Testing
        //reference.child("list").setPriority(STNAME);



    }
}

