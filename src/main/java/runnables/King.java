package runnables;

import treasury.Treasury;
import utility.LogFacade;
import utility.Valuable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class King extends Person {
    private Treasury treasury;
    private Random random;

    public King(Treasury treasury) {
        this.treasury = treasury;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                int target = random.nextInt(101) + 50;
                List<Valuable> valuables = new ArrayList<>();
                int total = 0;

                while (total < target) {
                    Valuable valuable = treasury.retrieveValuable(this);
                    if (valuable == null) {
                        valuables.forEach(v -> treasury.addValuable(this, v));
                        LogFacade.info("King cancelled the party");
                        break;
                    }

                    valuables.add(valuable);
                    total += valuable.getValue();
                }

                if (total >= target) {
                    LogFacade.info("King threw a party worth: " + total);
                }

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
