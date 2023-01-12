package domain;

import domain.Enums.Gender;

import java.util.ArrayList;
import java.util.List;

public class Owner {
    private String firstname;
    private String lastname;
    private Gender gender;
    private int age;
    List<Animal> animals = new ArrayList();

    public Owner(String firstname, String lastname, Gender gender, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public List<Animal> getAnimals() {
        return animals;
    }


    public String ownerAndAnimalToString() {
        StringBuilder animalList = new StringBuilder();
        if (animals.size() > 0) {
            animals.forEach(animal -> animalList.append(animal));
            return toString() + "\n is owner: " + animalList.toString();
        }
        return toString();
    }

    @Override
    public String toString() {
        return "First Name: " + firstname +
                ", Last Name: " + lastname +
                ", gender: " + gender +
                ", age: " + age;
    }

    public int compareByFirstname(Owner o1) {
        return this.getFirstname().compareTo(o1.getFirstname());
    }

    public int compareByAge(Owner o1) {
        return this.getAge() - (o1.getAge());
    }

    public int compareByNumberOfPets(Owner o1) {
        return this.getAnimals().size() - (o1.getAnimals().size());
    }

//    @Override
//    public int compare(Owner o1, Owner o2) {
//        return 0;
//    }
}
