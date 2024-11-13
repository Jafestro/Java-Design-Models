package Builder;

public class Main {
    public static void main(String[] args) {
        ComputerBuilder computerBuilder = new GamingComputerBuilder();
        ComputerDirector computerDirector = new ComputerDirector(computerBuilder);
        computerDirector.constructComputer();
        Computer computer = computerBuilder.getComputer();
        System.out.println("Gaming Computer built with the following components:");
        System.out.println("CPU: " + computer.getCpu().getName());
        System.out.println("GPU: " + computer.getGpu().getName());
        System.out.println("RAM: " + computer.getRam().getName());
        System.out.println("Storage: " + computer.getStorage().getName());
        System.out.println("OS: " + computer.getOs().getName());

        computerBuilder = new OfficeComputerBuilder();
        computerDirector = new ComputerDirector(computerBuilder);
        computerDirector.constructComputer();
        computer = computerBuilder.getComputer();
        System.out.println("Office Computer built with the following components:");
        System.out.println("CPU: " + computer.getCpu().getName());
        System.out.println("GPU: " + computer.getGpu().getName());
        System.out.println("RAM: " + computer.getRam().getName());
        System.out.println("Storage: " + computer.getStorage().getName());
        System.out.println("OS: " + computer.getOs().getName());
    }
}
