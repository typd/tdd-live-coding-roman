package typd;

import junit.framework.TestCase;

public class ConverterTest extends TestCase {
    private Converter converter = new Converter();

    public void testIllegal() {
        try {
            converter.convertRomanNumber(-1);
            fail();
        } catch (Exception e) {
        }
        try {
            converter.convertRomanNumber(0);
            fail();
        } catch (Exception e) {
        }
    }

    public void test1() {
        assertSame("I", 1);
    }

    public void test2() {
        assertSame("II", 2);
    }

    public void test3() {
        assertSame("III", 3);
    }

    public void test5() {
        assertSame("V", 5);
    }

    public void test6() {
        assertSame("VI", 6);
    }

    public void test7() {
        assertSame("VII", 7);
    }

    public void test8() {
        assertSame("VIII", 8);
    }

    public void testBelowOrEqual10() {
        assertSame("IV", 4);
        assertSame("IX", 9);
    }

    public void test10to100() {
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

    private void assertSame(String expect, int roman) {
        assertEquals(expect, converter.convertRomanNumber(roman));
    }
}
