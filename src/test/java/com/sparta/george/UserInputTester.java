package com.sparta.george;

import com.sparta.george.customExceptions.SorterNotFoundException;
import com.sparta.george.start.Starter;
import com.sparta.george.utility.GetNumbers;
import com.sparta.george.utility.UserChoice;
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

    @Test
    @DisplayName("The test checks if chooseSorter method returns the correct sorter")
    public void shouldReturnBubbleSorter() throws SorterNotFoundException {
        String simulatedUserInput = "1";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(in);

        Assertions.assertEquals(Starter.SortTypes.BUBBLE, UserChoice.chooseSorter(new int[]{1,2,3}));
    }

    @Test
    @DisplayName("The test checks if chooseSorter method returns the correct sorter")
    public void shouldReturnMergeSorter() throws SorterNotFoundException {
        String simulatedUserInput = "2";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(in);

        Assertions.assertEquals(Starter.SortTypes.MERGE, UserChoice.chooseSorter(new int[]{1,2,3}));
    }

    @Test
    @DisplayName("The test checks if chooseSorter method returns the correct sorter")
    public void shouldReturnTreeSorter() throws SorterNotFoundException {
        String simulatedUserInput = "3";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(in);

        Assertions.assertEquals(Starter.SortTypes.TREE, UserChoice.chooseSorter(new int[]{1,2,3}));
    }
}
