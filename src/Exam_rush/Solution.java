package Exam_rush;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args)throws IOException{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String s = br.readLine().trim();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken().trim());
        final int hr = Integer.parseInt(st.nextToken().trim());
        int arr[] = new int[n];
        int i = 0, temp = n;
        while(temp-->0){
            arr[i] = Integer.parseInt(br.readLine().trim());
            i++;
        }
        Arrays.sort(arr);
        int count = 0;
        for(int j = 0; j<n; j++){
            if(count+arr[j] <= hr){
                count+=arr[j];
            }
        }
        System.out.println(count);
    }
}
