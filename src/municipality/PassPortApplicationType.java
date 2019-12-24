package municipality;

import java.util.Stack;

public class PassPortApplicationType implements BaseApplicationType{


    @Override
    public Stack<Operation> getSteps(Application application) {
        Stack <Operation> passPortSteps = new Stack<>();

        Operation step1 = new Operation(application.getNextOperationId(),null,"Soora Shamsiyeh");
        Operation step2 = new Operation(application.getNextOperationId(),null,"wsee2at weelade");
        Operation step3 = new Operation(application.getNextOperationId(),null,"War2et Talab Passport men 3ande el me5tar");
        Operation step4 = new Operation(application.getNextOperationId(),null,"Tawabe3");
        Operation step5 = new Operation(application.getNextOperationId(),null,"2adem el wra2 bel saraya");
        Operation step6 = new Operation(application.getNextOperationId(),null,"Bsoom");

            passPortSteps.push(step6);
            passPortSteps.push(step5);
            passPortSteps.push(step4);
            passPortSteps.push(step3);
            passPortSteps.push(step2);
            passPortSteps.push(step1);

        return passPortSteps;
    }

    @Override
    public String stringValue() {
        return "PassPortApplication";
    }
}
