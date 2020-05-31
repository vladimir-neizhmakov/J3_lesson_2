import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

public class HW6_Test {
    private HW6 hw6;

    @BeforeEach
    public void init() {
        hw6 = new HW6();
    }

    @Test
    public void Test_HW6_2_Values1_ExtractFromPacket() {
        int[] input = {3,4,5,6,8,9};
        int[] output = {5,6,8,9};
        Assertions.assertEquals(Arrays.toString(output), Arrays.toString(hw6.ExtractFromPacket(input)));
    }

    @Test
    public void Test_HW6_2_Values2_ExtractFromPacket() {
        int[] input = {3,4,5,7,8,9,5,4,2,3,7,6,8,9};
        int[] output = {2,3,7,6,8,9};
        Assertions.assertArrayEquals(output, hw6.ExtractFromPacket(input));
    }
    @Test
    public void Test_HW6_2_Values3_ExtractFromPacket() {
        int[] input = {3,4,5,6,8,9,4};
        int[] output = {};
        Assertions.assertArrayEquals(output, hw6.ExtractFromPacket(input));
    }

    @Test
    public void Test_HW6_2_Exception_ExtractFromPacket() {

        Assertions.assertThrows(RuntimeException.class, ()-> {
            int[] input = {3,3,5,6,8,9};
            hw6.ExtractFromPacket(input);
            });
        }

    @Test
    public void Test_HW6_3_Values1_Find14() {
        int[] input = {3,4,5,6,8,1,9,4,1};
        Assertions.assertTrue(hw6.Find14(input));
    }

    @Test
    public void Test_HW6_3_Values2_Find14() {
        int[] input = {3,4,5,6,8,9,4};
        Assertions.assertFalse(hw6.Find14(input));
    }

    @Test
    public void Test_HW6_3_Values3_Find14() {
        int[] input = {3,4,5,2,2,2,5,9,0,1,6,8,9,4};
        Assertions.assertEquals(true,hw6.Find14(input));
    }

    @Test
    public void Test_HW6_3_Values4_Find14() {
        int[] input = {3,4,5,2,2,2,5,9,0,6,8,9,4};
        Assertions.assertEquals(false,hw6.Find14(input));
    }

}
