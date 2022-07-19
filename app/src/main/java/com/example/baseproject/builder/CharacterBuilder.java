package com.example.baseproject.builder;

import com.example.baseproject.builder.component.Attack;
import com.example.baseproject.builder.component.Energy;
import com.example.baseproject.builder.component.Movement;

public interface CharacterBuilder {
    void setAttack(Attack attack);
    void setEnergy(Energy energy);
    void setMovement(Movement movement);
}
