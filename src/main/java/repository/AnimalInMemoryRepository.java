package repository;

import domain.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class AnimalInMemoryRepository implements AnimalRepository {
    static List<Animal> animalList = new ArrayList<>();

    @Override
    public void save(Animal animal) {
        animalList.add(animal);
    }

    @Override
    public List<Animal> getAll() {
        return animalList;
    }

    @Override
    public List<Animal> getByName(String nameFragment) {
        List<Animal> fragmentNameList = new ArrayList<>();
        for (Animal animal : animalList) {
            if (animal.getName().toLowerCase().contains(nameFragment.toLowerCase())) {
                fragmentNameList.add(animal);
            }
        }
        return fragmentNameList;
    }

    @Override
    public List<Animal> findByAge(int age) {
        List<Animal> animalsInAge = new ArrayList<>();
        for (Animal animal : animalList) {
            if (animal.getAge() == age) {
                animalsInAge.add(animal);
            }
        }
        return animalsInAge;
    }

    @Override
    public List<Animal> findByOwner(String nameFragment) {
        List<Animal> fragmentNameList = new ArrayList<>();
        for (Animal animal : animalList) {
            if (animal.getOwner().getFirstname().contains(nameFragment)) {
                fragmentNameList.add(animal);
            }
        }
        return fragmentNameList;
    }
}
