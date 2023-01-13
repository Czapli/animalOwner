package Logic;

import View.UserInteraction;
import domain.Enums.Gender;
import domain.Owner;
import repository.OwnerInMemoryRepository;
import repository.OwnerRepository;

import java.util.List;

public class OwnerService{
    private OwnerRepository ownerRepository = new OwnerInMemoryRepository();
    private Service service = new Service();

    public void addNew() {
        System.out.println("Crete new Owner");
        System.out.println("Insert first name: ");
        String firstname = UserInteraction.input();
        System.out.println("Insert last name:");
        String lastname = UserInteraction.input();
        Gender gender = service.getGender();
        System.out.println("Insert age");
        int age = service.getAge();
        Owner owner = new Owner(firstname, lastname, gender, age);
        ownerRepository.save(owner);
        System.out.println(owner + " has been added");
    }
    public void printAll() {
        System.out.println("return OwnerList");
        ownerRepository.getOwners().forEach(owner -> System.out.println(owner.ownerAndAnimalToString()));
    }
    public List<Owner> getAll() {
        System.out.println("return OwnerList");
        return ownerRepository.getOwners();
    }
    public void sortByNameAscending() {
        System.out.println("sort by name ascending");
        ownerRepository.sortByFirstnameAscending();
    }
    public void sortByNameDescending() {
        System.out.println("sort by name descending");
        ownerRepository.sortByFirstnameDescending();
    }
    public void sortByAgeAscending(){
        System.out.println("sort by age ascending");
        ownerRepository.sortByAgeAscending();
    }
    public void sortByAgeDescending(){
        System.out.println("sort by age descending");
        ownerRepository.sortByAgeDescending();
    }
    public void sortByNumberOfPetsAscending() {
        System.out.println("sort by number of animals ascending");
        ownerRepository.sortByNumberOfPetsAscending();
    }
    public void sortByNumberOfPetsDescending() {
        System.out.println("sort by number of animals descending");
        ownerRepository.sortByNumberOfPetsDescending();
    }
}
