package ticket;

public class TicketDTO {
	private String tic_id, tic_name, tic_time, tic_place, tic_area;
	private int tic_seat;
	
	public String getTic_id() { return tic_id; }
	public void setTic_id(String tic_id) { this.tic_id = tic_id; }
	
	public String getTic_name() { return tic_name; }
	public void setTic_name(String tic_name) { this.tic_name = tic_name; }
	
	public String getTic_time() { return tic_time; }
	public void setTic_time(String tic_time) { this.tic_time = tic_time; }
	
	public String getTic_place() { return tic_place; }
	public void setTic_place(String tic_place) { this.tic_place = tic_place; }
	
	public String getTic_area() { return tic_area; }
	public void setTic_area(String tic_area) { this.tic_area = tic_area; }
	
}
