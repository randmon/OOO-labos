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
        System.out.println(cc.code(abc));
        System.out.println(cc.code(lorem));

        assertEquals(bcd, cc.code(abc));
        assertEquals(mpsfn, cc.code(lorem));
    }

    @Test
    public void stringDecoderen() {
        System.out.println(cc.decode(bcd));
        System.out.println(cc.decode(mpsfn));

        assertEquals(abc, cc.decode(bcd));
        assertEquals(abc, cc.decode(cc.code(abc)));
    }
}