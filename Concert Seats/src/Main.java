/**
 * 
 */

/**
 * @author charles
 *
 */
public class Main {
	
	public static void main(String[] args) {
		Concert metallica = new Concert("Metallica", 5, 10);

		System.out.println(showUnreservedSeats(metallica));
		System.out.println(showReservedSeats(metallica));
		
		System.out.println("-----------------------------------------------------");
		
		Customer warrenSanford = new Customer("Warren Sanford");
		metallica.reserveSeat('A', 2, warrenSanford);
		metallica.reserveSeat('B', 3, warrenSanford);
		metallica.reserveSeat('C', 1, warrenSanford);
		
		System.out.println(showUnreservedSeats(metallica));
		System.out.println(showReservedSeats(metallica));
		
		System.out.println("-----------------------------------------------------");
		
		Customer jamesSmith = new Customer("James Smith");
		metallica.reserveSeat('E', 4, jamesSmith);
		
		System.out.println(showUnreservedSeats(metallica));
		System.out.println(showReservedSeats(metallica));

		System.out.println("-----------------------------------------------------");
		
		System.out.println(warrenSanford.getName() + " Seats purchased" + warrenSanford.getSeatsPurchased() 
							+ " Total Bill: $" + warrenSanford.getTotalBill());
		
		System.out.println("-----------------------------------------------------");
		
		System.out.println(jamesSmith.getName() + " Seats purchased" + jamesSmith.getSeatsPurchased() 
							+ " Total Bill: $" + jamesSmith.getTotalBill());

	}
	
	
	public static String showUnreservedSeats(Concert concert) {
		System.out.println("-------UNRESEVED SEATS------------");
		StringBuilder stringBuilderUnreserved = new StringBuilder();
		for(Seat seat: concert.getSeats()) {
			if(seat.isReserved() == false) {
				stringBuilderUnreserved.append(seat.toStringUnreserved() + " ");
			}
		}
		
		String toReturn = stringBuilderUnreserved.toString();

		return toReturn;
	}
	
	public static String showReservedSeats(Concert concert) {
		System.out.println("-------RESEVED SEATS------------");
		StringBuilder stringBuilderReserved = new StringBuilder("");
		for(Seat seat: concert.getSeats()) {
			if(seat.isReserved() == true) {
				stringBuilderReserved.append(seat.toStringReserved() + " ");
			}
		}
		
		if (stringBuilderReserved.toString().equals("")) {
			return "No seats reserved.....";
		}
		String toReturn = stringBuilderReserved.toString();
		return toReturn;
	}
}
