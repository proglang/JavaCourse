package lecture20150601;

public class NilInt implements IListInt {

	@Override
	public int length() {
		return 0;
	}

	@Override
	public int sum() {
		return 0;
	}

	@Override
	public IListInt append(IListInt other) {
		return other;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}


}
