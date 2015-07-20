package lesson_08;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SymbolTable<K,V> implements Map<K, V> {
	private final List<Map<K,V>> bindings;

	public SymbolTable() {
		this.bindings = new LinkedList<Map<K, V>>();
		this.bindings.add(new HashMap<K,V>());
	}
	
	public void enterScope() {
		bindings.add(new HashMap<K,V>());
	}
	
	public void enterScope(Map<K,V> m) {
		bindings.add(m);
	}
	
	public void leaveScope() {
		int s = bindings.size();
		bindings.remove(s-1);
	}

	@Override
	public int size() {
		int n = 0;
		for (Map<K,V> m : bindings) {
			n += m.size();
		}
		return n;
	}

	@Override
	public boolean isEmpty() {
		return bindings.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		for (Map<K,V> m : bindings) {
			if (m.containsKey(key)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		for (Map<K,V> m : bindings) {
			if (m.containsValue(value)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public V get(Object key) {
		V value = null;
		for (Map<K,V> m : bindings) {
			V newvalue = m.get(key);
			if (newvalue != null) {
				value = newvalue;
			}
		}
		return value;
	}

	@Override
	public V put(K key, V value) {
		Map<K,V> scope = null;
		for (Map<K,V> m : bindings) {
			if (m.containsKey(key)) {
				scope = m;
			}
		}
		if (scope == null) {
			scope = topScope();
		}
		return scope != null ? scope.put(key, value) : null;
	}

	private Map<K, V> topScope() {
		Map<K,V> lastm = null;
		for (Map<K,V> m : bindings) {
			lastm = m;
		}
		return lastm;
	}

	@Override
	public V remove(Object key) {
		Map<K,V> lastm = topScope();
		if (lastm != null) {
			return lastm.remove(key);
		}
		return null;
	}

	@Override
	public void clear() {
		bindings.clear();
	}

	@Override
	public Set<K> keySet() {
		Set<K> result = new HashSet<K>();
		for (Map<K,V> m : bindings) {
			result.addAll(m.keySet());
		}
		return result;
	}

	@Override
	public Collection<V> values() {
		Collection<V> result = new LinkedList<V>();
		for (Map<K,V> m : bindings) {
			result.addAll(m.values());
		}
		return result;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> result = new HashSet<Map.Entry<K,V>>();
		for (Map<K,V> m : bindings) {
			result.addAll(m.entrySet());
		}
		return result;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for(K key : m.keySet()) {
			put(key, m.get(key));
		}
	}

}
