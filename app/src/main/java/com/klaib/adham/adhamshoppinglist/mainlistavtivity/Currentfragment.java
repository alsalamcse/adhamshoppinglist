package com.klaib.adham.adhamshoppinglist.mainlistavtivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.klaib.adham.adhamshoppinglist.R;
import com.klaib.adham.adhamshoppinglist.data.Product;


public class Currentfragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    //1
    private TextView tvTotal,tvCount,tvTotalValue,tvCountValue;
    private ImageButton imbSave;
    private ListView IstvCurrent;


    public Currentfragment() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Currentfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Currentfragment newInstance(String param1, String param2) {
        Currentfragment fragment = new Currentfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    //2
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //3
        View view= inflater.inflate(R.layout.fragment_currentfragment, container, false);
        //5
        tvTotal= (TextView) view.findViewById(R.id.tvTotal);
        tvTotalValue= (TextView) view.findViewById(R.id.tvTotalValue);
        tvCount= (TextView) view.findViewById(R.id.tvCount);
        tvCountValue= (TextView) view.findViewById(R.id.tvCountValue);
        imbSave= (ImageButton) view.findViewById(R.id.imbSave);
        IstvCurrent= (ListView) view.findViewById(R.id.IstvCurrent);
        String[] ar={"noor","rimaa","sozy","adam","nana","adham"};
        //ArrayAdapter<String> arrayAdapter=new ArrayAdapter(this,)
        readAndListen();
        //4
        return view;
    }
    //read and listen data from firebase
    private void readAndListen()
    {
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
        //7.listening to data cgange
        reference.child(email).child("MyList").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                for (DataSnapshot ds:dataSnapshot.getChildren())
                {
                    Product p= ds.getValue(Product.class);
                    Log.d("LS",p.toString());

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });

    }


}
