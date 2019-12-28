package municipality;

import java.util.Stack;

public class PersonalDocumentType implements BaseApplicationType {
    @Override
    public Stack<Operation> getSteps(Application application) {
        Stack <Operation> baseApplicationSteps = new Stack<>();

        Operation step1 = new Operation(application.getNextOperationId(),null,"Soora Shamsiyeh");
        Operation step2 = new Operation(application.getNextOperationId(),null,"wsee2at weelade");
        Operation step3 = new Operation(application.getNextOperationId(),null,"War2et Talab Personal Document men 3ande el me5tar");
        Operation step4 = new Operation(application.getNextOperationId(),null,"Tawabe3");
        Operation step5 = new Operation(application.getNextOperationId(),null,"towkee3");


        baseApplicationSteps.push(step5);
        baseApplicationSteps.push(step4);
        baseApplicationSteps.push(step3);
        baseApplicationSteps.push(step2);
        baseApplicationSteps.push(step1);

        return baseApplicationSteps;
    }

    @Override
    public String stringValue() {
        return "PersonalDocument";
    }
}
