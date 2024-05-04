package runnables;

import queue.Deposit;
import utility.LogFacade;
import utility.Valuable;

import java.util.Random;

public class Miner extends Person {
    private Deposit<Valuable> deposit;
    private Random random;

    public Miner(Deposit<Valuable> deposit) {
        this.deposit = deposit;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Valuable valuable = Valuable.getInstance(Valuable.Type.values()[random.nextInt(Valuable.Type.values().length)]);
                deposit.put(valuable);
                LogFacade.info("Miner deposited: " + valuable);
                Thread.sleep(random.nextInt(750, 1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

