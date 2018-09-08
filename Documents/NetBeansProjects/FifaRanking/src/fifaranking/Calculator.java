package fifaranking;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
/**
 *
 * @author jeczm
 */
public class Calculator {
        Player player1,player2;
        int goals1,goals2;
        double stars1,stars2;
        double W;
        int K;
       
        public Calculator(Player p1,Player p2,int g1,int g2,double s1,double s2,int gameWeight){
            player1=p1;
            player2=p2;
            goals1=g1;
            goals2=g2;
            stars1=s1;
            stars2=s2; 
            K=gameWeight;
            
        }
        
        
        public double countExpectedResultForFirstTeam(){
            double dr=((stars1-stars2)*57+player1.score-player2.score);
            double power=(-1*dr/400);
            double retVal=1/(pow(10,power)+1);
            retVal=1000*retVal;
            retVal=Math.round(retVal);
            retVal=retVal/1000;
            return retVal;
        } 
        public double countExpectedResultForSecondTeam(){
            double dr=((stars2-stars1)*57+player2.score-player1.score);
            double power=(-1*dr/400);
            double retVal=1/(pow(10,power)+1);
            retVal=1000*retVal;
            retVal=Math.round(retVal);
            retVal=retVal/1000;
            return retVal;
        }
        
        public int countPointDifferenceForFirstTeam(){
            int retVal;
            double val,expected;
            int goalDiff=goals1-goals2;
            wasAWin(goalDiff);
            double G=calculateG(goalDiff);
            expected=countExpectedResultForFirstTeam();
            val=Math.round(K*G*(W-expected));
            retVal=(int)val;
            return retVal;
        }
        public int countPointDifferenceForSecondTeam(){
            int retVal;
            double val,expected;
            int goalDiff=goals2-goals1;
            wasAWin(goalDiff);
            double G=calculateG(goalDiff);
            expected=countExpectedResultForFirstTeam();
            val=Math.round(K*G*(W-expected));
            retVal=(int)val;
            return retVal;
        }
        
        public double calculateG(int d){
            double retVal;
            if(abs(d)<=1){
                retVal=1;
            }
            else if(abs(d)==2){
                retVal=1.5;
            }
            else{
                retVal=11+abs(d);
                retVal=retVal/8;
            }
            return retVal;                    
        }    
        private void wasAWin(int diff){
            if(diff>0)
                W=1;
            else if(diff<0)
                W=0;
            else
                W=0.5;
        }
        
}
