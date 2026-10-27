public class Queue<T>
{
    //be sure that your attributes are protected, so subclasses can use them
	protected Node head;
	protected Node tail;
	
	public class Node{
		T val;
		Node next;
		public Node(T val, Node next) {
			this.val = val;
			this.next = next;
		}
	}

   public Queue()
   {
	   head = null;
	   tail = null;
   }


    /**Adds val to the end of the queue
     */
   public void push(T val)
   {
	   Node add = new Node(val, null);
	   if(head == null) {
		   tail = add;
		   head = add;
	   }else {
		   tail.next = add;
		   tail = add;
	   }
	 
   }


    /**
       removes and returns the oldest value in the queue
       throws QueueUnderFlowException if the queue is empty
     */
   public T pop()
   {
       if(head == null) {
    	   throw new QueueUnderFlowException();
       }
       Node removed = head;
       head = head.next;
       return removed.val;
       
       
   }    


    /**
      returns true if the queue is empty
     */

   public boolean isEmpty()
   {
       return head == null;
   }




}
