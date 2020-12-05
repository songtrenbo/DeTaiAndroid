package com.example.detaiandroid;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginFragment extends Fragment implements View.OnClickListener {

    TextView txtForget;
    Button btnDangNhap;
    EditText edtSDT,edtPass;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_login, container, false);

        txtForget=view.findViewById(R.id.txtForget);
        btnDangNhap=view.findViewById(R.id.btnLogin);
        edtSDT=view.findViewById(R.id.editTextNhapSDT);
        edtPass=view.findViewById(R.id.editTextNhapMK);

        Bundle bundle=getArguments();
        if(bundle!=null) {
            edtSDT.setText(bundle.getString("SDT"));
            edtPass.setText(bundle.getString("Password"));
        }

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtSDT.getText().toString().isEmpty()){
                    edtSDT.setError("Số điện thoại không được để trống! ");
                    return;
                }
                if(edtPass.getText().toString().isEmpty()){
                    edtPass.setError("Mật khẩu không được để trống");
                    return;
                }
                if(edtPass.getText().toString().length() < 6){
                    edtPass.setError("Mật khẩu phải từ 6 số trở lên");
                }
                else {

                    Intent intent = new Intent(getActivity(), MainActivity.class);
//                    intent.putExtra("username",
//                            edtUsername.getText().toString());
//                    intent.putExtra("password",
//                            edtPassword.getText().toString());
//                    setResult(101, intent);
//                    finish();
                    startActivity(intent);
                }
                return;
            }
        });

        txtForget.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent myIntent = new Intent(getActivity(), ForgetPassActivity.class);
        getActivity().startActivity(myIntent);
    }
}