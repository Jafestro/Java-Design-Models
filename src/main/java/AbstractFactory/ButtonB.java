package AbstractFactory;

public class ButtonB extends Button {
   
    public ButtonB(String text) {
        super(text);
    }

    @Override
    void display() {
        System.out.printf("<"+ text + ">");
    }
}
