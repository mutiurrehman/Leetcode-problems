class Solution {

    public String add(String first, String second) {
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        for (int i = first.length() - 1, j = second.length() - 1; i >= 0 || j >= 0 || carry > 0; i--, j--) {
            int x = i < 0 ? 0 : first.charAt(i) - '0';
            int y = j < 0 ? 0 : second.charAt(j) - '0';

            int sum = (x + y + carry);
            sb.append(sum % 10);
            carry = sum / 10;

        }

        return sb.reverse().toString();

    }


    public String multiply(String A, String B) {

        if (A.equals("0") || B.equals("0"))
            return "0";

        boolean min = false;
        if (A.charAt(0) == '-' && B.charAt(0) == '-') {
            A = A.substring(1);
            B = B.substring(1);
        } else if (A.charAt(0) == '-') {
            A = A.substring(1);
            min = true;
        } else if (B.charAt(0) == '-') {
            B = B.substring(1);
            min = true;
        }

        String temp1 = "";
        int l = 0;
        while (A.charAt(l) == '0')
            l++;

        for (int k = l; k < A.length(); k++)
            temp1 += A.charAt(k);


        A = temp1;

        String temp2 = "";
        l = 0;
        while (B.charAt(l) == '0')
            l++;

        for (int k = l; k < B.length(); k++)
            temp2 += B.charAt(k);

        B = temp2;

        String prev = "";

        for (int i = A.length() - 1; i >= 0; i--) {
            int carry = 0;
            int num1 = A.charAt(i) - '0';
            StringBuilder sb = new StringBuilder();
            for (int j = B.length() - 1; j >= 0; j--) {
                int num2 = B.charAt(j) - '0';
                sb.append((num1 * num2 + carry) % 10);
                carry = (num1 * num2 + carry) / 10;
            }
            if (carry != 0)
                sb.append(carry);

            sb.reverse();

            for (int k = 0; k <= A.length() - 1 - i; k++)
                sb.append(0);

            String curr = sb.toString();

            prev = add(prev, curr);
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < prev.length() - 1; i++) {
            ans.append(prev.charAt(i));
        }


        if (min)
            ans.insert(0, "-");
        return ans.toString();

    }
}