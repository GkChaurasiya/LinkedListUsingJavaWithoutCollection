import java.io.*;
import java.util.*;

class LinkedList
{
	Node head=null;
	static class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data=data;
			this.next=null;
		}
	}
	public static void Insert(LinkedList list,int data)
	{
		Node newNode=new Node(data);
		if(list.head==null)
			list.head=newNode;
		else
		{
			Node ItrNode=list.head;
			while(ItrNode.next!=null)
			{
				ItrNode=ItrNode.next;
			}
			ItrNode.next=newNode;
			
		}
			System.out.println("Node inserted into the list");
		
	}
	public static void displayList(LinkedList list)
	{
		System.out.println("OUTPUT:");

		Node ItrNode=list.head;
		if(ItrNode==null)	
			System.out.println("List is empty!!");
		else
		{
			while(ItrNode.next!=null)
			{
				System.out.print("| "+ItrNode.data+" |---->");
				ItrNode=ItrNode.next;
			}
				System.out.print("| "+ItrNode.data+" |---->NULL");
		}
	}
	public static void InsertFront(LinkedList list,int data)
	{
		Node newNode=new Node(data);
		if(list.head==null)
		{
			System.out.println("List was empty so, element inserted as head");
			list.head=newNode;
		}
		else
		{
			newNode.next=list.head;
			list.head=newNode;
			System.out.println("Node Inserted at the front of the list");
		}
		
	}
	public static void InsertBetween(LinkedList list,int data, int position)
	{
		Node newNode=new Node(data);
		if(list.head==null)
			System.out.println("List is empty");
		else
		{
			Node ItrNode=list.head;
			int NodeCount=1;
			Node FrontOfNewNode=null;
			Node BackOfNewNode=null;
			while(ItrNode.next!=null)
			{
				NodeCount++;
				if(NodeCount==position)
				{
					FrontOfNewNode=ItrNode; 
					BackOfNewNode=ItrNode.next;	
					break;
				}
				
				ItrNode=ItrNode.next;
			}
			if(ItrNode.next==null)
				LinkedList.Insert(list,data);
			else
			{
				FrontOfNewNode.next=newNode;
				newNode.next=BackOfNewNode;
				System.out.println("Node is inserted between "+FrontOfNewNode.data+" and "+BackOfNewNode.data);
			}
			
		}
		
	}
	public static void DeleteFront(LinkedList list)
	{

		Node front=list.head;
		if(front==null)
			System.out.println("List is empty!");
		else
		{
			front=front.next;
			list.head=front;
			System.out.println("Front Node removed");
		}
		
	}

	public static void DeleteEnd(LinkedList list)
	{

		
		if(list.head==null)
			System.out.println("List is empty!");
		else
		{
			Node ItrNode=list.head;
			Node Prev=null;
			while(ItrNode.next!=null)
			{
				Prev=ItrNode;
				ItrNode=ItrNode.next;
			}
			Prev.next=null;
			ItrNode=Prev;
			System.out.println("End Node removed");
		}
		
	}
	public static void DeleteBetween(LinkedList list,int position)
	{
		
		if(list.head==null)
			System.out.println("List is empty");
		else
		{
			Node ItrNode=list.head;
			int NodeCount=1;
			Node FrontOfNode=null;
			Node BackOfNode=null;
			while(ItrNode.next!=null)
			{
				
				 
				if(NodeCount==position-1)
				{
					FrontOfNode=ItrNode;
					BackOfNode=(ItrNode.next).next;	
					
					//System.out.println("FrontOfNode:"+FrontOfNode+"|BackOfNode:"+BackOfNode);
					break;
				}
				NodeCount++;
				ItrNode=ItrNode.next;
			}
			//System.out.println("checkpoint2:"+ItrNode.next+"|Position:"+position);
			if(ItrNode.next==null)
				System.out.println("Position of node not found!");
			else
			{
					if(BackOfNode==null)
					{
						FrontOfNode.next=null;
						System.out.println("Last Node of the list is deleted");
					}
					else
					{
						FrontOfNode.next=BackOfNode;
						System.out.println("Node between "+FrontOfNode.data+" and "+ BackOfNode.data+" is deleted");
					}
					
				
			}
			
		}
		
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);

		//Initializing the head
		LinkedList list=new LinkedList();
		int choice;
		do
		{
			System.out.println("\n\n");
			System.out.println("1. Insert a node");
			System.out.println("2. Display nodes");
			System.out.println("3. Insert a node at the front");
			System.out.println("4. Insert a node in between the list at a particular position");
			System.out.println("5. Delete node at the front");
			System.out.println("6. Delete node at the end");
			System.out.println("7. Delete node in between");
			System.out.println("0. Exit");
			System.out.println("Enter your choice:");
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:
						//Inserting the node
						System.out.println("Enter data for new Node to insert:");
						int data=sc.nextInt();
						LinkedList.Insert(list,data);
				break;

				case 2:
						//Displaying the list
						LinkedList.displayList(list);	
				break;

				case 3:
						//Insert at the front of the list
						System.out.println("\nEnter data for inserting at the front of linkedlist:");
						int dataFront=sc.nextInt();
						LinkedList.InsertFront(list,dataFront);
				break;

				case 4:
						//Insert in between the nodes
						System.out.println("\nEnter data for inserting in between the linkedlist:");
						int dataBetween=sc.nextInt();
						System.out.println("\nEnter the position of the node to be inserted:");
						int position=sc.nextInt();
						if(position>0)
						{
							if(position>1)
								LinkedList.InsertBetween(list,dataBetween,position);
							else
								LinkedList.InsertFront(list,dataBetween);
						}
						else
							System.out.println("Invalid position of the node");
				break;
				case 5:
						LinkedList.DeleteFront(list);
				break;
				case 6:
						LinkedList.DeleteEnd(list);
				break;
				case 7:
						System.out.println("\nEnter the position of the node to be Deleted:");
						int position_del=sc.nextInt();
						if(position_del>0)
						{
							if(position_del>1)
								LinkedList.DeleteBetween(list,position_del);
							else
								LinkedList.DeleteFront(list);
							
						}
						else
							System.out.println("Invalid position of the node");
				break;
				case 0:
				break;

				default:
						System.out.println("Invalid Choice!");
			}
		}while(choice!=0);
	}
}
