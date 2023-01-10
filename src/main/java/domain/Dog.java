package domain;

import domain.Enums.Gender;

public class Dog extends Animal{
    private String species;

    public Dog(String name, Gender gender, int age, Owner owner, String species) {
        super(name, gender, age, owner);
        this.species = species;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
