package typd;

import junit.framework.TestCase;

public class ConverterTest extends TestCase {
    private Converter converter = new Converter();

    public void testStr() {
        assertEquals(1, converter.convert("I"));
        for (int i = 1; i <= 3999; i++) {
            assertEquals(i, converter.convert(converter.convert(i)));
        }
    }

    public void test100toAbove() {
        assertEquals("C", converter.convert(100));
        assertEquals("CD", converter.convert(400));
        assertEquals("D", converter.convert(500));
        assertEquals("DC", converter.convert(600));
        assertEquals("CMXCIX", converter.convert(999));
        assertEquals("MMXVI", converter.convert(2016));
        assertEquals("M", converter.convert(1000));
        assertEquals("MMMCMXCIX", converter.convert(3999));
    }

    public void test10to99() {
        assertEquals("X", converter.convert(10));
        assertEquals("XLIX", converter.convert(49));
        assertEquals("XL", converter.convert(40));
        assertEquals("L", converter.convert(50));
        assertEquals("XC", converter.convert(90));
        assertEquals("XCIX", converter.convert(99));
    }

    public void testIllegal() {
        assertFail(0);
        assertFail(-1);
        assertFail(4000);
        assertFail(10000);
    }

    public void test4and9() {
        assertEquals("IV", converter.convert(4));
        assertEquals("IX", converter.convert(9));
    }

    public void test1to3() {
        assertEquals("I", converter.convert(1));
        assertEquals("II", converter.convert(2));
        assertEquals("III", converter.convert(3));
    }

    public void test5() {
        assertEquals("V", converter.convert(5));
    }

    public void test6to8() {
        assertEquals("VI", converter.convert(6));
        assertEquals("VII", converter.convert(7));
        assertEquals("VIII", converter.convert(8));
    }

    private void assertFail(int value) {
        try {
            converter.convert(value);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

}
