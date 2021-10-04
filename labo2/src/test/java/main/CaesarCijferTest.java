package main;

import org.junit.Test;
import static org.junit.Assert.*;

public class CaesarCijferTest {
    private final CaesarCijfer cc = new CaesarCijfer(1);
    private final String abc = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ .;!";
    private final String bcd = "bcdefghijklmnopqrstuvwxyzaBCDEFGHIJKLMNOPQRSTUVWXYZA .;!";
    private final String lorem = "Lorem, Ipsum Sit Amet!!!";
    private final String mpsfn = "Mpsfn, Jqtvn Tju Bnfu!!!";

    @Test
    public void stringCoderen() {
        System.out.println(cc.coderen(abc));
        System.out.println(cc.coderen(lorem));

        assertEquals(bcd, cc.coderen(abc));
        assertEquals(mpsfn, cc.coderen(lorem));
    }

    @Test
    public void stringDecoderen() {
        System.out.println(cc.decoderen(bcd));
        System.out.println(cc.decoderen(mpsfn));

        assertEquals(abc, cc.decoderen(bcd));
        assertEquals(abc, cc.decoderen(cc.coderen(abc)));
    }
}