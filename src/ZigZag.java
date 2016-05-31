import java.util.Scanner;

public class ZigZag {
	
	public static int zigzag(int[] a){
		int max=0;
		int z[][] = new int[a.length][2];
		for(int i=0;i<a.length;i++){
				z[i][0]=1;
				z[i][1]=1;
		}

		for(int i=1;i<a.length;i++){
			for(int j=i-1;j>=0;j--){
				if(a[i]-a[j]>0 && z[i][1]<z[j][0]+1)
					z[i][1]=z[j][0]+1;
				else if(a[i]-a[j]<0 && z[i][0]<z[j][1]+1)
					z[i][0]=z[j][1]+1;
			}
			max = z[i][0]>z[i][1]?z[i][0]:z[i][1];
		}
	
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int size=scan.nextInt();
		int array[]=new int[size];
		for(int count=0;count<size;count++){
			array[count]=scan.nextInt();
		}
		//int array[] = { 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 };
		int ans=zigzag(array);
		System.out.println(ans);
		scan.close();

	}

}
