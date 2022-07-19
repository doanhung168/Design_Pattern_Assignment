package com.example.baseproject.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baseproject.R;
import com.example.baseproject.builder.Director;
import com.example.baseproject.builder.concrete_builder.ArcherBuilder;
import com.example.baseproject.builder.concrete_builder.FighterBuilder;
import com.example.baseproject.builder.model.Archer;
import com.example.baseproject.builder.model.Fighter;
import com.example.baseproject.databinding.ActivityMainBinding;
import com.example.baseproject.singleton.GameAccountSingleton;
import com.example.baseproject.util.Util;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private final ActivityResultLauncher<Intent> mLaunchFightingActivity =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result != null && result.getResultCode() == RESULT_OK) {
                    loadAccountInfo();
                }
            });
    private final ActivityResultLauncher<Intent> mLaunchPracticingActivity =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result != null && result.getResultCode() == RESULT_OK) {
                    loadCharacterInfo();
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setTitle(getString(R.string.home));

        mBinding.btnCreateAccountWithArcher.setOnClickListener(v -> createAccountWithArcher());
        mBinding.btnCreateAccountWithFighter.setOnClickListener(v -> createAccountWithFighter());
        mBinding.btnFighting.setOnClickListener(v -> goToFighting());
        mBinding.btnPracticing.setOnClickListener(v -> goToPracticing());

    }

    private void createAccountWithArcher() {
        Util.hideKeyboard(this);
        String characterName =
                Objects.requireNonNull(mBinding.edtCharacterName.getText()).toString().trim();

        if (!validateName(characterName)) return;


        Director director = new Director();

        ArcherBuilder archerBuilder = new ArcherBuilder();
        director.createArcher(archerBuilder);

        Archer archer = archerBuilder.build();
        archer.setCharacterName(characterName);

        GameAccountSingleton.getInstance().setCharacter(archer);
        showAccountInfo();
    }

    private void createAccountWithFighter() {
        Util.hideKeyboard(this);
        String characterName =
                Objects.requireNonNull(mBinding.edtCharacterName.getText()).toString().trim();

        if (!validateName(characterName)) return;

        Director director = new Director();

        FighterBuilder fighterBuilder = new FighterBuilder();
        director.createFighter(fighterBuilder);

        Fighter fighter = fighterBuilder.build();
        fighter.setCharacterName(characterName);

        GameAccountSingleton.getInstance().setCharacter(fighter);
        showAccountInfo();
    }

    private void goToFighting() {
        mLaunchFightingActivity.launch(new Intent(this, FightingActivity.class));
    }

    private void goToPracticing() {
        mLaunchPracticingActivity.launch(new Intent(this, PracticingActivity.class));
    }


    @SuppressLint("SetTextI18n")
    private void showAccountInfo() {

        mBinding.tvAccountName.setText(GameAccountSingleton.getInstance().getCharacter().getCharacterName());

        if (GameAccountSingleton.getInstance().getCharacter() instanceof Fighter) {
            mBinding.tvCharacter.setText(getString(R.string.fighter) + "\n" +
                    GameAccountSingleton.getInstance().getCharacter().toString());
        } else {
            mBinding.tvCharacter.setText(getString(R.string.archer) + "\n" +
                    GameAccountSingleton.getInstance().getCharacter().toString());
        }

        mBinding.tvCoin.setText(String.valueOf(GameAccountSingleton.getInstance().getCoin()));
        mBinding.tvExp.setText(String.valueOf(GameAccountSingleton.getInstance().getExp()));

        mBinding.layoutCreateAccount.setVisibility(View.INVISIBLE);
        mBinding.layoutDisplayAccountInfo.setVisibility(View.VISIBLE);
    }

    public void loadAccountInfo() {
        mBinding.tvCoin.setText(String.valueOf(GameAccountSingleton.getInstance().getCoin()));
        mBinding.tvExp.setText(String.valueOf(GameAccountSingleton.getInstance().getExp()));
    }

    @SuppressLint("SetTextI18n")
    private void loadCharacterInfo() {
        if (GameAccountSingleton.getInstance().getCharacter() instanceof Fighter) {
            mBinding.tvCharacter.setText(getString(R.string.fighter) + "\n" +
                    GameAccountSingleton.getInstance().getCharacter().toString());
        } else {
            mBinding.tvCharacter.setText(getString(R.string.archer) + "\n" +
                    GameAccountSingleton.getInstance().getCharacter().toString());
        }
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private boolean validateName(@NonNull String name) {
        if (name.isEmpty()) {
            Toast.makeText(
                    HomeActivity.this,
                    getString(R.string.please_enter_character_name),
                    Toast.LENGTH_SHORT
            ).show();
            return false;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding = null;
    }
}