import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // epoch ~ January 1, 1970 UTC

        // Legacy API, now not in use, used before JAVA 8
        Date date = new Date();
        System.out.println("Current date time : " + date);

        /*
        Disadvantages of Legacy API
        ---------------------------
        -> No separate representation for date and time
        -> Year offset to 1900
        -> Month 0 - 11
        -> Not thread safe
         */

        // New Date and Time API

        /*
        -> LocalDate
        -> LocalTime
        -> LocalDateTime
        -> ZonedDateTime
        -> Instant
         */

    }
}