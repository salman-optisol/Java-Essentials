import java.time.*;
import java.util.Date;

public class Main {

    static void benchmarkTest() {
        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            for(int j = 0; j < Integer.MAX_VALUE; j++) {
                int s = 10;
            }
        }
    }
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

        LocalDate expiryDate = LocalDate.of(2024, Month.MARCH, 30);
        System.out.println(expiryDate);

        // Plus Minus Period
        int renewalPeriod = 3;
        LocalDate extendedExpiryDate = expiryDate.plusMonths(renewalPeriod);
        System.out.println(extendedExpiryDate);

        // Get methods
        System.out.println(extendedExpiryDate.getYear());

        // Parsing
        LocalDate parsedDate = LocalDate.parse("2012-10-02"); // yyyy-mm-dd
        System.out.println(parsedDate.getMonth());

        // Local Time
        LocalTime endTime = LocalTime.of(12, 23, 34);
        System.out.println(endTime.getHour());

        LocalDate birthDate = LocalDate.of(2001, Month.OCTOBER, 25);
        Period age = birthDate.until(LocalDate.now());

        System.out.println("My age is " + age.getYears());

        // Duration calculation

        Instant start = Instant.now();
        benchmarkTest();
        Instant end = Instant.now();

        Duration duration = Duration.between(start, end);
        System.out.println("Total duration : " + duration.toMillis());

        // Zoned time
        System.out.println("Time in London :" + ZonedDateTime.now().withZoneSameInstant(ZoneId.of("Europe/London")));
        System.out.println("Time in India  : " + ZonedDateTime.now());


    }
}




























