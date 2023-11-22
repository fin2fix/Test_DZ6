package task1;

import java.util.List;

public class CompareListsOfNumbers {

    public Double findAverageValue(List<Integer> integerList) {
        if (integerList == null || integerList.isEmpty()) {
            throw new IllegalStateException("List is null or empty");
        } else {
            return integerList.stream().mapToInt(e -> e).average().getAsDouble();
        }
    }

    public String compareTwoListsOfInteger(List<Integer> integerList1, List<Integer> integerList2) {
        return switch (Double.compare(findAverageValue(integerList1), findAverageValue(integerList2))) {
            case 0 -> "Средние значения списков равны";
            case -1 -> "Второй список имеет большее среднее значение";
            case 1 -> "Первый список имеет большее среднее значение";
            default -> throw new IllegalStateException("One of the Lists is incorrect");
        };
    }

    public void printResults(String string) {
        System.out.println(string);
    }

}
