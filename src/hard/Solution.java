package hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static  void main(String[] args)throws IOException{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final String s = br.readLine().trim();
        //System.out.println("b".substring(0,1));
        int length = s.length();
        int i = 0;
        while(length-->0){
            int k1 = 0;
            int q1=(int)Math.floor((s.length())*(0.25));
            int q2=(int)Math.floor((s.length())*(0.5));
            int q3=(int)Math.floor((s.length())*(0.75));
            int flag3 = 0;
            int flag2 = 0;
            int flag1 = 0;

            for(int k = q3; k<=s.length() ; k++){

                if(((i-k+1>=0)) && ((i+k)<=s.length()) && ((i+k)>=0) && ((k)<=s.length()) && ((k)>=0) &&((i+1)<=s.length())){
                    String a = s.substring((i-k+1),i+1);
                    String b = s.substring(i,(i+k));
                    String c = s.substring(0,(k));


                    if(a.equals(b) && b.equals(c)){
//                        System.out.println(a+" "+b+" "+c+" i "+i+" k "+k);
                        k1 = k;

                    }
                }
            }
            if(k1==0){
                for(int k = q2; k<=q3 ; k++){

                    if(((i-k+1>=0)) && ((i+k)<=s.length()) && ((i+k)>=0) && ((k)<=s.length()) && ((k)>=0) &&((i+1)<=s.length())){
                        String a = s.substring((i-k+1),i+1);
                        String b = s.substring(i,(i+k));
                        String c = s.substring(0,(k));


                        if(a.equals(b) && b.equals(c)){
//                        System.out.println(a+" "+b+" "+c+" i "+i+" k "+k);
                            k1 = k;

                        }
                    }
                }
            }
            if(k1==0){
                for(int k = q1; k<=q2 ; k++){

                    if(((i-k+1>=0)) && ((i+k)<=s.length()) && ((i+k)>=0) && ((k)<=s.length()) && ((k)>=0) &&((i+1)<=s.length())){
                        String a = s.substring((i-k+1),i+1);
                        String b = s.substring(i,(i+k));
                        String c = s.substring(0,(k));


                        if(a.equals(b) && b.equals(c)){
//                        System.out.println(a+" "+b+" "+c+" i "+i+" k "+k);
                            k1 = k;

                        }
                    }
                }
            }
            //babbabababb
            if(k1==0){
                for(int k = 0; k<=q1 ; k++){

                    if(((i-k+1>=0)) && ((i+k)<=s.length()) && ((i+k)>=0) && ((k)<=s.length()) && ((k)>=0) &&((i+1)<=s.length())){
                        String a = s.substring((i-k+1),i+1);
                        String b = s.substring(i,(i+k));
                        String c = s.substring(0,(k));


                        if(a.equals(b) && b.equals(c)){
//                        System.out.println(a+" "+b+" "+c+" i "+i+" k "+k);
                            k1 = k;

                        }
                    }
                }
            }
            sb.append(k1+" ");
            i++;
        }
        System.out.println(sb);
    }
}
