package AbstractFactory;

public abstract class CheckBox extends UIElement{
    public CheckBox(String text){
        super(text);
    }

    abstract void display();
}
