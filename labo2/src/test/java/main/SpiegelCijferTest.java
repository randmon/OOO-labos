package main;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpiegelCijferTest {
    private final SpiegelCijfer sc = new SpiegelCijfer();
    private final String abc = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ .;!";
    private final String cba = "!;. ZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcba";
    private final String lorem = "Lorem, Ipsum Sit Amet!!!";
    private final String merol = "!!!temA tiS muspI ,meroL";

    @Test
    public void coderen() {
        System.out.println(sc.coderen(abc));
        System.out.println(sc.coderen(lorem));

        assertEquals(cba, sc.coderen(abc));
        assertEquals(merol, sc.coderen(lorem));
    }

    @Test
    public void decoderen() {
        assertEquals(abc, sc.decoderen(cba));
        assertEquals(lorem, sc.decoderen(merol));
    }

}