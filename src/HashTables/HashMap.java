package HashTables;

public class HashMap <K,V>{
	private final static int TABLE_SIZE=128;
	private int elemCount;
	private HashEntry[] table;
	
	private final int hash(K key){
		int k=0;
		return k;
	}
	
	public class HashEntry<K,V> {
		K key;
		V value;
		HashEntry<K,V> next;
		
		
		HashEntry(K key, V value){
			this.key=key;
			this.value=value;
		}
		
		public K getKey(){
			return key;
		}
		
		public V getValue(){
			return value;
		}
	}
	
	HashMap(){
		table = new HashEntry[TABLE_SIZE];
		for(int i=0;i<TABLE_SIZE;i++){
			table[i]=null;
		}		
	}
	
	public V get(K key){
		if(table[hash(key)]==null){
			return null;
		}
		else{
			HashEntry<K,V> cur=table[hash(key)];
			while(cur!=null&&cur.key!=key){
				cur=cur.next;
			}
			if(cur==null){
				return null;
			}else{
				return cur.value;
			}
		}
		
	}
	
	public void put(K key, V value){
		if(table[hash(key)]==null){
			table[hash(key)]=new HashEntry<K,V>(key, value);
		}else{
			//add to end.next
		}
	}
	
	 
}
