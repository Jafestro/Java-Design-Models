package Decorator;

public class EncryptedPrinterDecorator extends PrinterDecorator{

    public EncryptedPrinterDecorator(Printer printer) {
        super(printer);
    }
    
    @Override
    public void print(String message) {
        String encryptedMessage = encryptMessage(message);
        super.print(encryptedMessage);
    }

    private String encryptMessage(String message) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : message.toCharArray()) {
            encrypted.append((char) (c + 5));
        }
        return encrypted.toString();
    }
    
}
