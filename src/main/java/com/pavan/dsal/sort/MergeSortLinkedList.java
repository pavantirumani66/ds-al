package com.pavan.dsal.sort;

class LinkedList {
	Node head;

	class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", next=" + next + "]";
		}
		
	}

	public void insert(int value) {
		Node new_node = new Node(value);
		if (head == null) {
			head = new_node;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new_node;
		}
	}

	public void show() {
		Node current = head;
		while (current != null) {
			System.out.print(current.value);
			current = current.next;
		}
		System.out.println();
	}

	public void sort() {
		head = mergeSort(head);
	}

	private Node mergeSort(Node node) {
		if(node==null||node.next==null)
			return node;
		Node middle = getMiddle(node);
		Node midNext = middle.next;
		middle.next = null;
		Node left = mergeSort(node);
		Node right = mergeSort(midNext);
		Node sortedList= merge(left, right);
		return sortedList;
	}

	private Node merge(Node left, Node right) {
		Node result =null ;
		if (left == null)
			return right;
		if (right == null)
			return left;
		if(left.value<=right.value) {
			result=left;
			result.next=merge(left.next,right);
		}else {
			result=right;
			result.next=merge(left,right.next);
		}
		return result;
	}

	private Node getMiddle(Node head) {
		if(head==null) 
			return head;
		Node slow = head;
		Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}

public class MergeSortLinkedList {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insert(5);
		ll.insert(4);
		ll.insert(3);
		ll.insert(7);
		ll.insert(8);
		ll.insert(9);
		ll.insert(1);
		ll.insert(1);
		ll.insert(2);
		ll.insert(6);
		
		ll.show();
		ll.sort();
		ll.show();
	}

}
