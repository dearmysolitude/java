package basic;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PassByValue {
    @Test
    void addArray() {
        String[] strings = new String[2];
        strings[0] = "Hello";
        add(strings);
        
        assertThat(strings[1]).isEqualTo("Java");
    }
    private void add(String[] arrays) {
        arrays[1] = "Java";
    }
}
