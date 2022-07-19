package com.example.baseproject.builder.component;

public class Energy {
    public enum EnergyType {
        NONE, MANA, INTERNAL_ENERGY
    }
    private EnergyType mEnergyType;
    private int mAmount;

    public Energy() {
    }

    public Energy(EnergyType energyType, int amount) {
        this.mEnergyType = energyType;
        this.mAmount = amount;
    }

    public EnergyType getEnergyType() {
        return mEnergyType;
    }

    public void setEnergyType(EnergyType energyType) {
        this.mEnergyType = energyType;
    }

    public int getAmount() {
        return mAmount;
    }

    public void setAmount(int amount) {
        this.mAmount = amount;
    }
}
