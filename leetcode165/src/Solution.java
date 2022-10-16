class Solution {
    public int compareVersion(String version1, String version2) {
        //去掉首端的0
        Integer[] nums1 = removePrefix0(version1);
        Integer[] nums2 = removePrefix0(version2);
        int n1 = nums1.length,n2 = nums2.length;
        int i = 0;
        while (i < Math.min(n1,n2)) {
            if (nums1[i] < nums2[i]) return -1;
            if (nums1[i] > nums2[i]) return 1;
            i++;
        }
        if (n1 == n2) return 0;
        if (n1 > n2) {
            for (int j = i; j < n1; j++) {
                if (nums1[j] != 0) return 1;
            }
        }
        else {
            for (int j = i; j < n2; j++) {
                if (nums2[j] != 0) return -1;
            }
        }
        return 0;
    }

    private Integer[] removePrefix0(String version) {
        String [] ss = version.split("\\.");
        Integer[] res = new Integer[ss.length];
        for (int i = 0; i < ss.length; i++) {
            int j = 0;
            while (j < ss[i].length() && ss[i].charAt(j) == '0') j++;
            ss[i] = ss[i].substring(j);
            if (ss[i].length() == 0) ss[i] = "0";
            res[i] = Integer.parseInt(ss[i]);
        }
        return res;
    }
}

class Solution2 {
    public int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");

        for(int n = 0; n < Math.max(a1.length, a2.length); n++){
            int i = (n < a1.length ? Integer.parseInt(a1[n]) : 0);
            int j = (n < a2.length ? Integer.parseInt(a2[n]) : 0);
            if(i < j) return -1;
            else if(i > j) return 1;
        }
        return 0;
    }
}