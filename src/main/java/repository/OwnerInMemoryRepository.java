package repository;

import domain.Owner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OwnerInMemoryRepository implements OwnerRepository {

    static List<Owner> ownerList = new ArrayList<>();

    @Override
    public void save(Owner owner) {
        ownerList.add(owner);
        System.out.println("save to repository:\n" + owner.toString());
    }

    @Override
    public List<Owner> getOwners() {
        return ownerList;
    }

    @Override
    public void sortByFirstnameAscending() {
        ownerList.sort((o1, o2) -> o1.getFirstname().compareTo(o2.getLastname()));
    }

    @Override
    public void sortByFirstnameDescending() {
        ownerList.sort((o1, o2) -> o2.getFirstname().compareTo(o1.getLastname()));
    }

    @Override
    public void sortByAgeAscending() {
        ownerList.sort((o1, o2) -> o1.getAge() - o2.getAge());
    }

    @Override
    public void sortByAgeDescending() {

        ownerList.sort((o1, o2) -> o2.getAge() - o1.getAge());
    }

    @Override
    public void sortByNumberOfPetsAscending() {
        ownerList.sort((o1, o2) -> o1.getAnimals().size()-o2.getAnimals().size());
    }

    @Override
    public void sortByNumberOfPetsDescending() {

        ownerList.sort((o1, o2) -> o2.getAnimals().size()-o1.getAnimals().size());
    }

}
