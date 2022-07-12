package com.example.baseproject.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.baseproject.PersonSingleton;
import com.example.baseproject.R;
import com.example.baseproject.databinding.ActivitySecondBinding;
import com.example.baseproject.util.Util;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setTitle(getString(R.string.edit_info));

        loadDataAndDisplay();
        actionClickSaveBtn();
    }

    @SuppressWarnings("ConstantConditions")
    private void actionClickSaveBtn() {
        mBinding.btnSave.setOnClickListener(v -> {
            Util.hideKeyboard(SecondActivity.this);
            String name = mBinding.edtName.getText().toString().trim();
            String age = mBinding.edtAge.getText().toString().trim();
            String address = mBinding.edtAddress.getText().toString().trim();

            if (!validateName(name)) return;
            if (!validateAge(age)) return;
            if (!validateAddress(address)) return;

            PersonSingleton.getInstance().setName(name);
            PersonSingleton.getInstance().setAge(Integer.parseInt(age));
            PersonSingleton.getInstance().setAddress(address);

            Intent intent = new Intent();
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }

    private boolean validateName(String name) {
        if (name.isEmpty()) {
            Toast.makeText(
                    SecondActivity.this,
                    getString(R.string.please_enter_your_name),
                    Toast.LENGTH_SHORT
            ).show();
            return false;
        }
        return true;
    }

    private boolean validateAge(String age) {
        if (age.isEmpty()) {
            Toast.makeText(
                    SecondActivity.this,
                    getString(R.string.please_enter_your_age),
                    Toast.LENGTH_SHORT
            ).show();
            return false;
        }
        int _age = Integer.parseInt(age); // always true due to inputType of Edittext is number
        if (_age < 1 || _age > 150) {
            Toast.makeText(
                    SecondActivity.this,
                    getString(R.string.please_enter_your_age_in_format),
                    Toast.LENGTH_SHORT
            ).show();
            return false;
        }
        return true;
    }

    private boolean validateAddress(String address) {
        if (address.isEmpty()) {
            Toast.makeText(
                    SecondActivity.this,
                    getString(R.string.please_enter_your_address),
                    Toast.LENGTH_SHORT
            ).show();
            return false;
        }
        return true;
    }

    private void loadDataAndDisplay() {
        mBinding.edtName.setText(PersonSingleton.getInstance().getName());
        mBinding.edtAge.setText(String.valueOf(PersonSingleton.getInstance().getAge()));
        mBinding.edtAddress.setText(PersonSingleton.getInstance().getAddress());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding = null;
    }
}