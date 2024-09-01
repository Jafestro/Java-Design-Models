package AbstractFactory;

public class CheckBoxA extends CheckBox {
    public CheckBoxA(String text) {
        super(text);
    }

    @Override
    void display(){
        System.out.printf("[%s]",text);
    }
}
