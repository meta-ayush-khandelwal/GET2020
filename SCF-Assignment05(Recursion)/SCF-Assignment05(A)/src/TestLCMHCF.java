import org.junit.Test;
import static org.junit.Assert.*;
public class TestLCMHCF {
	@Test
public void testLCM(){
	int ans=LCMHCF.lcm(5, 10);
	assertEquals(10, ans);
}
	@Test
public void testHCF(){
		int ans=LCMHCF.hcf(5, 10);
		assertEquals(5, ans);
}
}
