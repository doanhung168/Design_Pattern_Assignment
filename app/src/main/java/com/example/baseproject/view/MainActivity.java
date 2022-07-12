package com.example.baseproject.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baseproject.PersonSingleton;
import com.example.baseproject.R;
import com.example.baseproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    private final ActivityResultLauncher<Intent> mActivityResultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK) {
                    loadDataAndDisplay();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setTitle(getString(R.string.info));

        loadDataAndDisplay();
        actionClickEditBtn();

    }

    private void loadDataAndDisplay() {
        mBinding.tvName.setText(PersonSingleton.getInstance().getName());
        mBinding.tvAge.setText(String.valueOf(PersonSingleton.getInstance().getAge()));
        mBinding.tvAddress.setText(PersonSingleton.getInstance().getAddress());
    }

    private void actionClickEditBtn() {
        mBinding.btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            mActivityResultLauncher.launch(intent);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding = null;
    }
}