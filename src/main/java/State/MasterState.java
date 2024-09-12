package State;

public class MasterState extends State {

    public MasterState(Character character) {
        super(character);
    }

    @Override
    void action() {
        this.getCharacter().printStatus();
    }
    
}
