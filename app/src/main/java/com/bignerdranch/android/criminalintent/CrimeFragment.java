package com.bignerdranch.android.criminalintent;


import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Anthony on 10/14/2015.
 */
public class CrimeFragment extends Fragment{
    private Crime mCrime;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }
}