
import java.util.*;
public class t2 {
	private static Scanner scanner = new Scanner(System.in);
	private static List<Room> rooms = new ArrayList<>();
	private static List<Booking> bookings = new ArrayList<>();
	private static int bookingIdCounter = 1;

	public static void main(String[] args) {
		initializeRooms();

		boolean exit = false;
		while (!exit) {
			System.out.println("Hotel Reservation System:-");
			System.out.println("1. Search Available Rooms");
			System.out.println("2. Make Reservation");
			System.out.println("3. View Booking Details");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				searchAvailableRooms();
				break;
			case 2:
				makeReservation();
				break;
			case 3:
				viewBookingDetails();
				break;
			case 4:
				exit = true;
				System.out.println("Exiting Hotel Reservation System.Thank you!!");
				break;
			default:
				System.out.println("Invalid choice. Please enter a valid option.");
			}
		}
		scanner.close();
	}

	private static void initializeRooms() {
		rooms.add(new Room("Single", 1, 500));
		rooms.add(new Room("Double", 2, 800));
		rooms.add(new Room("Suite", 4, 1500));
	}

	private static void searchAvailableRooms() {
		System.out.println("Available Rooms:");
		for (Room room : rooms) {
			if (!isRoomBooked(room)) {
				System.out.println(room);
			}
		}
	}

	private static void makeReservation() {
		System.out.print("Enter room type (Single/Double/Suite): ");
		String roomType = scanner.next();
		System.out.print("Enter number of guests: ");
		int numGuests = scanner.nextInt();

		Room selectedRoom = null;
		for (Room room : rooms) {
			if (room.getRoomType().equalsIgnoreCase(roomType) && room.getCapacity() >= numGuests
					&& !isRoomBooked(room)) {
				selectedRoom = room;
				break;
			}
		}

		if (selectedRoom != null) {
			System.out.print("Enter payment amount: Rs.");
			double paymentAmount = scanner.nextDouble();
			System.out.print("Enter customer name: ");
			String customerName = scanner.next();

			bookings.add(new Booking(bookingIdCounter++, selectedRoom, paymentAmount, customerName));
			System.out.println("Reservation successful. Your booking ID is: " + (bookingIdCounter - 1));
		} else {
			System.out.println("No available rooms matching the criteria.");
		}
	}

	private static boolean isRoomBooked(Room room) {
		for (Booking booking : bookings) {
			if (booking.getRoom().equals(room)) {
				return true;
			}
		}
		return false;
	}

	private static void viewBookingDetails() {
		System.out.print("Enter booking ID: ");
		int bookingId = scanner.nextInt();

		for (Booking booking : bookings) {
			if (booking.getBookingId() == bookingId) {
				System.out.println("Booking Details:");
				System.out.println(booking);
				return;
			}
		}
		System.out.println("Booking not found.");
	}

	static class Room {
		private String roomType;
		private int capacity;
		private double price;

		public Room(String roomType, int capacity, double price) {
			this.roomType = roomType;
			this.capacity = capacity;
			this.price = price;
		}

		public String getRoomType() {
			return roomType;
		}

		public int getCapacity() {
			return capacity;
		}

		public double getPrice() {
			return price;
		}

		@Override
		public String toString() {
			return "Room Type: " + roomType + ", Capacity: " + capacity + ", Price: Rs." + price;
		}
	}

	static class Booking {
		private int bookingId;
		private Room room;
		private double paymentAmount;
		private String customerName;

		public Booking(int bookingId, Room room, double paymentAmount, String customerName) {
			this.bookingId = bookingId;
			this.room = room;
			this.paymentAmount = paymentAmount;
			this.customerName = customerName;
		}

		public int getBookingId() {
			return bookingId;
		}

		public Room getRoom() {
			return room;
		}

		public double getPaymentAmount() {
			return paymentAmount;
		}

		public String getCustomerName() {
			return customerName;
		}

		@Override
		public String toString() {
			return "Booking ID: " + bookingId + ", Room: " + room.getRoomType() + ", Payment Amount: Rs." + paymentAmount
					+ ", Customer Name: " + customerName;
		}
	}
}

