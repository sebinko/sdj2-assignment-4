package treasury;

import runnables.Person;
import utility.Valuable;

import java.util.ArrayList;
import java.util.List;

public class TreasureRoom implements Treasury {
    private List<Valuable> valuables;
    private Door door;

    public TreasureRoom() {
        this.valuables = new ArrayList<>();
        this.door = new Door();
    }

    @Override
    public void addValuable(Person person, Valuable valuable) {
        door.acquireWrite();
        try {
            this.valuables.add(valuable);
        } finally {
            door.releaseWrite();
        }
    }

    @Override
    public Valuable retrieveValuable(Person person) {
        door.acquireWrite();
        try {
            if (!this.valuables.isEmpty()) {
                return this.valuables.remove(0);
            }
            return null;
        } finally {
            door.releaseWrite();
        }
    }

    @Override
    public List<Valuable> lookAtValuables(Person person) {
        door.acquireRead();
        try {
            return new ArrayList<>(this.valuables);
        } finally {
            door.releaseRead();
        }
    }
}