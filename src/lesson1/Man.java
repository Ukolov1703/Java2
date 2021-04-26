package lesson1;

public class Man implements Runable, Jumpable{

    int maxHeight;
    int maxDistance;
    String name;

    public Man (int maxHeight, int maxDistance, String name){
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
        this.name = name;
    }

    @Override
    public int getMaxHeight(){
        return maxHeight;
    }

    @Override
    public void jump() {
        System.out.println("Человек прыгнул");
    }

    @Override
    public int getMaxDistance(){
        return maxDistance;
    }

    @Override
    public void run() {
        System.out.println("Человек побежал");
    }

    @Override
    public String toString(){
        return name;
    }
}
