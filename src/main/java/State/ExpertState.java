package State;

public class ExpertState extends State {

    public ExpertState(Character character) {
        super(character);
    }

    @Override
    void action() {
        this.getCharacter().printStatus();
        String[] options = {"Train", "Meditate", "Fight"};
        switch (this.getCharacter().readUserChoice(options)) {
            case 1 -> this.getCharacter().train();
            case 2 -> this.getCharacter().meditate();
            case 3 -> this.getCharacter().fight();
        }
        if (this.getCharacter().getExp() >= Integer.toUnsignedLong(Threshold.MASTER.getExp())){
            this.getCharacter().setState(new MasterState(this.getCharacter()));
            this.getCharacter().levelUp("MASTER", 800);
        }
    }
    
}
