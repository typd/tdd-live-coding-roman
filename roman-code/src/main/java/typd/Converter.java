package typd;

public class Converter {

    public String convertRomanNumber(int value) {
        if (value <= 0)
            throw new RuntimeException("value should > 0, but now it's: " + value);
        String result = "";
        int ones = value % 10;
        int tens = (value % 100) / 10;
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
