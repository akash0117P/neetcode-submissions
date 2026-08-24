class Solution {
    public int[] plusOne(int[] digits) {
        long num = 0;

        for (int i = 0; i < digits.length; i++) {
            num = num * 10;
            num += digits[i];
        }
        num = num + 1;

        System.out.println(num);

        List<Long> res = new ArrayList<>();

        while (num > 0) {
            res.add(num % 10);
            num = num / 10;
        }
        Collections.reverse(res);
        return res.stream().mapToInt(Long::intValue).toArray();
    }
}
