package lecture20150511;

public class Axe implements IWeapon {
	/**
	 * magic axe is bad for zombie!!!
	 */
	private boolean magic;

	public Axe(boolean magic) {
		this.magic = magic;
	}
	
	// bad example:
	// this defines a new method that has nothing to do with
	// Object.equals(Object)
	public boolean equals(Axe other) {
		System.out.println("in equals(Axe)");
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (magic ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		// this yields only one direction
		if (!(obj instanceof Axe))
			return false;
		// here, obj may still belong to a subclass of Axe
		if (this.getClass() != obj.getClass())
			return false;
		Axe other = (Axe) obj;
		// compare fields
		if (this.magic != other.magic)
			return false;
		return true;
	}
	
}
