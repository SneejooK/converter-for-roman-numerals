package src;

public class RomanNomeral implements RomanNomeralTranslator {

    @Override
    public String toRoman(int n) {
        StringBuilder sb = new StringBuilder();
        String[] array = String.valueOf(n).split("");
        if (n >= 10000) {
            int count = n / 10000;
            count *= 10;
            while (count-- > 0) {
                sb.append(translator("1000"));
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals("0")) {
                for (int j = 0; j < (array.length - (i + 1)); j++) {
                    array[i] += "0";
                }
            }
        }
        for (String s : array) {
            if (!s.equals("0")) {
                sb.append(translator(s));
            }
        }
        return sb.toString();
    }

    @Override
    public int fromRoman(String romanNumeral) {
        int answer = 0;
        String[] array = romanNumeral.split("");
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                if (romanToInteger(array[i]) < romanToInteger(array[i + 1])) {
                    answer += romanToInteger(array[i + 1]) - romanToInteger(array[i]);
                    i++;
                } else if (romanToInteger(array[i]) == romanToInteger(array[i + 1])) {
                    answer += romanToInteger(array[i]) + romanToInteger(array[i + 1]);
                    i++;
                } else {
                    answer += romanToInteger(array[i]);
                }
            } else {
                answer += romanToInteger(array[i]);
            }
        }
        return answer;
    }
    
    public String translator(String num) {
        if (!integerToRoman(num).isEmpty()) {
            return integerToRoman(num);
        } else {
            StringBuilder sb = new StringBuilder();
            int number = Integer.valueOf(num.substring(0, 1));
            if (!integerToRoman(String.valueOf(number + 1) + num.substring(1)).isEmpty()) {
                sb.append(integerToRoman(String.valueOf(1) + num.substring(1))
                        + translator(String.valueOf(number + 1) + num.substring(1)));
            } else {
                for (int i = 1; i <= 10; i++) {
                    number--;
                    if (!integerToRoman(String.valueOf(number) + num.substring(1)).isEmpty()) {
                        sb.append(integerToRoman(String.valueOf(number) + num.substring(1))
                                + translator(String.valueOf(i) + num.substring(1)));
                        break;
                    }
                }
            }
            return sb.toString();
        }
    }
}
