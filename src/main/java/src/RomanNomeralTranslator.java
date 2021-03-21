package src;

public interface RomanNomeralTranslator {

    public String toRoman(int n);

    public int fromRoman(String romanNumeral);

    default public String integerToRoman(String num) {
        switch (num) {
            case "1":
                return "I";
            case "5":
                return "V";
            case "10":
                return "X";
            case "50":
                return "L";
            case "100":
                return "C";
            case "500":
                return "D";
            case "1000":
                return "M";
            default:
                return "";
        }
    }

    default public int romanToInteger(String num) {
        switch (num) {
            case "I":
                return 1;
            case "V":
                return 5;
            case "X":
                return 10;
            case "L":
                return 50;
            case "C":
                return 100;
            case "D":
                return 500;
            case "M":
                return 1000;
            default:
                return 0;
        }
    }
}
