import java.util.ArrayList;

public class Box<T extends Fruit> {
    ArrayList<T> box = new ArrayList<T>();
    ;

    void addInBox(T o) {
        box.add(o);
    }

    void addInBox(T o, int k) {
        if (box == null) {
            box = new ArrayList<T>();
        }
        for (int i = 0; i < k; i++) {
            box.add(o);
        }
    }

    double getWeight() {
        if (box == null) {
            return 0;
        }
        return box.get(0).getWeight() * box.size();
    }

    <V extends Box> boolean compare(V o) {
        return getWeight() == o.getWeight();
    }

    <V extends Box> void pourContent(V o) {
        if (box.size() != 0) {
            if (o.box.isEmpty() || o.box.get(0).getClass() == box.get(0).getClass()) {
                for (T t : box) {
                    o.box.add(t);
                }
                box.clear();
            } else System.out.println("В коробку нельзя насыпать: " + box.get(0).getClass().getName());

        } else System.out.println("Коробка пуста, нечего пересыпать");

    }


    void info() {
        System.out.println(box.toString());
    }
}
