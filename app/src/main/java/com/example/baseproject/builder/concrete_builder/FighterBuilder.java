package com.example.baseproject.builder.concrete_builder;

import com.example.baseproject.builder.CharacterBuilder;
import com.example.baseproject.builder.component.Armor;
import com.example.baseproject.builder.component.Attack;
import com.example.baseproject.builder.component.Energy;
import com.example.baseproject.builder.component.Movement;
import com.example.baseproject.builder.model.Fighter;

public class FighterBuilder implements CharacterBuilder {

    private int mBloodAmount;
    private Energy mEnergy;
    private Movement mMovement;
    private Attack mAttack;
    private Armor mArmor;

    public void setBloodAmount(int bloodAmount) {
        this.mBloodAmount = bloodAmount;
    }

    public void setArmor(Armor armor) {
        this.mArmor = armor;
    }

    @Override
    public void setAttack(Attack attack) {
        this.mAttack = attack;
    }

    @Override
    public void setEnergy(Energy energy) {
        this.mEnergy = energy;
    }

    @Override
    public void setMovement(Movement movement) {
        this.mMovement = movement;
    }

    public Fighter build() {
        return new Fighter(mAttack, mEnergy, mMovement, mArmor, mBloodAmount);
    }
}
