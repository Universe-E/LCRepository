import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Solution {
    public boolean haveConflict(String[] event1, String[] event2){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date begin1 = new Date(),begin2 = new Date(),end1 = new Date(),end2 = new Date();
        try {
            begin1 = sdf.parse(event1[0]);
            end1 = sdf.parse(event1[1]);
            begin2 = sdf.parse(event2[0]);
            end2 = sdf.parse(event2[1]);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return !end1.before(begin2) && !begin1.after(end2);
    }
}