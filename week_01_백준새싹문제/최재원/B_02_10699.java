import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class B_02_10699 {
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        format.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));

        System.out.println(format.format(date));
    }
}
