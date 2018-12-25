import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * 
 */

/**
 * @author charles
 *
 */
public class Concert {
	private String concertName;
	private List<Seat> seats;
	private final double STANDARDPRICE = 12.00;
	
	public Concert(String name, int rows, int seatsPerRow) {
		this.concertName = name;
		seats = new ArrayList<>();
		
		//convert char to ASCII for numerical increase
		int startingRow = 'A';
		int endingRow = startingRow + rows;
		
		//create seat labels
		for(char row = 'A';row <= endingRow-1;row++) {
			for(int seat = 1;seat <=seatsPerRow;seat++) {
				Seat newSeat = null;
				//create seat objects and pricing logic
				if(row <= 'D') {
					newSeat = new Seat(row, seat, STANDARDPRICE + 
							(STANDARDPRICE * .75));
				}else if (row <= 'H') {
					newSeat = new Seat(row, seat, STANDARDPRICE + 
							(STANDARDPRICE * .25));
				}else {
					newSeat = new Seat(row, seat, STANDARDPRICE);
				}
				seats.add(newSeat);
			}
		}
	}
	

	
	public List<Seat> getSeats(){
		return seats;
	}
	
	public String getName() {
		return concertName;
	}

	
	public boolean reserveSeat(char row, int seatNumber, Customer customer) {
		Seat newSeat = null;
		if(row <= 'D') {
			newSeat = new Seat(row, seatNumber, STANDARDPRICE + 
					(STANDARDPRICE * .75));
		}else if (row <= 'H') {
			newSeat = new Seat(row, seatNumber, STANDARDPRICE + 
					(STANDARDPRICE * .25));
		}else {
			newSeat = new Seat(row, seatNumber, STANDARDPRICE);
		}
		
		int foundSeat = Collections.binarySearch(seats, newSeat);
		if(foundSeat >= 0) {
			seats.get(foundSeat).reserveSeat();
			seats.get(foundSeat).setCustomer(customer);			
			return true; 
		}else {
			System.out.println("Seat not found...");
			return false;
		}
	}
	
}
