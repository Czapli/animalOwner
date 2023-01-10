package domain;

import domain.Enums.Gender;
import domain.Enums.Type;

public class Turtle extends Animal{
    private Type type;

    public Turtle(String name, Gender gender, int age, Owner owner, Type type) {
        super(name, gender, age, owner);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
