package typd;

import junit.framework.TestCase;
import org.junit.Ignore;

public class ConverterRomanNumeralTest extends TestCase {
    private Converter converter = new Converter();

    public void testStrSpeed() {
        long start = System.currentTimeMillis();
        converter.convertRomanNumber(converter.convertRomanNumber(3999));
        long end = System.currentTimeMillis();
        long duration = end - start;
        assertTrue("duration = " + duration + " > 2L", duration < 3L);
    }

    public void testStrAll() {
        for (int i = 1; i <= 3999; i++) {
            int result = converter.convertRomanNumber(converter.convertRomanNumber(i));
            assertTrue("result: " + result + " should be:" + i, result == i);
        }
    }

    public void testStr1to10() {
        assertSame(1, "I");
        assertSame(5, "V");
        assertSame(10, "X");
    }

    public void testIntIllegal() {
        assertFail(-1);
        assertFail(0);
        assertFail(4000);
    }

    public void testInt1to10() {
        assertSame("I", 1);
        assertSame("II", 2);
        assertSame("III", 3);
        assertSame("V", 5);
        assertSame("VI", 6);
        assertSame("VII", 7);
        assertSame("VIII", 8);
        assertSame("IV", 4);
        assertSame("IX", 9);
    }

    public void testInt10to100() {
        assertSame("X", 10);
        assertSame("XI", 11);
        assertSame("XII", 12);
        assertSame("XIII", 13);
        assertSame("XIV", 14);
        assertSame("XV", 15);
        assertSame("XX", 20);
        assertSame("L", 50);
        assertSame("LXV", 65);
    }

    public void testInt100to3999() {
        assertSame("C", 100);
        assertSame("M", 1000);
        assertSame("MD", 1500);
        assertSame("MCCXXXIV", 1234);
        assertSame("MCM", 1900);
        assertSame("MMMCMXCIX", 3999);
    }

    // I    1    V    5
    // X   10    L   50
    // C  100    D  500
    // M 1000

    private void assertFail(int value) {
        try {
            converter.convertRomanNumber(value);
            fail();
        } catch (Exception e) {
        }
    }

    private void assertSame(int expect, String roman) {
        assertTrue(expect == converter.convertRomanNumber(roman));
    }

    private void assertSame(String expect, int roman) {
        assertEquals(expect, converter.convertRomanNumber(roman));
    }
}
