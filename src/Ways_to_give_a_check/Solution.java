package Ways_to_give_a_check;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int queen(String kpos, String pawn, String[] r){
        if(rook(kpos,pawn,r)==1 || bishop(kpos,pawn,r)==1){
            return 1;
        }else
            return 0;
    }
    static int rook(String kpos, String pawn, String[] chess){
        int ppos = pawn.charAt(1)-'0';
        int a = kpos.charAt(0)-'0';
        int b = kpos.charAt(1)-'0';

        int answer = 0;

        if( a==(pawn.charAt(0)-'0') && b<ppos){
            int pos = ppos-1;
            while(pos>b){
                if(chess[8-(pawn.charAt(0)-'0')].charAt(pos-1) != '#'){
                    answer = 0;
                    break;
                }else{
                    answer = 1;
                    pos--;
                }
            }

        }else if(a==(pawn.charAt(0)-'0') && b>ppos){
            int pos = ppos+1;
            while(pos<b){
                if(chess[8-(pawn.charAt(0)-'0')].charAt(pos-1) != '#'){
                    answer = 0;
                    break;
                }else{
                    answer = 1;
                    pos++;
                }
            }
        }else if(b==ppos){
            for(int i = 0; i<(8-a); i++){
               if(chess[i].charAt(b-1) != '#'){
                   answer = 0;
                   break;
               }else
                   answer = 1;
            }
        }

        return answer;
    }
    static int knight(String kpos, String pawn){
        int ppos = pawn.charAt(1)-'0';
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
    static int bishop(String kpos, String pawn, String[] chess){
        int ppos = pawn.charAt(1)-'0';
        int pr = 8, pc = ppos;
        int row = kpos.charAt(0)-'0';
        int column = kpos.charAt(1)-'0';
        int answer = 0;
        int r = 1,c=ppos-2;
        if(column<ppos){

            while(pr>1 && pc>1 && pr>row){
                pr--;
                pc--;
                if(chess[r].charAt(c)=='#'){
                    r++;
                    c--;
                }else{
                    if(row==pr && column==pc){
                        answer=1;
                        break;
                    }else{
                        answer = 0;
                        break;
                    }
                }

            }
        }else if(column>ppos){
            r = 1; c = ppos;
            pr = 8;pc = ppos;

            while(pr>1 && pc<=8 && pr>row){
                pr--;
                pc++;
                if(chess[r].charAt(c)=='#'){
                    r++;
                    c++;
                }else{
                    if(row==pr && column==pc){
                        answer=1;
                        break;
                    }else{
                        answer = 0;
                        break;
                    }
                }
            }
        }else{
            answer = 0;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int query = Integer.parseInt(br.readLine().trim());
        while(query-->0){

            String[] r = new String[8];
            for(int i = 0; i<8; i++){
                r[i] = br.readLine().trim();
            }

            String ppos = "8";
            String kpos = "";

            for(int i = 0; i<8; i++){
                if(r[1].charAt(i)=='P'){
                    ppos += (i+1);
                    break;
                }
            }
            //(ppos.charAt(1)-'0')-1
            r[0] = r[0].substring(0,((ppos.charAt(1)-'0')-1))+"P"+r[0].substring((ppos.charAt(1)-'0'));
            r[1] = r[1].substring(0,((ppos.charAt(1)-'0')-1))+"#"+r[1].substring((ppos.charAt(1)-'0'));

            /*
            king    k
            queen   q
            bishop  b
            rook    r
            knight  n
            pawn    p
            */

            for(int i = 0; i<8; i++){
                for(int j = 0; j<8; j++){
                    if(r[i].charAt(j) == 'k')
                        kpos = (8-i)+""+(j+1);

                }
            }

            int count = rook(kpos,ppos,r)+knight(kpos,ppos)+bishop(kpos,ppos,r)+queen(kpos,ppos,r);

            String ROOK = "00", BISHOP = "00", QUEEN="00";
            for(int i = 0; i<2; i++){
                for(int j = 0; j<8; j++){
                    if(r[i].charAt(j) == 'R'){
                        ROOK = (8-i)+""+(j+1);
                        if( (ROOK.charAt(0)-'0')==7 &&(kpos.charAt(0)-'0')==7 )
                            count+=rook(kpos,ROOK,r);
                    }
                    if(r[i].charAt(j) == 'B'){
                        BISHOP = (8-i)+""+(j+1);
                        if((BISHOP.charAt(0)-'0')==8 && ((BISHOP.charAt(1)-'0')==((ppos.charAt(1)-'0')-1) || (BISHOP.charAt(1)-'0')==((ppos.charAt(1)-'0')+1) )){
                            count += bishop(kpos,BISHOP,r);
                        }
                    }
                    if(r[i].charAt(j) == 'Q'){
                        QUEEN = (8-i)+""+(j+1);
                        if( (QUEEN.charAt(0)-'0')==7 &&(kpos.charAt(0)-'0')==7 )
                            count+=rook(kpos,QUEEN,r);


                        if( (QUEEN.charAt(0)-'0')==8 && ((QUEEN.charAt(1)-'0')==((ppos.charAt(1)-'0')-1) || (QUEEN.charAt(1)-'0')==((ppos.charAt(1)-'0')+1) )){
                            count += bishop(kpos,QUEEN,r);
                        }
                    }
                }
            }



            System.out.println(count);
        }

    }
}
