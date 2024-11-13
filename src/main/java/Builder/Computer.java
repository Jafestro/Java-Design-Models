package Builder;

public class Computer {
    private Part cpu;
    private Part gpu;
    private Part ram;
    private Part storage;
    private Part os;

    public Part getCpu() {
        return cpu;
    }
    public void setCpu(Part cpu) {
        this.cpu = cpu;
    }
    public Part getGpu() {
        return gpu;
    }
    public void setGpu(Part gpu) {
        this.gpu = gpu;
    }
    public Part getRam() {
        return ram;
    }
    public void setRam(Part ram) {
        this.ram = ram;
    }
    public Part getStorage() {
        return storage;
    }
    public void setStorage(Part storage) {
        this.storage = storage;
    }
    public Part getOs() {
        return os;
    }
    public void setOs(Part os) {
        this.os = os;
    }

    
}
