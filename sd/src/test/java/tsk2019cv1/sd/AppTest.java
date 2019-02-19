package tsk2019cv1.sd;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.stream.Stream;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

//@TestMethodOrder(OrderAnnotation.class)
public class AppTest 
{
	private static App app;

	@BeforeAll
	public static void init() {
		System.out.println("inti");
		app = new App();

	}
	
	@AfterAll
	public static void destroy() {
		System.out.println("destroy");
		app = null;
	}
	
	//@Order(2)
	@DisplayName("Test neplatnych hodnot")
	@ParameterizedTest(name="a= {0}, b= {1}, c= {2}")
	@MethodSource("edgeProvider")
	public void equalEdges(int a, int b, int c)
    {
        assertEquals(false, app.isTriangle(a, b, c));
    }
	
	
	static Stream<Arguments> edgeProvider() {
		return Stream.of(Arguments.of(1,2,3), Arguments.of(0,0,0), Arguments.of(2,1,1));
	}
	
	
	@RepeatedTest(5)
	//@Order(1)
	public void RTest(RepetitionInfo info) {
		assumeTrue(info.getCurrentRepetition()%2==0);
		fail("Sude neberu");
	}
	
	@Test
	public void testException() {
		String s = "2,6";
		try {			
			Double.parseDouble(s);
			fail("Vyjimka");
		}catch(NumberFormatException e){			
			//assertThat(e.getMessage(), Matchers.containsString("For input string"));
			assertThat(e.getMessage(), Matchers.anyOf(
					Matchers.containsString("For input string"),
					Matchers.containsString(s)
		        ));
			//assertTrue(e.getMessage().contains("For input string"));
		}
	}
	
	
	@Test
	public void testException2() {
		String s = "2.6"; //Je tu tecka proto neprojde
		assertThrows(NumberFormatException.class, () -> Double.parseDouble(s) ,"Nemelo projit");
	}
	
	
	
	/*@Test
    public void equalEdges()
    {
        assertEquals(false, app.isTriangle(0, 1, 3));
    }*/
}
