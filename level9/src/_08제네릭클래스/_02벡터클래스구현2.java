package _08제네릭클래스;
/*
  # 주요 기능
  1. 추가 : add(value)
  2. 삭제 : remove(idx) , remove(value)
  3. 삽입 : add(idx, value)
  4. 수정 : set(idx, value) 
  5. 갯수 : size()
  6. 값읽기 : get(idx)
  7. 전체삭제 : clear()
  
  */

import java.util.Objects;

class User{
	String name;

	public User(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(name, other.name);
	}

}

class MyVector<T>{
	Object[] arr;
	int size;
	int capacity;
	
	MyVector(){
		capacity = 10;
				//제네릭으로 new 할 수 없음
		arr = new Object[capacity]; //new 해서 객체 생성할때는 반드시 타입이 특정되어야한다.
	}
	
	void addIsSizeLength() {
		capacity+=10;
		Object[] copy = arr;
		arr = new Object[capacity];
		for(int i =0; i<copy.length; i++) {
			arr[i] = copy[i];
		}
	}
	
	void add(T value) {
		if(size>=capacity) addIsSizeLength();
		arr[size] = value;
		size++;
	}
	
	void remove(T value) {
		for(int i =0; i<size; i++) {
			if(arr[i].equals((Object)value)) {
				remove(i);
			}
		}
	}
	
	void remove(int idx) {
		if(idx<0 || idx>=size) throw new ArrayIndexOutOfBoundsException();

		for(int i =idx; i<size-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[size] = null;
		size--;
	}
	
	void add(int idx, T value) {
		if(idx<0 || idx>=size) throw new ArrayIndexOutOfBoundsException();
		if(size>=capacity) addIsSizeLength();
		size++;
		for(int i=size-1; i>idx; i--) {
			arr[i] = arr[i-1];
		}
		arr[idx] = value;
	}

	void set(int idx, T value) {
		if(idx<0 || idx>=size) throw new ArrayIndexOutOfBoundsException();
		
		arr[idx] = value;
	}
	
	int size() {
		return size;
	}
	
	T get(int idx) {
		if(idx<0 || idx>=size) throw new ArrayIndexOutOfBoundsException();

		return (T)arr[idx];
	}
	
	void clear() {
		arr = new Object[capacity];
		size = 0;
	}
	
	@Override
	public String toString() {
		System.out.print("[");
		for(int i =0; i<size; i++) {
			System.out.print(i==0 ? arr[i] : ", "+arr[i]);
		}
		System.out.print("]");
		return "";
	}
	
}

public class _02벡터클래스구현2 {
	public static void main(String[] args) {
		
		MyVector<String> v1 = new MyVector<>();
		
		for(int i =0; i<11; i++) {
			v1.add(i+"");
		}
		System.out.println(v1);
		System.out.println(v1.capacity);
		
		v1.add(1, "k");
		System.out.println(v1);
		
		v1.remove("3");
		System.out.println(v1);
		
		v1.set(1, "g");
		System.out.println(v1);
		
		System.out.println(v1.get(1));
		
		v1.clear();
		System.out.println(v1);
		
		MyVector<User> u = new MyVector<>();
		
		u.add(new User("test1"));
		u.add(new User("test1"));
		u.add(new User("test1"));
		u.add(new User("test1"));
		u.add(new User("test1"));
		
		System.out.println(u);
		
		User user1 = new User("test1");
		User user2 = new User("test1");
		
		System.out.println(user1.equals(user2));
	}
}
