import java.util.ArrayList;

public class Government {
    private String governmentName;
    private Archive archive;
    private ArrayList<GovernmentEmployee> employeesList = new ArrayList<>();

    Government(String governmentName) {
        this.governmentName = governmentName;
        this.archive = new Archive();
    }

    public void populateEmployees(ArrayList<Employee> employeesList) {

        for (int i = 0; i < employeesList.size(); i++) {
            this.employeesList.add(new GovernmentEmployee(employeesList.get(i)));
        }
    }

    public Employee getAvailableEmployee() {
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).isAvailable()) {
                GovernmentEmployee employee = employeesList.get(i);
                employee.setAvailable(false);
                return employee.getEmployee();
            }
        }
        System.out.println("No Available Employee to assist you, thank you for your patience.");
        return null;
    }

    public void setBackEmployeeAsAvailable(Employee employee) {
        for (GovernmentEmployee governmentEmployee : employeesList) {
            if (governmentEmployee.getEmployee().getId() == employee.getId()) {
                governmentEmployee.setAvailable(true);
            }
        }
    }

    public Archive getArchive() {
        return archive;
    }
}
