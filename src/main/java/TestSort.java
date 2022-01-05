import java.util.Comparator;

public class TestSort {
    public static void main(String[] args) {

        MakeshiftList<Person> list = new MakeshiftArrayListImpl<>();

        list.add(new Person(5, "Name5"));
        list.add(new Person(7, "Name07"));
        list.add(new Person(1, "Name1"));
        list.add(new Person(3, "Name3333"));
        list.add(new Person(2, "Name22"));
        list.add(new Person(6, "Name6"));
        list.add(new Person(4, "Name"));

        System.out.println("Before sort");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        MyCollections.sort(list, Comparator.comparingInt(Person::getId));

        System.out.println("after");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

class Person implements Comparable<Person> {
    private final int id;
    private final String name;

    public int getId() {
        return id;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.id, o.getId());
    }
}


