package AbstractFactory;

public abstract class UIElement {
    protected String text;

    public UIElement(String text){
        this.text = text;
    }

    void setText(String text){
        this.text = text;
    }
}
