package algos;

import java.util.*;
import java.util.stream.Collectors;

public class PalindromeText {
    public static void main(String[] args) {

        String text = "abc";

        Set<String> set = getPermutationsOf(text);

        List<String> palindromes = set.stream().filter(item -> isPalindrome(item) == true)
                .collect(Collectors.toList());
        palindromes.forEach(System.out::println);

    }

    private static boolean isPalindrome(String text) {
        String[] textArray = text.split("");
        List<String> originalList = Arrays.asList(textArray);

        List<String> reverseList = Arrays.asList(textArray);

        Collections.reverse(reverseList);

        return reverseList.equals(originalList);
    }



    private static void log(Set<String> set) {
        set.stream().forEach(x -> System.out.print(String.join("",x, " ")));
    }

    private static Set<String> getPermutationsOf(String text) {

        char[] textArray = text.toCharArray();

        Set<String> set = new HashSet<>();
        set.add(text);
        for(int i=0;i < textArray.length; i++) {
            for(int j=i+1; j< textArray.length; j++) {
                String swappedText = swap(i, j, textArray);
                set.add(swappedText);
            }
        }
        //log(set);
        return set;
    }

    private static String swap(int i, int j, char[] textArray) {

        char[] localCopy = Arrays.copyOf(textArray, textArray.length);

        char temp = localCopy[j];
        localCopy[j]=localCopy[i];
        localCopy[i]=temp;

        return String.valueOf(localCopy);
    }
}
