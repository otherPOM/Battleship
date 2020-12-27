package battleship;

import java.util.Arrays;

public class Battleship {
    private char[][] field;

    public Battleship() {
        field = new char[10][10];
        for (int i = 0; i < 10; i++) {
            Arrays.fill(field[i], '~');
        }
    }

    public String place(Type type, String coordinates) {
        var coord = coordinates.split("\\s+");
        Arrays.sort(coord);

        var x1 = coord[0].charAt(0) - 'A' + 1;
        var x2 = Integer.parseInt(coord[0].substring(1));
        var y1 = coord[1].charAt(0) - 'A' + 1;
        var y2 = Integer.parseInt(coord[1].substring(1));
        if ((x1 != y1 && x2 != y2) || (x1 == y1 && x2 == y2)) {
            return "Error! Wrong ship location! Try again:";
        }
        if ((x1 == y1 && Math.abs(x2 - y2) + 1 != type.getLength()) ||
                (x2 == y2 && Math.abs(x1 - y1) + 1 != type.getLength())) {
            return String.format("Error! Wrong length of the %s! Try again:", type.getName());
        }
        if (isOccupied(x1, x2, y1, y2)) {
            return "Error! You placed it too close to another one. Try again:";
        }

        if (x1 == y1) {
            for (int i = Math.min(x2, y2) - 1; i < Math.max(x2, y2); i++) {
                field[x1 - 1][i] = 'O';
            }
        } else {
            for (int i = Math.min(x1, y1) - 1; i < Math.max(x1, y1); i++) {
                field[i][x2 - 1] = 'O';
            }
        }
        return "";
    }

    public String shoot(String coord) {
        var x = coord.charAt(0) - 'A' + 1;
        var y = Integer.parseInt(coord.substring(1));
        if (field[x - 1][y - 1] == 'O') {
            field[x - 1][y - 1] = 'X';
            return fow() + System.lineSeparator() + "You hit a ship!";
        } else {
            field[x - 1][y - 1] = 'M';
            return fow() + System.lineSeparator() + "You missed!";
        }
    }

    private boolean isOccupied(int x1, int x2, int y1, int y2) {
        x1 = x1 - 1 < 1 ? x1 : x1 - 1;
        x2 = x2 > y1 ? (x2 + 1 > 10 ? x2 : x2 + 1) : x2 - 1 < 1 ? x2 : x2 - 1;
        y1 = y1 + 1 > 10 ? y1 : y1 + 1;
        y2 = y2 > x2 ? (y2 + 1 > 10 ? y2 : y2 + 1) : y2 - 1 < 1 ? y2 : y2 - 1;
        for (int i = x1 - 1; i < y1; i++) {
            for (int j = Math.min(x2, y2) - 1; j < Math.max(x2, y2); j++) {
                if (field[i][j] == 'O') {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder("  1 2 3 4 5 6 7 8 9 10");
        sb.append(System.lineSeparator());
        char letter = 'A';
        for (char[] row : field) {
            sb.append(letter++);
            for (char c : row) {
                sb.append(" ").append(c);
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String fow() {
        var sb = new StringBuilder("  1 2 3 4 5 6 7 8 9 10");
        sb.append(System.lineSeparator());
        char letter = 'A';
        for (char[] row : field) {
            sb.append(letter++);
            for (char c : row) {
                c = c == 'O' ? '~' : c;
                sb.append(" ").append(c);
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
