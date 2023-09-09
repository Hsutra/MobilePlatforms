class Cat implements Animal {
    private String name;
    private String type;
    private String sound;
    private String eyeColor;

    public Cat(String name, String type, String sound, String eyeColor) {
        this.name = name;
        this.type = type;
        this.sound = sound;
        this.eyeColor = eyeColor;
    }
    @Override
    public String getName()
    {
        return name;
    }
    @Override
    public String getType()
    {
        return type;
    }
    @Override
    public String getSound()
    {
        return sound;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public void setSound(String sound) {
        this.sound = sound;
    }
    @Override
    public void run() {
        System.out.println(name + " беги!");
    }

    @Override
    public void doCommand() {
        System.out.println(name + " выполняй команду!");
    }

    @Override
    public void eat() {
        System.out.println(name + " кушац");
    }

    @Override
    public void sleep() {
        System.out.println(name + " спать");
    }

    @Override
    public void say() {
        System.out.println(getSound());
    }

    @Override
    public String toString() {
        return "Имя: " + getName() + "\nВид: " + getType() + "\nИздаваемый звук: " + getSound() + "\n";
    }

    @Override
    public boolean equals(Object o)
    {
        boolean result = false;
        if( o!=null && o instanceof Cat cat)
        {
            if(name == cat.name && type == cat.type && sound == cat.sound && eyeColor == cat.eyeColor)
            {
                result = true;
            }
        }
        return result;
    }
}

class Dog implements Animal {

    private String name;
    private String type;
    private String sound;
    private int weight;
    public Dog(String name, String type, String sound, int weight) {
        this.name = name;
        this.type = type;
        this.sound = sound;
        this.weight = weight;
    }
    @Override
    public String getName()
    {
        return name;
    }
    @Override
    public String getType()
    {
        return type;
    }
    @Override
    public String getSound()
    {
        return sound;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public void setSound(String sound) {
        this.sound = sound;
    }
    @Override
    public void run() {
        System.out.println(name + " беги!");
    }

    @Override
    public void doCommand() {
        System.out.println(name + " выполняй команду!");
    }

    @Override
    public void eat() {
        System.out.println(name + " кушац");
    }

    @Override
    public void sleep() {
        System.out.println(name + " спать");
    }

    @Override
    public void say() {
        System.out.println(getSound());
    }

    @Override
    public String toString() {
        return "Имя: " + getName() + "\nВид: " + getType() + "\nИздаваемый звук: " + getSound() + "\n";
    }

    @Override
    public boolean equals(Object o)
    {
        boolean result = false;
        if( o!=null && o instanceof Dog dog)
        {
            if(name == dog.name && type == dog.type && sound == dog.sound && weight == dog.weight)
            {
                result = true;
            }
        }
        return result;
    }
}

class Horse implements Animal {
    private String name;
    private String type;
    private String sound;
    private int weight;
    private int runningSpeed;
    public Horse(String name, String type, String sound, int weight, int runningSpeed) {
        this.name = name;
        this.type = type;
        this.sound = sound;
        this.weight = weight;
        this.runningSpeed = runningSpeed;
    }
    @Override
    public String getName()
    {
        return name;
    }
    @Override
    public String getType()
    {
        return type;
    }
    @Override
    public String getSound()
    {
        return sound;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public void setSound(String sound) {
        this.sound = sound;
    }
    @Override
    public void run() {
        System.out.println(name + " беги!");
    }

    @Override
    public void doCommand() {
        System.out.println(name + " выполняй команду!");
    }

    @Override
    public void eat() {
        System.out.println(name + " кушац");
    }

    @Override
    public void sleep() {
        System.out.println(name + " спать");
    }

    @Override
    public void say() {
        System.out.println(getSound());
    }

    @Override
    public String toString() {
        return "Имя: " + getName() + "\nВид: " + getType() + "\nИздаваемый звук: " + getSound() + "\n";
    }

    @Override
    public boolean equals(Object o)
    {
        boolean result = false;
        if( o!=null && o instanceof Horse horse)
        {
            if(name == horse.name && type == horse.type && sound == horse.sound && weight == horse.weight && runningSpeed == horse.runningSpeed)
            {
                result = true;
            }
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {

        Animal[] animals = new Animal[9];
        animals[0] = new Cat("Мурзик", "Кот", "мяу", "Зеленый");
        animals[1] = new Dog("Султан", "Собака", "гав", 25);
        animals[2] = new Horse("Осел", "Лошадь", "пфпфпф", 550, 70);
        animals[3] = new Cat("Барсик", "Кот", "мяу", "Голубой");
        animals[4] = new Dog("Всеволод", "Собака", "гав гав", 30);
        animals[5] = new Horse("Ишак", "Лошадь", "игого", 600, 75);
        animals[6] = new Cat("Мурзик", "Кот", "мяу", "Зеленый");
        animals[7] = new Dog("Глеб", "Собака", "мяу", 20);
        animals[8] = new Horse("Зуфар", "Лошадь", "игого", 500, 65);

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
        System.out.println(animals[0].equals(animals[6]));
    }
}
