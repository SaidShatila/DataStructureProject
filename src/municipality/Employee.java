package municipality;

public class Employee {
    private String name;
    private int Id;
    private String position;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public void registerApplication(Archive archive, Application application, Citizen citizen) {
        archive.applicationRegister(application, citizen, this);
        String body = buildSMSText(name, citizen.getFirstName(), application.getId(), String.valueOf(State.WAITING));
        SMSManager.sendSMS(citizen.getPhoneNumber(), body);
    }

    public void processNextStep(Archive archive, int appid, Operation operation) {
        Application application = archive.getApplicationById(appid);
        if (application.isInWaiting()) {
            archive.startApplicationProcessing(appid);
            Citizen citizen = archive.getCitizenById(application.getCitizenId());
            String body = buildSMSText(name, citizen.getFirstName(), appid, String.valueOf(State.PROCESSING));
            SMSManager.sendSMS(citizen.getPhoneNumber(), body);
        }
        if (application.isInProcessing()) {
            operation.setProcessedBy(this.name);
            application.applyNextStep(operation);
        } else {
            System.out.println("No more steps can be done this application is finished. ");
        }
    }

    public void undoStep(Archive archive, int appid) {
        Application application = archive.getApplicationById(appid);
        if (application.isInWaiting()) {
            System.out.println("You can't undo step because it is in the waiting process");
        }
        if (application.isInProcessing()) {
            application.undoStep();
        }
        if (application.isCompleted()) {
            System.out.println("This municipality.Application is completed you can't undo next step");
        }
    }

    public void finishApplication(Archive archive, int appId) {
        Application application = archive.getApplicationById(appId);
        if (application.isInWaiting()) {
            System.out.println("You need to process the application it is still in the waiting list.");
        } else if (application.isInProcessing()) {
            application.finishProcessing();
            Citizen citizen = archive.getCitizenById(application.getCitizenId());
            String body = buildSMSText(name, citizen.getFirstName(), appId, String.valueOf(State.COMPLETED));
            SMSManager.sendSMS(citizen.getPhoneNumber(), body);

        } else {
            System.out.println("The application is already finished.");
        }
    }

    public void printApplicationSteps(Archive archive, int appid) {
        Application application = archive.getApplicationById(appid);
        String toBePrinted = application.display();

        toBePrinted += "Printed by: " + name;

        System.out.println(toBePrinted);
    }

    private String buildSMSText(String employeeName, String citizenName, int appid, String newState) {
        return "Dear " + citizenName + "\n"
                + " your submitted application of id: " + appid + " is now in the: " + newState + " state." +
                "\n" + "Sent by municipality.Employee: " + employeeName + "\n" + "Thank you for your patience.";
    }
}
