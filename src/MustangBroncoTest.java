/* 
 * @author Anh-Minh Tai Nguyen
 * This is the junit test to verify if the getValue method produce the correct output.
 * This also test edge cases such as if the number is 0 or negative.
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class MustangBroncoTest {

	@Test
	public void test1() {
		assertEquals("Mustang", GUI.getValue(3));
	}

	@Test
	public void test2() {
		assertEquals("Bronco", GUI.getValue(5));
	}

	@Test
	public void test3() {
		assertEquals("MustangBronco", GUI.getValue(15));
	}

	@Test
	public void test4() {
		assertEquals("1", GUI.getValue(1));
	}

	@Test
	public void test5() {
		assertEquals("MustangBronco", GUI.getValue(0));
	}

	@Test
	public void test6() {
		assertEquals("Mustang", GUI.getValue(-9));
	}

}
