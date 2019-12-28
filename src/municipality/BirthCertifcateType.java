package municipality;

import java.util.Stack;

public class BirthCertifcateType implements BaseApplicationType {

    @Override
    public Stack<Operation> getSteps(Application application) {
        Stack <Operation> birthCertifcateSteps = new Stack<>();

        Operation step1 = new Operation(application.getNextOperationId(),null,"Soora Shamsiyeh");
        Operation step2 = new Operation(application.getNextOperationId(),null,"wsee2at weelade");
        Operation step3 = new Operation(application.getNextOperationId(),null,"2e5raj kayed");
        Operation step4 = new Operation(application.getNextOperationId(),null,"Tawabe3");
        Operation step5 = new Operation(application.getNextOperationId(),null,"Bsoom");

        ;
        birthCertifcateSteps.push(step5);
        birthCertifcateSteps.push(step4);
        birthCertifcateSteps.push(step3);
        birthCertifcateSteps.push(step2);
        birthCertifcateSteps.push(step1);

        return birthCertifcateSteps;
    }

    @Override
    public String stringValue() {
        return "BirthCertifcateApplication";
    }
}
