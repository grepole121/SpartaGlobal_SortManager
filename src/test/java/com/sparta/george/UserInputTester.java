package com.sparta.george;

import com.sparta.george.utility.GetNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class UserInputTester {
    @Test
    @DisplayName("The test checks if non-numeric character is inputted to getNumbers method")
    public void shouldReturnEmptyArray() {
        String simulatedUserInput = "t";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(in);

        Assertions.assertArrayEquals(new int[]{}, GetNumbers.getNumbers());
    }

    @Test
    @DisplayName("The test checks if numeric characters are inputted to getNumbers method")
    public void shouldReturnArrayOfInts() {
        String simulatedUserInput = "4" + System.getProperty("line.separator")
                + "8" + System.getProperty("line.separator")
                + "2" + System.getProperty("line.separator")
                + "13" + System.getProperty("line.separator")
                + "5" + System.getProperty("line.separator");

        ByteArrayInputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(in);

        Assertions.assertArrayEquals(new int[]{8, 2, 13, 5}, GetNumbers.getNumbers());
    }
}
