package AbstractFactory;

public class TextFieldB extends TextField {
    public TextFieldB(String text) {
        super(text);
    }

    @Override
    void display(){
        System.out.printf("______________%s______________", text);
    }
}
