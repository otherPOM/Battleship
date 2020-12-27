package battleship;

import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        var game = new Battleship();
        System.out.println(game);
        positioning(game);
        System.out.println("The game starts!");
        System.out.println(game.fow());
        shooting(game);
        System.out.println(game);
    }

    private static void shooting(Battleship game) {
        while (true) {
            System.out.println("Take a shot!");
            var coord = scan.nextLine();
            if (!coord.matches("[A-J]([1-9]|10)")) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                continue;
            }
            System.out.println(game.shoot(coord));
            break;
        }
    }

    private static void positioning(Battleship game) {
        for (Type type : Type.values()) {
            String res = "Start";
            while (!res.equals("")) {
                System.out.printf("Enter the coordinates of the %s (%d cells):%s",
                        type.getName(), type.getLength(), System.lineSeparator());
                var coordinates = scan.nextLine();
                if (!coordinates.matches("[A-J]([1-9]|10) [A-J]([1-9]|10)")) {
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                    continue;
                }
                res = game.place(type, coordinates);
                System.out.println(res);
            }
            System.out.println(game);
        }
    }
}
