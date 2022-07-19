package com.example.baseproject.singleton;

import com.example.baseproject.builder.model.Character;

public class GameAccountSingleton {

    // name of character == nickname of account
    private Character mCharacter;
    private long mExp;
    private long mCoin;

    private static GameAccountSingleton instance;

    private GameAccountSingleton() {
        this.mExp = 100;
        this.mCoin = 3000;
    }

    public static GameAccountSingleton getInstance() {
        synchronized (GameAccountSingleton.class) {
            if (instance == null) {
                instance = new GameAccountSingleton();
                return instance;
            }
            return instance;
        }
    }

    public Character getCharacter() {
        return mCharacter;
    }

    public void setCharacter(Character character) {
        this.mCharacter = character;
    }

    public long getExp() {
        return mExp;
    }


    public long getCoin() {
        return mCoin;
    }

    public void changeExp(int changedExpAmount) {
        this.mExp += changedExpAmount;
    }

    public void changeCoin(int changedCoinAmount) {
        this.mCoin += changedCoinAmount;
    }

    public void changeAttackSpeed(int changedSpeedAmount) {
        mCharacter.getCharacterAttack().setAttackSpeed(
                mCharacter.getCharacterAttack().getAttackSpeed() + changedSpeedAmount
        );
    }

    public boolean changeAttackSpeedEnable(int plusSpeed) {
        return mCharacter.getCharacterAttack().getAttackSpeed() + plusSpeed <= 30;
    }
}
