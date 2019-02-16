package maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapPractice {

	/**
	 * Write and test a method makeConstantMap, which takes a list of keys of type K
	 * and a single value of type V, and produces a Map<K,V> where the keys come
	 * from the list, and the values are all the single provided value.
	 */

	/**
	 * Write and test a method incrementMap, which takes a Map<K,Integer> and
	 * changes the map so that each value is incremented by 1.
	 */

	/**
	 * Write and test a method upperCaseMap, which takes a Map<K,String> and changes
	 * the map so that each value is in uppercase.
	 */
	
	
	/**
	 * Write and test a method invertMap, which takes a map from K to V, and
	 * produces a map from V to List<K> (why does it have to be List<K>)?
	 * 
	 * We've provided the signature below; not that you can create generic methods
	 * by writing type variables right before the return type. So each time you call
	 * invertMap below, java will choose the K and V types based on the arguments
	 * you provide.
	 * 
	 * As an example, the map
	 * 
	 * { x: 5, y: 10 }
	 * 
	 * should be inverted to:
	 * 
	 * { 10: [y], 5: [x]}
	 */
	public static <K, V> Map<V, List<K>> invertMap(Map<K, V> input) {
		return null;
	}

	interface Chooser<E> {
		boolean choose(E e);
	}

	/**
	 * Write and test a method filterMapByKeys, which takes Map<K,V> and a Chooser
	 * of the K type, and removes all entries from the map where the chooser returns
	 * false for the key's value.
	 * 
	 * You write it out completely, including figuring out the signature!
	 */


	interface Transformer<E> {
		E transform(E e);
	}

	/**
	 * Write and test a method transformMap that takes a Map<K,V> and a
	 * Transformer<V>, and changes the map so that each value has the result of
	 * transforming the original value with the transformer's transform method.
	 */
	
	/** Once you've finished transformMap, can you make incrementMap and uppercaseMap simpler? */

}
