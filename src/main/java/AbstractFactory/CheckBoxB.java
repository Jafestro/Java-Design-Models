package AbstractFactory;

public class CheckBoxB extends CheckBox {
    public CheckBoxB(String text) {
        super(text);
    }

    @Override
    void display(){
        System.out.printf("{%s}",text);
    }
}
