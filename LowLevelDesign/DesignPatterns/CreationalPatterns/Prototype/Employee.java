package LowLevelDesign.DesignPatterns.CreationalPatterns.Prototype;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Cloneable {

    private List<String> empList;

    public Employee() {
        empList = new ArrayList<>();
    }

    public Employee(List<String> list) {
        this.empList = list;
    }

    public void loadData() {
        // read all employees from database and put into the list
        empList.add("Pankaj");
        empList.add("Raj");
        empList.add("David");
        empList.add("Lisa");
    }

    public List<String> getEmpList() {
        return empList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // clone method is overridden to provide a deep copy of the employee list
        List<String> temp = new ArrayList<>();
        for (String s : this.getEmpList()) {
            temp.add(s);
        }
        return new Employee(temp);
    }

}
