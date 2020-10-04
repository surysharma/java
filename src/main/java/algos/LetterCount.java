package algos;

public class LetterCount {
    public static void main(String[] args) {

        String[] str = new String[]{"a", "b", "a", "c", "c"};
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length; i++) {
            int c = str[i].charAt(0);
            boolean aChar = char_set[c];
            if (aChar) {
                System.out.println("Duplicate found...");
            } else {
                char_set[c] = true;
            }
        }
    }
}
