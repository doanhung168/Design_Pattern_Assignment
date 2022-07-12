package com.example.baseproject;

public class PersonSingleton {

    private static PersonSingleton instance;

    private String mName;
    private int mAge;
    private String mAddress;

    private PersonSingleton(String name, int age, String address) {
        this.mName = name;
        this.mAge = age;
        this.mAddress = address;
    }

    public static PersonSingleton getInstance() {
        synchronized (PersonSingleton.class) {
            if (instance == null) {
                instance = new PersonSingleton("Hung", 22, "Nghệ An");
                return instance;
            }
            return instance;
        }
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        this.mAge = age;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        this.mAddress = address;
    }
}
