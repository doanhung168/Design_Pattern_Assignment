package com.example.baseproject.builder;

import androidx.annotation.NonNull;

import com.example.baseproject.builder.component.Armor;
import com.example.baseproject.builder.component.Attack;
import com.example.baseproject.builder.component.Energy;
import com.example.baseproject.builder.component.Movement;
import com.example.baseproject.builder.component.Pet;
import com.example.baseproject.builder.concrete_builder.ArcherBuilder;
import com.example.baseproject.builder.concrete_builder.FighterBuilder;

import java.util.Random;

public class Director {

    public Random mBloodAmountRandom = new Random();

    /**
     * Rule: An archer always use MANA energy, attack type is SHOOT, has a pet, movement is running
     * and range of the blood amount is from 100 to 140. So we has below createArcher method
     *
     * @param builder builder of an Archer
     */
    public void createArcher(@NonNull ArcherBuilder builder) {
        builder.setEnergy(new Energy(Energy.EnergyType.MANA, 100));
        builder.setAttack(new Attack(Attack.AttackType.SHOOT, 15));
        builder.setMovement(new Movement(Movement.MovementType.RUN, 10));
        builder.setPet(new Pet());
        builder.setBloodAmount(mBloodAmountRandom.nextInt(40) + 100);
    }


    /**
     * @param builder builder of a Fighter
     */
    public void createFighter(@NonNull FighterBuilder builder) {
        builder.setEnergy(new Energy(Energy.EnergyType.INTERNAL_ENERGY, 100));
        builder.setAttack(new Attack(Attack.AttackType.SLASH, 10));
        builder.setMovement(new Movement(Movement.MovementType.RUN, 10));
        builder.setArmor(new Armor());
        builder.setBloodAmount(mBloodAmountRandom.nextInt(80) + 100);
    }

}
