package treasury;

import runnables.Person;
import utility.Valuable;

import java.util.List;

public interface Treasury {
    void addValuable(Person person, Valuable valuable);

    Valuable retrieveValuable(Person person);

    List<Valuable> lookAtValuables(Person person);
}