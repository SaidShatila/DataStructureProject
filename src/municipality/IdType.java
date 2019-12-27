package municipality;

import java.util.Stack;

public class IdType implements BaseApplicationType {
    @Override
    public Stack<Operation> getSteps(Application application) {
        Stack <Operation> idSteps = new Stack<>();

        Operation step1 = new Operation(application.getNextOperationId(),null,"Soora Shamsiyeh");
        Operation step2 = new Operation(application.getNextOperationId(),null,"wsee2at weelade");
        Operation step3 = new Operation(application.getNextOperationId(),null,"War2et Talab 2e5raj kayd men 3ande el me5tar");
        Operation step4 = new Operation(application.getNextOperationId(),null,"Tawabe3");
        Operation step5 = new Operation(application.getNextOperationId(),null,"War2et La hokom 3alyeh");
        Operation step6 = new Operation(application.getNextOperationId(),null,"Bsoom");

        idSteps.push(step6);
        idSteps.push(step5);
        idSteps.push(step4);
        idSteps.push(step3);
        idSteps.push(step2);
        idSteps.push(step1);

        return idSteps;
    }

    @Override
    public String stringValue() {
        return "IdApplication";
    }
}
