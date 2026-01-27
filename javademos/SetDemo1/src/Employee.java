import java.util.Objects;

public class Employee implements Comparable<Employee>{
    private int eid;
    private String ename;
    private double sal;

    public Employee() {

    }

    public Employee(int eid, String ename, double sal) {
        this.eid = eid;
        this.ename = ename;
        this.sal = sal;
    }

    public Employee(int eid) {
        this.eid = eid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        System.out.println("in employee equals "+ this.eid+ employee.eid);
        return eid == employee.eid;
    }

    @Override
    public int hashCode() {
        System.out.println("in employee hashcode "+ this.eid);
       return eid;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", sal=" + sal +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        System.out.println("In Employees CompareTo method"+this.eid+"----->"+o.eid);
        return this.eid-o.eid;
    }
}
