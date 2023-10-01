
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] playingField = new String[3][3];
        do {
            fieldКendering(playingField);
            boolean check;
            System.out.println("Ход крестика ");
            do {
                int coordinateOneX = scan.nextInt();
                int coordinateTwoX = scan.nextInt();
                check = moveX(playingField, coordinateOneX, coordinateTwoX);
            } while (check);
            if (winsX(playingField)) {
                System.out.println("Победил крестик ");
                break;
            }
            if (draw(playingField)) {
                System.out.println("Ничья ходов не осталось");
                break;
            }
            fieldКendering(playingField);
            System.out.println("Ход нолика ");
            do {
                int coordinateOneY = scan.nextInt();
                int coordinateTwoY = scan.nextInt();
                check = moveY(playingField, coordinateOneY, coordinateTwoY);
            } while (check);
            if (winsY(playingField)) {
                System.out.println("Победил нолик ");
                break;
            }
            if (draw(playingField)) {
                System.out.println("Ничья ходов не осталось");
                break;
            }
        }while (true);



    }
    public static void fieldКendering(String[][] playingField) {
        for (int i = 0; i < playingField.length; i++) {
            for (int j = 0; j < playingField[i].length; j++) {
                System.out.print(playingField[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean moveX(String[][] playingField, int x, int y) {
        if (playingField[x][y] != null) {
            System.out.println("Данное поле занято");
            return true;
        }
        playingField[x][y] = "X";
        return false;
    }
    public static boolean moveY(String[][] playingField, int x, int y) {
        if (playingField[x][y] != null) {
            System.out.println("Данное поле занято");
            return true;
        }
        playingField[x][y] = "O";
        return false;
    }
    public static boolean winsX(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i][0].equals("X") && array[i][1].equals("X") && array[i][2] .equals("X")) {
                return true;
            }
        }
        for (int j = 0; j < array.length; j++) {
            if (array[0][j].equals("X") && array[1][j].equals("X") && array[2][j].equals("X")) {
                return true;
            }
        }
        if (array[0][0].equals("X") && array[1][1].equals("X") && array[2][2].equals("X")) {
            return true;
        }
        return false;
    }
    public static boolean winsY(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i][0].equals("O") && array[i][1].equals("O") && array[i][2].equals("O")) {
                return true;
            }
        }
        for (int j = 0; j < array.length; j++) {
            if (array[0][j].equals("O") && array[1][j].equals("O") && array[2][j].equals("O")) {
                return true;
            }
        }
        if (array[0][0].equals("O") && array[1][1].equals("O") && array[2][2].equals("O")) {
            return true;
        }
        return false;
    }
    public static boolean draw(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }
}