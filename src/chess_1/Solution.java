package chess_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int queen(String kpos, int ppos){
        if(rook(kpos,ppos)==1 || bishop(kpos,ppos)==1){
            return 1;
        }else
            return 0;
    }
    static int rook(String kpos, int ppos){
        int a = kpos.charAt(0)-'0';
        int b = kpos.charAt(1)-'0';
        if(a==8 || b==ppos){
            return 1;
        }else
            return 0;
    }
    static int knight(String kpos, int ppos){
        String kr="", kl="", kbr="", kbl="";
        if(ppos<7){
            kr = 7+""+(ppos+2);
        }
        if(ppos>2){
            kl = 7+""+(ppos-2);
        }
        if(ppos>1){
            kbl = 6+""+(ppos-1);
        }
        if(ppos<8){
            kbr = 6+""+(ppos+1);
        }
        if(kpos.equalsIgnoreCase(kr) || kpos.equalsIgnoreCase(kl) || kpos.equalsIgnoreCase(kbl) || kpos.equalsIgnoreCase(kbr)){
            return 1;
        }else{
            return 0;
        }

    }
    static int bishop(String kpos, int ppos){
        int pr = 8;
        int pc = ppos;
        int row = kpos.charAt(0)-'0';
        int column = kpos.charAt(1)-'0';
        int flag1 = 0,flag2=0;
        while(pr>1 && pc>1 && pr>row){
            pr--;
            pc--;
            if(row==pr && column==pc){
                flag1=1;
                break;
            }
        }
        if(flag1!=1){
            pr = 8;
            pc = ppos;

            while(pr>1 && pc<=8 && pr>row){
                pr--;
                pc++;
                if(row==pr && column==pc){
                    flag2=1;
                    break;
                }
            }
        }
        if(flag1==1 || flag2==1){
            return 1;
        }else
            return 0;
    }



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int query = Integer.parseInt(br.readLine().trim());
        while(query-->0){
            String[] r = new String[8];
            for(int i = 0; i<8; i++){
                r[i] = br.readLine().trim();
            }

            int ppos = 0;
            String kpos = "";
            for(int i = 0; i<8; i++){
                for(int j = 0; j<8; j++){
                    if(r[i].charAt(j) == 'k')
                        kpos = (8-i)+""+(j+1);
                }
            }
            for(int i = 0; i<8; i++){
                if(r[1].charAt(i)=='P'){
                    ppos = i+1;
                    break;
                }
            }

            int count = rook(kpos,ppos)+knight(kpos,ppos)+bishop(kpos,ppos)+queen(kpos,ppos);
            System.out.println(count);
        }

    }
}

