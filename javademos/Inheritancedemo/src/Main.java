import com.demo.beans.Employee;
import com.demo.beans.SalariedEmp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SalariedEmp salEmp=new SalariedEmp(12,"Rajan","33333","HR","manager",200000);
        System.out.println(salEmp);

    }
}