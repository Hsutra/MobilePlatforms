public interface Animal {
    String getName();

    String getType();

    String getSound();

    void setName(String name);

    void setType(String type);

    void setSound(String sound);

    void run();

    void doCommand();

    void eat();

    void sleep();

    void say();

    String toString();

    boolean equals(Object o);
}
