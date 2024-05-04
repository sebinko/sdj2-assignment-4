package runnables;

import treasury.Treasury;
import utility.LogFacade;
import utility.Valuable;

import java.util.List;

public class Accountant extends Person {
    private Treasury treasury;

    public Accountant(Treasury treasury) {
        this.treasury = treasury;
    }

    @Override
    public void run() {
        while (true) {
            try {
                List<Valuable> valuables = treasury.lookAtValuables(this);
                int total = valuables.stream().mapToInt(Valuable::getValue).sum();
                LogFacade.info("Accountant counted: " + total);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
