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
        return animalList.stream()
                .filter(animal -> animal.getName().contains(nameFragment))
                .collect(Collectors.toList());
//    List<Animal> fragmentNameList = new ArrayList<>();
//        for (Animal animal : animalList ) {
//            if (animal.getName().toLowerCase().contains(nameFragment.toLowerCase())){
//                fragmentNameList.add(animal);
//            }
//        }
//        return fragmentNameList;
    }

    @Override
    public List<Animal> findByAge(int age) {
        return animalList.stream()
                .filter(animal -> animal.getAge() == age)
                .collect(Collectors.toList());
    }

    @Override
    public List<Animal> findByOwner(String owner) {
        return animalList.stream()
                .filter(animal -> animal.getOwner().getFirstname().contains(owner))
                .collect(Collectors.toList());
    }
}
