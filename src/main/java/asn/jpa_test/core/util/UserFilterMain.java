package asn.jpa_test.core.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Abhishek
 * 
 */
public class UserFilterMain {

	public static void main(String[] args) {
		Set<User> existingUsers = new LinkedHashSet<User>();
		existingUsers.add(new User(1L, "Tapan1"));
		existingUsers.add(new User(2L, "Tapan2"));
		existingUsers.add(new User(3L, "Tapan3"));

		Set<User> modifiedUsers = new LinkedHashSet<User>();
		modifiedUsers.add(new User(null, "Abhishek"));
		modifiedUsers.add(new User(null, "Abhishek2"));
		modifiedUsers.add(new User(null, "Abhishek3"));
		modifiedUsers.add(new User(1L, "Tapan1"));
		modifiedUsers.add(new User(2L, "Tapan2"));
		modifiedUsers.add(new User(null, "Tapan3"));
		System.out.println("existingUsers: " + existingUsers);
		System.out.println("modifiedUsers: " + modifiedUsers);
		List<User> removeUsers = (List<User>) filter(existingUsers,
				modifiedUsers, new IPredicate<User>() {

					@Override
					public boolean contains(Collection<User> source, User elem) {
						boolean status = false;
						for (User u : source) {
							if (u.getId()!=null && u.getId().equals(elem.getId())) {
								status = true;
								break;
							}
						}

						return status;
					}

				});
		//System.out.println("removeUsers: " + removeUsers);
	}

	public static <T> Collection<T> filter(Collection<T> source,
			Collection<T> target, IPredicate<T> predicate) {
		Collection<T> result = new ArrayList<T>();
		for (T type : source) {
			if (!predicate.contains(target, type)) {
				result.add(type);
			}

		}

		return result;
	}

	/*
	 * public static <T> Collection<T> filter(Collection<T> target,
	 * IPredicate<T> predicate) { Collection<T> result = new ArrayList<T>(); for
	 * (T element : target) { if (predicate.apply(element)) {
	 * result.add(element); } } return result; }
	 */
}
