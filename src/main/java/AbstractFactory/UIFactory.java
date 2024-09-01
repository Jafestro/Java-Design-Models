package AbstractFactory;

public abstract class UIFactory {
    abstract Button createButton(String text);
    abstract TextField createTextField(String text);
    abstract CheckBox createCheckBox(String text);
}
