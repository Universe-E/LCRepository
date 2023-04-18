import java.util.HashMap;

class AuthenticationManager {
    HashMap<String,Integer> map;
    int tl;
    public AuthenticationManager(int timeToLive) {
        map = new HashMap<>();
        tl = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId,currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId) && map.get(tokenId) > currentTime-tl) map.put(tokenId,currentTime);
        else map.remove(tokenId);
    }

    public int countUnexpiredTokens(int currentTime) {
        check(currentTime);
        return map.keySet().size();
    }

    private void check(int currentTime) {
        map.keySet().removeIf(s -> map.get(s) + tl <= currentTime);
    }
}