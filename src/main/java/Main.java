import java.util.*;

public class Main {
    public static void main(String[] args) {

        oneTask();

        twoTask();

        threeTask();

        complementaryTask();

    }

    private static void oneTask() {
        System.out.println("Первое задание \n");
        String[] arrStr = new String[]{"А", "B", "C"};
        Integer[] arrInt = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        Object[] arrObj = new Object[]{1, 1.0, "S", true};

        swapTwoElementsOfAnArray(arrStr, 0, 2);
        swapTwoElementsOfAnArray(arrInt, 3, 6);
        swapTwoElementsOfAnArray(arrObj, 0, 3);

        System.out.println(Arrays.toString(arrStr));
        System.out.println(Arrays.toString(arrInt));
        System.out.println(Arrays.toString(arrObj));

    }

    private static void twoTask() {
        System.out.println("\nВторое задание \n");
        Object[] arrObj = new Object[]{1, 1.0, "S", true};
        String[] arrStr = new String[]{"А", "B", "C"};
        ArrayList<?> arrayList = conversionToArrayList(arrObj);
        ArrayList<?> arrayList2 = conversionToArrayList(arrStr);

        System.out.println(arrayList.toString());
        System.out.println("Размер коллекции: " + arrayList.size());
        System.out.println(arrayList2.toString());
        System.out.println("Размер коллекции: " + arrayList2.size());

    }

    private static void threeTask() {
        System.out.println("\nТретье задание \n");
        Box<Apple> boxApple = new Box<>();
        Box<Orange> boxOrange = new Box<>();
        Box<?> box = new Box<>();

        Apple apple = new Apple();
        Orange orange = new Orange();
        Apple appleRed = new Apple();
        Orange orangeYellow = new Orange();

        boxApple.addInBox(apple, 4);
        boxApple.addInBox(appleRed);

        boxOrange.addInBox(orange, 30);
        boxOrange.addInBox(orangeYellow);

        System.out.println("Вес коробки с яблоками: " + boxApple.getWeight());
        System.out.println("Вес коробки с апельсинами: " + boxOrange.getWeight());

        System.out.println(boxApple.compare(boxOrange));

        boxApple.pourContent(box);
        boxOrange.pourContent(box);

        boxApple.addInBox(apple);
        boxApple.pourContent(box);

        box.info();
        boxApple.info();

        boxApple.pourContent(box);


    }

    private static void complementaryTask() {
        System.out.println("\nДополнительное задание \n");
        String[] words = new String[]{"A", "B", "C", "D", "E", "A", "B", "C", "B", "C", "D"};
        words = removeDuplicates(words);
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + " ");
        }
    }

    private static <T> void swapTwoElementsOfAnArray(T[] a, int i, int j) {
        try {
            T t = a[i];
            a[i] = a[j];
            a[j] = t;
        } catch (ArrayIndexOutOfBoundsException exp) {
            System.out.println("Указаны несуществующие индексы\n Доступные индексы: от 0 до " + (a.length - 1));
        }
    }

    private static <T> ArrayList<T> conversionToArrayList(T[] a) {
        ArrayList<T> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, a);
        return arrayList;

    }


    private static String[] removeDuplicates(String[] words) {
        Set<String> set = new HashSet<String>(Arrays.asList(words));
        String[] temp = new String[set.size()];
        set.toArray(temp);
        return temp;
    }
}
