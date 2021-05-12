package lesson1;

public class Lesson1 {
    public static void main(String[] args) {
        int Stage = 0;

        Team[] team = new Team[3];
        team[0] = new Cat(5,700, "Siri");
        team[1] = new Man(2,500,"Oleg");
        team[2] = new Robot(10,1000, "Bot");

        Treadmill treadmill = new Treadmill(300);
        Wall wall = new Wall(2);

    }
}
