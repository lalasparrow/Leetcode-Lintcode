class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        sb.append(sign);
        sb.append(num/den);
        long reminder = num%den;
        if(reminder == 0){
            return sb.toString();
        }
        
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        
        while(!map.containsKey(reminder)){
            map.put(reminder, sb.length());
            sb.append(10*reminder/den);
            reminder = 10*reminder%den;
        }
        int idx = map.get(reminder);
        
        sb.insert(idx, "(");
        sb.append(")");
        return sb.toString().replace("(0)", "");
        
    }
}