package municipality;

import java.util.ArrayList;
import java.util.Stack;

public class Application {
    private int id;
    private int citizenId;
    private BaseApplicationType type;
    private State state;
    private Stack<Operation> steps;
    private Stack<Operation> pendingSteps;
    public Application() {
        state = State.WAITING;
        steps = new Stack<>();
    }

    public void startProcessing() {
        if (state == State.PROCESSING) {
            throw new IllegalStateException("The application is already in the processing state\n");
        }
        if (state == State.COMPLETED) {
            throw new IllegalStateException("The application has been completed. You cannot process it again\n");

        }
        state = State.PROCESSING;
    }

    public void finishProcessing() {

        if (state == State.WAITING) {
            throw new IllegalStateException("The application should pass through the processing state before finishing it\n");
        }
        if (state == State.COMPLETED) {
            throw new IllegalStateException("The application has been completed. You cannot finish it again\n");

        }
        state = State.COMPLETED;
    }

    public void applyNextStep(Operation operation) {
        if (state != State.PROCESSING) {
            throw new IllegalStateException("The application should be in the processing state");
        }
        steps.push(operation);
        pendingSteps.pop();

    }

    public Operation undoStep() {
        if (state != State.PROCESSING) {
            throw new IllegalStateException("The application should be in the processing state");
        }
       Operation stepPop=  steps.pop();
         pendingSteps.push(stepPop);
        return stepPop;
    }

    public boolean isInProcessing() {
        return state == State.PROCESSING;
    }

    public boolean isInWaiting() {
        return state == State.WAITING;
    }

    public boolean isCompleted() {
        return state == State.COMPLETED;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(int citizenId) {
        this.citizenId = citizenId;
    }

    public BaseApplicationType getType() {
        return type;
    }

    public void setType(BaseApplicationType type) {
        this.type = type;
        pendingSteps= type.getSteps(this);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Stack<Operation> getSteps() {
        return steps;
    }

    public Stack<Operation> getPendingSteps() {
        return pendingSteps;
    }

public ArrayList<Operation> listOfSteps (){
        ArrayList<Operation> operationsList = new ArrayList<>() ;
        Stack<Operation>  temp = new Stack<>();

          while (!steps.isEmpty()){
              Operation popSteps= steps.pop();
             temp.push(popSteps);
             operationsList.add(popSteps);
          }
          while (!temp.isEmpty()){
              steps.push(temp.pop());
          }

          return operationsList;
}

public ArrayList<Operation> listOfPendingSteps(){
        ArrayList<Operation> operationsOfPendingList =new ArrayList<>();
        Stack<Operation> temp = new Stack<>();

        while (!pendingSteps.isEmpty()){
            Operation popPendingSteps= pendingSteps.pop();
            temp.push(popPendingSteps);
            operationsOfPendingList.add(popPendingSteps);
        }
        while (!temp.isEmpty()){
            pendingSteps.push(temp.pop());
        }
        return operationsOfPendingList;
}


    public String display() {
        String toBePrinted = "";
        Stack<Operation> temp = new Stack<>();
        while (!steps.empty()) {
            Operation x = steps.pop();
            temp.push(x);
            toBePrinted += x.toString() + "\n\n ---------------------------------- \n\n";
        }
        while(!temp.isEmpty()){
            steps.push(temp.pop());
        }
        return toBePrinted;
    }
    public String getNextOperationId(){
        return id+""+steps.size();
    }
}
