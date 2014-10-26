/**
 * 
 */
package asn.jpa_test.core.util;

import java.util.Collection;

/**
 * @author Abhishek
 *
 */
public interface IPredicate<T> {
	/*boolean apply(T src, T type);*/
	boolean contains(Collection<T> source, T elem);
}
