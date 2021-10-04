package task_2;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    static List<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner scannerForAddingBMW = new Scanner(System.in);
        Scanner scannerForAddingMercedes = new Scanner(System.in);

        int choice;
        while (true) {
            System.out.println("Main Menu\n");
            System.out.print("1.) Add BMW car. \n");
            System.out.print("2.) Add Mercedes car. \n");
            System.out.print("3.) Remove car.\n");
            System.out.print("4.) Show cars.\n");
            System.out.print("5.) Sort cars by brand.\n");
            System.out.print("6.) Exit\n");
            System.out.print("\nEnter Your Menu Choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Please write type of the car:");
                    String typeNameBMW = scannerForAddingBMW.nextLine();

                    System.out.println("Please write model of the car:");
                    String modelNameBMW = scannerForAddingBMW.nextLine();

                    System.out.println("Please write color of the car:");
                    String colorNameBMW = scannerForAddingBMW.nextLine();

                    System.out.println("Please write speed of the car:");
                    int speedBMW = scannerForAddingBMW.nextInt();

                    cars.add(new BMW(typeNameBMW, modelNameBMW, "BMW", colorNameBMW, speedBMW));
                    break;

                case 2:

                    System.out.println("Please write type of the car:");
                    String typeNameMercedes = scannerForAddingMercedes.nextLine();

                    System.out.println("Please write model of the car:");
                    String modelNameMercedes = scannerForAddingMercedes.nextLine();

                    System.out.println("Please write color of the car:");
                    String colorNameMercedes = scannerForAddingMercedes.nextLine();

                    System.out.println("Please write speed of the car:");
                    int speedMercedes = scannerForAddingMercedes.nextInt();

                    cars.add(new Mercedes(typeNameMercedes, modelNameMercedes, "Mercedes", colorNameMercedes, speedMercedes));

                    break;

                case 3:

                    System.out.println("Please write number of object to remove:");
                    int choiceRemove = input.nextInt();

                    cars.remove(choiceRemove);
                    break;

                case 4:

                    cars.stream()
                            .forEach(System.out::print);

                    break;

                case 5:

                    Collections.sort(cars);
                    break;

                case 6:

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
                "} \n";
    }

    @Override
    public int compareTo(Car o) {
        int result;
        result = this.brand.compareTo(o.brand);
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