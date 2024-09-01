package AbstractFactory;

public class BFactory extends UIFactory {

    private ButtonB buttonB;
    private CheckBoxB checkBoxB;
    private TextFieldB textFieldB;

    @Override
    Button createButton(String text) {
        return new ButtonB(text);
    }

    @Override
    TextField createTextField(String text) {
        return new TextFieldB(text);
    }

    @Override
    CheckBox createCheckBox(String text){
        return new CheckBoxB(text);
    }
    
}
