package Acid_naming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args)throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        solve sol = new solve();

        int query = Integer.parseInt(br.readLine().trim());
        while(query-->0){
            String s = br.readLine().trim();
            sb.append(sol.solver(s)).append("\n");
        }
        System.out.println(sb);
    }
}
class solve{
    public String solver(String name){
        //hydro   ic        non-metal acid
        //ic                polyatomic acid
        //none of the above not an acid
        name = name.toLowerCase();

        boolean b1 = name.startsWith("hydro");
        boolean b2 = name.endsWith("ic");
        String answer = "";
        if(b1 && b2){
            answer = "non-metal acid";
        }else if(b1==false && b2 ==true){
            answer = "polyatomic acid";
        }else if(b1 == false && b2 == false){
            answer = "not an acid";
        }
        return answer;
    }
}
