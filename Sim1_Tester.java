import static org.junit.Assert.*;

import org.junit.Test;

public class Sim1_Tester {

	@Test
	public void testSim1_AND() {
		Sim1_AND tester = new Sim1_AND();
		tester.a.set(false);
		tester.b.set(false);
		tester.execute();
		assertEquals(false, tester.out.get());
	}
	
	@Test
	public void testSim1_XOR() {
		Sim1_XOR tester = new Sim1_XOR();
		tester.a.set(true);
		tester.b.set(false);
		tester.execute();
		assertEquals(true, tester.out.get());
	}

}
