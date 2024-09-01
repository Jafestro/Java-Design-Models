package AbstractFactory;

public class AFactory extends UIFactory {
    public AFactory(){}

    @Override
    ButtonA createButton(String text) {
        return new ButtonA(text);
    }

    @Override
    TextFieldA createTextField(String text) {
        return new TextFieldA(text);
    }

    @Override
    CheckBox createCheckBox(String text){
        return new CheckBoxA(text);
    }
    
}
