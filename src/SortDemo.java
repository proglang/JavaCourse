import java.util.ArrayList;
import java.util.Collections;


public class SortDemo {

	public static <X extends Comparable<X>> X getMin(ArrayList<X> inp) {
		X el = inp.get(0);
		for (int i=1; i<inp.size(); i++) {
			if (inp.get(i).compareTo(el) < 0) {
				el = inp.get(i);
			}
		}
		return el;
	}
	
	public static <X extends Comparable<X>> ArrayList<X> sort(ArrayList<X> inp) {
		// Platz machen für das Ergebnis
		ArrayList<X> res = new ArrayList<X>();
		// Falls noch Elemente im Argument vorhanden sind...
		while (inp.size() > 0) {
			// Berechne das Minimum
			X el = getMin(inp);
			// Füge das Minimum zum Ergebnis hinzu
			res.add(el);
			// Entferne es aus dem Argument
			inp.remove(el);
		}
		return res;
	}
	
	public static void main(String[] arg) {
		ArrayList<Integer> t = new ArrayList<Integer>();
		Collections.addAll(t, 5,3,6,4,7,5,8,6);
		System.out.println(t);
		ArrayList<Integer> r = sort(t);
		System.out.println(r);
	}
}
