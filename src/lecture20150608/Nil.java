package lecture20150608;

import java.util.Iterator;

public class Nil<X> implements IList<X> {

	@Override
	public Iterator<X> iterator() {
		return new IListIterator<X>(this);
	}

	@Override
	public boolean empty() {
		return true;
	}

	@Override
	public X getElement() {
		return null;
	}

	@Override
	public IList<X> getRest() {
		return null;
	}

}
