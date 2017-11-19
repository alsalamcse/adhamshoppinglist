package com.klaib.adham.adhamshoppinglist.mainlistavtivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.klaib.adham.adhamshoppinglist.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Currentfragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Currentfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
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
    private OnFragmentInteractionListener mListener;

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
     //   ArrayAdapter<String> arrayAdapter=new ArrayAdapter(this,)
        //4
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
