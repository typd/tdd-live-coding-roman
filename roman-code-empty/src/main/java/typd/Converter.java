package typd;

public class Converter {
    public int convert(String roman) {
        for (int i = 1; i <= 3999; i++) {
            String result = convert(i);
            if (result.equals(roman))
                return i;
        }
        throw new IllegalArgumentException("wrong input" + roman);
    }

    public String convert(int value) {
        if (value <= 0)
            throw new IllegalArgumentException("value should > 0, now it's " + value);
        if (value > 3999)
            throw new IllegalArgumentException("value should <= 3999, now it's " + value);
        int thousands = (value / 1000) % 10;
        int hundreds = (value / 100) % 10;
        int tens = (value / 10) % 10;
        int ones = value % 10;
        String onesStr = convertSingleDigit(ones, "I", "V", "X");
        String tensStr = convertSingleDigit(tens, "X", "L", "C");
        String hundredsStr = convertSingleDigit(hundreds, "C", "D", "M");
        String thousandsStr = convertSingleDigit(thousands, "M", "*", "*");
        return thousandsStr + hundredsStr + tensStr + onesStr;
    }

    private String convertSingleDigit(int value, String one, String five, String ten) {
        String result = "";

        String key = "";
        if (value >= 9)
            key = ten;
        else if (value >= 4)
            key = five;
        result += key;

        if (value == 4 || value == 9) {
            result = one + result;
            return result;
        }

        for (int i = 1; i <= (value % 5); i++) {
            result += one;
        }

        return result;
    }
}
