import org.junit.Test;

import static org.junit.Assert.*;

public class TestArea {

@Test
public void testAreaOfTriangle(){
	double ans=Area.areaOfTriangle(13.5986,24.6879);
	assertEquals(167.86, ans,0.009);
}

@Test
public void testAreaOfRectangle(){
	double ans=Area.areaOfRectangle(20,25);
	assertEquals(500.00, ans,0.009);
}

@Test
public void testAreaOfSquare(){
	double ans=Area.areaOfSquare(25);
	assertEquals(625.00, ans,0.009);
}

@Test
public void testAreaOfCircle(){
	double ans=Area.areaOfCircle(7);
	assertEquals(154.00, ans,0.009);
}

@Test
public void negativeTestAreaOfTriangle(){
	double ans=Area.areaOfTriangle(13.5986,24.6879);
	assertNotEquals(166.86, ans,0.009);
}

@Test
public void negativeTestAreaOfRectangle(){
	double ans=Area.areaOfRectangle(20,25);
	assertNotEquals(400.00, ans,0.009);
}

@Test
public void negativeTestAreaOfSquare(){
	double ans=Area.areaOfSquare(25);
	assertNotEquals(620.00, ans,0.009);
}

@Test
public void negativeTestAreaOfCircle(){
	double ans=Area.areaOfCircle(7);
	assertNotEquals(156.00, ans,0.009);
}
}
