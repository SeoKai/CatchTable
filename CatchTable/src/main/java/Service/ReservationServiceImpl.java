package Service;

import java.sql.SQLException;
import java.util.List;
import Model.Dao.ReservationDao;
import Model.Dto.Reservation;

public class ReservationServiceImpl {

	private ReservationDao reservationDao;

	// 싱글톤 패턴 적용
	private static ReservationServiceImpl instance;

	private ReservationServiceImpl() {
		reservationDao = new ReservationDao();
	}

	public static ReservationServiceImpl getInstance() {
		if (instance == null) {
			instance = new ReservationServiceImpl();
		}
		return instance;
	}

    // 예약 추가 (생성된 예약 ID 반환)
    public int addReservation(Reservation reservation) throws SQLException {
        return reservationDao.addReservation(reservation);
    }

	// 예약 조회 (단건)
	public Reservation getReservation(int reservationId) throws SQLException {
		return reservationDao.getReservation(reservationId);
	}

	// 예약 조회 (전체)
	public List<Reservation> getAllReservations() throws SQLException {
		return reservationDao.getAllReservations();
	}

	// 예약 수정
	public void updateReservation(Reservation reservation) throws SQLException {
		reservationDao.updateReservation(reservation);
	}

	// 예약 삭제
	public boolean deleteReservation(int reservationId) throws SQLException {
		return reservationDao.deleteReservation(reservationId);
	}

}
