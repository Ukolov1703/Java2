package lesson2;

public class MyArraySizeException extends Exception {
    int row;
    int colon;

    public MyArraySizeException( int row, int colon){

        this.row = row;
        this.colon = colon;


    }
}
