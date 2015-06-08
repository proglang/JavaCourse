package lecture20150608;

public interface IList<X> extends Iterable<X> {
	boolean empty();
	X getElement();
	IList<X> getRest();
}
