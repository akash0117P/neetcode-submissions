class Solution {
    public int reverseBits(int n) {
        int bit = 0;
        for (int i = 0; i < 32; i++) {
            int curBit = n & 1;
            bit = (bit << 1) | curBit;
            n = n >> 1;
        }
        return bit;
    }
}
