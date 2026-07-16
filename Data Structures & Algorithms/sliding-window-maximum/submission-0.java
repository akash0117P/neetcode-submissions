class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();

        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ;i < nums.length ; i++){

            if(!dq.isEmpty() && dq.getFirst() <= i - k ){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.getLast()] <= nums[i] ){
                dq.pollLast();
            } 

            dq.addLast(i);

            if( i >= k-1){
                ans.add(nums[dq.getFirst()]);
            }
        }
        return ans.stream()
               .mapToInt(Integer::intValue)
               .toArray();

    }
}
