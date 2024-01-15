import animals.Animal;
import animals.birds.IFlying;
import data.AnimalData;
import data.CommandsData;
import factory.AnimalFactory;
import validators.DataValidator;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animalList = new ArrayList<>();

        AnimalFactory animalFactory = new AnimalFactory();
        DataValidator dataValidator = new DataValidator();

        while (true) {
            System.out.println("Введите одну из команд: add / list / exit");
            String commandStr = scanner.next().toUpperCase().trim();

            if (!dataValidator.isValidate(commandStr, CommandsData.values())) {
                System.out.println("Вы ввели неверную команду");
                continue;
            }

                CommandsData commandsData = CommandsData.valueOf(commandStr);

                switch (commandsData) {
                    case ADD:
                        while (true) {
                            System.out.println("Введите тип животного: cat / dog / duck");
                            String animalTypeStr = scanner.next().toUpperCase().trim();

                            if (!dataValidator.isValidate(animalTypeStr, AnimalData.values())) {
                                System.out.println("Вы ввели неверный тип животного");
                                continue;
                            }

                        Animal animal = animalFactory.create(AnimalData.valueOf(animalTypeStr));

                        // заполнение данных об объекте через сеттеры

                        System.out.println("Введите имя животного кириллицей");
                        animal.setName(scanner);

                        System.out.println("Введите возраст животного в годах");
                        animal.setAge(scanner);

                        System.out.println("Введите вес животного в килограммах ");
                        animal.setWeight(scanner);

                        System.out.println("Введите цвет животного кириллицей");
                        animal.setColor(scanner);

                        animalList.add(animal);

                        animal.say();
                        if(animal instanceof IFlying) {
                            ((IFlying) animal).fly();
                        }


                        break;
                        }

                    case LIST:
                        if(animalList.isEmpty()) {
                            System.out.println("Список животных пуст");
                            continue;
                        }

                        for (Animal animalObj : animalList) {
                            System.out.println(animalObj.toString());
                        }
                        break;

                    case EXIT:
                        System.out.println("До скорых встреч!");
                        System.exit(0);
                }
            }
    }
}