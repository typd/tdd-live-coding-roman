package typd;

import junit.framework.TestCase;

public class ConverterTest extends TestCase {
    private Converter converter = new Converter();

    public void test1() {
        assertSame("I", 1);
    }

    public void test2() {
        assertSame("II", 2);
    }

    public void test3() {
        assertSame("III", 3);
    }

    public void test4() {
        assertSame("IV", 4);
    }

    public void test5() {
        assertSame("V", 5);
    }

    public void test6to8() {
        assertSame("VI", 6);
        assertSame("VII", 7);
        assertSame("VIII", 8);
    }

    private void assertSame(String expect, int roman) {
        assertSame(expect, converter.convertRomanNumber(roman));
    }
}
