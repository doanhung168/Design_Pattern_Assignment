package com.example.baseproject.builder.concrete_builder;

import com.example.baseproject.builder.CharacterBuilder;
import com.example.baseproject.builder.component.Attack;
import com.example.baseproject.builder.component.Energy;
import com.example.baseproject.builder.component.Movement;
import com.example.baseproject.builder.component.Pet;
import com.example.baseproject.builder.model.Archer;

public class ArcherBuilder implements CharacterBuilder {

    private int mBloodAmount;
    private Energy mEnergy;
    private Movement mMovement;
    private Attack mAttack;
    private Pet mPet;

    public void setBloodAmount(int bloodAmount) {
        this.mBloodAmount = bloodAmount;
    }

    public void setPet(Pet pet) {
        this.mPet = pet;
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

    public Archer build() {
        return new Archer(mAttack, mEnergy, mMovement, mPet, mBloodAmount);
    }


}
