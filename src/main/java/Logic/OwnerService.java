package Logic;

import View.Descriptions;
import View.UserInteraction;
import domain.Enums.Gender;
import domain.Owner;
import repository.OwnerInMemoryRepository;
import repository.OwnerRepository;

import java.util.List;

public class OwnerService{
    private OwnerRepository ownerRepository = new OwnerInMemoryRepository();
    Service service = new Service();
    String input = "";
    int inputInt = 0;

    public void addNew() {
        System.out.println("Crete new Owner");
        System.out.println("Insert first name: ");
        String firstname = UserInteraction.input();
        System.out.println("Insert last name:");
        String lastname = UserInteraction.input();
        Gender gender = service.getGender();
        System.out.println("Insert age");
        int age = UserInteraction.inputInt();
        Owner owner = new Owner(firstname, lastname, gender, age);
        ownerRepository.save(owner);
        System.out.println(owner.toString() + " has been added");
    }

    //TDD
    public void printAll() {
        System.out.println("return OwnerList");
        ownerRepository.getOwners().forEach(owner -> System.out.println(owner.ownerAndAnimalToString()));
    }

    public List<Owner> getAll() {
        System.out.println("return OwnerList");
        return ownerRepository.getOwners();
    }

    public void sortByName() {
        System.out.println("sort by name ");
    }

    public void sortByAge() {
        System.out.println("sort by age ");
    }

    public void sortByNumberOfPet() {
        System.out.println("sort by number of pets ");
    }
}
