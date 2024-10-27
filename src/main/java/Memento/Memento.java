package Memento;

import java.time.Instant;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;
    private long timestamp;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.timestamp = Instant.now().toEpochMilli();
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options.clone(); // Return a copy of options array
    }

    public boolean isSelected() {
        return isSelected;
    }

    public String getMetaData() {
        return "Saved at: " + Instant.ofEpochMilli(timestamp).toString();
    }

    public long getTimestamp() {
        return timestamp;
    }
}
