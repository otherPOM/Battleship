package battleship;

import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        var field = new Field();
        System.out.println(field);
        positioning(field);
        System.out.println("The game starts!");
        System.out.println(field.fow());
        System.out.println("Take a shot!");
        while (field.hasShips()) {
            shooting(field);
        }
        System.out.println(field);
    }

    private static void shooting(Field field) {
            var coord = scan.nextLine();
            if (!coord.matches("[A-J]([1-9]|10)")) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                shooting(field);
            }
            System.out.println(field.shoot(coord));
    }

    private static void positioning(Field field) {
        for (Type type : Type.values()) {
            String res = "Start";
            System.out.printf("Enter the coordinates of the %s (%d cells):%s",
                    type.getName(), type.getLength(), System.lineSeparator());
            while (!res.equals("")) {
                var coordinates = scan.nextLine();
                if (!coordinates.matches("[A-J]([1-9]|10) [A-J]([1-9]|10)")) {
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                    continue;
                }
                res = field.place(type, coordinates);
                System.out.println(res);
            }
            System.out.println(field);
        }
    }
}
