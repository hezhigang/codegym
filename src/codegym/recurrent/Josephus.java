/**
 * Josephus problem
 */
package codegym.recurrent;

import java.util.ArrayList;

/**
 * @author hezhigang
 *
 */
public class Josephus {
	
	static class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
		}
	}
	
	/**
	 * Josephus Circle using circular linked list
	 * @param m
	 * @param n
	 */
	private static void getJosephusPosition(int m, int n) {
		Node head = new Node(1);
		Node prev = head;
		for (int i = 2; i <= n; i++) {
			prev.next = new Node(i);
			prev = prev.next;
		}

		prev.next = head;

		Node ptr1 = head, ptr2 = head;

		while (ptr1.next != ptr1) {
			int count = 1;
			while (count != m) {
				ptr2 = ptr1;
				ptr1 = ptr1.next;
				count++;
			}

			ptr2.next = ptr1.next;
			ptr1 = ptr2.next;
		}
		System.out.printf("Last person left standing (Josephus Position) is %d \n", ptr1.data);
	}
	
	/**
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	private static int josephus(int n, int k) {
		if (n == 1)
			return 1;
		else
			return (josephus(n - 1, k) + k - 1) % n + 1;
	}
	
	/**
	 * https://rosettacode.org/wiki/Josephus_problem#Java
	 * @param n
	 * @param k
	 * @return
	 */
    public static int execute(int n, int k){
        int killIdx = 0;
        ArrayList<Integer> prisoners = new ArrayList<Integer>(n);
        for(int i = 0;i < n;i++){
            prisoners.add(i);
        }
        System.out.println("Prisoners executed in order:");
        while(prisoners.size() > 1){
            killIdx = (killIdx + k - 1) % prisoners.size();
            System.out.print(prisoners.get(killIdx) + " ");
            prisoners.remove(killIdx);
        }
        System.out.println();
        return prisoners.get(0);
    }
    
    /**
     * https://rosettacode.org/wiki/Josephus_problem#Java
     * @param n
     * @param k
     * @param m
     * @return
     */
    public static ArrayList<Integer> executeAllButM(int n, int k, int m){
        int killIdx = 0;
        ArrayList<Integer> prisoners = new ArrayList<Integer>(n);
        for(int i = 0;i < n;i++){
            prisoners.add(i);
        }
        System.out.println("Prisoners executed in order:");
        while(prisoners.size() > m){
            killIdx = (killIdx + k - 1) % prisoners.size();
            System.out.print(prisoners.get(killIdx) + " ");
            prisoners.remove(killIdx);
        }
        System.out.println();
        return prisoners;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 14;
		int k = 2;
		getJosephusPosition(k, n);
		System.out.println();
		System.out.printf("The chosen place is %d \n", josephus(n, k));
		System.out.println();
		System.out.println("Survivor: " + execute(41, 3));
		System.out.println();
        System.out.println("Survivors: " + executeAllButM(41, 3, 3)); 
	}

}