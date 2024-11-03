package Model.Dto;

import java.sql.Time;
import java.util.Date;

public class Reservation {
	private int reservationId; // 예약 고유 ID
	private String restaurantName; // 음식점 이름
	private Date reservationDate; // 예약 날짜
	private Time reservationTime; // 예약 시간
	private String customerName; // 예약자 이름
	private int numberOfPeople; // 예약 인원수

	// 생성자 | getter, setter | toString()
	public Reservation() {
		super();
	}

	public Reservation(int reservationId, String restaurantName, Date reservationDate, Time reservationTime,
			String customerName, int numberOfPeople) {
		super();
		this.reservationId = reservationId;
		this.restaurantName = restaurantName;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.customerName = customerName;
		this.numberOfPeople = numberOfPeople;
	}
	public Reservation(String restaurantName, Date reservationDate, Time reservationTime,
			String customerName, int numberOfPeople) {
		super();
		this.restaurantName = restaurantName;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.customerName = customerName;
		this.numberOfPeople = numberOfPeople;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Time getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(Time reservationTime) {
		this.reservationTime = reservationTime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", restaurantName=" + restaurantName
				+ ", reservationDate=" + reservationDate + ", reservationTime=" + reservationTime + ", customerName="
				+ customerName + ", numberOfPeople=" + numberOfPeople + "]";
	}

}
