package hotel.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hotel.credit.CreditCard;
import hotel.utils.IOUtils;

public class Room {
	
	private enum State {READY, OCCUPIED}
	
	int id;
	RoomType roomType;
	List<Booking> bookings;
	State state;

	
	public Room(int id, RoomType roomType) {
		this.id = id;
		this.roomType = roomType;
		bookings = new ArrayList<>();
		state = State.READY;
	}
	

	public String toString() {
		return String.format("Room : %d, %s", id, roomType);
	}


	public int getId() {
		return id;
	}
	
	public String getDescription() {
		return roomType.getDescription();
	}
	
	
	public RoomType getType() {
		return roomType;
	}
	
	public boolean isAvailable(Date arrivalDate, int stayLength) {
		IOUtils.trace("Room: isAvailable");
		for (Booking b : bookings) {
			if (b.doTimesConflict(arrivalDate, stayLength)) {
				return false;
			}
		}
		return true;
	}
	
	
	public boolean isReady() {
		return state == State.READY;
	}


	public Booking book(Guest guest, Date arrivalDate, int stayLength, int numberOfOccupants, CreditCard creditCard) {
		while(true){
                System.out.println("Enter your Room no. : (Enter x for quite ) : ");
                roomID = inputID.nextLine();
                System.out.println("X : " + roomID.equals("x"));
                if(roomID.equals("x")){
                    System.out.println("Break");
                    break;
                }

                if(getRoom(roomID) == null){

                    System.out.println("The room ID is incorrect, please enter again or enter x to quit");

                }
                else{

                    room = getRoom(roomID);

                    if(!room.isBooked()){
                        System.out.println("Book successfully");
                        room.setBooked(true);
                        break;
                    }
                    else{
                        System.out.println("please enter the room ID again or enter x to quit");
                    }
		return null;		
	}


	public void checkin() {
		if(isPending())
		
		{
	
		room.checkin();
	
		state = State.CHECKED_IN;
		
		}

		else

		{

			throw new RuntimeException();
		
		}
	}


	public void checkout(Booking booking) {
		if(isCheckedIn())
		
		{
			Booking booking = new Booking( guest,  room,bookedArrival,
stayLength, numberOfOccupants, creditCard);
		room.checkout(booking);
			
			state = State.CHECKED_OUT;

		}
		
		else

		{

		throw new RuntimeException();
		}
		}


}
