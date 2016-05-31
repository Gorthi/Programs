import java.util.Arrays;

public class FlowerGarden {
	
	public static int[] getOrder(int[] h, int[] b, int[] w){
		int res[] = new int[h.length];
		boolean used[] = new boolean[h.length];
		int maxHeight=0;
		int r = -1;
		Arrays.fill(used, false);
		for(int i=0;i<h.length;i++){
			
			maxHeight=0;
			int pos=-1;
			if(used[i]==true)
				continue;
			
			for(int j=0;j<h.length;j++){
				if(used[j]==true)
					continue;
				boolean found=true;
				
				for(int k=0;k<h.length;k++){
					if(used[k]==true)
						continue;
					boolean block = !(w[j]<b[k] || b[j]>w[k]);
					if(h[j]>h[k] && block){
						found=false;
						break;
					}
				}
				if(found && maxHeight<h[j]){
					pos=j;
					maxHeight=h[j];
					
				}
				
			}
			r++;
			used[pos]=true;
			res[r]=h[pos];
			
		}
		for (int i=r+1;i<h.length;i++){
			for(int j=0;j<h.length;j++){
				if(used[j]!=true){
					used[j]=true;
					res[i]=h[j];
					break;
				}
			}
		}
		/*for(int j=0;j<h.length;j++){
			System.out.print(used[j]+" ");
		}*/
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int h[]={1,2,3,4,5,6};
		int b[]={1,3,1,3,1,3};
		int w[]={2,4,2,4,2,4};
		int order[] = getOrder(h,b,w);
		for(int i=0;i<order.length;i++){
			System.out.print(order[i]+" ");
		}
	}

}
