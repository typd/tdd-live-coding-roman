package typd;

public class Converter {

    public int convertRomanNumeral(String roman) {
        for (int i = 1; i <= 3999; i++) {
            String result = convertRomanNumber(i);
            if (result.equals(roman))
                return i;
        }
        return 0;
    }

    public Integer convertRomanNumber(String roman) {
        String romanLeft = roman;
        String lastDigitString = null;

        int ones = parseSingleDigit(romanLeft, "I", "V", "X");
        lastDigitString = convertSingleDigit(ones, "I", "V", "X");
        romanLeft = romanLeft.substring(0, romanLeft.length() - lastDigitString.length());

        int tens = parseSingleDigit(romanLeft, "X", "L", "C");
        lastDigitString = convertSingleDigit(tens, "X", "L", "C");
        romanLeft = romanLeft.substring(0, romanLeft.length() - lastDigitString.length());

        int hundreds = parseSingleDigit(romanLeft, "C", "D", "M");
        lastDigitString = convertSingleDigit(hundreds, "C", "D", "M");
        romanLeft = romanLeft.substring(0, romanLeft.length() - lastDigitString.length());

        int thousands = parseSingleDigit(romanLeft, "M", "*", "*");

        return ones + tens * 10 + hundreds * 100 + thousands * 1000;
    }

    private int parseSingleDigit(String roman, String one, String five, String ten) {
        if (roman.endsWith(one + five))
            return 4;
        for (int i = 9; i >= 1; i--) {
            String singleDigit = convertSingleDigit(i, one, five, ten);
            if (roman.endsWith(singleDigit))
                return i;
        }
        return 0;
    }

    public String convertRomanNumber(int value) {
        if (value <= 0)
            throw new RuntimeException("value should > 0, but now it's: " + value);
        if (value > 3999)
            throw new RuntimeException("value should < 4000, but now it's: " + value);
        String result = "";
        int ones = value % 10;
        int tens = (value % 100) / 10;
        int hundreds = (value % 1000) / 100;
        int thousands = value / 1000;
        result += convertSingleDigit(thousands, "M", "*", "*");
        result += convertSingleDigit(hundreds, "C", "D", "M");
        result += convertSingleDigit(tens, "X", "L", "C");
        result += convertSingleDigit(ones, "I", "V", "X");
        return result;
    }

    private String convertSingleDigit(int singleDigit, String one, String five, String ten) {
        String result = "";
        if (singleDigit < 0)
            throw new RuntimeException("singleDigit should > 0, but now it's: " + singleDigit);
        boolean hasFirstI = false;
        if ((singleDigit - 3) % 5 == 1) {
            result += one;
            hasFirstI = true;
        }

        if (singleDigit >= 9)
            result += ten;
        else if (singleDigit >= 4)
            result += five;

        if (!hasFirstI) {
            int lastIs = (singleDigit % 5);
            for (int i = 1; i <= lastIs; i++) {
                result += one;
            }
        }
        return result;
    }
}
