import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        Date aAlice = new Date(),aBob = new Date(),lAlice = new Date(),lBob = new Date();
        try {
            aAlice = sdf.parse(arriveAlice);
            aBob = sdf.parse(arriveBob);
            lAlice = sdf.parse(leaveAlice);
            lBob = sdf.parse(leaveBob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date latest = aAlice.after(aBob) ? aAlice : aBob;
        Date earliest = lAlice.before(lBob) ? lAlice : lBob;
        if (earliest.before(latest)) return 0;
        else {
            return (int) ((earliest.getTime() - latest.getTime()) / (24*60*60*1000)) + 1;
        }
    }
}