package race;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim())-1;
        int mason = Integer.parseInt(br.readLine().trim());
        String height = br.readLine().trim();
        String price = br.readLine().trim();
        StringTokenizer st = new StringTokenizer(height);
        StringTokenizer sp = new StringTokenizer(price);
        int total = 0;
        int time=0;
        while(n-->0){
            int h = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(sp.nextToken());
            time++;
            if(h>mason){
                total += (Math.abs(h-mason))+time+p;
                time=0;
            }
            if(h<=mason && total<0 && p>0){
                total += (Math.abs(h-mason))+time+p;
                time=0;
            }
        }
        total +=(time+1);
        System.out.println(total);
    }
}
