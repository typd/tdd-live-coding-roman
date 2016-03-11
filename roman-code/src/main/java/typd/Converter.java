package typd;

public class Converter {

    public String convertRomanNumber(int value) {
        if (value <= 0)
            throw new RuntimeException("value should > 0, but now it's: " + value);
        String result = "";

        boolean hasFirstI = false;
        if ((value - 3) % 5 == 1) {
            result += "I";
            hasFirstI = true;
        }

        if (value >= 9)
            result += "X";
        else if (value >= 4)
            result += "V";

        if (!hasFirstI) {
            int lastIs = (value % 5);
            for (int i = 1; i <= lastIs; i++) {
                result += "I";
            }
        }
        return result;
    }

}
