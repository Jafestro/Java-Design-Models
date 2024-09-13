package Decorator;

public class Main {
    public static void main(String[] args) {
         // Basic printer
         Printer printer = new BasicPrinter();
         printer.print("I am Voldemort!");
 
         // Encrypted and File printer
         Printer printer2 = new EncryptedPrinterDecorator(new FilePrinterDecorator(new BasicPrinter()));
         printer2.print("I am Gimli!");
    }
}
