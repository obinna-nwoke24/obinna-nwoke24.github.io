package Project1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserCheckoutListTest {
	UserCheckoutList ucl;

	@BeforeEach
	void setUp() throws Exception {
		ucl = new UserCheckoutList();
	}

	@Test
	void testAddBookToList() {
		ucl.addBookToList(new Book("Book 1", "001"));
		ucl.addBookToList(new Book("Book 2", "002"));
		String cnum1 = ucl.get(0).getCallNum();
		String cnum2 = ucl.get(1).getCallNum();
		
		//no failures because the book with a Call Number 001 was added
		assertEquals("001", cnum1);
		
		//no failures because the book with a Call Number 002 was added
		assertEquals("002", cnum2);
	}

	@Test
	void testSize() {
		Book b1 = new Book("Book 1", "000");
		Book b2 = new Book("Book 2", "001");
		Book b3 = new Book("Book 3", "002");
		
		/*
		 * no failures because the default size of the array list is 0
		 */
		int size1 = ucl.size();
		assertEquals(0, size1);
		
		/*
		 * no failures because adding the 3 books to the list
		 * then getting the size should have an actual integer of 3
		 */
		ucl.addBookToList(b1);
		ucl.addBookToList(b2);
		ucl.addBookToList(b3);
		int size2 = ucl.size();
		assertEquals(3, size2);
		
	}

	@Test
	void testGet() {
		ucl.addBookToList(new Book("Book 1", "000"));
		ucl.addBookToList(new Book("Book 2", "001"));
		ucl.addBookToList(new Book("Book 3", "002"));
		int pos1 = 0;
		int pos2 = 1;
		int pos3 = 2;
		String cnum1 = ucl.get(pos1).getCallNum();
		String title2 = ucl.get(pos2).getTitle();
		String cnum3 = ucl.get(pos3).getCallNum();
		
		//no failures because the Call Number at the 0 index is 000 for the first book
		assertEquals("000", cnum1);
		//no failures because the Book Title at the 1 index is Book 2 for the second book
		assertEquals("Book 2", title2);
		//no failures because the Call Number at the 2 index is 002 for the third book
		assertEquals("002", cnum3);
		
	}

	@Test
	void testRemoveBookFromList() {
		ucl.addBookToList(new Book("Book 1", "001"));
		ucl.addBookToList(new Book("Book 2", "002"));
		String cnum1 = ucl.get(0).getCallNum();
		
		/*
		 * No failure because we expect the Call Number at the 0 index
		 * to be 001 because Book 1 was not removed yet 
		 */
		assertEquals("001", cnum1);
		
		ucl.removeBookFromList(cnum1);
		String cnum2 = ucl.get(0).getCallNum();
		
		/*
		 * Still no failure because we expect the new Call Number at the 0 index
		 * to be 002 because Book 1 was removed
		 */
		assertEquals("002", cnum2);
	}

}
