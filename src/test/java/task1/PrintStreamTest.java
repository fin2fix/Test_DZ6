package task1;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class PrintStreamTest {
    CompareListsOfNumbers compareListsOfNumbers;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        compareListsOfNumbers = new CompareListsOfNumbers();
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("Проверка вывода сообщения в консоль")
    public void checkPrintInConsole() {
        compareListsOfNumbers.printResults(compareListsOfNumbers.compareTwoListsOfInteger(Arrays.asList(1, 2, 3, 4), Arrays.asList(4, 3, 2, 1)));
        Assertions.assertEquals("Средние значения списков равны", outputStreamCaptor.toString().trim());
    }

}