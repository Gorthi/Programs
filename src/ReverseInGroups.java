import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class List {
	int data;
	List next;

	public List(int value) {
		data = value;
		next = null;
	}
}

public class ReverseInGroups {
	List head;

	public static void main(String[] args) throws IOException {
		ReverseInGroups ll = new ReverseInGroups();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num[] = br.readLine().split(" ");
		for (int i = 0; i < num.length; i++) {
			ll.head = ll.push(ll.head, Integer.parseInt(num[i]));
		}
		int number = Integer.parseInt(br.readLine());
		ll.printList(ll.head);
		System.out.println("\n");

		ll.head = ll.reverse(ll.head, number);

		ll.printList(ll.head);
	}

	private List push(List head, int value) {
		List newNode = new List(value);
		newNode.next = head;
		head = newNode;
		return head;
	}

	private List reverse(List head, int i) {
		List prev = null, next = null, current = head;
		int count = i;
		while (current != null && count > 0) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count--;
		}
		if (next != null) {
			head.next = reverse(next, i);
		}
		return prev;
	}

	private void printList(List head) {
		List temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

	}

}
