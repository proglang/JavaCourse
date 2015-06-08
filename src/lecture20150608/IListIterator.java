package lecture20150608;

import java.util.Iterator;

public class IListIterator<E> implements Iterator<E> {
	// immutable wrapper
	private IList<E> list;

	public IListIterator(IList<E> list) {
		this.list = list;
	}

	@Override
	public boolean hasNext() {
		return !list.empty();
	}

	@Override
	public E next() {
		if (list.empty()) {
			throw new IllegalStateException("next on empty iteration");
		}
		E elem = list.getElement();
		list = list.getRest();
		return elem;
	}

}
