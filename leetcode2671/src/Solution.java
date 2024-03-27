import java.util.HashMap;

class FrequencyTracker {
    HashMap<Integer,Integer> map,freqMap;
    public FrequencyTracker() {
        map = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public void add(int number) {
        //之前的频率
        int freq = map.getOrDefault(number,0);
        map.put(number,freq+1);
        //该频率对应的出现次数-1
        if (freqMap.containsKey(freq)) {
            freqMap.put(freq,freqMap.get(freq)-1);
            //如果该频率出现次数为0，移除该频率
            if (freqMap.get(freq) == 0) freqMap.remove(freq);
        }
        //新频率
        freq = map.get(number);
        freqMap.put(freq,freqMap.getOrDefault(freq,0)+1);
    }

    public void deleteOne(int number) {
        if (map.containsKey(number)) {
            //之前的频率
            int freq = map.get(number);
            //number出现次数-1
            map.put(number,map.get(number)-1);
            //该频率对应的出现次数-1
            freqMap.put(freq,freqMap.get(freq)-1);
            //如果该频率出现次数为0，移除该频率
            if (freqMap.get(freq) == 0) freqMap.remove(freq);
            //新频率
            freq = map.get(number);
            if (freq == 0) map.remove(number);
            else freqMap.put(freq,freqMap.getOrDefault(freq,0)+1);
        }
    }

    public boolean hasFrequency(int frequency) {
        return freqMap.containsKey(frequency);
    }
}
