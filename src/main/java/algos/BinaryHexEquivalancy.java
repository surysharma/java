package algos;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 Given two string's one in binary and another in Hex. Find if they are equal
 a= "1111000000001101"
 b = "0xF00D"
 Both represent's decimal number 61453
 */
public class BinaryHexEquivalancy {

    public static void main(String[] args) {

        String[] hex = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A",
                "B", "C", "D", "E", "F"};

        String a= "1111000000001101";
        String b = "0xF00D";

        String[] achar = a.split("");
        double result2 = convertToDecimal(achar, 2, Integer::valueOf);
        System.out.println(result2);

        String[] bchar = b.substring(2).split("");
        double result1 = convertToDecimal(bchar, 16, hexVal -> Arrays.binarySearch(hex, hexVal));
        System.out.println(result1);

        System.out.println(result1 == result2);
    }

    private static double convertToDecimal(String[] achar, int base, Function<String, Integer> fn) {

        double decimalVal = 0;
        for (int i = achar.length - 1, j=0; i > -1; i--, j++) {
            int num = fn.apply(achar[i]);
            decimalVal = decimalVal + (num * Math.pow(base, j));
        }

        return decimalVal;
    }
}
