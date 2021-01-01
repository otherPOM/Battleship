package battleship;

import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        var field1 = new Field();
        var field2 = new Field();
        boolean turn = true;

        System.out.println("Player1, place your ships on the game field");
        System.out.println(field1);
        positioning(field1);

        System.out.println("Player2, place your ships on the game field");
        System.out.println(field2);
        positioning(field2);

        Field playerField;
        Field opponentField;

        do {
            playerField = turn ? field1 : field2;
            opponentField = turn ? field2 : field1;
            System.out.println(opponentField.fow());
            System.out.println("---------------------");
            System.out.println(playerField);
            System.out.printf("Player%d, it's your turn\n", turn ? 1 : 2);
            shooting(opponentField);
            turn = !turn;
        } while (opponentField.hasShips());
    }

    private static void shooting(Field field) {
        var coord = scan.nextLine();
        if (!coord.matches("[A-J]([1-9]|10)")) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
            shooting(field);
        }
        System.out.println(field.shoot(coord));
        System.out.println("Press Enter and pass the move to another player");
        scan.nextLine();
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
        System.out.println("Press Enter and pass the move to another player");
        scan.nextLine();
    }
}
