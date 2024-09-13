package Decorator;

import java.io.FileWriter;
import java.io.IOException;

public class FilePrinterDecorator extends PrinterDecorator{

    public FilePrinterDecorator(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        try (FileWriter writer = new FileWriter("output.txt", true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.print(message);
    }
    
}
