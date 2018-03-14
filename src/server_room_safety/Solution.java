package server_room_safety;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st1 = new StringTokenizer(br.readLine().trim());
        StringTokenizer st2 = new StringTokenizer(br.readLine().trim());

        int temp = n, i =0;
        int position[] = new int[n];
        int height[] = new int[n];
        while (temp-->0){
            position[i] = Integer.parseInt(st1.nextToken().trim());
            height[i] = Integer.parseInt(st2.nextToken().trim());
            i++;
        }

        String fromleft = "", fromright;
        int luckyl = 0;
        int luckyr = n-1;
        for(i = 0; i<=luckyl; i++){
            for(int j = luckyl+1; j<n;j++){
                if(solverl(position[i],height[i],position[j])){
                    luckyl = j;
                }else{
                    break;
                }
            }
        }
        for(i = n-1; i>=luckyr; i--){
            for(int j = luckyr-1; j>=0;j--){
                //System.out.println("luckyr "+luckyr);
                if(solverr(position[i],height[i],position[j])){
                    luckyr = j;
                    //System.out.println("luckyr passed "+ j);
                }else{
                    break;
                }
            }
        }
       // System.out.println("luckyr "+luckyr + "  luckyl "+luckyl);
        if(luckyl == n-1 && luckyr==0){
            System.out.println("BOTH");
        }else if(luckyl != n-1 && luckyr!=0){
            System.out.println("NONE");
        }else if(luckyl == n-1 && luckyr!=0){
            System.out.println("LEFT");
        }else if(luckyl != n-1 && luckyr==0){
            System.out.println("RIGHT");
        }

    }
    public static boolean solverl(int pos, int height, int pos_test){
        if(pos+height>=pos_test)
            return true;
        else
            return false;
    }
    public static boolean solverr(int pos, int height, int pos_test){
        if(pos-height<=pos_test)
            return true;
        else
            return false;
    }
}

