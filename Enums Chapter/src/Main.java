public class Main {
    public static void main(String[] args) {

        /*
        Benefits of enums :
        -------------------
        -> Grouping of same group constants
        -> We can hover over the constants of a particular type
        -> There is type safety among the groups
         */

        for(Status status : Status.values()) {
            System.out.println("The value of the status " + status + " is " + status.value);
        }

        String currentStatus = "Approved";
        if(currentStatus.equals(Status.APPROVED.value)) {
            System.out.println("Congratulations ! Your request is " + Status.APPROVED.value);
        }
    }
}