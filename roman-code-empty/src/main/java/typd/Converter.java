package typd;

public class Converter {

    public int convert(String roman) {
        for (int i = 1; i <= 3999; i++) {
            String result = convert(i);
            if (result.equals(roman))
                return i;
        }
        throw new IllegalArgumentException("wrong roman " + roman);
    }

    public String convert(int value) {
        if (value <= 0)
            throw new IllegalArgumentException("value should > 0, but actual value is " + value);
        if (value > 3999)
            throw new IllegalArgumentException("value should <= 3999, but actual value is " + value);
        int ones = value % 10;
        int tens = value % 100 / 10;
        int hundreds = value % 1000 / 100;
        int thousands = value % 10000 / 1000;
        String thousandsStr = convertSingleDigit(thousands, "M", "*", "*");
        String hundredsStr = convertSingleDigit(hundreds, "C", "D", "M");
        String tensStr = convertSingleDigit(tens, "X", "L", "C");
        String onesStr = convertSingleDigit(ones, "I", "V", "X");
        return thousandsStr + hundredsStr + tensStr + onesStr;
    }

    private String convertSingleDigit(int value, String one, String five, String ten) {
        String key = "";
        if (value >= 9)
            key = ten;
        else if (value >= 4)
            key = five;
        else
            key = "";

        String result = "";
        if (value == 4 || value == 9) {
            result = one + key;
            return result;
        }

        result += key;

        int leftIs = value % 5;
        for (int i = 1; i <= leftIs; i++)
            result += one;
        return result;
    }

}
