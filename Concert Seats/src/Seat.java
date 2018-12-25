import java.util.Comparator;

/**
 * 
 */

/**
 * @author charles
 *
 */
public class Seat implements Comparable<Seat>, Comparator<Seat> {
	private int seatNum;
	private char row;
	private boolean reserved = false;
	private double price;
	private Customer customer;
	
	public Seat(char row, int seatNumber, double price) {
		this.row = row;
		this.seatNum = seatNumber;
		this.price = price;
		this.customer = null;
	}
	
	public double getPrice() {return this.price;}
	public Customer getCustomer() {return this.customer;}
	
	public void setCustomer(Customer newCustomer) {
		this.customer = newCustomer;
		newCustomer.addSeatPurchase(this);
	}
	
	public int getSeatNum() {return this.seatNum;}	
	
	public String toStringReserved() {
		return "SeatNumber: " + this.row + Integer.toString(this.seatNum)
				+ " Price: " + Double.toString(this.price)
				+ " Customer: " + customer.getName() ;
	}
	
	public String toStringUnreserved() {
		return "SeatNumber: " + this.row + Integer.toString(this.seatNum)
				+ " Price: " + Double.toString(this.price);
	}
	
	public String toString() {
		return this.row + Integer.toString(this.seatNum);
	}
	
	public boolean isReserved() {return this.reserved;}
	
	boolean reserveSeat() {
		if(reserved == false) {
			reserved = true;
			System.out.println("REservered seat " + this.toString());
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int compareTo(Seat seat) {
		return this.toString().compareToIgnoreCase(seat.toString());
	}
	


	@Override
	public int compare(Seat o1, Seat o2) {
		if(o1.getPrice() < o2.getPrice()) {return -1;}
		if (o1.getPrice() > o2.getPrice()) {return 1;}
		return 0;
	}

}
