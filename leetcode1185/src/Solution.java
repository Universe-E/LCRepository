import java.time.LocalDate;
class Solution {
    private final String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public String dayOfTheWeek(int day, int month, int year) {
        // API逃课大法
        LocalDate date = LocalDate.of(year, month, day);
        return week[date.getDayOfWeek().getValue() % 7];
    }
}