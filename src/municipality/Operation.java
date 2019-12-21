package municipality;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Operation {
    private String id;
    private String processedBy;
    private Date timing;
    private String description;

    public Operation(String id, String processedBy, String description) {
        timing = new Date();
        this.id = id;
        this.processedBy = processedBy;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public Date getTiming() {
        return timing;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "id: " + id + "\tprocessedBy: " + processedBy + " at "
                + new SimpleDateFormat("EEE, dd MMM, yyyy").format(timing) + "\ndescription: " + description;
    }
}
