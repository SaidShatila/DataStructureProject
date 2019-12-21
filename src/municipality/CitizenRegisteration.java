package municipality;

public class CitizenRegisteration {
    private Employee employee;
    private Citizen citizen;

    CitizenRegisteration(Employee employee, Citizen citizen) {
this.employee=employee;
this.citizen=citizen;
    }

    public Employee getEmployee() {
        return employee;
    }
    public Citizen getCitizen() {
        return citizen;
    }

}
