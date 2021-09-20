class Solution {
    public int minOperations(int[] nums) {

        List<Integer> unique = new ArrayList<>();
        HashSet<Integer> vis = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!vis.contains(nums[i])) {
                vis.add(nums[i]);
                unique.add(nums[i]);
            }
        }
        
        Collections.sort(unique);
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < unique.size(); ++i) {
            int start = unique.get(i);
            int last = unique.get(i) + nums.length - 1;
            int lo = i;
            int hi = unique.size() - 1;

            while (lo < hi) {
                int mi = (lo + hi + 1) / 2;

                if (unique.get(mi) <= last) {
                    lo = mi;
                } else {
                    hi = mi - 1;
                }
            }

            min = Math.min(min, nums.length - (lo - i + 1));
        }
        return min;
    }
}