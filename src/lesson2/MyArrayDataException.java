package lesson2;

public class MyArrayDataException extends Exception {
    int row;
    int colon;

    public MyArrayDataException(int row, int colon){
        this.row = row;
        this.colon = colon;
    }
}
