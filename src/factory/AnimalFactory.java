package factory;

import animals.Animal;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import data.AnimalData;

public class AnimalFactory {

    private String name = "";
    private int age = -1;
    private int weight = -1;
    private String color = "";

    public AnimalFactory (String name, int age, int weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public AnimalFactory () {};

    public Animal create(AnimalData animalData) {
        switch (animalData) {
            case CAT:
                return new Cat(this.name, this.age, this.weight, this.color);
            case DOG:
                return new Dog(this.name, this.age, this.weight, this.color);
            default:
                return new Duck(this.name, this.age, this.weight, this.color);
        }
    }
}
