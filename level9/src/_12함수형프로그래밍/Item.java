package _12함수형프로그래밍;

import java.util.Objects;

public class Item implements Comparable<Item>{
	private int itemNo;
	private String category;
	private String name;
	private int price;
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "%d) %s\t%s\t%d원".formatted(itemNo,category,name,price);
	}
	public Item(int itemNo, String category, String name, int price) {
		super();
		this.itemNo = itemNo;
		this.category = category;
		this.name = name;
		this.price = price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(category, itemNo, name, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(category, other.category) && itemNo == other.itemNo && Objects.equals(name, other.name)
				&& price == other.price;
	}
	@Override
	public int compareTo(Item o) {
		if(itemNo>o.getItemNo()) {
			return 1;
		} else if(itemNo<o.getItemNo()){
			return -1;
		}
		return 0;
	}
}
