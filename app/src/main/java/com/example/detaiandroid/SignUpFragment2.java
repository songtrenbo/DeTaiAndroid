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


public class SignUpFragment2 extends Fragment {
    Button btnSXacNhan;
    EditText edtPass,edtConfirmPass;


    public SignUpFragment2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_sign_up2, container, false);

        edtPass=view.findViewById(R.id.editTextSPass);
        edtConfirmPass=view.findViewById(R.id.editTextSXNPass);
        btnSXacNhan=view.findViewById(R.id.btnSComplete);

        btnSXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtPass.getText().toString().isEmpty()){
                    edtPass.setError("Mật khẩu không được để trống! ");
                    return;
                }
                if(edtConfirmPass.getText().toString().isEmpty()){
                    edtConfirmPass.setError("Nhập lại mật khẩu không được để trống!");
                    return;
                }
                if(edtPass.getText().toString().equals(edtConfirmPass.getText().toString()))
                {
                    Intent intent=new Intent(getActivity(),LoginActivity.class);

                    startActivity(intent);
                }else {
                    edtPass.setError("Mật khẩu và mật khẩu nhập lại không trùng khớp!");
                    edtConfirmPass.setText("");
                    return;
                }
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