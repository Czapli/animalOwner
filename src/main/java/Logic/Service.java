package Logic;

import View.Descriptions;
import View.UserInteraction;
import domain.Enums.Gender;
import domain.Owner;
import repository.OwnerInMemoryRepository;
import repository.OwnerRepository;

import java.util.List;

public class Service {
    int inputInt = 0;
    private Descriptions descriptions = new Descriptions();
    private OwnerRepository ownerRepository = new OwnerInMemoryRepository();

    Gender getGender() {
        System.out.println("Insert Gender: \n1-male\n2-female");
        Gender gender = null;
        do {
            inputInt = UserInteraction.inputInt();
            switch (inputInt) {
                case 1 -> gender = Gender.MALE;
                case 2 -> gender = Gender.FEMALE;
                default -> descriptions.badInput();
            }

        } while (gender == null);
        return gender;
    }

    Owner getOwner(int age) {
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
                if (tempOwner.getAnimals().size() < 3 && tempOwner.getAge() >= age) {
                    owner = tempOwner;
                }
                if (tempOwner.getAnimals().size() > 2) System.out.println("Owner has too many pets");
                if (tempOwner.getAge() < age) System.out.println("Owner is too young");
            } catch (IndexOutOfBoundsException e) {
                descriptions.badInput();
            }
        } while (owner == null);
        return owner;
    }
}
