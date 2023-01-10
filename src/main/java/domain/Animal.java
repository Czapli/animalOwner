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
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
        owner.getAnimals().add(this);
    }

    public String animalAndOwnerToString(){
        return toString() + " \n have owner: " + owner.toString();
    }

    @Override
    public String toString() {
        return
                "name='" + name +
                ", gender=" + gender +
                ", age=" + age;
    }
}
