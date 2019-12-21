package municipality;

/**
 * This is a wrapper class that encapsulates the employee with its availability status
 * This is mainly used for the government in order t o keep track of which employee is available and which is not.
 */
public class GovernmentEmployee {
    private Employee employee ;
    private boolean isAvailable;


    GovernmentEmployee(Employee employee){
        this.employee=employee;
        this.isAvailable=true;
    }


    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Employee getEmployee() {
        return employee;
    }
}
