package repository;

import domain.Owner;

import java.util.ArrayList;
import java.util.List;

public class OwnerRepository {

    List<Owner> ownerList = new ArrayList<>();

    void save(Owner owner) {
        ownerList.add(owner);
    }

    List<Owner> getOwners() {
        return ownerList;

    }
    void sortByFirstnameAscending(){
        ownerList.sort(Owner::compareByFirstname);
    }
    void sortByAge(){
        ownerList.sort(Owner::compareByAge);
    }
    void sortByNumberOfPets(){
        ownerList.sort(Owner::compareByNumberOfPets);
    }
}
