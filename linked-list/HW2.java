
	class LinkedList
	{

		// Node structure containing power and coefficient of variable
		static class Node{
			double coefficient;
			int power;
			Node next;
			public Node(double coefficient, int power){
				this.coefficient = coefficient;
				this.power = power;
			}
		}

		//Function To Display The Linked list
		static void printList( Node ptr)
		{
			if (ptr == null)
			{
				System.out.println();
				return;
			}
			else if (ptr.next != null)
			{
				while (ptr.next != null)
				{
					System.out.print( ptr.coefficient + "x^" + ptr.power + " + ");
					ptr = ptr.next;
				}
			}
			System.out.println( ptr.coefficient + "x^" + ptr.power);
		}

		// Create a node and return
		static Node createNode(double coeff, int power)
		{
			return new Node(coeff, power);
		}

		// This function adds each node in descending order.
		static Node addnode(Node head, double coeff, int power)
		{
			Node newNode = createNode(coeff, power);
			if (head == null){
				head = newNode;
			}else if (head.power < power){
				newNode.next = head;
				head = newNode;
			}else{
				Node current = head;
				while (current.next != null){
					if(current.next.power < power){
						newNode.next = current.next;
						current.next = newNode;
						return head;
					}else{
						current = current.next;
					}
				}
				current.next = newNode;
			}
			return head;
		}

		static Node multiply(Node poly1, Node poly2){
			poly1 = sort_linklist(poly1);
			poly2 = sort_linklist(poly2);


			Node total = null;
			while(poly1 != null){
				Node current_mult = null;
				Node current_poly2 = poly2;
				double coefficient = poly1.coefficient;
				int	power = poly1.power;

				while (current_poly2 != null){
					current_mult = addnode(current_mult, coefficient*current_poly2.coefficient, power+current_poly2.power);
					current_poly2 = current_poly2.next;
				}
				total = add(total, current_mult);
				poly1 = poly1.next;
			}
			return total;
		}

		static Node add(Node poly1, Node poly2){
			poly1 = sort_linklist(poly1);
			poly2 = sort_linklist(poly2);
			if (poly1 == null && poly2 == null) return null;
			else if(poly1 == null) return poly2;
			else if(poly2 == null) return poly1;
			else{
				Node head = null;
				while(poly1 != null || poly2 != null){
					if (poly1 == null){
						head = addnode(head, poly2.coefficient, poly2.power);
						poly2 = poly2.next;
					}else if(poly2 == null){
						head = addnode(head, poly1.coefficient, poly1.power);
						poly1 = poly1.next;
					}else if (poly1.power > poly2.power){
						head = addnode(head, poly1.coefficient, poly1.power);
						poly1 = poly1.next;
					}else if (poly2.power > poly1.power){
						head = addnode(head, poly2.coefficient, poly2.power);
						poly2 = poly2.next;
					}else {
						head = addnode(head, poly1.coefficient + poly2.coefficient, poly1.power);
						poly1 = poly1.next;
						poly2 = poly2.next;
					}
				}
				return head;
			}
		}

		static Node sort_linklist(Node head){
			Node sorted_head = null;

			while(head != null){
				sorted_head = addnode(sorted_head, head.coefficient, head.power);
				head = head.next;
			}
			return sorted_head;

		}
	}
