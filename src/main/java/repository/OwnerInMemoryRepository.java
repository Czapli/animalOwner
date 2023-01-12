package repository;

import domain.Owner;

import java.util.ArrayList;
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
