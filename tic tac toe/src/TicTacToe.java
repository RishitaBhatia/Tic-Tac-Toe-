import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class TicTacToe {
	
	static ArrayList<Integer> playerpos=new ArrayList<Integer>();
	static ArrayList<Integer> systempos=new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board= {{' ','|',' ','|',' '},{'-','+','-','+','-'},{' ','|',' ','|',' '},{'-','+','-','+','-'},{' ','|',' ','|',' '}};
		
		print(board);
		
		while(true)
		{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter your placement (1-9)");
		int pos=sc.nextInt();
		while(playerpos.contains(pos)||systempos.contains(pos))
		{
			System.out.println("Position taken! Enter a correct position");
			pos=sc.nextInt();
		}
		placement(board,pos,"player");
		String result=winner();
		if(result.length()>0)
		{
		System.out.println(result);
		break;
		}
		
		Random rd=new Random();
		int syspos=rd.nextInt(9)+1;
		while(playerpos.contains(syspos)||systempos.contains(syspos))
		{
			syspos=rd.nextInt(9)+1;
		}
		placement(board,syspos,"system");
		
		print(board);
		
	    result=winner();
		if(result.length()>0)
		{
		System.out.println(result);
		break;
		}
		}
	}
		
		public static void print(char[][] board)
		{
			for(int i=0;i<board.length;i++)
			{
				for(int j=0;j<board.length;j++)
				{
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
		}
		
		public static void placement(char[][] board,int pos,String user)
		{
			char symbol=' ';
			if(user.equals("player"))
			{
				symbol='X';
				playerpos.add(pos);
			}
			else if(user.equals("system"))
			{
				symbol='O';
				systempos.add(pos);
			}
			
			switch(pos)
			{
			case 1:
				board[0][0]=symbol;
				break;
			case 2:
				board[0][2]=symbol;
				break;
			case 3:
				board[0][4]=symbol;
				break;
			case 4:
				board[2][0]=symbol;
				break;
			case 5:
				board[2][2]=symbol;
				break;
			case 6:
				board[2][4]=symbol;
				break;
			case 7:
				board[4][0]=symbol;
				break;
			case 8:
				board[4][2]=symbol;
				break;
			case 9:
				board[4][4]=symbol;
				break;
			default:
				break;	
			}
		}
		
		public static String winner()
		{
			List toprow=Arrays.asList(1,2,3);
			List midrow=Arrays.asList(4,5,6);
			List bottomrow=Arrays.asList(7,8,9);
			List topcol=Arrays.asList(1,4,7);
			List midcol=Arrays.asList(2,5,8);
			List bottomcol=Arrays.asList(3,6,9);
			List diag1=Arrays.asList(1,5,9);
			List diag2=Arrays.asList(7,5,9);
			
			List<List> winner=new ArrayList<List>();
			winner.add(toprow);
			winner.add(midrow);
			winner.add(bottomrow);
			winner.add(topcol);
			winner.add(midcol);
			winner.add(bottomcol);
			winner.add(diag1);
			winner.add(diag2);
			
			for(List l:winner)
				if(playerpos.containsAll(l))
				{
					return "Congratulations, you won!";
				}
				else if(systempos.containsAll(l))
				{
					return "System wins! Sorry :(";
				}
				else if(playerpos.size()+systempos.size()==9)
				{
					return "It's a tie.";
				}
			return "";
		}

}
