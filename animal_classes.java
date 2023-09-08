abstract class Animal {
    private String name;
    private String type;
    private String sound;
    public Animal(String name, String type, String sound) {
        this.name = name;
        this.type = type;
        this.sound = sound;
    }
    public String getName()
    {
        return name;
    }
    public String getType()
    {
        return type;
    }
    public String getSound() { return sound;}

    public void setName(String name) { this.name = name;}
    public void setType(String type) { this.type = type;}
    public void setSound(String sound) { this.sound = sound;}
    public void run() {
        System.out.println(name + " беги!");
    }
    public void doCommand() {
        System.out.println(name + " выполняй команду!");
    }
    public void eat() {
        System.out.println(name + " кушац");
    }
    public void sleep() {
        System.out.println(name + " спать");
    }
    public abstract void say();

    @Override
    public String toString()
    {
        return "Имя: " + this.name + "\nВид: " + this.type + "\nИздаваемый звук: " +  this.sound + "\n";
    }

    @Override
    public boolean equals(Object o)
    {
        boolean result = false;
        if( o!=null && o instanceof Animal a)
        {
            if(name == a.name && type == a.type && sound == a.sound)
            {
                result = true;
            }
        }
        return result;
    }
}

class Cat extends Animal {
    private String eyeColor;
    public Cat(String name, String type, String sound, String eyeColor) {
        super(name, type, sound);
        this.eyeColor = eyeColor;
    }
    @Override
    public void say() {
        System.out.println(getSound());
    }
}

class Dog extends Animal {
    private int weight;
    public Dog(String name, String type, String sound, int weight) {
        super(name, type, sound);
        this.weight = weight;
    }
    @Override
    public void say() {
        System.out.println(getSound());
    }
}

class Horse extends Animal {
    private int weight;
    private int runningSpeed;
    public Horse(String name, String type, String sound, int weight, int runningSpeed) {
        super(name, type, sound);
        this.weight = weight;
        this.runningSpeed = runningSpeed;
    }
    @Override
    public void say() {
        System.out.println(getSound());
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
