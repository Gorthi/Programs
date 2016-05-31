

public class ChessMetric {
	public static long howMany(int size,int[] start,int[] end,int nomoves){
		long ways[][][] = new long[size][size][55];
		int dx[] = {-2,-2,-1,-1,-1,-1,-1,0,0,1,1,1,1,1,2,2};
		int dy[] = {-1,1,-2,-1,0,1,2,-1,1,-2,-1,0,1,2,-1,1};
		int x,y,i,j; 
	    for(x=0;x<size;x++) for(y=0;y<size;y++) for(i=0;i<55;i++) ways[y][x][i]=0; 
	    int sx=start[0],sy=start[1],ex=end[0],ey=end[1]; 
	    ways[sy][sx][0]=1; 
	    for(i=1;i<=nomoves;i++) { 
	      for(x=0;x<size;x++) 
	        for(y=0;y<size;y++) { 
	          for(j=0;j<16;j++) { 
	            int nx=x+dx[j]; 
	            int ny=y+dy[j]; 
	            if (nx<0 || ny<0 || nx>=size || ny>=size) continue; 
	            ways[ny][nx][i]+=ways[y][x][i-1]; 
	          } 
	        } 
	    }
	    return ways[ex][ey][nomoves];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size=100;
		int start[]={0,0};
		int end[]={0,99};
		int noMoves=50;
		System.out.println(howMany(size,start,end,noMoves));

	}

}
