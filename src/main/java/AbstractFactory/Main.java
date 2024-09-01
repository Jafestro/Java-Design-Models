package AbstractFactory;

public class Main {
    public static void main(String[] args) {
        UIFactory uiFactoryA = new AFactory();
        UIFactory uiFactoryB = new BFactory();

        CheckBox checkBox = uiFactoryA.createCheckBox("V");
        TextField textField = uiFactoryB.createTextField("Hello There");
        Button button = uiFactoryA.createButton("Click me!");

        checkBox.display();
        textField.display();
        button.display();

        System.out.println();
        checkBox.setText("H");
        textField.setText("How You Doin? :D");
        button.setText("Click Me! I am not forcing you or anything it is your choice");

        checkBox.display();
        textField.display();
        button.display();
    }
}
