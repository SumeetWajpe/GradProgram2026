import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Set<Employee> eset=new HashSet<>();
        eset.add(new Employee(12,"xxxx",4567));
        eset.add(new Employee(13,"xxxx",4567));
        eset.add(new Employee(12,"yyy",4567));
        eset.forEach(System.out::println);
        eset.remove(new Employee(13));


        Set<Employee> ts=new TreeSet<>();
        ts.add(new Employee(10,"x",44444));
        ts.add(new Employee(7,"x",44444));
        ts.add(new Employee(7,"x",44444));
        ts.forEach(System.out::println);

        Comparator<Employee> c=(o1, o2)->{
            System.out.println("using salary comparator");
            return (int)(o1.getSal()-o2.getSal());
        };
        Set<Employee> ts1=new TreeSet<>(c);
        ts1.add(new Employee(10,"x",44444));
        ts1.add(new Employee(7,"x",44444));
        ts1.add(new Employee(7,"x",44444));
        ts1.forEach(System.out::println);


    }
}