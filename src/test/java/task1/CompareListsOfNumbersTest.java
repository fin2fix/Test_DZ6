package task1;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompareListsOfNumbersTest {
    CompareListsOfNumbers compareListsOfNumbers;
    List<Integer> integerListBase;


    @BeforeEach
    void setUp() {
        compareListsOfNumbers = new CompareListsOfNumbers();
        integerListBase = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    }

    @AfterEach
    void tearDown() {
        compareListsOfNumbers = null;
        integerListBase = null;

    }

    @Test
    @DisplayName("Среднее значение списка если на входе NULL")
    void findAverageValueIfNull() throws IllegalStateException {

        //блок кода, в котором может вылететь исключение
        Throwable thrown = assertThrows(IllegalStateException.class, () -> {
            compareListsOfNumbers.findAverageValue(null);
        });
        //Проверка, вылетело ли исключение. Если вылетело - то тест вернет положительный результат
        assertNotNull(thrown.getMessage());
    }

    @Test
    @DisplayName("Среднее значение списка если на входе Empty List")
    void findAverageValueIfEmptyList() throws IllegalStateException {

        //блок кода, в котором может вылететь исключение
        Throwable thrown = assertThrows(IllegalStateException.class, () -> {
            compareListsOfNumbers.findAverageValue(new ArrayList<>());
        });
        //Проверка, вылетело ли исключение. Если вылетело - то тест вернет положительный результат
        assertNotNull(thrown.getMessage());
    }

    @Test
    @DisplayName("Находим среднее значение списка при валидных входных данных")
    void findAverageValueIfListWithNumbers() {
        assertEquals(5.5, compareListsOfNumbers.findAverageValue(integerListBase));
    }


    @Test
    @DisplayName("Сравнение 2х списков - среднее значение первого списка больше")
    void compareTwoListsOfIntegerFirstListIsBigger() {
        List<Integer> integerListBigger = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90);
        assertEquals("Первый список имеет большее среднее значение", compareListsOfNumbers.compareTwoListsOfInteger(integerListBigger, integerListBase));
    }

    @Test
    @DisplayName("Сравнение 2х списков - среднее значение первого списка меньше")
    void compareTwoListsOfIntegerFirstListIsSmaller() {
        List<Integer> integerListSmaller = Arrays.asList(-1, -2, -3, -4, -5, -6, -7, -8, -9);
        assertEquals("Второй список имеет большее среднее значение", compareListsOfNumbers.compareTwoListsOfInteger(integerListSmaller, integerListBase));
    }

    @Test
    @DisplayName("Сравнение 2х списков - среднее значение обеих списков равны")
    void compareTwoListsOfIntegerListsEquals() {
        List<Integer> integerListEquals = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        assertEquals("Средние значения списков равны", compareListsOfNumbers.compareTwoListsOfInteger(integerListEquals, integerListBase));
    }

    @Test
    @DisplayName("Сравнение 2х списков - если на входе NULL")
    void compareTwoListsOfIntegerListsIfNull() throws IllegalStateException {

        //блок кода, в котором может вылететь исключение
        Throwable thrown = assertThrows(IllegalStateException.class, () -> {
            compareListsOfNumbers.compareTwoListsOfInteger(null, integerListBase);
        });
        //Проверка, вылетело ли исключение. Если вылетело - то тест вернет положительный результат
        assertNotNull(thrown.getMessage());
    }

    @Test
    @DisplayName("Сравнение 2х списков - если на входе Empty List")
    void compareTwoListsOfIntegerListsIfEmpty() throws IllegalStateException {

        //блок кода, в котором может вылететь исключение
        Throwable thrown = assertThrows(IllegalStateException.class, () -> {
            compareListsOfNumbers.compareTwoListsOfInteger(new ArrayList<>(), integerListBase);
        });
        //Проверка, вылетело ли исключение. Если вылетело - то тест вернет положительный результат
        assertNotNull(thrown.getMessage());
    }
}
