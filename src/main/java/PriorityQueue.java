import java.util.Comparator;

public class PriorityQueue<T> extends Queue<T>
{

   Comparator<T> compare;

   public PriorityQueue(Comparator<T> comp)
   {
      compare = comp;
      head = null;
      tail = null;
   }

    //@Override
   public void push(T val)
   {
	   if(head == null) {
		   head = new Node(val, null);
		   tail = head;
	   }else if(compare.compare(val, head.val) > 0) 
       {
    	   head = new Node(val, head);
       }else if(head.next == null) {
		   head.next = new Node(val, null);
		   tail = head.next;
	   }else if(compare.compare(val, tail.val) < 0)
       {
    	   tail.next = new Node(val, null);
    	   tail = tail.next;
       }else 
       {
    	   findPlace(val, head);
       }
   }

   public void findPlace(T val, Node current)
   {
	   if(compare.compare(val, current.next.val) < 0)
	   {
		   findPlace(val, current.next);
	   }else
	   {
		   current.next = new Node(val, current.next);
	   }
   }

}
