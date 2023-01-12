package domain;

import domain.Enums.Gender;

public abstract class Animal {
    private String name;
    private Gender gender;
    private int age;
    private Owner owner;

    public Animal(String name, Gender gender, int age, Owner owner) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.owner = owner;
        owner.getAnimals().add(this);
    }

    public String getName() {
        return name;
    }


    public Gender getGender() {
        return gender;
    }


    public int getAge() {
        return age;
    }


    public Owner getOwner() {
        return owner;
    }


    @Override
    public String toString() {
        return "name= " + name +
                ", gender=" + gender +
                ", age=" + age +
                ", owner:\n\t" + owner.toString();
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
