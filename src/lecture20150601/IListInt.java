package lecture20150601;

public interface IListInt {
	/**
	 * @return the length of the list
	 */
	int length();
	/**
	 * @return the sum of the list elements
	 */
	int sum();
	/**
	 * @param other
	 * @return the result of appending this list to the other.
	 */
	IListInt append(IListInt other);
}
