package repository;

import domain.Animal;

import java.util.List;

public interface AnimalRepository {
    void save(Animal animal);
    List<Animal> getAll();
    List<Animal> getByName(String nameFragment);
    List<Animal> findByAge(int age);
    List<Animal> findByOwner(String owner);
}
