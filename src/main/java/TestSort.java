import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestSort {
    public static void main(String[] args) {

        MakeshiftList<Person> list = new MakeshiftArrayListImpl<>();

        list.add(new Person(5,"Name5"));
        list.add(new Person(1,"Name1"));
        list.add(new Person(3,"Name3333"));
        list.add(new Person(2,"Name22"));
        list.add(new Person(6,"Name6"));
        list.add(new Person(4,"Name"));

        System.out.println("Before sort");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        list.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getId() > o2.getId()){
                    return 1;
                }else if(o1.getId() < o2.getId()){
                    return -1;
                }else return 0;
            }
        });

        System.out.println("after");
        for(int i = 0; i < list.size(); i++){
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


