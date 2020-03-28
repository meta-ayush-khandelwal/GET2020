package Question2;

import static org.junit.Assert.*;
import org.junit.Test;

public class NumberOfUniqueCharacterTestCase {

	
	@Test
	public void test_countsNmberOfUniqueCharacters_withString_shouldReturn_5()
	{
		 NumberOfUniqueCharacter uniqueCharacter = new  NumberOfUniqueCharacter();
		assertEquals(5,uniqueCharacter.countsNmberOfUniqueCharacters("Ayush"));
	}
	@Test
	public void test_countsNmberOfUniqueCharacters_withString_shouldReturn_3()
	{
		 NumberOfUniqueCharacter uniqueCharacter = new NumberOfUniqueCharacter();
		assertEquals(3,uniqueCharacter.countsNmberOfUniqueCharacters("HELLO"));
	}
	
	@Test
	public void test_countsNmberOfUniqueCharacters_withString_shouldReturn_1()
	{
		 NumberOfUniqueCharacter uniqueCharacter = new NumberOfUniqueCharacter();
		assertEquals(1,uniqueCharacter.countsNmberOfUniqueCharacters("AaaaAmmM"));
	}
	
	@Test
	public void test_countsNmberOfUniqueCharacters_withNull_shouldReturn_0()
	{
		 NumberOfUniqueCharacter uniqueCharacter = new NumberOfUniqueCharacter();
		assertEquals(0,uniqueCharacter.countsNmberOfUniqueCharacters(""));
	}
	
	@Test
    public void negativeTest_countsNmberOfUniqueCharacters_withNull_shouldReturn_1()
    {
         NumberOfUniqueCharacter uniqueCharacter = new NumberOfUniqueCharacter();
        assertNotEquals(1,uniqueCharacter.countsNmberOfUniqueCharacters("ZzzzZ@Zzzz!"));
    }

}
