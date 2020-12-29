import org.junit.Test;

import java.util.List;

/**
 * @description:
 * @author: chenyan
 * @time: 2020/12/25 18:17
 */
public class LetterCombinationTest {
    @Test
    public void letterCombinationTest() {
        Integer[] input0 = new Integer[]{0, 1, 2};
        Integer[] input1 = new Integer[]{0, 1, 6, 1, 0};
        Integer[] input2 = new Integer[]{6, 88};
        Integer[] input3 = new Integer[]{2, 01, 10, 00, 99};

        List<String> output0 = LetterCombinationUntil.digitToCharacterConversion(input0);
        System.out.println("\nOutput value:" + output0.toString());

        List<String> output1 = LetterCombinationUntil.digitToCharacterConversion(input1);
        System.out.println("\nOutput value:" + output1.toString());

        List<String> output2 = LetterCombinationUntil.digitToCharacterConversion(input2);
        System.out.println("\nOutput value:" + output2.toString());

        List<String> output3 = LetterCombinationUntil.digitToCharacterConversion(input3);
        System.out.println("\nOutput value:" + output3.toString());

    }

}
