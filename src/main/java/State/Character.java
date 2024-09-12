package State;
import java.util.Random;
import java.util.Scanner;

public class Character {
    private String name;
    private String level;
    private Long experiencePoints;
    private Integer healthPoints;
    private State state;
    private Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public Character(String name){
        this.name = name;
        this.level = "NOVICE";
        this.experiencePoints = Integer.toUnsignedLong(0);
        this.healthPoints = 10;
        this.state = new NoviceState(this);
    }

    public void setState(State state){
        this.state = state;
    }

    public void train(){
        experiencePoints += Integer.toUnsignedLong(10);
        System.out.println("Training sounds.... /} ----     +--->[*]\\");
        System.out.println("Experience: " + experiencePoints);
    }

    public void meditate(){
        healthPoints++;
        System.out.println("Oooommmmmmmmm , ZZzzzzzZzZZZzZZ....... "); 
    }

    public void fight(){
        healthPoints -= random.nextInt(3);
        experiencePoints += random.nextLong(100) + Integer.toUnsignedLong(20);
        System.out.println("Figting Finally. Chick Norrus Would be proud of you");
    }

    public Long getExp(){
        return experiencePoints;
    }

    public void levelUp(String level){
        System.out.println("LEVEL UP!!!");
        this.level = level;
    }

    public void printStatus(){
        System.out.println();
        System.out.println("Hero: " + name);
        System.out.println("Level: " + level);
        System.out.println("Exp: " + experiencePoints);
        System.out.println("HP: " + healthPoints);
        System.out.println();
    }

    public void play() {
        while (true) {
            state.action();
            if (state == null){
                System.out.println("Game is broken");
                break;
            }
            if (state instanceof MasterState) {
                System.out.println("You are your own Master now.");
                System.out.println("We greet you Master " + name + "!");
                break;
            }
        }
    }

    public int readUserChoice(String[] options) {
        System.out.println("\nSelect an option:");
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i-1]);
        }
        return scanner.nextInt();
    }
}
