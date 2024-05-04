import queue.Deposit;
import runnables.Accountant;
import runnables.King;
import runnables.Miner;
import runnables.ValuableTransporter;
import treasury.TreasureRoom;
import treasury.TreasureRoomGuardsman;
import utility.Valuable;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Deposit<Valuable> deposit = new Deposit<>(10);

        TreasureRoom treasureRoom = new TreasureRoom();
        TreasureRoomGuardsman guardsman = new TreasureRoomGuardsman(treasureRoom);

        ValuableTransporter transporter = new ValuableTransporter(deposit, guardsman);
        Accountant accountant = new Accountant(guardsman);
        King king = new King(guardsman);
        Miner miner = new Miner(deposit);
        Miner miner2 = new Miner(deposit);
        Miner miner3 = new Miner(deposit);

        Thread transporterThread = new Thread(transporter);
        Thread accountantThread = new Thread(accountant);
        Thread kingThread = new Thread(king);
        Thread minerThread = new Thread(miner);
        Thread minerThread2 = new Thread(miner2);
        Thread minerThread3 = new Thread(miner3);

        minerThread.start();
        minerThread2.start();
        minerThread3.start();
        transporterThread.start();
        accountantThread.start();
        kingThread.start();

        Thread.sleep(10000);

        transporterThread.interrupt();
        accountantThread.interrupt();
        kingThread.interrupt();
        minerThread.interrupt();
        minerThread2.interrupt();
        minerThread3.interrupt();
    }
}