import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

/**
 * Created by Bludya on 29.6.2016 г..
 * All rights reserved!
 */
class DateModifier{
    private Calendar firstCal;
    private Calendar secondCal;

    public DateModifier(String firstDate, String secondDate){
        int firstYear = Integer.valueOf(firstDate.split("\\s+")[0]);
        int firstMonth = Integer.valueOf(firstDate.split("\\s+")[1]);
        int firstDay = Integer.valueOf(firstDate.split("\\s+")[2]);
        firstCal = Calendar.getInstance();
        firstCal.set(firstYear, firstMonth, firstDay);

        int secondYear = Integer.valueOf(secondDate.split("\\s+")[0]);
        int secondMonth = Integer.valueOf(secondDate.split("\\s+")[1]);
        int secondDay = Integer.valueOf(secondDate.split("\\s+")[2]);
        secondCal = Calendar.getInstance();
        secondCal.set(secondYear, secondMonth, secondDay);
    }

    public long calculateDays() throws Exception{
        long diff = firstCal.getTime().getTime() - secondCal.getTime().getTime();
        return diff / (1000 * 3600 * 24);
    }
}
public class Problem10_DateModifier {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DateModifier dateModifier = new DateModifier(reader.readLine(), reader.readLine());

        System.out.println(Math.abs(dateModifier.calculateDays()));

    }
}
