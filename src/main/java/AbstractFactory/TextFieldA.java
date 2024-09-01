package AbstractFactory;

public class TextFieldA extends TextField {

    public TextFieldA(String text) {
        super(text);
    }

    @Override
    void display() {
        System.out.printf("*********************%s*********************", text);
    }
    
}
