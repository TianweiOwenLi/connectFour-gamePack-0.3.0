package GamePacks;
import java.util.Scanner;
import java.util.Arrays;
public class Game_03 {

	public void go(int chessBoard[][] , int line, int atSide){
		if (chessBoard[0][line]!=0){
		}else{
			int i=0;
			while((i<6)&&(chessBoard[i][line]==0)){
				i++;
			}
			chessBoard[i-1][line]=atSide;
		}
	}

	public void up(int digit, int arr[]){
		int[] origin=new int[11];
		for(int i=0;i<11;i++){
			origin[i]=arr[i];
		}
		arr[digit]++;
		for(int i=digit+1;i<11;i++){
			arr[i]=0;
		}

		while((arr[2]-7)*(arr[3]-7)*(arr[4]-7)*(arr[5]-7)*(arr[6]-7)*(arr[7]-7)*(arr[8]-7)*(arr[9]-7)*(arr[10]-7)==0){
			if(arr[2]==7){
				arr[2]=0;
				arr[0]++;
			}
			
			if(arr[3]==7){
				arr[3]=0;
				arr[1]++;
			}
			
			if(arr[4]==7){
				arr[4]=0;
				arr[2]++;
			}
			
			if(arr[5]==7){
				arr[5]=0;
				arr[3]++;
			}
			
			if(arr[6]==7){
				arr[6]=0;
				arr[4]++;
			}
			
			if(arr[7]==7){
				arr[7]=0;
				arr[5]++;
			}
			
			if(arr[8]==7){
				arr[8]=0;
				arr[6]++;
			}
			
			if(arr[9]==7){
				arr[9]=0;
				arr[7]++;
			}
			
			if(arr[10]==7){
				arr[10]=0;
				arr[8]++;
			}
		}

		boolean clear=false;
		for(int i=0;i<10;i++){
			if(clear){
				arr[i]=0;
			}
			if(arr[i]!=origin[i]){
				clear=true;
			}
		}
	}
	
	public int test(int chessBoard[][]){
		int r=0;
		for(int i=0;i<21;i++){
			if(Math.abs((chessBoard[i/7][i%7]+chessBoard[(i/7)+1][i%7]+chessBoard[(i/7)+2][i%7]+chessBoard[(i/7)+3][i%7])*chessBoard[i/7][i%7]*chessBoard[(i/7)+1][i%7]*chessBoard[(i/7)+2][i%7]*chessBoard[(i/7)+3][i%7])==4){
				r=chessBoard[i/7][i%7];
			}
		}
		for(int i=0;i<24;i++){
			if(Math.abs((chessBoard[i/4][i%4]+chessBoard[i/4][(i%4)+1]+chessBoard[i/4][(i%4)+2]+chessBoard[i/4][(i%4)+3])*chessBoard[i/4][i%4]*chessBoard[i/4][(i%4)+1]*chessBoard[i/4][(i%4)+2]*chessBoard[i/4][(i%4)+3])==4){
				r=chessBoard[i/4][i%4];
			}
		}
		for(int i=0;i<12;i++){
			if(Math.abs((chessBoard[i/4][i%4]+chessBoard[(i/4)+1][(i%4)+1]+chessBoard[(i/4)+2][(i%4)+2]+chessBoard[(i/4)+3][(i%4)+3])*chessBoard[i/4][i%4]*chessBoard[(i/4)+1][(i%4)+1]*chessBoard[(i/4)+2][(i%4)+2]*chessBoard[(i/4)+3][(i%4)+3])==4){
				r=chessBoard[i/4][i%4];
			}
		}
		for(int i=0;i<12;i++){
			if(Math.abs((chessBoard[i/4][(i%4)+3]+chessBoard[(i/4)+1][(i%4)+2]+chessBoard[(i/4)+2][(i%4)+1]+chessBoard[(i/4)+3][i%4])*chessBoard[i/4][(i%4)+3]*chessBoard[(i/4)+1][(i%4)+2]*chessBoard[(i/4)+2][(i%4)+1]*chessBoard[(i/4)+3][i%4])==4){
				r=chessBoard[i/4][(i%4)+3];
			}
		}
		return r;
	}
	
