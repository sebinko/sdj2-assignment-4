package runnables;

import queue.Deposit;
import treasury.Treasury;
import utility.LogFacade;
import utility.Valuable;

import java.util.Random;

public class ValuableTransporter extends Person {
    private Deposit<Valuable> deposit;
    private Treasury treasury;
    private Random random;

    public ValuableTransporter(Deposit<Valuable> deposit, Treasury treasury) {
        this.deposit = deposit;
        this.treasury = treasury;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Valuable valuable = deposit.take();
                treasury.addValuable(this, valuable);
                LogFacade.info("ValuableTransporter added: " + valuable);
                Thread.sleep(random.nextInt(750, 1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}