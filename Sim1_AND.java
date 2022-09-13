/* Simulates a physical AND gate.
 *
 * Author: TODO
 */

public class Sim1_AND
{
	public void execute()
	{
		if(a.get() && b.get()) {
			out.set(true);
		}
		out.set(false);
	}



	public RussWire a,b;   // inputs
	public RussWire out;   // output

	public Sim1_AND()
	{
		a = new RussWire(); b = new RussWire(); out = new RussWire();
	}
}

