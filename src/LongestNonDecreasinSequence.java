import java.util.Arrays;
import java.util.Scanner;

public class LongestNonDecreasinSequence {
	
	public static int max(int a,int b){
		return (a>b?a:b);
	}
	
	public static int longestNonDecreasingSequence(int[] a){
		int[] s = new int[a.length];
		Arrays.fill(s, 1);
		for(int i=1;i<a.length;i++){
			for(int j=i-1;j>=0;j--){
				if(a[j]<a[i] && s[i]<s[j]+1){
					s[i]=s[j]+1;
				}
			}
		}
		Arrays.sort(s);
		return s[s.length-1];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size=scan.nextInt();
		int array[]=new int[size];
		for(int count=0;count<size;count++){
			array[count]=scan.nextInt();
		}
		int ans=longestNonDecreasingSequence(array);
		System.out.println(ans);
		scan.close();
	}

}
