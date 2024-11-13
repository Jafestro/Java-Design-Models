package Builder;

public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    
    public OfficeComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public void buildCPU() {
        computer.setCpu(new Part("Intel Core i5-12600K"));
    }

    @Override
    public void buildGPU() {
        computer.setGpu(new Part("Intel UHD Graphics 770"));
    }

    @Override
    public void buildRAM() {
        computer.setRam(new Part("16GB DDR4"));
    }

    @Override
    public void buildStorage() {
        computer.setStorage(new Part("SSD 1TB"));
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

