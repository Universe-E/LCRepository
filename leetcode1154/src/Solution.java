import java.time.LocalDate;

class Solution {
    public int dayOfYear(String date) {
        String[] ss = date.split("-");
        LocalDate date1 = LocalDate.of(Integer.parseInt(ss[0]),Integer.parseInt(ss[1]),Integer.parseInt(ss[2]));
        return date1.getDayOfYear();
    }
}