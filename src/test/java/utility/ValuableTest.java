package utility;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ValuableTest {
    @Test
    public void testGetInstance_Diamond() {
        Valuable diamond = Valuable.getInstance(Valuable.Type.DIAMOND);
        assertNotNull(diamond);
        assertEquals(250, diamond.getValue());
    }

    @Test
    public void testGetInstance_Emerald() {
        Valuable emerald = Valuable.getInstance(Valuable.Type.EMERALD);
        assertNotNull(emerald);
        assertEquals(100, emerald.getValue());
    }

    @Test
    public void testGetInstance_Ruby() {
        Valuable ruby = Valuable.getInstance(Valuable.Type.RUBY);
        assertNotNull(ruby);
        assertEquals(50, ruby.getValue());
    }

    @Test
    public void testGetInstance_Gold() {
        Valuable gold = Valuable.getInstance(Valuable.Type.GOLD);
        assertNotNull(gold);
        assertEquals(25, gold.getValue());
    }

}
