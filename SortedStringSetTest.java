/**
  * A unit test for SortedSet
  *
  * @author Rick Mercer and Omar R. Gebril
  */
import static org.junit.Assert.*;
import org.junit.Test;

public class SortedStringSetTest {

  @Test
  public void testGettersWhenEmpty() {
    SortedStringSet names = new SortedStringSet(10);
    assertTrue(names.isEmpty());
    assertEquals(0, names.size());
    assertEquals("[]", names.toString());
  }

  @Test
  public void testToString() {
    SortedStringSet names = new SortedStringSet(10);
    assertEquals("[]", names.toString());
    assertTrue(names.insertInOrder("Kim"));
    assertEquals("[Kim]", names.toString());
    assertTrue(names.insertInOrder("Chris"));
    assertEquals("[Chris, Kim]", names.toString());
    assertTrue(names.insertInOrder("Devon"));
    assertEquals("[Chris, Devon, Kim]", names.toString());
    assertTrue(names.insertInOrder("Ali"));
    assertEquals("[Ali, Chris, Devon, Kim]", names.toString());
  }

  @Test
  public void testToString2() {
    SortedStringSet names = new SortedStringSet(2);
    assertEquals("[]", names.toString());
    assertTrue(names.insertInOrder("Yo"));
    assertEquals("[Yo]", names.toString());
    assertTrue(names.insertInOrder("Trousers"));
    assertEquals("[Trousers, Yo]", names.toString());
    assertTrue(names.insertInOrder("Brownies"));
    assertEquals("[Brownies, Trousers, Yo]", names.toString());
    assertFalse(names.isEmpty());
    assertFalse(names.insertInOrder("Brownies"));
    assertTrue(names.contains("Yo"));
    assertFalse(names.contains("Yoooo"));
    assertEquals("[Brownies, Trousers, Yo]", names.toString());
  }

  @Test
  public void testToString3() {
    SortedStringSet names = new SortedStringSet(0);
    assertEquals("[]", names.toString());
    assertTrue(names.insertInOrder("Egypt"));
    assertEquals("[Egypt]", names.toString());
    assertTrue(names.insertInOrder("Will"));
    assertEquals("[Egypt, Will]", names.toString());
    assertTrue(names.insertInOrder("Win"));
    assertEquals("[Egypt, Will, Win]", names.toString());
    assertTrue(names.remove("Egypt"));
    assertTrue(names.insertInOrder("Mexico"));
    assertEquals("[Mexico, Will, Win]", names.toString());
    assertFalse(names.remove("Wizzzz"));
  }

  @Test
  public void testToString4() {
    SortedStringSet names = new SortedStringSet(0);
    assertEquals("[]", names.toString());
    assertTrue(names.insertInOrder("Beauty"));
    assertEquals("[Beauty]", names.toString());
    assertTrue(names.insertInOrder("Will"));
    assertEquals("[Beauty, Will]", names.toString());
    assertTrue(names.insertInOrder("Prevail"));
    assertTrue(names.insertInOrder("Definitely"));
    assertEquals("[Beauty, Definitely, Prevail, Will]", names.toString());

    SortedStringSet B = new SortedStringSet(0);
    assertEquals("[]", B.toString());
    assertTrue(B.insertInOrder("Beauty"));
    assertEquals("[Beauty]", B.toString());
    assertTrue(B.insertInOrder("Will"));
    assertEquals("[Beauty, Will]", B.toString());
    assertTrue(B.insertInOrder("Succeed"));
    assertTrue(B.insertInOrder("Carbon"));
    assertEquals("[Beauty, Carbon, Succeed, Will]", B.toString());
    
    assertEquals("[Beauty, Carbon, Definitely, Prevail, Succeed, Will]",names.union(B).toString());
  }
}
