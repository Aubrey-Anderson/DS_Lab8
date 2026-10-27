import static org.junit.jupiter.api.Assertions.*;
import java.util.Comparator;
import org.junit.jupiter.api.Test;


class PriorityQueueTest
{

	@Test
	void testPriorityQueue()
	{
		Comparator<Customer> w = new Customer.WorthComparator();
		Queue<Customer> W = new PriorityQueue<Customer>(w);
		
		//int netWorth,int yearsWithCompany,int politeness
		Customer A = new Customer(3, 6, 2);
		Customer B = new Customer(3, 5, 1);
		Customer C = new Customer(5, 5, 3);
		Customer D = new Customer(2, 2, 0);
		Customer E = new Customer(4, 4, 2);
		
		W.push(A);
		W.push(B);
		W.push(C);
		W.push(D);
		W.push(E);
		
		assertEquals(C, W.pop());
		assertEquals(E, W.pop());
		assertEquals(A, W.pop());
		assertEquals(B, W.pop());
		assertEquals(D, W.pop());
		
		Comparator<Customer> l = new Customer.LoyaltyComparator();
		Comparator<Customer> p = new Customer.WorthPoliteComparator();
		
		assertTrue(l.compare(A, B) > 0);
		assertTrue(l.compare(B, C) == 0);
		assertTrue(l.compare(C, D) > 0);
		
		assertTrue(p.compare(A, B) > 0);
		assertTrue(p.compare(B, A) < 0);
		assertTrue(p.compare(D,C) < 0);
		

		
		
	}

}
