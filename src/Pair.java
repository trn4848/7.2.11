

/*Реализуйте generic-класс Pair, похожий на Optional, но содержащий пару элементов разных типов и не запрещающий элементам принимать значение null.

        Реализуйте методы getFirst(), getSecond(), equals() и hashCode(), а также статический фабричный метод of(). Конструктор должен быть закрытым (private).

        С корректно реализованным классом Pair должен компилироваться и успешно работать следующий код:


        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        Пожалуйста, не меняйте модификатор доступа класса Pair. Для корректной проверки класс должен иметь пакетную видимость.*/


import java.util.Objects;

public  class Pair<T,V> {
    private T obj1;
    private V obj2;

    private Pair(T obj1, V obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        System.out.println(pair);
        Integer i = pair.getFirst();
        System.out.println(i);
        String s = pair.getSecond();
        System.out.println(s);
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        System.out.println(pair2);
        boolean mustBeTrue = pair.equals(pair2);
        System.out.println(mustBeTrue);
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode();
        System.out.println(mustAlsoBeTrue);

    }
    public static <T,V> Pair<T,V> of(T obj1, V obj2) {
        return new Pair<>(obj1,obj2);
    }

     public T getFirst(){
        return obj1;
    };

    public V getSecond(){
        return obj2;
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return obj1.equals(pair.obj1) && obj2.equals(pair.obj2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(obj1, obj2);
    }
}


