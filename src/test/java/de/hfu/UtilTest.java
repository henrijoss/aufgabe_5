package de.hfu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class UtilTest {

    private int ungueltigerMonat;
    private int monatErstesHalbJahr;
    private int monatZweitesHalbjahr;

    public UtilTest(int ungueltigerMonat, int monatErstesHalbjahr, int monatZweitesHalbjahr) {
        this.ungueltigerMonat = ungueltigerMonat;
        this.monatErstesHalbJahr = monatErstesHalbjahr;
        this.monatZweitesHalbjahr = monatZweitesHalbjahr;
    }

    @Parameterized.Parameters
    public static Collection<Integer[]> daten() {
        return Arrays.asList(new Integer[][] {
                {0, 1, 8}, {13, 3, 10}
        });
    }

    @Test(expected = IllegalArgumentException.class, timeout = 1000)
    public void testIstErstesHalbjahrException() throws Exception {
        Util.istErstesHalbjahr(ungueltigerMonat);
    }

    @Test
    public void testIstErstesHalbjahrTrue() throws Exception {
        assertTrue(Util.istErstesHalbjahr(monatErstesHalbJahr));
    }

    @Test
    public void testIstErstesHalbjahrFalse() throws Exception {
        assertFalse(Util.istErstesHalbjahr(monatZweitesHalbjahr));
    }


}
