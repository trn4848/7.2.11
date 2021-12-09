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


import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Map;

public class Pair {

    public static void main(String[] args) {
    String source = "Алексей 3000\n" +
            "        Дмитрий 9000\n" +
            "        Антон 3000\n" +
            "        Алексей 7000\n" +
            "        Антон 8000";
        StringReader s = new StringReader(source);
        BufferedReader reader = new BufferedReader(s);
        System.out.println(getSalesMap(reader));
    }


    public static Map<String, Long> getSalesMap(Reader reader) {
        //Твой код здесь
    }

}


