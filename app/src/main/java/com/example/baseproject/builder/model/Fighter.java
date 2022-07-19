package com.example.baseproject.builder.model;

import com.example.baseproject.builder.component.Armor;
import com.example.baseproject.builder.component.Attack;
import com.example.baseproject.builder.component.Energy;
import com.example.baseproject.builder.component.Movement;

public class Fighter extends Character {

    private Armor mArmor;

    public Fighter(Attack attack, Energy energy, Movement movement, Armor armor, int bloodAmount) {
        setBloodAmount(bloodAmount);
        setCharacterAttack(attack);
        setCharacterEnergy(energy);
        setCharacterMovement(movement);
        this.mArmor = armor;
    }

    public Armor getArmor() {
        return mArmor;
    }

    public void setArmor(Armor armor) {
        this.mArmor = armor;
    }


    @Override
    public void attack() {
        System.out.println("Fighter attack");
    }

    @Override
    public void defence() {
        System.out.println("Fighter defence");
    }

    @Override
    public void hurt() {
        System.out.println("Fighter hurt");
    }

    @Override
    public void die() {
        System.out.println("Fighter die");
    }
}
