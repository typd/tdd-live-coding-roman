package typd;

import junit.framework.TestCase;

public class ConverterTest extends TestCase {
    private Converter converter = new Converter();

    public void testConvertStr() {
        for (int i = 1; i <= 3999; i++) {
            assertTrue(i == converter.convert(converter.convert(i)));
        }
    }

    public void testIllegal() {
        assertRomanFail(0);
        assertRomanFail(-1);
        assertRomanFail(-2);
        assertRomanFail(4000);
        assertRomanFail(10000);
    }

    public void test1to3() {
        assertRomanSame("I", 1);
        assertRomanSame("II", 2);
        assertRomanSame("III", 3);
    }

    public void test4and9() {
        assertRomanSame("IV", 4);
        assertRomanSame("IX", 9);
    }

    public void test5() {
        assertRomanSame("V", 5);
    }

    public void test6to8() {
        assertRomanSame("VI", 6);
        assertRomanSame("VII", 7);
        assertRomanSame("VIII", 8);
    }

    public void test10to13() {
        assertRomanSame("X", 10);
        assertRomanSame("XI", 11);
        assertRomanSame("XII", 12);
        assertRomanSame("XIII", 13);
    }

    public void test14to100() {
        assertRomanSame("XX", 20);
        assertRomanSame("XXV", 25);
        assertRomanSame("L", 50);
        assertRomanSame("LXII", 62);
        assertRomanSame("XLIX", 49);
        assertRomanSame("XCIX", 99);
    }

    public void test101toAbove() {
        assertRomanSame("C", 100);
        assertRomanSame("CCCXCII", 392);
        assertRomanSame("D", 500);
        assertRomanSame("MDCXXXI", 1631);
        assertRomanSame("MMXVI", 2016);
        assertRomanSame("MMMCMXCIX", 3999);
    }

    private void assertRomanSame(String expect, int arabic) {
        String actual = converter.convert(arabic);
        String message = arabic + "=>" + expect + ", not " + actual;
        assertTrue(message, expect.equals(converter.convert(arabic)));
    }

    private void assertRomanFail(int arabic) {
        try {
            converter.convert(arabic);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

}