	public void undo(int Board[][], int com, int player){
		for(int i=0;i<6;i++){
			if(Board[i][com]!=0){
				Board[i][com] = 0;
				i = 6;
			}
		}
		
		for(int i=0;i<6;i++){
			if(Board[i][player]!=0){
				Board[i][player] = 0;
				i = 6;
			}
		}
	}
	
	public void copyBoard(int mockBoard [][], int Board [][]){
		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				mockBoard[i][j]=Board[i][j];
			}
		}
	}

	public class value_05 {
		
		//Can not be used in the method Value_04.
		int Board[][] = new int[8][9];
		
		public value_05(int Board_o [][]){
			//Craft a board with a frame of number 2.
			for(int i=0;i<8;i++){
				for(int j=0;j<9;j++){
					if((i*j*(i-7)*(j-8))==0){
						Board[i][j] = 2;
					}else{
						Board[i][j] = Board_o[i-1][j-1];
					}
				}
			}
		}
		
		public int slant_3(){
			int n = 0;
			for(int i=2;i<6;i++){
				for(int j=2;j<7;j++){
					if((Board[i][j]==Board[i-1][j-1])&&(Board[i][j]==Board[i+1][j+1])&&(Math.abs(Board[i][j])==1)&&((Board[i+2][j+2]==0)||(Board[i-2][j-2]==0))){
						n = n+Board[i][j];
					}
					
					if((Board[i][j]==Board[i-1][j+1])&&(Board[i][j]==Board[i+1][j-1])&&(Math.abs(Board[i][j])==1)&&((Board[i-2][j+2]==0)||(Board[i+2][j-2]==0))){
						n = n+Board[i][j];
					}
				}
			}
			
			return n;
		}
		
		public int hor_3(){
			int n = 0;
			for(int i=1;i<7;i++){
				for(int j=2;j<7;j++){
					if((Board[i][j]==Board[i][j-1])&&(Board[i][j]==Board[i][j+1])&&(Math.abs(Board[i][j])==1)&&((Board[i][j-2]==0)||(Board[i][j+2]==0))){
						n = n+Board[i][j];
					}
				}
			}
			return n;
		}
		
		public int ver_3(){
			int n = 0;
			for(int i=3;i<6;i++){
				for(int j=1;j<8;j++){
					if((Board[i][j]==Board[i-1][j])&&(Board[i][j]==Board[i+1][j])&&(Math.abs(Board[i][j])==1)&&(Board[i-2][j]==0)){
						n = n+Board[i][j];
					}
				}
			}
			return n;
		}
		
		public int slant_2(){
			int n = 0;
			for(int i=1;i<6;i++){
				for(int j=1;j<7;j++){
					if((Board[i+1][j+1]==Board[i][j])&&(Math.abs(Board[i][j])==1)&&((Board[i-1][j-1]==0)||(Board[i+2][j+2]==0))){
						n = n+Board[i+1][j+1];
					}
					
					if((Board[i+1][j]==Board[i][j+1])&&(Math.abs(Board[i+1][j])==1)&&((Board[i-1][j+2]==0)||(Board[i+2][j-1]==0))){
						n = n+Board[i+1][j];
					}
					
					if((Board[i+1][j+1]==Board[i][j])&&(Math.abs(Board[i][j])==1)&&((Board[i-1][j-1]==0)&&(Board[i+2][j+2]==0))){
						n = n+Board[i+1][j+1];
					}
					
					if((Board[i+1][j]==Board[i][j+1])&&(Math.abs(Board[i+1][j])==1)&&((Board[i-1][j+2]==0)&&(Board[i+2][j-1]==0))){
						n = n+Board[i+1][j];
					}
				}
			}
			return n;
		}
		
		public int hor_2(){
			int n=0;
			for(int i=1;i<7;i++){
				for(int j=1;j<7;j++){
					if((Board[i][j+1]==Board[i][j])&&(Math.abs(Board[i][j])==1)&&((Board[i][j+2]==0)||(Board[i][j-1]==0))){
						n = n+Board[i][j];
					}
					
					if((Board[i][j+1]==Board[i][j])&&(Math.abs(Board[i][j])==1)&&((Board[i][j+2]==0)&&(Board[i][j-1]==0))){
						n = n+Board[i][j];
					}
				}
			}
			return n;
		}
		
		public int ver_2(){
			int n=0;
			for(int i=1;i<6;i++){
				for(int j=1;j<8;j++){
					if((Board[i+1][j]==Board[i][j])&&(Math.abs(Board[i][j])==1)&&((Board[i+2][j]==0)||(Board[i-1][j]==0))){
						n = n+Board[i+1][j];
					}
					
					if((Board[i+1][j]==Board[i][j])&&(Math.abs(Board[i][j])==1)&&((Board[i+2][j]==0)&&(Board[i-1][j]==0))){
						n = n+Board[i+1][j];
					}
				}
			}
			return n;
		}
		
		public int value(){
			return 8*(slant_3()+hor_3()+ver_3())+5*(slant_2()+hor_2()+ver_2());
		}
	}
	
	public int value(int Board[][],int step){
		int[][] mockBoard = new int[6][7];
		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				mockBoard[i][j]=Board[i][j];
			}
		}
		value_05 value = new value_05(mockBoard);
		int a = value.value();
		
		go(mockBoard, step, -1);
		value_05 value_b = new value_05(mockBoard);
		int b = value_b.value();
		
		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				mockBoard[i][j]=Board[i][j];
			}
		}
		go(mockBoard, step, 1);
		value_05 value_c = new value_05(mockBoard);
		int c = value_c.value();
		return (int)(Math.max(0, c-a))+a-b;
	}
	
	public int attack(int Board[][]){
		int[][] mockBoard=new int[6][7];
		int[] path=new int[11];
		Arrays.fill(path, 0);
		while((path[0]-7)*(path[1]-7)!=0){
			while((path[0]-7)*(path[1]-7)!=0){
				copyBoard(mockBoard, Board);
				
				//First level
				if(mockBoard[0][path[0]]==0){
					go(mockBoard, path[0], -1);
					if(test(mockBoard)==-1){
						path[1]=7;
						break;
					}
				}else{
					up(0, path);
					break;
				}
				
				//Second level
				if(mockBoard[0][path[1]]==0){
					go(mockBoard, path[1], 1);
					if(test(mockBoard)==1){
						up(0, path);
						break;
					}
				}else{
					up(1, path);
					break;
				}
				
				//Third level
				if(mockBoard[0][path[2]]==0){
					go(mockBoard, path[2], -1);
					if(test(mockBoard)==-1){
						up(1, path);
						break;
					}
				}else{
					up(2, path);
					break;
				}
				
				//Fourth level
				if(mockBoard[0][path[3]]==0){
					go(mockBoard, path[3], 1);
					if(test(mockBoard)==1){
						up(2, path);
						break;
					}
				}else{
					up(3, path);
					break;
				}
				
				//Fifth level
				if(mockBoard[0][path[4]]==0){
					go(mockBoard, path[4], -1);
					if(test(mockBoard)==-1){
						up(3, path);
						break;
					}
				}else{
					up(4, path);
					break;
				}
				
				//Sixth level
				if(mockBoard[0][path[5]]==0){
					go(mockBoard, path[5], 1);
					if(test(mockBoard)==1){
						up(4, path);
						break;
					}
				}else{
					up(5, path);
					break;
				}
				

				//Seventh level
				if(mockBoard[0][path[6]]==0){
					go(mockBoard, path[6], -1);
					if(test(mockBoard)==-1){
						up(5, path);
						break;
					}
				}else{
					up(6, path);
					break;
				}
				
				//Eighth level
				if(mockBoard[0][path[7]]==0){
					go(mockBoard, path[7], 1);
					if(test(mockBoard)==1){
						up(6, path);
						break;
					}
				}else{
					up(7, path);
					break;
				}
				
				//Ninth level
				if(mockBoard[0][path[8]]==0){
					go(mockBoard, path[8], -1);
					if(test(mockBoard)==-1){
						up(7, path);
						break;
					}else{
						up(8, path);
						break;
					}
				}else{
					up(8, path);
					break;
				}
			}
		}
		return path[0];
	}
	
	public int defense(int Board[][]){
		int[][] mockBoard=new int[6][7];
		int[] path=new int[11];
		int[] result=new int[7];
		int score[]=new int[7];
		int r=7;
		Arrays.fill(path, 0);
		Arrays.fill(result, 0);
		Arrays.fill(score, 0);

		//First tree
		while((path[0]-7)!=0){
			if(path[1]==7){
				result[path[0]]=1;
				up(0, path);
				
			}
			while((path[0]-7)!=0){
				//Form the original board
				copyBoard(mockBoard, Board);
				
				//First level
				if(mockBoard[0][path[0]]==0){
					go(mockBoard, path[0], -1);
				}else{
					up(0, path);
					break;
				}
				
				//Second level
				if(mockBoard[0][path[1]]==0){
					go(mockBoard, path[1], 1);
					if(test(mockBoard)==1){
						up(0, path);
						break;
					}
				}else{
					up(1, path);
					break;
				}
				
				//Third level
				if(mockBoard[0][path[2]]==0){
					go(mockBoard, path[2], -1);
				}else{
					up(2, path);
					break;
				}
				
				//Fourth level
				if(mockBoard[0][path[3]]==0){
					go(mockBoard, path[3], 1);
					if(test(mockBoard)==1){
						up(2, path);
						break;
					}
				}else{
					up(3, path);
					break;
				}
				//Fifth level
				if(mockBoard[0][path[4]]==0){
					go(mockBoard, path[4], -1);
				}else{
					up(4, path);
					break;
				}
				
				//Sixth level
				if(mockBoard[0][path[5]]==0){
					go(mockBoard, path[5], 1);
					if(test(mockBoard)==1){
						up(4, path);
						break;
					}
				}else{
					up(5, path);
					break;
				}
				
				//Seventh level
				if(mockBoard[0][path[6]]==0){
					go(mockBoard, path[6], -1);
				}else{
					up(6, path);
					break;
				}
				
				//Eighth level
				if(mockBoard[0][path[7]]==0){
					go(mockBoard, path[7], 1);
					if(test(mockBoard)==1){
						up(6, path);
						break;
					}else{
						up(7, path);
						break;
					}
				}else{
					up(7, path);
					break;
				}
			}//System.out.println();
		}
		if(result[0]+result[1]+result[2]+result[3]+result[4]+result[5]+result[6]!=0){
			for(int i=0;i<7;i++){
				if(result[i]==1){
					score[i]=value(Board, i);
				}else{
					score[i]=-100;
				}
			}
			int max=-50;
			
			for(int i2=0;i2<7;i2++){
				if(score[i2]>max){
					max=score[i2];
				}
			}
			
			for(int i3=0;i3<7;i3++){
				if((max-score[i3])>0){
					result[i3]=0;
				}
			}
			
			int randNum=1+(int)(Math.random()*(result[0]+result[1]+result[2]+result[3]+result[4]+result[5]+result[6]));
			int counter=0;
			for(int i4=0;i4<7&&counter<randNum;i4++){
				if(result[i4]==1){
					counter++;
					r=i4;
				}
			}
			return r;
			
		}else{
			Arrays.fill(path, 0);
			//Second tree
			while((path[0]-7)*(path[1]-7)!=0){
				while((path[0]-7)*(path[1]-7)!=0){
					copyBoard(mockBoard, Board);
					
					//First level
					if(mockBoard[0][path[0]]==0){
						go(mockBoard, path[0], -1);
					}else{
						up(0, path);
						break;
					}
					
					//Second level
					if(mockBoard[0][path[1]]==0){
						go(mockBoard, path[1], 1);
						if(test(mockBoard)==1){
							up(0, path);
							break;
						}
					}else{
						up(1, path);
						break;
					}
					
					//Third level
					if(mockBoard[0][path[2]]==0){
						go(mockBoard, path[2], -1);
					}else{
						up(2, path);
						break;
					}
					
					//Fourth level
					if(mockBoard[0][path[3]]==0){
						go(mockBoard, path[3], 1);
						if(test(mockBoard)==1){
							up(2, path);
							break;
						}
					}else{
						up(3, path);
						break;
					}
					
					//Fifth level
					if(mockBoard[0][path[4]]==0){
						go(mockBoard, path[4], -1);
					}else{
						up(4, path);
						break;
					}
					
					//Sixth level
					if(mockBoard[0][path[5]]==0){
						go(mockBoard, path[5], 1);
						if(test(mockBoard)==1){
							up(4, path);
							break;
						}else{
							up(5, path);
							break;
						}
					}else{
						up(5, path);
						break;
					}
				}
			}
			r=path[0];
			if(r!=7){
				return r;
			}else{
				Arrays.fill(path, 0);
				//Third tree
				while((path[0]-7)*(path[1]-7)!=0){
					while((path[0]-7)*(path[1]-7)!=0){
						copyBoard(mockBoard, Board);
						
						//First level
						if(mockBoard[0][path[0]]==0){
							go(mockBoard, path[0], -1);
						}else{
							up(0, path);
							break;
						}
						
						//Second level
						if(mockBoard[0][path[1]]==0){
							go(mockBoard, path[1], 1);
							if(test(mockBoard)==1){
								up(0, path);
								break;
							}else{
								up(1, path);
								break;
							}
						}
					
					
						//Third level
						if(mockBoard[0][path[2]]==0){
							go(mockBoard, path[2], -1);
						}else{
							up(2, path);
							break;
						}
					
						//Fourth level
						if(mockBoard[0][path[3]]==0){
							go(mockBoard, path[3], 1);
							if(test(mockBoard)==1){
								up(2, path);
								break;
							}else{
								up(3, path);
								break;
							}
						}else{
							up(3, path);
							break;
						}
					}
			}
			r=path[0];
			if(r!=7){
				return r;
			}else{
				Arrays.fill(path, 0);
				//Fourth tree
				while((path[0]-7)*(path[1]-7)!=0){
					while((path[0]-7)*(path[1]-7)!=0){
						copyBoard(mockBoard, Board);
						
						//First level
						if(mockBoard[0][path[0]]==0){
							go(mockBoard, path[0], -1);
						}else{
							up(0, path);
							break;
						}
						
						//Second level
						if(mockBoard[0][path[1]]==0){
							go(mockBoard, path[1], 1);
							if(test(mockBoard)==1){
								up(0, path);
								break;
							}else{
								up(1, path);
								break;
								}
							}else{
								up(1, path);
								break;
							}
						}
					}
				r=path[0];
				if(r!=7){
					return r;
				}else{
					for(int i5=0;i5<7;i5++){
						if(Board[0][i5]==0){
							return i5;
						}
					}
				}
				return 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int Board[][]=new int[6][7];
		Game_03 hacer=new Game_03();
		int side=1;
		int step=0;
		int playerLast = 7;
		int computerLast = 7;
		//boolean go=true;
		while((hacer.test(Board)==0)&&step<42){
			//Operate
			if(side==1){
				Scanner press=new Scanner(System.in);
				int pressNum=press.nextInt()-1;
				if(pressNum == -1){
					if((computerLast != 7)&&(playerLast != 7)){
						hacer.undo(Board, computerLast, playerLast);
						playerLast = 7;
						computerLast = 7;
						step = step-2;
					}else{
						System.out.println();
						if(step < 2){
							System.out.println("You don't have enough steps to use the 'undo' method !");
						}else{
							System.out.println("You can only use the 'undo' priviledge once a time !");
						}
						System.out.println();
					}
				}else{
					if(Board[0][pressNum]==0){
						hacer.go(Board,pressNum, side);
						playerLast = pressNum;
						side=side*(-1);
						step++;
					}else{
						System.out.println("This column is filled, please choose another column to place your piece !");
					}
				}
			}else{
					System.out.println();
					System.out.println("Calculating...Please Wait");
					System.out.println();
					long t=System.currentTimeMillis()+500;
					while(t!=System.currentTimeMillis()){}
					int A=hacer.attack(Board);
					if(A==7){
						int D=hacer.defense(Board);
						hacer.go(Board,D, -1);
						computerLast = D;
					
					}else{
						hacer.go(Board,A, -1);
						computerLast = A;
					}
				side=side*(-1);
				step++;
			}
			
			//Print out the board
			for(int i=0;i<6;i++){
				System.out.print("|");
				for(int j=0;j<7;j++){
					if(Board[i][j]==1){
						System.out.print(" O ");
					}else if(Board[i][j]==-1){
						System.out.print(" X ");
					}else{
						System.out.print("   ");
					}
				}
				System.out.println("|");
			}
			System.out.println();
		}
		long t=System.currentTimeMillis()+500;
		while(t!=System.currentTimeMillis()){}
		if(hacer.test(Board)==1){
			System.out.println("Player Wins!");
		}else if(hacer.test(Board)==-1){
			System.out.println("Computer Wins!");
		}else{
			System.out.println("Tied!");
		}
	}
}
//Developed 28 Feb 2017 by Tianwei (Owen) Li as a connectFour program.