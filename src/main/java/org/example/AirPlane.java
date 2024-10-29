package org.example;

import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AirPlane {

    private static final Set<String> TYPES_AIRPLANES = new HashSet<>(Arrays.asList(
            "Commercial", "Cargo", "Private", "Military", "Helicopter",
            "Glider", "Airship", "Seaplane", "Fighter", "Bomber"
    ));

    private static final Set<String> MODELS_AIRPLANES = new HashSet<>(Arrays.asList(
            "BOEING-747", "AIRBUS-A380", "CESSNA-172", "GULFSTREAM-G650",
            "BOMBARDIER-CRJ200", "EMBRAER-ERJ145", "LOCKHEED-C130",
            "PIPER-PA28", "DASSAULT-FALCON-900", "BEECHCRAFT-KING-AIR"
    ));

    private String type;
    private String model;
    private String number;
    private int capacity;
    private String color;
    private String pilot_name;
    private String pilot_surname;

    public AirPlane(String type, String model, String number, int capacity, String color, String pilot_name, String pilot_surname) {
        this.type = type;
        this.model = model;
        this.number = number;
        this.capacity = capacity;
        this.color = color;
        this.pilot_name = pilot_name;
        this.pilot_surname = pilot_surname;
    }

    public boolean isLetters(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c) && c != '-' && c != '`') {
                return false;
            }
        }
        return true;
    }

    public boolean isValidNumber(String number) {
        return number.matches("^[A-Z0-9-]+$");
    }

    public boolean isValidCapacity(int capacity) {
        return capacity > 0 && capacity <= 853;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Airplane information.");

        if (TYPES_AIRPLANES.contains(type)) {
            sb.append("\nType of airplane: ").append(type);
        } else {
            sb.append("\nInvalid type of airplane.");
        }

        if (MODELS_AIRPLANES.contains(model)) {
            sb.append("\nModel: ").append(model);
        } else {
            sb.append("\nInvalid model of airplane.");
        }

        if (isValidNumber(number)) {
            sb.append("\nNumber of airplane: ").append(number);
        } else {
            sb.append("\nInvalid number of airplane.");
        }

        if (isValidCapacity(capacity)) {
            sb.append("\nCapacity of airplane: ").append(capacity);
        } else {
            sb.append("\nInvalid capacity of airplane.");
        }

        if (isLetters(color)) {
            sb.append("\nColor of airplane: ").append(color);
        } else {
            sb.append("\nInvalid color of airplane.");
        }

        if (isLetters(pilot_name)) {
            sb.append("\nPilot name: ").append(pilot_name);
        } else {
            sb.append("\nInvalid pilot's name.");
        }

        if (isLetters(pilot_surname)) {
            sb.append("\nPilot surname: ").append(pilot_surname);
        } else {
            sb.append("\nInvalid pilot's surname.");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean mainMenu = true;

        while (mainMenu) {
            System.out.print("How many airplane's records do you want to add? ");
            int records = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < records; i++) {
                System.out.println("Enter the type of airplane: ");
                String type = scanner.nextLine();
                System.out.println("Enter the model: ");
                String model = scanner.nextLine();
                System.out.println("Enter the number: ");
                String number = scanner.nextLine();
                System.out.println("Enter the capacity: ");
                int capacity = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the color: ");
                String color = scanner.nextLine();
                System.out.println("Enter the pilot name: ");
                String pilot_name = scanner.nextLine();
                System.out.println("Enter the pilot's surname: ");
                String pilot_surname = scanner.nextLine();

                AirPlane plane = new AirPlane(type, model, number, capacity, color, pilot_name, pilot_surname);
                System.out.println(plane);
            }

            System.out.print("Do you want to add more airplane's records?\n1. Yes\n2. Exit\n");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice != 1) {
                mainMenu = false;
            }
        }

        scanner.close();
    }
}
