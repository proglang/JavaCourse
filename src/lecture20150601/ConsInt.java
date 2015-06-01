package lecture20150601;

public class ConsInt implements IListInt {
	private final int element;
	private final IListInt rest;
	public ConsInt(int element, IListInt rest) {
		if (rest == null) 
			throw new IllegalArgumentException("null not a valid rest list");
		this.element = element;
		this.rest = rest;
	}
	@Override
	public int length() {
		return 1 + rest.length();
	}
	@Override
	public int sum() {
		return this.element + rest.sum();
	}
	@Override
	public IListInt append(IListInt other) {
		return new ConsInt(element, rest.append(other));
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + element;
		result = prime * result + ((rest == null) ? 0 : rest.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsInt other = (ConsInt) obj;
		if (element != other.element)
			return false;
		if (rest == null) {
			if (other.rest != null)
				return false;
		} else if (!rest.equals(other.rest))
			return false;
		return true;
	}
	
}
