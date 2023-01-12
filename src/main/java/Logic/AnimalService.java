package Logic;

import View.Descriptions;
import View.UserInteraction;
import domain.*;
import domain.Enums.Gender;
import domain.Enums.Type;
import repository.AnimalInMemoryRepository;
import repository.AnimalRepository;

public class AnimalService {
    AnimalRepository animalRepository = new AnimalInMemoryRepository();
    Descriptions descriptions = new Descriptions();
    Service service = new Service();
    int inputInt = 0;

    public void addNew() {
        System.out.println("Crete new Pet");
        System.out.println("Insert name: ");
        String name = UserInteraction.input();
        Gender gender = service.getGender();
        System.out.println("Insert age");
        int age = UserInteraction.inputInt();
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
        Owner owner = service.getOwner(10);
        Animal cat = new Cat(name, gender, age, owner, species);
        animalRepository.save(cat);
    }

    private void addNewDog(String name, Gender gender, int age) {
        System.out.println("Insert species:");
        String species = UserInteraction.input();
        Owner owner = service.getOwner(15);
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
        if (type == Type.TORTOISE) owner = service.getOwner(20);
        else if (type == Type.EMYD) owner = service.getOwner(25);
        else if (type == Type.SEA_TURTLE) owner = service.getOwner(30);
        Turtle turtle = new Turtle(name, gender, age, owner, type);
        if (turtle.getType() == Type.SEA_TURTLE && turtle.getOwner().getFirstname().charAt(0) == 'M') turtle.setOwner(null);
        if (turtle.getOwner() != null) animalRepository.save(turtle);
        else System.out.println("the owner does not meet the conditions");
    }

    public void printAll() {
        animalRepository.getAll().forEach(System.out::println);
    }

    public void findByName() {
        animalRepository.getByName(UserInteraction.input()).forEach(System.out::println);
    }

    public void findByAge() {
        animalRepository.findByAge(UserInteraction.inputInt()).forEach(System.out::println);
    }

    public void findByOwnerName() {
        animalRepository.findByOwner(UserInteraction.input()).forEach(System.out::println);
    }
}
