package Builder;

public class GamingComputerBuilder implements ComputerBuilder {
    private final Computer computer;


    public GamingComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public void buildCPU() {
        computer.setCpu(new Part("Intel Core i9-14900K"));
    }

    @Override
    public void buildGPU() {
        computer.setGpu(new Part("GeForce RTX 4090 Ti"));
    }

    @Override
    public void buildRAM() {
        computer.setRam(new Part("64GB DDR5"));
    }

    @Override
    public void buildStorage() {
        computer.setStorage(new Part("SSD 2TB"));
    }

    @Override
    public void buildOS() {
        computer.setOs(new Part("Windows 11"));
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}