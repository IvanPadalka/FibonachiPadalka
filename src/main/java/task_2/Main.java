package task_2;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    static List<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int choice;
        while (true) {
            System.out.println("Main Menu\n");
            System.out.print("1.) Add car. \n");
            System.out.print("2.) Remove car.\n");
            System.out.print("3.) Show cars.\n");
            System.out.print("4.) Sort cars.\n");
            System.out.print("5.) Exit\n");
            System.out.print("\nEnter Your Menu Choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("Please write type of the car:");
                    String typeName = input.nextLine();

                    System.out.println("Please write model of the car:");
                    String modelName = input.nextLine();

                    System.out.println("Please write brand of the car:");
                    String brandName = input.nextLine();;

                    System.out.println("Please write color of the car:");
                    String colorName = input.nextLine();

                    System.out.println("Please write speed of the car:");
                    int speed = input.nextInt();

                    cars.add(new BMW(typeName, modelName, brandName, colorName, speed));
                    break;

                case 2:

                    System.out.println("Please write number of object to remove:");
                    int choiceRemove = input.nextInt();

                    cars.remove(choiceRemove);
                    break;

                case 3:

                    cars.stream()
                            .forEach(System.out::print);

                    break;

                case 4:

                    Collections.sort(cars);
                    break;

                case 5:

                    System.out.println("Exiting Program...");
                    System.exit(0);

                    break;
                default:

                    System.out.println("This is not a valid Menu Option! Please Select Another");
                    break;

            }
        }
    }

}

interface Alarm {

    default void turnAlarmOn() {
        System.out.println("Alarm is on");
    }

    default void turnAlarmOff() {
        System.out.println("Alarm is off");
    }

}

interface Vehicle {

    String getBrand();

    int increaseSpeed(int increment);

    int decreaseSpeed(int increment);

}

abstract class Car implements Vehicle, Alarm, Comparable<Car> {

    protected String type;
    protected String model;
    protected String brand;
    protected String color;
    protected int speed;

    public Car(String type, String model, String brand, String color, int speed) {
        this.type = type;
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.speed = speed;
    }

    public int increaseSpeed(int increment) {
        this.speed = this.speed + increment;
        return this.speed;
    }

    public int decreaseSpeed(int increment) {
        this.speed = this.speed - increment;
        return this.speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", speed=" + speed +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        int result;
        if (this.speed > o.speed) {
            result = 1;
        } else {
            result = 0;
        }
        return result;

    }
}

class BMW extends Car {

    public BMW(String type, String model, String brand, String color, int speed) {
        super(type, model, brand, color, speed);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

class Mercedes extends Car {


    public Mercedes(String type, String model, String brand, String color, int speed) {
        super(type, model, brand, color, speed);
    }

    public String getBrand() {
        return model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}