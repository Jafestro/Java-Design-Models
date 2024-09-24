package State;
import java.util.Random;
import java.util.Scanner;

public class Character {
    private boolean gameState = true;
    private boolean alive = true;
    private String name;
    private String level;
    private Long experiencePoints;
    private Integer healthPoints;
    private Integer maxHealthPoints;
    private State state;
    private Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);
    

    public Character(String name){
        this.name = name;
        this.level = "NOVICE";
        this.experiencePoints = Integer.toUnsignedLong(0);
        this.healthPoints = 10;
        this.maxHealthPoints = 10;
        this.state = new NoviceState(this);
    }

    public void setState(State state){
        this.state = state;
    }

    public void train(){
        experiencePoints += Integer.toUnsignedLong(10);
        System.out.println(Colors.GREEN + "Training sounds.... /} ----     +--->[*]\\" + Colors.RESET);
        System.out.println("Experience: " + experiencePoints);
    }

    public void meditate(){
        if (maxHealthPoints > healthPoints) healthPoints++; else System.out.println(Colors.RED + "MAX HEALTH REACHED" + Colors.RESET);
        System.out.println(Colors.YELLOW + "Oooommmmmmmmm , ZZzzzzzZzZZZzZZ....... " + Colors.RESET); 
    }

    public void fight(){
        healthPoints -= random.nextInt(3);
        if(!isDead()){
            experiencePoints += random.nextLong(100) + Integer.toUnsignedLong(20);
            System.out.println(Colors.RED + "Figting Finally. Chick Norrus Would be proud of you" + Colors.RESET);
        }

    }

    public boolean isDead(){
        if (healthPoints <= 0){
            alive = false;
            gameState = false;
            System.out.println(Colors.RED + "You are dead. Game Over. Restart the game to play again." + Colors.RESET);
            return true;
        }
        return false;
    }

    public Long getExp(){
        return experiencePoints;
    }

    public void levelUp(String level, int maxHealthPoints){
        System.out.println(Colors.YELLOW + "********************************LEVEL UP!!!********************************" + Colors.RESET);
        this.level = level;
        this.maxHealthPoints += maxHealthPoints;
        this.healthPoints = this.maxHealthPoints;
    }

    public void endGame(){
        System.out.println(Colors.RED + "***************************************************************************" + Colors.RESET);
        System.out.println(Colors.CYAN + "You are your own Master now." + Colors.RESET);
        System.out.println(Colors.CYAN + "We greet you Master " + name + "!" + Colors.RESET);
        System.out.println(Colors.GREEN + "Game Over. Restart the game to play again." + Colors.RESET);
        System.out.println(Colors.GREEN + "Thank you for playing." + Colors.RESET);
        System.out.println(Colors.RED + "***************************************************************************" + Colors.RESET);
        gameState = false;
    }

    public void printStatus(){
        System.out.println();
        System.out.println(Colors.BLUE + "Hero: " + Colors.PURPLE + name + Colors.RESET);
        System.out.println(Colors.BLUE + "Level: " + Colors.PURPLE + level + Colors.RESET);
        System.out.println(Colors.BLUE + "Exp: " + Colors.PURPLE + experiencePoints + Colors.RESET);
        System.out.println(Colors.BLUE + "HP: " + Colors.PURPLE + healthPoints + "/" + maxHealthPoints + Colors.RESET);    
        System.out.println();
    }

    public void play() {
        System.out.println();
        System.out.println(GameBanner.banner);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(Colors.GREEN + "Welcome to The Way of The Mevan, " + name + "!" + Colors.RESET);
        while (gameState) {
            state.action();
            if (state == null){
                System.out.println("Game is broken");
                break;
            }
            if (level.equals("MASTER")) {
                endGame();
            }
        }
    }

    public int readUserChoice(String[] options) {
        System.out.println("\nSelect an option:");
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i-1]);
        }
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }
}
