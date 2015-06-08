package lecture20150608;

import java.util.Iterator;

public class Cons<X> implements IList<X> {
	private final X element;
	private final IList<X> rest;

	public Cons(X element, IList<X> rest) {
		this.element = element;
		this.rest = rest;
	}

	@Override
	public Iterator<X> iterator() {
		return new IListIterator<X>(this);
	}

	@Override
	public boolean empty() {
		return false;
	}

	@Override
	public X getElement() {
		return this.element;
	}

	@Override
	public IList<X> getRest() {
		return this.rest;
	}

}
