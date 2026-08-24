class Solution {
    double count(double k, long n) {
        if (n == 0)
            return 1;

        double temp = count(k, n / 2);

        if (n % 2 == 1) {
            return temp * temp * k;
        }
        return temp * temp;
    }
    public double myPow(double x, int n) {
         long power = n;
        if (n < 0) {
            return 1 / count(x, -power);
        }
        return count(x, n);
    }
}
