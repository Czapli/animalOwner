package View;

public class Descriptions {

    public void mainMenu() {
        System.out.println("Main Menu: ");
        System.out.println("press: ");
        System.out.println("1 - go to Owners menu");
        System.out.println("2 - go to Animals menu");
        System.out.println("3 - exit program");
    }

    public void ownerMenu() {
        System.out.println("Owner Menu: ");
        System.out.println("press: ");
        System.out.println("1 - to add new Owner");
        System.out.println("2 - to print all Owners");
        System.out.println("3 - to sort Owners");
        System.out.println("4 - go to Main Menu");
    }
    public void sortMenu() {
        System.out.println("Sort Menu: ");
        System.out.println("press: ");
        System.out.println("1 - to sort by name ascending");
        System.out.println("2 - to sort by name descending");
        System.out.println("3 - to sort by age ascending");
        System.out.println("4 - to sort by age descending");
        System.out.println("5 - to sort by number of pets ascending");
        System.out.println("6 - to sort by number of pets descending");
        System.out.println("7 - go to Main Menu");
    }

    public void animalMenu() {
        System.out.println("Animal Menu: ");
        System.out.println("press: ");
        System.out.println("1 - to add new Pet");
        System.out.println("2 - to print all Animals");
        System.out.println("3 - to find Animal");
        System.out.println("4 - go to Main Menu");
    }
    public void findMenu() {
        System.out.println("Find Menu: ");
        System.out.println("press: ");
        System.out.println("1 - to find Pet by name");
        System.out.println("2 - to find Animals by age");
        System.out.println("3 - to find Animal by Owner name");
        System.out.println("4 - go to Main Menu");
    }
    public void badInput() {
        System.out.println("wrong input - try one more");
    }
}
