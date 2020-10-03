package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 Given two arrays
 a[2,3,9,19,15,6,5]
 b[19,10,12,6,11,7]

 We should print the common no.'s like
 [6,9, 12]
 */
public class CommonNumbersInArray {

    public static void main(String[] args) {

        int[] a = new int[]{13,27,35,40,49,55,59};
        int[] b = new int[]{17,35,39,40,55,58,60};
        Arrays.sort(a);
        Arrays.sort(b);
        int foundIndex = 0;
        List<Integer> commonNumbers = new ArrayList<>();
        for (int i=0; i< a.length; i++) {
            foundIndex = Arrays.binarySearch(b, foundIndex, b.length, a[i]);
            if (foundIndex >=0) {
                commonNumbers.add(a[i]);
            } else {
                foundIndex = 0;
            }
        }

        System.out.println(String.join(" ", commonNumbers.stream().map(String::valueOf).collect(Collectors.toList())));
    }
}
