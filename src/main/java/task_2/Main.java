package task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
                    cars.add(new BMW("Sedan","A280","black"));
                    break;

                case 2:
                    cars.remove(1);
                    break;

                case 3:
                    cars.stream()
                        .forEach(System.out::print);
                    break;

                case 4:
                    cars.stream().sorted();
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

abstract class Car implements Vehicle, Alarm {

    protected String type;
    protected String model;
    protected String brand;
    protected String color;
    protected int speed;

    public int increaseSpeed(int increment) {
        this.speed = this.speed + increment;
        return this.speed;
    }

    public int decreaseSpeed(int increment) {
        this.speed = this.speed - increment;
        return this.speed;
    }

}

class BMW extends Car {

    BMW(String type, String model, String color) {
        this.type = type;
        this.model = model;
        this.color = color;
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
    Mercedes(String type, String model, String color) {
        this.type = type;
        this.model = model;
        this.color = color;
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