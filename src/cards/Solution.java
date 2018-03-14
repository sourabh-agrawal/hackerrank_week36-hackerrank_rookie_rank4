package cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args)throws IOException{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        final int n = Integer.parseInt(st.nextToken().trim());
        final int mod = Integer.parseInt(st.nextToken().trim());
        final int target = Integer.parseInt(st.nextToken().trim());
        st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        int temp = n,i =0;
        while(temp-->0){
            arr[i] = Integer.parseInt(st.nextToken().trim());
            i++;
        }
        for(int r=1; r<=n;r++){
            printCombination(arr, n, r,mod,target);
        }
        System.out.println(count);
        //System.out.println(Math.pow(10,7)%Math.pow(9,6));
    }
    static int count=0;
    static void combinationUtil(int arr[], int n, int r, int index, int data[], int i,int mod, int target)
    {
        if (index == r) {
            String s="";
            int temp = 1;
            for (int j = 0; j < r; j++)
                s += data[j] + " ";
            StringTokenizer st = new StringTokenizer(s);
            System.out.println("s is "+s);
            while(st.hasMoreTokens()){
                temp*=Integer.parseInt(st.nextToken().trim());
            }
            //System.out.println("temp is "+temp+" mod is "+mod+" target is "+target);
            if((int)(temp%mod) == target)
                count++;
            return;
        }
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);


            // Remove duplicates
            while (arr[i] == arr[i+1])
                i++;
        }
    }

    static void printCombination(int arr[], int n, int r,int mod, int target)
    {
        int data[] = new int[r];
        combinationUtil(arr, n, r, 0, data, 0,mod, target);
    }
}


