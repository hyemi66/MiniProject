package movie;

public class MovieDTO {
	private String mov_name, mov_time, mov_place, mov_area;
	private int mov_seat;
	
	public String getMov_name() { return mov_name; }
	public void setMov_name(String mov_name) { this.mov_name = mov_name; }
	
	public String getMov_time() { return mov_time; }
	public void setMov_time(String mov_time) { this.mov_time = mov_time; }
	
	public String getMov_place() { return mov_place; }
	public void setMov_place(String mov_place) { this.mov_place = mov_place; }
	
	public int getMov_seat() { return mov_seat; }
	public void setMov_seat(int mov_seat) { this.mov_seat = mov_seat; }
	
	public String getMov_area() { return mov_area; }
	public void setMov_area(String mov_area) { this.mov_area = mov_area; }
	
}
