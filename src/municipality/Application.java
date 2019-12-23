package municipality;

import java.util.Stack;

public class Application {
    private int id;
    private int citizenId;
    private String type;
    private State state;
    private Stack<Operation> steps;

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

    }

    public Operation undoStep() {
        if (state != State.PROCESSING) {
            throw new IllegalStateException("The application should be in the processing state");
        }
        return steps.pop();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public void setSteps(Stack<Operation> steps) {
        this.steps = steps;
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
