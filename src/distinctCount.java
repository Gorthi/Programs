import java.util.Scanner;

/**Given a sorted array of integers, return the number of distinct absolute values among the elements of the array. 
 * The input can contain duplicates values.
 */

/** unordered_set<int> s;
 
    // Note that set keeps only one copy even if we try to insert multiple values
    for (int i = 0 ; i < n; i++)
        s.insert(abs(arr[i]));
 
    return s.size();
 */
public class distinctCount {

	/**We initialize the count of distinct elements to number of elements in the array. We start with two index variables 
	 * from two corners of the array and check for pair in the input array with sum as 0. If pair with 0 sum is found or 
	 * duplicates are encountered, we decrement the count of distinct elements.Finally we return the updated count.
	 */
	
	public static int countDistinctElements(int array[]){
		int count=array.length;
		int diff=0;
		for(int head=0,tail=array.length-1;head<tail;){
			
			// Remove duplicate elements from the
	        // left of the current window (i, j)
	        // and also decrease the count
			while(head!=tail && array[head]==array[head+1]){
				head++;
				count--;
			}
			
			// Remove duplicate elements from the
	        // right of the current window (i, j)
	        // and also decrease the count
			while(head!=tail && array[tail]==array[tail-1]){
				tail--;
				count--;
			}
			
			// break if only one element is left
			if(head==tail)
				break;
			
			diff=array[head]+array[tail];
			if(diff==0){
				count--;
				head++;
				tail--;
			}
			else if(diff>0){
				tail--;
			}
			else if(diff<0){
				head++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int size=scan.nextInt();
		int array[]=new int[size];
		for(int count=0;count<size;count++){
			array[count]=scan.nextInt();
		}
		int ans=countDistinctElements(array);
		System.out.println(ans);
		scan.close();

	}

}
