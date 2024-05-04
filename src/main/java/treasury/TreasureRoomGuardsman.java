package treasury;

import runnables.Person;
import runnables.ValuableTransporter;
import utility.Valuable;

import java.util.List;

public class TreasureRoomGuardsman implements Treasury {
    private Treasury treasury;

    public TreasureRoomGuardsman(Treasury treasury) {
        this.treasury = treasury;
    }

    @Override
    public void addValuable(Person person, Valuable valuable) {
        treasury.addValuable(person, valuable);
    }

    @Override
    public Valuable retrieveValuable(Person person) {
        if (person instanceof ValuableTransporter) {
            throw new SecurityException("ValuableTransporter is not allowed to retrieve valuables");
        }
        return treasury.retrieveValuable(person);
    }

    @Override
    public List<Valuable> lookAtValuables(Person person) {
        return treasury.lookAtValuables(person);
    }
}