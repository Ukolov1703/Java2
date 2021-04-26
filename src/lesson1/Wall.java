package lesson1;

public class Wall {
    int height;

    public Wall( int height){

        this.height = height;
    }

    public boolean toJump(int maxHeight) {
        return (maxHeight >= height);

    }
}
