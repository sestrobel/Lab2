package pokerBase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokerEnums.eRank;
import pokerEnums.eSuit;

public class CardTest {
	static Card x;

	// create var
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		x = new Card(eSuit.CLUBS, eRank.JACK, 10); // Need 10 to define card but
													// test not necessary
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		assertEquals(x.geteSuit(), eSuit.CLUBS);
	}

	@Test
	public void test2() {
		assertFalse2(x.geteSuit(), eSuit.HEARTS);
	}

	private void assertFalse2(eSuit geteSuit, eSuit hearts) {
	}

	@Test
	public void test3() {
		assertFalse3(x.geteSuit(), eSuit.CLUBS);
	}

	private void assertFalse3(eSuit geteSuit, eSuit clubs) {
	}

	@Test
	public void test4() {
		assertFalse4(x.geteSuit(), eSuit.SPADES);
	}

	private void assertFalse4(eSuit geteSuit, eSuit spades) {
	}

	// TESTING RANK NOW

	@Test
	public void test5() {
		assertEquals(x.geteRank(), eRank.JACK);
	}

	@Test
	public void test6() {
		assertFalse6(x.geteRank(), eRank.QUEEN);
	}

	private void assertFalse6(eRank geteRank, eRank queen) {
	}

	@Test
	public void test7() {
		assertFalse7(x.geteRank(), eRank.KING);
	}

	private void assertFalse7(eRank geteRank, eRank king) {
	}

	@Test
	public void test8() {
		assertFalse8(x.geteRank(), eRank.ACE);
	}

	private void assertFalse8(eRank geteRank, eRank ace) {
	}

	@Test
	public void test9() {
		assertFalse9(x.geteRank(), eRank.TWO);
	}

	private void assertFalse9(eRank geteRank, eRank two) {
	}

	@Test
	public void test10() {
		assertFalse10(x.geteRank(), eRank.THREE);
	}

	private void assertFalse10(eRank geteRank, eRank three) {
	}

	@Test
	public void test11() {
		assertFalse11(x.geteRank(), eRank.FOUR);
	}

	private void assertFalse11(eRank geteRank, eRank four) {
	}

	@Test
	public void test12() {
		assertFalse12(x.geteRank(), eRank.FIVE);
	}

	private void assertFalse12(eRank geteRank, eRank five) {
	}

	@Test
	public void test13() {
		assertFalse13(x.geteRank(), eRank.SIX);
	}

	private void assertFalse13(eRank geteRank, eRank six) {
	}

	@Test
	public void test14() {
		assertFalse14(x.geteRank(), eRank.SEVEN);
	}

	private void assertFalse14(eRank geteRank, eRank seven) {
	}

	@Test
	public void test15() {
		assertFalse15(x.geteRank(), eRank.EIGHT);
	}

	private void assertFalse15(eRank geteRank, eRank eight) {
	}

	@Test
	public void test16() {
		assertFalse16(x.geteRank(), eRank.NINE);
	}

	private void assertFalse16(eRank geteRank, eRank nine) {
	}

	@Test
	public void test17() {
		assertFalse17(x.geteRank(), eRank.TEN);
	}

	private void assertFalse17(eRank geteRank, eRank ten) {
	}

}
