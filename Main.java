package battleship;

import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        var game = new Battleship();
        System.out.println(game);
        positioning(game);
    }

    private static void positioning(Battleship game) {
        for (Type type : Type.values()) {
            String res = "Start";
            while (!res.equals("")) {
                System.out.printf("Enter the coordinates of the %s (%d cells):%s",
                        type.getName(), type.getLength(), System.lineSeparator());
                var coordinates = scan.nextLine();
                if (!coordinates.matches("[A-J]([1-9]|10) [A-J]([1-9]|10)")) {
                    throw new IllegalArgumentException();
                }
                res = game.place(type, coordinates);
                System.out.println(res);
            }
            System.out.println(game);
        }
    }
}
