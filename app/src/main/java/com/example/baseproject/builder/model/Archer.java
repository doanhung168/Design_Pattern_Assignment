package com.example.baseproject.builder.model;


import com.example.baseproject.builder.component.Attack;
import com.example.baseproject.builder.component.Energy;
import com.example.baseproject.builder.component.Movement;
import com.example.baseproject.builder.component.Pet;

public class Archer extends Character {

    private Pet mPet;

    public Archer(Attack attack, Energy energy, Movement movement, Pet pet, int bloodAmount) {
        setBloodAmount(bloodAmount);
        setCharacterAttack(attack);
        setCharacterEnergy(energy);
        setCharacterMovement(movement);
        this.mPet = pet;
    }

    public Pet getPet() {
        return mPet;
    }

    public void setPet(Pet pet) {
        this.mPet = pet;
    }

    @Override
    public void attack() {
        System.out.println("Archer attack");
    }

    @Override
    public void defence() {
        System.out.println("Archer defence");
    }

    @Override
    public void hurt() {
        System.out.println("Archer hurt");
    }

    @Override
    public void die() {
        System.out.println("Archer die");
    }

}
