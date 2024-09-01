package AbstractFactory;

public class ButtonA extends Button{

    public ButtonA(String text) {
        super(text);
    }

    @Override
    void display() {
        System.out.printf("<"+ text + ">");
    }
    
}
