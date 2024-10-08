//TC: O(n)
//SC: O(n)
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length==0){
            return 0;
        }
        Stack<Integer> st = new Stack<>();
        for(String token: tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int num2 = st.pop();
                int num1 = st.pop();
                switch(token){
                    case "+":
                        st.push(num1+num2);
                        break;
                    case "-":
                        st.push(num1-num2);
                        break;
                    case "*":
                        st.push(num1*num2);
                        break;
                    case "/":
                        st.push(num1/num2);
                        break;
                }
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}
