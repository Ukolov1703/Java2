package lesson2;

import java.sql.Array;
import java.util.Scanner;

public class Lesson2 {
    public static void main(String[] args) {
        int row;
        int colon;

        System.out.println("Введите размер массива:");
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        colon = scanner.nextInt();
        String[][] Array = new String[row][colon];
        try {
            checkArray(Array, scanner, row, colon);

        }catch (MyArraySizeException e){
            System.out.println("Неверный размер массива!");
        }
        catch (MyArrayDataException e){
            System.out.println("Некорректно заполнен массив");
            System.out.println("Ошибка в ячейке: " + (e.row + 1) + "*" + (e.colon + 1));
        }
    }

    public static int checkArray(String[][] Array,Scanner scanner, int row, int colon) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (row != 4) {
            throw new MyArraySizeException(row, colon);
        }
            if (colon != 4) {
                throw new MyArraySizeException(row, colon);
            }
        System.out.println("Создайте массив, вводите по одному значению:  ");
        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array[i].length; j++) {
                System.out.println("Новый ряд: " + i + " Новая колонна:  " + j);
                Array[i][j] = scanner.next();
            }
        }
        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array[i].length; j++) {

                try {
                    count = count + Integer.parseInt(Array[i][j]);

                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                } finally {
                    //System.out.println(count);
                }
            }

        }
        System.out.println(count);
        return count;

    }
}
