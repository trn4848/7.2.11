/*Магазину нужно сохранять информацию о продажах для каждого сотрудника. Напишите метод Map getSalesMap(Reader reader) который принимает Reader содержащий строки вида:

        Алексей 3000
        Дмитрий 9000
        Антон 3000
        Алексей 7000
        Антон 8000
        Метод должен получить все строки из Readera и заполнить и вернуть карту где ключом будет имя сотрудника, а значением сумма всех его продаж.

        Пример ввода:


        Алексей 3000
        Дмитрий 9000
        Антон 3000
        Алексей 7000
        Антон 8000
        Пример вывода:
        {Алексей=[10000], Дмитрий=[9000], Антон=[11000]}

        Требования:
        1. Должен быть метод public static Map<String, Long> getSalesMap(Reader reader)
        2. Работа метода getSalesMap должна удовлетворять условию*/

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

//Что произойдет? Почему отработает 2 метод? Как это исправить?

public class Pair {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        Gen gen = new Gen();
        gen.m(integerList);
    }
    static class Gen<T> {
        <T> void m(Collection<T> collection) {
            for (T s : collection) {
                System.out.println(s+ " 1й метод");
            }
        }
        <T> void m(List<String> list) {
            for (String s : list) {
                System.out.println(s+ " 2й метод");
            }
        }
    }
}
