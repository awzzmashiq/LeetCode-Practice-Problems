class Solution {
    public boolean isHappy(int n) {
        
       HashSet<Integer> s=new HashSet<>();
       while (n != 1 && !s.contains(n)) {
            s.add(n);
            int sum = 0;
            while (n != 0) {
                sum = sum + (int) Math.pow(n % 10, 2);
                n = n / 10;
            }
            n = sum;
        }

        return n == 1;
    }
}
