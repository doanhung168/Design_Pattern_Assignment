package com.example.baseproject.builder.model;

import androidx.annotation.NonNull;

import com.example.baseproject.builder.component.Attack;
import com.example.baseproject.builder.component.Energy;
import com.example.baseproject.builder.component.Movement;

public abstract class Character {
    private String mCharacterName;
    private int mBloodAmount;
    private Energy characterEnergy;
    private Movement characterMovement;
    private Attack characterAttack;


    public String getCharacterName() {
        return mCharacterName;
    }

    public void setCharacterName(String characterName) {
        this.mCharacterName = characterName;
    }

    public int getBloodAmount() {
        return mBloodAmount;
    }

    public void setBloodAmount(int bloodAmount) {
        this.mBloodAmount = bloodAmount;
    }

    public Energy getCharacterEnergy() {
        return characterEnergy;
    }

    public void setCharacterEnergy(Energy characterEnergy) {
        this.characterEnergy = characterEnergy;
    }

    public Movement getCharacterMovement() {
        return characterMovement;
    }

    public void setCharacterMovement(Movement characterMovement) {
        this.characterMovement = characterMovement;
    }

    public Attack getCharacterAttack() {
        return characterAttack;
    }

    public void setCharacterAttack(Attack characterAttack) {
        this.characterAttack = characterAttack;
    }

    @NonNull
    @Override
    public String toString() {
        return "Attack type: " + characterAttack.mAttackType +
                "\nAttack speed: " + characterAttack.mAttackSpeed;
    }

    public abstract void attack();

    public abstract void defence();

    public abstract void hurt();

    public abstract void die();
}
