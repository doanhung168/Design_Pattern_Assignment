package com.example.baseproject.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.baseproject.R;
import com.example.baseproject.databinding.ActivityPracticingBinding;
import com.example.baseproject.singleton.GameAccountSingleton;

import java.util.Random;

public class PracticingActivity extends AppCompatActivity {

    private ActivityPracticingBinding mBinding;
    private Random mRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityPracticingBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mRandom = new Random();
        mBinding.btnPracticing.setOnClickListener(v -> practicing());

    }

    private void practicing() {
        int extraSpeed = mRandom.nextInt(3);
        if (GameAccountSingleton.getInstance().changeAttackSpeedEnable(extraSpeed)) {
            GameAccountSingleton.getInstance().changeAttackSpeed(extraSpeed);
            Toast.makeText(
                    getApplicationContext(),
                    getString(R.string.plus_speed_message, extraSpeed),
                    Toast.LENGTH_SHORT
            ).show();
            setResult(RESULT_OK);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    getString(R.string.limit_speed_message),
                    Toast.LENGTH_SHORT
            ).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding = null;
    }
}