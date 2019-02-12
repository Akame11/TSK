package tsk2019cv1.sd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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
	
	@DisplayName("Test neplatnych hodnot")
	@ParameterizedTest
	@MethodSource("edgeProvider")
	public void equalEdges(int a, int b, int c)
    {
        assertEquals(false, app.isTriangle(a, b, c));
    }
	
	
	static Stream<Integer[]> edgeProvider() {
		return Stream.of(new Integer[] {1,2,3}, new Integer[] {0,0,0});
	}
	/*@Test
    public void equalEdges()
    {
        assertEquals(false, app.isTriangle(0, 1, 3));
    }*/
}
