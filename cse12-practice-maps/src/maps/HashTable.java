package maps;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This is a version of HashTable that implements what we described in lecture.
 * 
 * Try adding a few methods to it, and testing it out!
 * 
 * Methods to implement and test for practice:
 * 
 *  - boolean containsKey(K key)
 *  
 *  - boolean containsValue(V value)
 *  
 *  - int size()
 *  
 *  - void remove(K key)
 *  
 *  - void setAll(List<Entry<K,V>> entries)
 *    Adds *all* the listed entries to the map.
 *  
 * @author joe
 *
 * @param <K>
 * @param <V>
 */
class Entry<K,V> {
	K k;
	V v;

	public Entry(K k, V v) {
		this.k = k;
		this.v = v;
	}
}
public class HashTable<K, V> {

	

	List<Entry<K,V>>[] buckets; // An array of Lists of Entries
	int size;

	@SuppressWarnings("unchecked")
	public HashTable() {
		this.size = 0;
		this.buckets = (List<Entry<K,V>>[]) (new List[4]);
	}

	public double loadFactor() {
		return (double) (this.size) / this.buckets.length;
	}

	/*
	 * Value get(key): hashed = hash(key) index = hashed % this.buckets.length if
	 * this.buckets[index] contains an Entry with key: return the value of that
	 * entry else: return null/report an error
	 */
	public V get(K k) {
		int hashCode = k.hashCode();
		int index = hashCode % this.buckets.length;
		if (this.buckets[index] == null) {
			throw new NoSuchElementException("No such element " + k);
		} else {
			for (Entry<K,V> e : this.buckets[index]) {
				if (e.k.equals(k)) {
					return e.v;
				}
			}
			throw new NoSuchElementException("No such element " + k);
		}
	}

	/*
	 * 
	 * set(key, value): hashed = hash(key) index = hashed % array length if
	 * this.buckets[index] contains a pair with key: update that pair to contain
	 * value else: increment this.size add {key: value} to buckets[index]
	 * 
	 */
	public void set(K k, V v) {
		if (loadFactor() > 0.5) {
			expandCapacity();
		}
		int hashCode = k.hashCode();
		int index = hashCode % this.buckets.length;
		if (this.buckets[index] == null) {
			this.buckets[index] = new ArrayList<Entry<K,V>>();
			this.buckets[index].add(new Entry<K,V>(k, v));
		} else {
			for (Entry<K,V> e : this.buckets[index]) {
				if (e.k.equals(k)) {
					e.v = v;
					return;
				}
			}
			this.buckets[index].add(new Entry<K,V>(k, v));
		}
		this.size += 1;
	}

	/*
	 * 
	 * expandCapacity(): newEntries = new List[this.buckets.length * 2]; oldEntries
	 * = this.buckets this.buckets = newEntries this.size = 0 for each entry {k:v}:
	 * this.set(k, v)
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void expandCapacity() {
		List<Entry<K,V>>[] newEntries = (List<Entry<K,V>>[]) (new List[this.buckets.length * 2]);
		List<Entry<K,V>>[] oldEntries = this.buckets;
		this.buckets = newEntries;
		this.size = 0;
		for (int i = 0; i < oldEntries.length; i += 1) {
			if (oldEntries[i] == null) {
				continue;
			}
			for (Entry<K,V> e : oldEntries[i]) {
				this.set(e.k, e.v);
			}
		}
	}

}
