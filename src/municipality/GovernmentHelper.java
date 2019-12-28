package municipality;

import java.util.ArrayList;

public class GovernmentHelper {
    private static GovernmentHelper currentInstance;
    Government government = new Government("Shatila's municipality.Government");

    public static Government getCurrentGoverment() {
        if (currentInstance == null) {
            currentInstance = new GovernmentHelper();
        }
        return currentInstance.government;
    }

    private GovernmentHelper() {
        Employee said1 = new Employee();
        said1.setId(1);
        said1.setName("Employee #1");
        Employee said2 = new Employee();
        said2.setId(2);
        said2.setName("Employee #2");
        Employee said3 = new Employee();
        said3.setId(3);
        said3.setName("Employee #3");
        Employee said4 = new Employee();
        said4.setId(4);
        said4.setName("Employee #4");
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(said1);
        employees.add(said2);
        employees.add(said3);
        employees.add(said4);
        government.populateEmployees(employees);
    }
}
