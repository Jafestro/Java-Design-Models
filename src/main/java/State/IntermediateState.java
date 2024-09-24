package State;

public class IntermediateState extends State {

    public IntermediateState(Character character) {
        super(character);
    }

    @Override
    void action() {
        this.getCharacter().printStatus();
        String[] options = {"Train", "Meditate"};
        switch (this.getCharacter().readUserChoice(options)) {
            case 1 -> this.getCharacter().train();
            case 2 -> this.getCharacter().meditate();
        }
        // Abstraction at its finest :D
        if (this.getCharacter().getExp() >= Integer.toUnsignedLong(Threshold.EXPERT.getExp())){
            this.getCharacter().setState(new ExpertState(this.getCharacter()));
            this.getCharacter().levelUp("EXPERT", 150);
        }
    }
    
}
