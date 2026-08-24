class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n = num1.length();
        int m = num2.length();

        int[] res = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';

                int product = n1 * n2;

                int pos1 = i + j;
                int pos2 = i + j + 1;

                product = product + res[pos2];

                res[pos2] = product % 10;
                res[pos1] += product / 10;
            }
        }

        StringBuilder temp = new StringBuilder();

        for (int digit : res) {
            if (temp.length() == 0 && digit == 0) {
                continue;
            }
            temp.append(digit);
        }
        return temp.toString();
    }
}
