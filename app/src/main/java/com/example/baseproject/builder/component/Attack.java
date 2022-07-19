package com.example.baseproject.builder.component;

public class Attack {

    public enum AttackType {
        PUNCH, SHOOT, THROW, SLASH
    }

    public AttackType mAttackType;
    public int mAttackSpeed;

    public Attack() {
    }

    public Attack(AttackType attackType, int attackSpeed) {
        this.mAttackType = attackType;
        this.mAttackSpeed = attackSpeed;
    }

    public AttackType getAttackType() {
        return mAttackType;
    }

    public void setAttackType(AttackType attackType) {
        this.mAttackType = attackType;
    }

    public int getAttackSpeed() {
        return mAttackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.mAttackSpeed = attackSpeed;
    }
}
