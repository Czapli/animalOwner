package domain.Enums;

public enum Type {
    TORTOISE("tortose"), EMYD("emyd"), SEA_TURTLE("sea turtle");
    private String description;

    Type(String description) {
        this.description = description;
    }
}
