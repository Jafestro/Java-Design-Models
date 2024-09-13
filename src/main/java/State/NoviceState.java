package State;

public class NoviceState extends State{
    public NoviceState(Character character){
        super(character);
    }

    @Override
    void action() {
        this.getCharacter().printStatus();
        String[] options = {"Train"};
        switch (this.getCharacter().readUserChoice(options)) {
            case 1 -> this.getCharacter().train();
        }
        // Abstraction at its finest :D
        if (this.getCharacter().getExp().compareTo(Integer.toUnsignedLong(Threshold.INTERMEDIATE.getExp())) == 0){
            this.getCharacter().setState(new IntermediateState(this.getCharacter()));
            this.getCharacter().levelUp("INTERMEDIATE");
        }
    }
}