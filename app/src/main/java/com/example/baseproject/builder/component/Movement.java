package com.example.baseproject.builder.component;

public class Movement {
    public enum MovementType {
        WALK, RUN, BUMP, FLY
    }
    public MovementType mMovementType;
    public int mMovementSpeed;

    public Movement() {
    }

    public Movement(MovementType movementType, int movementSpeed) {
        this.mMovementType = movementType;
        this.mMovementSpeed = movementSpeed;
    }

    public MovementType getMovementType() {
        return mMovementType;
    }

    public void setMovementType(MovementType movementType) {
        this.mMovementType = movementType;
    }

    public int getMovementSpeed() {
        return mMovementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.mMovementSpeed = movementSpeed;
    }
}
