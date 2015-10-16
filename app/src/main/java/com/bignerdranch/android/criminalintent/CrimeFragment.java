package com.bignerdranch.android.criminalintent;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Created by Anthony on 10/14/2015.
 */
public class CrimeFragment extends Fragment {
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    private String TAG = "CrimeFragment";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView() called");
        View v = inflater.inflate(R.layout.fragment_crime, container, false);
        findViews(v);
        setListeners();
        setDefaultProperties();
        return v;
    }

    //sets references to views
    private void findViews(View v){
        Log.d(TAG, "findViews() called");

        mTitleField = (EditText)v.findViewById(R.id.crime_title);

        mDateButton = (Button)v.findViewById(R.id.crime_date);

        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
    }

    //sets listeners for views
    private void setListeners(){
        Log.d(TAG, "setListeners() called");

        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //This is intentional left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //also blank
            }
        });

        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Set te crime's solved property
                mCrime.setSolved(isChecked);
            }
        });
    }

    private void setDefaultProperties(){
        Log.d(TAG, "setDefaultProperties() called");

        mDateButton.setText(mCrime.getDate().toString());
        mDateButton.setEnabled(false);
    }
}
