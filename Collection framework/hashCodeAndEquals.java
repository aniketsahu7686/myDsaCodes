import java.util.HashSet;
import java.util.*;

public class hashCodeAndEquals {
    public static void main(String[] args) {
        Set<Student> studentSet = new HashSet<>();

         studentSet.add(new Student("Aniket", 5));
         studentSet.add(new Student("Aditya", 4));
         studentSet.add(new Student("Abhisekh", 3));
         studentSet.add(new Student("pankaj", 1));

         // so here when i add a name akash with the roll no 1.
         // it is not able to differntiate as roll no1 is already present
         studentSet.add(new Student("akash", 1));

         // so here we have to tell that both are not same 
         // for that we have to implement the hashCode and  equals method (see in Student class)
        //  so after implement that no duplicates will be added
         System.out.println(studentSet);
    }
}
