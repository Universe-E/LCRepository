class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP == null) return "Neither";
        String regexipv4 = "\\b((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.){3}" +
                            "(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\b";
        String regexipv6 = "(([\\da-fA-F]{1,4}):){7}([\\da-fA-F]{1,4})";
        if (queryIP.matches(regexipv4)) return "IPv4";
        if (queryIP.matches(regexipv6)) return "IPv6";
        return "Neither";
    }
}