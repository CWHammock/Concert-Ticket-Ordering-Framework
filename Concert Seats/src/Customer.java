

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author charles
 *
 */
public class Customer {
	private String name;
	private List<Seat> reservedSeats;
	private double totalBill;
	private final double TAX = .30;

	
	public Customer(String newName) {
		this.name = newName;
		this.reservedSeats = new ArrayList<>();
		this.totalBill = 0.0;
	}

	public String getName() {
		return this.name;
	}
	
	public double getTotalBill() {
		addTax();
		return totalBill;
	}
	
	public void addSeatPurchase(Seat newSeat) {
		reservedSeats.add(newSeat);
	}
	
	private void addTax() {
		double beforeTax = 0.0;
		for(Seat seat: reservedSeats) {
			beforeTax += seat.getPrice();
		}
		totalBill += beforeTax + (beforeTax * TAX);
	}
	
	public List<Seat> getSeatsPurchased(){
		return this.reservedSeats;
	}

}
