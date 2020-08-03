package com.example.android.fragmentexample1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.android.fragmentexample1.R;


/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class SimpleFragment extends Fragment {
    private static final int Yes=0;
    private static final int No=1;

    public SimpleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView=
                inflater.inflate(R.layout.fragment_simple,container,false);
        final RadioGroup radioGroup=rootView.findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener(new
                                                      RadioGroup.OnCheckedChangeListener() {
                                                          @Override
                                                          public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                              View radioButton = radioGroup.findViewById(checkedId);
                                                              int index = radioGroup.indexOfChild(radioButton);
                                                              TextView textView =
                                                                      rootView.findViewById(R.id.fragment_header);
                                                              switch (index) {
                                                                  case Yes:
                                                                      textView.setText(R.string.yes_message);
                                                                      break;
                                                                  case No:
                                                                      textView.setText(R.string.no_message);
                                                                      break;
                                                                  default:
                                                                      //do nothing
                                                                      break;
                                                              }
                                                          }

                                                      });

        // Inflate the layout for this fragment
        return rootView;
    }
    public static SimpleFragment newInstance(){

        return new SimpleFragment();
    }

}