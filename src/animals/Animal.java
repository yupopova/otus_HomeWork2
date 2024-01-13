    package animals;

    import validators.DataValidator;
    import java.util.Scanner;
    import java.util.function.Predicate;
    import java.util.regex.Pattern;

    public abstract class Animal {
    private int age = -1;
    private String name = "";
    private int weight = -1;
    private String color = "";

    private DataValidator dataValidator = new DataValidator();

    public Animal(int age, String name, int weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public abstract void say();
    public void go() {
       System.out.println("Я иду");
    }
    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    private String getNameColorValidData(Scanner scanner) {
        String dataNameColorStr = "";
        while(true) {
            String animalNameColorStr = scanner.next();
            if (dataValidator.isDataByRegExp(animalNameColorStr, Pattern.compile("^[А-Яа-я]+$"))) {
                dataNameColorStr = animalNameColorStr;
                break;
            }
            System.out.println("Вы ввели некорректное значение. Повторите ещё раз");
        }
               return dataNameColorStr;
        }

        public void setName(Scanner scanner) {
            this.name = this.getNameColorValidData(scanner);
        }

        public void setColor(Scanner scanner) {
            this.color = this.getNameColorValidData(scanner);
        }

        private int getAgeWeightValidData(Scanner scanner, Predicate<Integer> predicate) {
        int dataAgeWeight = -1;
        while(true) {
            String animalAgeWeightStr = scanner.next();
            if(dataValidator.isDataByRegExp(animalAgeWeightStr, Pattern.compile("^\\d+$"))) {
                dataAgeWeight = Integer.parseInt(animalAgeWeightStr);
                if (predicate.test(dataAgeWeight)) {
                    System.out.println("Вы ввели некорректное значение. Повторите ещё раз");
                    continue;
                }
                break;
            }
            System.out.println("Вы ввели некорректное значение. Повторите ещё раз");
        }
        return dataAgeWeight;
    }

    public void setAge(Scanner scanner) {
        this.age = this.getAgeWeightValidData(scanner, (Integer dataAgeWeight) -> dataAgeWeight > 50 || dataAgeWeight <=0);
    }

    public void setWeight(Scanner scanner) {
          this.weight = this.getAgeWeightValidData(scanner, (Integer dataAgeWeight) -> dataAgeWeight > 40 || dataAgeWeight <=0);
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getWeight() {
        return weight;
    }
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {

        String yearPadeg = getYearPadeg();
        if(yearPadeg == null) {
            return "Возраст указан не верно";
        }

        return String.format("Привет! Меня зовут %s, мне %d %s, я вешу - %d кг, мой цвет - %s",
                this.name,
                this.age,
                yearPadeg,
                this.weight,
                this.color
        );
    }

    private String getYearPadeg() {

        if(this.age <=0 || this.age > 200) {
            return null;
        }

        if(this.age >=11 && this.age <=19) {
            return "лет";
        }

        int ostatok = this.age % 10;
        if(ostatok == 0 || ostatok >=5) {
            return "лет";
    }
        if(ostatok == 1) {
            return "год";
        }

        return "года";
    }
}
