import java.util.Arrays;

class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int n = energy.length;
        //需要训练精力的时长，注意如果初始精力足够多就不需要训练
        int energyTimes = Math.max(0,Arrays.stream(energy).sum() - initialEnergy + 1);
        int curExp = initialExperience;
        //需要训练经验的时长，每次击败对手经验增加，如果遇到经验更高的对手则增加训练时长
        int expTimes = 0;
        for (int value : experience) {
            if (curExp <= value) {
                expTimes += value - curExp + 1;
                curExp += value - curExp + 1;
            }
            curExp += value;
        }
        return energyTimes + expTimes;
    }
}
