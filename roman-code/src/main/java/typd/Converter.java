package typd;

public class Converter {

    public String convertRomanNumber(int value){
        if (value == 1)
            return "I";
        if (value == 2)
            return "II";
        if (value == 3)
            return "III";
        if (value == 4)
            return "IV";
        if (value == 5)
            return "V";
        return null;
    }

}
