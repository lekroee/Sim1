/* Simulates a physical device that performs (signed) addition on
 * a 32-bit input.
 *
 * Author: TODO
 */

public class Sim1_ADD
{
	public void execute()
	{
		xor.a.set(a[0].get());
		xor.b.set(b[0].get());
		xor.execute();
		sum[0].set(xor.out.get());
		and.a.set(a[0].get());
		and.b.set(b[0].get());
		and.execute();
		boolean carryIn = and.out.get();
		for(int i = 1; i < 32; i++) {
			if(a[i].get() != b[i].get()) {
				if(carryIn) {
					sum[i].set(false);
				} else {
					sum[i].set(true);
				}
			} else if(a[i].get() && b[i].get()) {
				if(carryIn) {
					sum[i].set(true);
				} else {
					sum[i].set(false);
					carryIn = true;
				}
			} else {
				if(carryIn) {
					sum[i].set(true);
					carryIn = false;
				} else {
					sum[i].set(false);
				}
			}
			
		}
		carryOut.set(carryIn);
		if(a[31].get() != b[31].get()) {
			overflow.set(false);
		} else if (a[31].get() != sum[31].get()) {
			overflow.set(true);
		}
	}



	// ------ 
	// It should not be necessary to change anything below this line,
	// although I'm not making a formal requirement that you cannot.
	// ------ 

	// inputs
	public RussWire[] a,b;
	public Sim1_AND and;
	private Sim1_XOR xor;

	// outputs
	public RussWire[] sum;
	public RussWire   carryOut, overflow;

	public Sim1_ADD()
	{
		/* Instructor's Note:
		 *
		 * In Java, to allocate an array of objects, you need two
		 * steps: you first allocate the array (which is full of null
		 * references), and then a loop which allocates a whole bunch
		 * of individual objects (one at a time), and stores those
		 * objects into the slots of the array.
		 */

		a   = new RussWire[32];
		b   = new RussWire[32];
		xor = new Sim1_XOR();
		and = new Sim1_AND();
		sum = new RussWire[32];

		for (int i=0; i<32; i++)
		{
			a  [i] = new RussWire();
			b  [i] = new RussWire();
			sum[i] = new RussWire();
		}

		carryOut = new RussWire();
		overflow = new RussWire();
	}
}

