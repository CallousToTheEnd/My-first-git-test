package entity;

public class Book {
	private String id;
	private String type;
	private String name;
	private String author;
	private String translator;
	private String publisher;
	private String publish_time;
	private double price;
	private int stock;
	
	
	public void setId(String id){
		this.id = id;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setPublish_time(String publish_time){
		this.publish_time = publish_time;
	}
	public void setPrice(double price){
		this.price = price;
	}
	public void setStock(int stock){
		this.stock = stock;
	}
	
	//得到图书信息
	public String getId(){
		return id;
	}
	public String getType() {
		return type;
	}
	public String getName(){
		return name;
	}
	public String getAuthor() {
		return author;
	}
	public String getTranslator() {
		return translator;
	}
	public String getPublisher() {
		return publisher;
	}
	public String getPublish_time(){
		return publish_time;
	}
	public double getPrice(){
		return price;
	}
	public int getStock(){
		return stock;
	}
}
