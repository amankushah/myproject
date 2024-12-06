import java.util.Scanner;
class guesser{
    int Guesser;
    public int guessernum()
    {
        Scanner sc=new Scanner(System.in);
        Guesser=sc.nextInt();
        return Guesser;
    }
}
class player{
    int Player;
    public int playernum()
    {
        Scanner sc=new Scanner(System.in);
        Player=sc.nextInt();
        return Player;
    }
}
class umpier{
    int GSRNUM;
    int PLYR1;
    int PLYR2;
    int PLYR3;
    public void collectfromguesser()
    {
        guesser gu=new guesser();
        System.out.print("guesser guess please a number : ");
        GSRNUM=gu.guessernum();
    }
    public void collectfromplayers()
    {
        player p1=new player();
        System.out.print("enter the player1 number : ");
        PLYR1=p1.playernum();

        player p2=new player();
        System.out.print("enter the player2 number : ");
        PLYR2=p2.playernum();

        player p3=new player();
        System.out.print("enter the player3 number : ");
        PLYR3=p3.playernum();
    }
    public void compare()
    {
        if(GSRNUM==PLYR1)
        {
            if(GSRNUM==PLYR2 && GSRNUM==PLYR3)
            System.out.println("all the players won the game");
            else if(GSRNUM==PLYR2)
            System.out.println("player1 and player2 won the game");
            else if(GSRNUM==PLYR3)
            System.out.println("player1 and player3 won the game");
            else
            System.out.println("only player1 won the game");
        }
        else if(GSRNUM==PLYR2)
        {
          if(GSRNUM==PLYR3)
          System.out.println("player2 and player3 won the game");
          else System.out.println("only player2 won the game");
        }
        else if(GSRNUM==PLYR3)
        {
            System.out.println("only player3 won the game");
        }
       else System.out.println("all the players lost the game");
    }
}
public class guessergame
{
    public static void main(String[] args) {
        System.out.println("-----game has started-----");
        umpier obj=new umpier();
        obj.collectfromguesser();
        obj.collectfromplayers();
        obj.compare();
        System.out.println("-----game has ended-----");
    }
}