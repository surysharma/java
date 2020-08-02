package algos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomSetTest {
    private CustomSet customSet = new CustomSet();

    @Test
    public void should_add_first_num() {
        boolean result = customSet.add(1);
        assert result == true;
    }

    @Test
    public void should_check_if_set_contains_element() {
        boolean result = customSet.add(1);
        assert result == true;

        Assertions.assertEquals(true, customSet.contains(1));
    }

    @Test
    public void should_add_same_num_twice() {
        boolean result = customSet.add(1);
        assert result == true;

        result = customSet.add(1);
        assert result == false;
    }

    @Test
    public void should_add_unique_nums() {
        customSet.add(1);
        customSet.add(2);
        customSet.add(3);

        assert customSet.contains(3) == true;
        assert customSet.contains(2) == true;
        assert customSet.contains(1) == true;
        assert customSet.contains(4) == false;
    }

    @Test
    public void should_add_unique_strings() {
        CustomSet strSet = new CustomSet();
        strSet.add("apple");
        strSet.add("oranges");
        strSet.add("banana");

        assert strSet.contains("oranges") == true;
        assert strSet.contains("apple") == true;
        assert strSet.contains("banana") == true;
        assert strSet.contains("mango") == false;
    }

    @Test
    public void should_have_size() {
        customSet.add(1);
        customSet.add(2);
        customSet.add(3);

        assert customSet.length() == 3;
    }

}
