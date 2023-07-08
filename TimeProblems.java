import java.time.*;
import java.time.temporal.Temporal;

public class TimeProblems {
    public static int countFridayThirteens(LocalDate start, LocalDate end){
        int count=0;


        while(!start.isAfter(end)){
            if(start.getDayOfWeek()==DayOfWeek.FRIDAY&&start.getDayOfMonth()==13){
                count++;
            }

            start=start.plusDays(1);

        }



        return count;

    }

    public static String dayAfterSeconds(
            LocalDateTime timeHere, long seconds
    ){

        LocalDateTime timeAfter= timeHere.plusSeconds(seconds);



        return timeAfter.getDayOfWeek().toString();

    }

    public static int whatHourIsItThere(
            LocalDateTime timeHere, String here, String there
    ){
        ZoneId zoneHere = ZoneId.of(here);
        ZoneId zoneThere = ZoneId.of(there);
        ZonedDateTime timeHereInHereZone = timeHere.atZone(zoneHere);
        ZonedDateTime timeHereInThereZone = timeHereInHereZone.withZoneSameInstant(zoneThere);
        return timeHereInThereZone.getHour();

    }

    public static void main(String[] args){


                outerLoop: for (int i = 1; i <= 5; i++) {
                    innerLoop: for (int j = 1; j <= 3; j++) {
                        System.out.println("i: " + i + ", j: " + j);
                        if (i == 2 && j == 2) {
                            i += 2; // Increment outer loop's variable by 2
                            continue outerLoop; // Skip remaining iterations of the inner loop and proceed to the next iteration of the outer loop
                        }
                    }
                }




    }

}
