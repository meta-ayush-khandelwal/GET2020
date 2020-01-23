import org.junit.Test;
import static org.junit.Assert.*;
public class TestIntSet {
IntSet obj=new IntSet(new int[]{1,2,3,4,5});
@Test
public void testSize(){
	int res=obj.size();
	assertEquals(5, res);
}

@Test
public void testIsSubSet(){
	boolean res=obj.isSubSet(new IntSet(new int[]{7,8}));
	assertEquals(false, res);
}

@Test
public void testGetComplement(){
	int res[]=obj.getComplement();
	int check[]=new int[995];
	for(int i=0;i<995;i++){
		check[i]=i+6;
	}
	assertArrayEquals(check,res);
}

@Test
public void testUnion(){
	int res[]=obj.union(new IntSet(new int[]{1,2,3,4}),new IntSet(new int[]{4,5,6}));
	int check[]={1,2,3,4,5,6};
	assertArrayEquals(check,res);
}

@Test
public void testIsMember(){
	boolean res=obj.isMember(5);
	assertEquals(true, res);
}
}
