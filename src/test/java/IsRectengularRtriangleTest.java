import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class IsRectengularRtriangleTest {

	private final Rtriangle mockRtriangle(int x1, int y1, int x2, int y2,
			int x3, int y3) {
		Rtriangle triangle = mock(Rtriangle.class);
		when(triangle.getApexX1()).thenReturn(x1);
		when(triangle.getApexY1()).thenReturn(y1);
		when(triangle.getApexX2()).thenReturn(x2);
		when(triangle.getApexY2()).thenReturn(y2);
		when(triangle.getApexX3()).thenReturn(x3);
		when(triangle.getApexY3()).thenReturn(y3);
		return triangle;
	}

	@Test
	public final void testIsRectangularWhenBasisTriangle() {
		Rtriangle triangle = mockRtriangle(0, 0, 0, 1, 1, 0);
		assertTrue(RtriangleProviderTest.isRectangular(triangle));
	}

	@Test
	public final void testIsRectangular() {
		Rtriangle triangle = mockRtriangle(-3, -2, 0, -1, -2, 5);
		assertTrue(RtriangleProviderTest.isRectangular(triangle));
	}

	@Test
	public final void testIsRectangularWhenBigTriangle() {
		Rtriangle triangle = mockRtriangle(-Integer.MAX_VALUE, -1,
				Integer.MAX_VALUE, 1, Integer.MAX_VALUE, -1);
		assertTrue(RtriangleProviderTest.isRectangular(triangle));
	}

	@Test
	public final void testIsNotRectangular() {
		Rtriangle triangle = mockRtriangle(-1, 0, 0, 1, 2, 0);
		assertFalse(RtriangleProviderTest.isRectangular(triangle));
	}

	@Test
	public final void testIsNotRectangularWhenDegenerateTriangle() {
		Rtriangle triangle = mockRtriangle(1, 1, 1,	1, 2, 3);
		assertFalse(RtriangleProviderTest.isRectangular(triangle));
	}
}
