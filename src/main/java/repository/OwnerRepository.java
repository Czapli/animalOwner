package repository;

import domain.Owner;

import java.util.List;

public interface OwnerRepository {
    void save(Owner owner);
    List<Owner> getOwners();
}
