package com.example.detaiandroid;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpFragment extends Fragment {

    Button btnContinue;
    EditText edtSDT;

    public SignUpFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_sign_up, container, false);

        btnContinue=view.findViewById(R.id.btnContinue);
        edtSDT=view.findViewById(R.id.editTextSSDT);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edtSDT.getText().toString().isEmpty()){
                    edtSDT.setError("Số điện thoại không được để trống!");
                }
                else {
                    SignUpFragment2 signUpFragment2=new SignUpFragment2();
                    replaceFragment(signUpFragment2);
                }
                return;
            }
        });
        return view;
    }


    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}