import java.util.*;

public class CustomCollectionsEx {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        list.add(new Student("asii", 1));
        list.add(new Student("vjiosod", 2));
        list.add(new Student("ijosdfii", 3));
        list.add(new Student("jsfohi", 4));


        // here it will no be excute beause , we have still not implmented the comparable in it
        Collections.sort(list);

        // so to do this we have implement an interface which is Comparable in Student class
    }
}
