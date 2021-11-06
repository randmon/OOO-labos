package cipherApp.main;

import org.junit.Test;

import static org.junit.Assert.*;

public class MirrorTest {
    private final Mirror sc = new Mirror();
    private final String abc = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ .;!";
    private final String cba = "!;. ZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcba";
    private final String lorem = "Lorem, Ipsum Sit Amet!!!";
    private final String merol = "!!!temA tiS muspI ,meroL";

    @Test
    public void code() {
        System.out.println(sc.code(abc));
        System.out.println(sc.code(lorem));

        assertEquals(cba, sc.code(abc));
        assertEquals(merol, sc.code(lorem));
    }

    @Test
    public void decode() {
        assertEquals(abc, sc.decode(cba));
        assertEquals(lorem, sc.decode(merol));
    }

}