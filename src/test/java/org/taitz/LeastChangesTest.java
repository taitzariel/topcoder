package org.taitz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by taitz.
 */
class LeastChangesTest {

    private static Stream<Arguments> provideTestInputsAndExpected() {
        return Stream.of(
                Arguments.of(new int[]{3, 7, 7, 7, 6}, new int[]{3, 7, 7, 7, 7}),
                Arguments.of(new int[]{10, 8}, new int[]{1, 8}),
                Arguments.of(new int[]{ 6, 9 }, new int[]{ 6, 9 }),
                Arguments.of(new int[]{ 9, 8, 10, 4 }, new int[]{1, 8, 10, 10 })
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestInputsAndExpected")
    void increasingLeastChanges(int[] input, int[] expected) {

        int[] actual = new LeastChanges().increasingLeastChanges(input);

        assertArrayEquals(expected, actual);
    }

}
