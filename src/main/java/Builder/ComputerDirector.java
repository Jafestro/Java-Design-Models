package Builder;

public class ComputerDirector {
    private final ComputerBuilder computerBuilder;

    public ComputerDirector(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public void constructComputer() {
        computerBuilder.buildCPU();
        computerBuilder.buildGPU();
        computerBuilder.buildRAM();
        computerBuilder.buildStorage();
        computerBuilder.buildOS();
    }
}