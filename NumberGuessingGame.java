import java.util.Scanner;
import java.util.Random;

class Game{
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);
    int number;
    int noOfAttempts;
    int count;
    int randNum;
    int points;
    Game(int c){
        this.noOfAttempts = c;
    }
    void process(){
        randNum = rand.nextInt(1, 100);
        System.out.println("Number has been given.");
        for(int i=0;i<noOfAttempts;i++){
            System.out.println();
            System.out.println("Enter number:-");
            number = sc.nextInt();
            if(randNum==number){
                System.out.println("You got the number in "+count+ " attempts");
                break;
            }
            else if(randNum>number){
                System.out.println("Its a small number...Go higher.");
                count+=1;
            }
            else{
                System.out.println("Its a large number...Go smaller.");
                count+=1;
            }
        }
        if(count==noOfAttempts){
            System.out.println("YOU LOSE.");
        }
        else{
            System.out.println("YOU WON.");
        }
    }

    int points(){
        this.points = noOfAttempts-count;
        return points;

    }
}

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int user;
        int round = 1;
        do {

            System.out.println("Enter 1 for playing the game and 0 for not playing the game.");
            user = sc.nextInt();
            if(user!=1 && user!=0){
                System.out.println("You initiated the game with wrong input...");
                System.out.println("GAME TERMINATED....");
                break;
            }
            else if (user == 0) {
                System.out.println("THANKS FOR PLAYING THE GAME.");
                break;
            }
            else {
                System.out.println("ROUND:" + round);
                Game g = new Game(10);
                g.count = 0;
                g.process();
                System.out.println("YOUR POINTS:- " + g.points());
                System.out.println();
                round += 1;
            }
        }
        while (true);
    }
}
