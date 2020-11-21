package local.tobbstr.demos.cleanarch.todo_in_spring.entities;

/**
 * Bounce is not an Entity, instead a helper class that provides useful methods for checking
 * arguments.
 * @author tobias
 *
 */
public class Bounce {
	/**
	 * Null checks for null pointers.
	 * @param <T>
	 * @param t is an array of objects to be checked for null pointers
	 * @throws IllegalArgumentException if any object in t is null
	 */
	public static final <T> void Null(T ...t) {
		for (T t2 : t) {
			if (t2 == null) {
				throw new IllegalArgumentException();
			}
		}
	}
	
	/**
	 * emptyString checks for empty String objects
	 * @param s is an array of String objects
	 * @throws IllegalArgumentException if any String in s is an empty String
	 */
	public static void emptyString(String ...s) {
		for (String string : s) {
			if (string.isEmpty()) {
				throw new IllegalArgumentException();
			}
		}
	}
}
