package algorithm_patterns.grapth;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public int balancedStringSplit(String s) {
        int max = 0;

        for (int i =2; i< s.length()-2 ; i=i+2){
            max +=findBalancedSubdomains( i,  s).size();
        }

        return max;

    }

    private List<String> findBalancedSubdomains(int subLength, String s){

        List<String> balancedSubdomains = new ArrayList<>();
        for (int i =0; i < s.length() -subLength; i++){
            String subs= s.substring(i, i + subLength);
            System.out.println("subs: "+subs);

            balancedSubdomains.add(subs);
        }
        System.out.println(balancedSubdomains);
        return balancedSubdomains;
    }

    public static void main(String[] args) {
        new Test().balancedStringSplit("RLRRLLRLRL");
    }

}
