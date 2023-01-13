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
    public int getAge() {
        System.out.println("Insert age");
        return UserInteraction.inputInt();
    }
}
