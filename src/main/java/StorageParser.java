import java.time.format.DateTimeFormatter;

public class StorageParser extends Parser {
    protected Task task;

    StorageParser(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        String returnString = "";
        if (this.task instanceof Todo) {
            returnString = returnString + "T | " + (this.task.getIsDone() ? "1 | " : "0 | ") + this.task.getDescription();
        }

        if (this.task instanceof Deadline) {
            String dateTime = ((Deadline) this.task).getDate().format(DateTimeFormatter.ofPattern("d/M/yyyy")) + " " + ((Deadline) this.task).getTime().format(DateTimeFormatter.ofPattern("HHmm"));
            returnString = returnString + "D | " + (this.task.getIsDone() ? "1 | " : "0 | ") + this.task.getDescription() + "| " + dateTime;
        }

        if (this.task instanceof Event) {
            String dateTime = ((Event) this.task).getDate().format(DateTimeFormatter.ofPattern("d/M/yyyy"));
            returnString = returnString + "E | " + (this.task.getIsDone() ? "1 | " : "0 | ") + this.task.getDescription() + "| " + dateTime;
        }

        return returnString + "\n";
    }
}