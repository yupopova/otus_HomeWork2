package animals.pets;

import animals.Animal;

public class Cat extends Animal {

    public Cat (String name, int age, int weight, String color) {
        super(age, name, weight, color);
    }

    public void say() {
        System.out.println("Мяу");
    }

}
