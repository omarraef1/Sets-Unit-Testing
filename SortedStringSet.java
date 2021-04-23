/**
 * A collection class that keeps unique String elements in their natural order
 *
 * @author Rick Mercer and Omar R. Gebril
 */
public class SortedStringSet {
	// Construct an empty set that can store any number of String elements
	// variable n to keep track of how many elements in bag.
	
	private String[] names;
	private int n;
	public SortedStringSet(int capacity) {
		// Initialize the instance variables
		n = 0;
		names = new String[capacity];
	}

	// Return true if there are 0 elements in this bag.
	public boolean isEmpty() {
		return n == 0;
	}

	// Return the number of unique String elements that are in this set
	public int size() {
		return n;
	}

	// If element exists, return false. Otherwise, place element into the index
	// that maintains natural ordering and return true.
	//
	// If there is no space, this method will grow the array by 20 elements
	public boolean insertInOrder(String element) {
		for (int i = 0; i < n; i++) {
			if (element.equals(names[i]))
				return false;
		}
		n++;
		if (n >= names.length) {
			String[] temp = new String[n + 20];
			for (int i = 0; i < n - 1; i++) {
				temp[i] = names[i];
			}
			names = temp;
		}
		if (n < names.length) {
			boolean precedes = false;
			for (int i = 0; i < n - 1; i++) {
				if (names[i].compareTo(element) > 0) {
					precedes = true;
					for (int j = n; j > i; j--) {
						names[j] = names[j - 1];
					}
					names[i] = element;
					break;
				}
			}
			if (precedes == false) {
				names[n - 1] = element;
			}
		}
		return true;
	}

	// Return true if element is in this SortedStringSet
	public boolean contains(String element) {
		for (int i = 0; i < names.length; i++) {
			if (element.equals(names[i])) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		if (n == 0) {
			return ("[]");
		} else if (n == 1) {
			return ("[" + names[0] + "]");
		} else {
			str.append("[");
			str.append(names[0]);
			for (int i = 1; i < n; i++) {
				if (names[i] != null) {
					str.append(", " + names[i]);
				}
			}
			str.append("]");
			return str.toString();
		}
	}

	// Remove element if it is in this set, otherwise return false
	public boolean remove(String element) {
		int index = -1;
		for (int i = 0; i < names.length; i++) {
			if (element.equals(names[i])) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			return false;
		} else {
			for (int i = 0; i < n; i++) {
				names[i] = names[i + 1];
			}
			names[n] = null;
			return true;
		}
	}

	// Return a SortedSet that is the union of this and other
	// Union of two sets. The union of two sets A and B is the set of elements which
	// are in A, in B, or in both A and B. For example, if
	// A = {"1", "3", "5", "7"} and B = {"1", "2", "4", "6"}
	// then A.union(B) = {"1", "2", "3", "4", "5", "6", "7"}.
	//
	// Feel free to research this.
	//
	public SortedStringSet union(SortedStringSet other) {
		// You may reference other.elements[0], other.elements[1], ...
		// other.elements[n-1] inside this method
		SortedStringSet union = new SortedStringSet(0);
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < union.n; j++) {
				if (names[i].compareTo(union.names[j]) == 0) {
					flag = false;
				} else if (names[i].compareTo(union.names[j]) != 0) {
					flag = true;
				}
			}
			if (flag) {
				union.insertInOrder(names[i]);
			}
		}

		boolean flag2 = true;
		for (int i = 0; i < other.n; i++) {
			for (int j = 0; j < union.n; j++) {
				if (other.names[i].compareTo(union.names[j]) == 0 && names[j] != null) {
					flag2 = false;
				} else if (other.names[i].compareTo(union.names[j]) != 0 && names[j] != null) {
					flag2 = true;
				}
			}
			if (flag2) {
				union.insertInOrder(other.names[i]);
			}
		}
		return union;
	}
}