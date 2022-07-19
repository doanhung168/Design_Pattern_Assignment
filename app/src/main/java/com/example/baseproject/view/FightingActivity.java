package com.example.baseproject.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.baseproject.R;
import com.example.baseproject.databinding.ActivitySecondBinding;
import com.example.baseproject.singleton.GameAccountSingleton;

import java.util.Random;

public class FightingActivity extends AppCompatActivity {

    private ActivitySecondBinding mBinding;
    private Random mRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setTitle(getString(R.string.fighting));
        mRandom = new Random();
        mBinding.btnFighting.setOnClickListener(v -> fighting());

    }

    private void fighting() {
        int extraExp = mRandom.nextInt(100) + 500;
        int extraCoin = mRandom.nextInt(100) + 100;

        GameAccountSingleton.getInstance().changeExp(extraExp);
        GameAccountSingleton.getInstance().changeCoin(extraCoin);
        setResult(RESULT_OK);

        Toast.makeText(
                getApplicationContext(),
                getString(R.string.plus_message, extraExp, extraCoin),
                Toast.LENGTH_SHORT
        ).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding = null;
    }
}