import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntersectingNode {
	List head;
	public static void main(String[] args) throws IOException{
		
		IntersectingNode ll = new IntersectingNode();
		IntersectingNode ll2 = new IntersectingNode();
		IntersectingNode list = new IntersectingNode();
		
		List node = new List(15);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num[] = br.readLine().split(" ");
		for (int i = 0; i < num.length; i++) {
			ll.head = ll.push(ll.head, Integer.parseInt(num[i]));
		}
		node.next = ll.head;
		ll.head.next = ll.push(ll.head, node);
		String n[] = br.readLine().split(" ");
		for (int i = 0; i < n.length; i++) {
			ll.head = ll.push(ll.head, Integer.parseInt(n[i]));
		}
		
		String num2[] = br.readLine().split(" ");
		for (int i = 0; i < num2.length; i++) {
			ll2.head = ll2.push(ll2.head, Integer.parseInt(num2[i]));
		}
		node.next = ll2.head;
		ll2.head.next = ll2.push(ll.head, node);
		String n2[] = br.readLine().split(" ");
		for (int i = 0; i < n2.length; i++) {
			ll2.head = ll2.push(ll2.head, Integer.parseInt(n2[i]));
		}
		//int number = Integer.parseInt(br.readLine());
		System.out.println("First list:");
		ll.printList(ll.head);
		System.out.println("\n");

		System.out.println("Second list:");
		ll2.printList(ll2.head);
		System.out.println("\n");
		
		list.findIntersectingNode(ll.head, ll2.head);

		//ll.printList(ll.head);
	}

	private List push(List head, List node) {
		node.next = head;
		head = node;
		return head;
	}

	private List push(List head, int value) {
		List newNode = new List(value);
		newNode.next = head;
		head = newNode;
		return head;
	}
	
	private void printList(List head) {
		List temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

	}
	
	private void findIntersectingNode(List head1,List head2){
		int count1 = countNodes(head1);
		int count2 = countNodes(head2);
		
		int distance = count1 - count2;
		if(distance>0){
			findNode(distance,head1,head2);
		} else {
			findNode(Math.abs(distance),head2,head1);
		}
	}
	
	private void findNode(int distance, List head1, List head2) {
		while(head1!=null && distance > 0){
			head1 = head1.next;
			distance--;
		}
		while(head1!=null && head2!=null){
			if(head1==head2){
				System.out.println(head1.data+" "+head2.data);
				break;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		
	}

	private int countNodes(List head){
		List temp = head;
		int count = 0;
		while(temp!=null){
			count++;
			temp = temp.next;
		}
		return count;
	}

}
