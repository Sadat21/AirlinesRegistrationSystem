/**
 * @author brain
 * @version 1.0
 * @since 3/22/2017
 */
public class Node
{
	public String ID, FN, LN, Address, PC, PN, CT;

	public Node(String ID, String FN, String LN, String Address, String PC, String PN, String CT)
	{
		this.ID = ID;
		this.FN = FN;
		this.LN = LN;
		this.Address = Address;
		this.PC = PC;
		this.PN = PN;
		this.CT = CT;
	}

	@Override
	public String toString()
	{
		return (ID + " " + FN + " " + LN + " " + Address + " " + PC + " " + PN + " " + CT);
	}
}
