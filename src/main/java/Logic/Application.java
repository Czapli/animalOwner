package Logic;

import View.Descriptions;
import View.UserInteraction;

public class Application {
    private Descriptions descriptions = new Descriptions();
    private OwnerService ownerService = new OwnerService();
    private AnimalService animalService = new AnimalService();
    String menuChose = "";

    public void start() {
        boolean isEnd = false;
        while (!isEnd) {
            descriptions.mainMenu();
            menuChose = UserInteraction.input();
            switch (menuChose) {
                case "1" -> ownerMenu();
                case "2" -> animalMenu();
                case "3" -> isEnd = true;
                default -> descriptions.badInput();
            }
        }
    }

    public void ownerMenu() {
        boolean isEnd = false;
        while (!isEnd) {
            descriptions.ownerMenu();
            menuChose = UserInteraction.input();
            switch (menuChose) {
                case "1" -> ownerService.addNew();
                case "2" -> ownerService.printAll();
                case "3" -> sortMenu();
                case "4" -> isEnd = true;
                default -> descriptions.badInput();
            }
        }
    }

    private void sortMenu() {
        boolean isEnd = false;
        while (!isEnd) {
            descriptions.sortMenu();
            menuChose = UserInteraction.input();
            switch (menuChose) {
                case "1" -> ownerService.sortByNameAscending();
                case "2" -> ownerService.sortByNameDescending();
                case "3" -> ownerService.sortByAgeAscending();
                case "4" -> ownerService.sortByAgeDescending();
                case "5" -> ownerService.sortByNumberOfPetsAscending();
                case "6" -> ownerService.sortByNumberOfPetsDescending();
                case "7" -> isEnd = true;
                default -> descriptions.badInput();
            }
        }
    }

    public void animalMenu() {
        boolean isEnd = false;
        while (!isEnd) {
            descriptions.animalMenu();
            menuChose = UserInteraction.input();
            switch (menuChose) {
                case "1" -> animalService.addNew();
                case "2" -> animalService.printAll(animalService.getAll());
                case "3" -> findMenu();
                case "4" -> isEnd = true;
                default -> descriptions.badInput();
            }
        }
    }

    public void findMenu() {
        boolean isEnd = false;
        while (!isEnd) {

            descriptions.findMenu();
            menuChose = UserInteraction.input();
            switch (menuChose) {
                case "1" -> animalService.findByName();
                case "2" -> animalService.findByAge();
                case "3" -> animalService.findByOwnerName();
                case "4" -> isEnd = true;
                default -> descriptions.badInput();
            }
        }
    }
}
