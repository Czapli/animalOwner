package Logic;

import View.Descriptions;
import View.UserInteraction;
import domain.*;
import domain.Enums.Gender;
import domain.Enums.Type;
import repository.AnimalInMemoryRepository;
import repository.AnimalRepository;
import repository.OwnerInMemoryRepository;
import repository.OwnerRepository;

import java.util.List;

public class AnimalService {
    private AnimalRepository animalRepository = new AnimalInMemoryRepository();
    private OwnerRepository ownerRepository = new OwnerInMemoryRepository();
    private Descriptions descriptions = new Descriptions();
    private Service service = new Service();
    int inputInt = 0;

    public void addNew() {
        System.out.println("Crete new Pet");
        System.out.println("Insert name: ");
        String name = UserInteraction.input();
        Gender gender = service.getGender();
        int age = service.getAge();
        System.out.println("Chose type of Pet:\n1-cat\n2-dog\n3-turtle");
        inputInt = UserInteraction.inputInt();
        switch (inputInt) {
            case 1 -> addNewCat(name, gender, age);
            case 2 -> addNewDog(name, gender, age);
            case 3 -> addNewTurtle(name, gender, age);
            default -> descriptions.badInput();
        }
    }

    private void addNewCat(String name, Gender gender, int age) {
        System.out.println("Insert species:");
        String species = UserInteraction.input();
        Owner owner = getOwner(10,false);
        Animal cat = new Cat(name, gender, age, owner, species);
        animalRepository.save(cat);
    }

    private void addNewDog(String name, Gender gender, int age) {
        System.out.println("Insert species:");
        String species = UserInteraction.input();
        Owner owner = getOwner(15,false);
        Animal dog = new Dog(name, gender, age, owner, species);
        animalRepository.save(dog);
    }

    private void addNewTurtle(String name, Gender gender, int age) {
        System.out.println("Insert Gender: \n1-tortoise\n2-emyd\n3-sea turtle");
        Type type = null;
        do {
            inputInt = UserInteraction.inputInt();
            switch (inputInt) {
                case 1 -> type = Type.EMYD;
                case 2 -> type = Type.TORTOISE;
                case 3 -> type = Type.SEA_TURTLE;
                default -> descriptions.badInput();
            }

        } while (type == null);
        Owner owner = null;
        switch (type) {
            case TORTOISE -> owner = getOwner(20, false);
            case EMYD -> owner = getOwner(25, false);
            case SEA_TURTLE -> owner = getOwner(25, true);
        }
        Turtle turtle = new Turtle(name, gender, age, owner, type);
        animalRepository.save(turtle);
    }
    private Owner getOwner(int age, boolean isSeaTurtle) {
        System.out.println("Assign owner from list:");
        List<Owner> owners = ownerRepository.getOwners();
        for (int i = 0; i < owners.size(); i++) {
            System.out.println(i + " - " + owners.get(i).toString());
        }
        Owner owner = null;
        do {
            inputInt = UserInteraction.inputInt();
            try {
                Owner tempOwner = owners.get(inputInt);
                if (tempOwner.getAnimals().size() < 3
                        && tempOwner.getAge() >= age
                        && !isSeaTurtle) {
                    owner = tempOwner;
                } else if(tempOwner.getAnimals().size() < 3
                        && tempOwner.getAge() >= age
                        && isSeaTurtle
                        && tempOwner.getFirstname().charAt(0)=='M') {
                    owner = tempOwner;
                }
                if (tempOwner.getAnimals().size() > 2) System.out.println("Owner has too many pets");
                if (tempOwner.getAge() < age) System.out.println("Owner is too young");
                if (isSeaTurtle && tempOwner.getFirstname().charAt(0)!='M') System.out.println("Owner first name must start on 'M'");
            } catch (IndexOutOfBoundsException e) {
                descriptions.badInput();
            }
        } while (owner == null);
        return owner;
    }

    public List<Animal> getAll(){
        return animalRepository.getAll();
    }
    public void printAll(List<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal.animalAndOwnerToString());
        }
    }

    public void findByName() {
        System.out.println("Insert name");
        List<Animal> animals = animalRepository.getByName(UserInteraction.input());
        printAll(animals);
    }

    public void findByAge() {
        System.out.println("Insert age");
        List<Animal> animals = animalRepository.findByAge(UserInteraction.inputInt());
        printAll(animals);
    }

    public void findByOwnerName() {
        System.out.println("Insert owner first name");
        List<Animal> animals = animalRepository.findByOwner(UserInteraction.input());
        printAll(animals);
    }
}
