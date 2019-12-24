import municipality.*;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        Government government = new Government("Shatila's municipality.Government");
        Employee said1 = new Employee();
        said1.setId(1);
        said1.setName("Said #1");
        Employee said2 = new Employee();
        said2.setId(2);
        said2.setName("Said #2");
        Employee said3 = new Employee();
        said3.setId(3);
        said3.setName("Said #3");
        Employee said4 = new Employee();
        said4.setId(4);
        said4.setName("Said #4");
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(said1);
        employees.add(said2);
        employees.add(said3);
        employees.add(said4);
        government.populateEmployees(employees);


        government.getAvailableEmployee();
        government.getAvailableEmployee();
        government.getAvailableEmployee();
        government.getAvailableEmployee();
        government.setBackEmployeeAsAvailable(said1);

        Employee availableEmployee = government.getAvailableEmployee();

        Citizen zico = new Citizen();
        //non conflict cde is added here to test the green color
        zico.setId(government.getArchive().getCitizenNewId());
        zico.setFirstName("Zico");
        zico.setLastName("Gringo");
        zico.setEmail("some@example.com");
        zico.setPhoneNumber("000 123 000");
// so I am editing in this exact place to cause a conlict. Niyahahahahaha
//We are editing this section to cause some conflict with the master branch
        Application zicoApp = new Application();
        zicoApp.setId(government.getArchive().getApplicationNewId());
        zicoApp.setCitizenId(zico.getId());
        zicoApp.setType(new PassPortApplicationType());

        availableEmployee.registerApplication(government.getArchive(), zicoApp, zico); // this is solely for educational purposes


        Operation zicoOper = new Operation(zicoApp.getNextOperationId(), availableEmployee.getName(), "This is the first operation on this application");
        availableEmployee.processNextStep(government.getArchive(), zicoApp.getId(), zicoOper);

//        government.setBackEmployeeAsAvailable(availableEmployee);

        government.setBackEmployeeAsAvailable(said2);
        availableEmployee = government.getAvailableEmployee();

        Operation zicoOper2 = new Operation(zicoApp.getNextOperationId(), availableEmployee.getName(), "This is the secondoperation on this application");
        availableEmployee.processNextStep(government.getArchive(), zicoApp.getId(), zicoOper2);


//        availableEmployee.printApplicationSteps(government.getArchive(), zicoApp.getId());
        availableEmployee.undoStep(government.getArchive(), zicoApp.getId());
        availableEmployee.printApplicationSteps(government.getArchive(), zicoApp.getId());

        availableEmployee.finishApplication(government.getArchive(),zicoApp.getId());
        availableEmployee.finishApplication(government.getArchive(),zicoApp.getId());




    }

}
