import static org.junit.Assert.*;
import org.junit.Test;

public class RtriangleProviderTest {

	private final static long scalar_mult(long x1, long y1, long x2, long y2) {
		return (x1 * x2 + y1 * y2);
	}

	public final static boolean isRectangular(Rtriangle triangle) {
		long a1 = triangle.getApexX2() - triangle.getApexX1();
		long a2 = triangle.getApexY2() - triangle.getApexY1();
		long b1 = triangle.getApexX3() - triangle.getApexX1();
		long b2 = triangle.getApexY3() - triangle.getApexY1();
		long c1 = triangle.getApexX3() - triangle.getApexX2();
		long c2 = triangle.getApexY3() - triangle.getApexY2();

		//Points lie on the same line
		if (b1 * c2 - c1 * b2 == 0) {
			return false;
		}
		
		return (scalar_mult(a1, a2, b1, b2) == 0)
				|| (scalar_mult(a1, a2, c1, c2) == 0)
				|| (scalar_mult(b1, b2, c1, c2) == 0);
	}

	@Test
	public final void testGetRtriangle() {
		assertTrue(isRectangular(RtriangleProvider.getRtriangle()));
	}
}
