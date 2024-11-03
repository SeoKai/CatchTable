package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Dto.Reservation;
import util.DBConnectionUtil;

public class ReservationDao {
	
    /*자원 반납: try-with-resources를 통해
     * Connection, PreparedStatement, ResultSet 자원을 자동으로 닫도록 함 
     * 
     * if(rs != null) 체크는 필요하지 않아서 생략
     * pstmt.executeQuery()가 실행되면 ResultSet 객체가 항상 반환된다.
     * 결과가 없다면 빈 ResultSet이 반환되므로, null을 반환하는 경우는 없다.
     * */
    
    // 예약 추가 (추가된 예약 ID 반환)
    public int addReservation(Reservation reservation) throws SQLException {
        String sql = "insert into tbl_reservation (restaurant_name, reservation_date, reservation_time, customer_name, number_of_people) "
                   + "values (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, reservation.getRestaurantName());
            pstmt.setDate(2, new java.sql.Date(reservation.getReservationDate().getTime()));
            pstmt.setTime(3, reservation.getReservationTime());
            pstmt.setString(4, reservation.getCustomerName());
            pstmt.setInt(5, reservation.getNumberOfPeople());

            pstmt.executeUpdate();

            // 추가된 예약 ID 가져오기
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1); // 생성된 예약 ID 반환
                }
            }
        }
        return -1; // ID 생성 실패 시 -1 반환
    }
    // 특정 ID로 예약 조회
    public Reservation getReservation(int reservationId) throws SQLException {
        String sql = "select * from tbl_reservation where reservation_id = ?";
        Reservation reservation = null;

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, reservationId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    reservation = new Reservation(
                            rs.getInt("reservation_id"),
                            rs.getString("restaurant_name"),
                            rs.getDate("reservation_date"),
                            rs.getTime("reservation_time"),
                            rs.getString("customer_name"),
                            rs.getInt("number_of_people"));
                }
            }
        }

        return reservation;
    }

    // 전체 예약 조회
    public List<Reservation> getAllReservations() throws SQLException {
        String sql = "select * from tbl_reservation";
        List<Reservation> reservations = new ArrayList<>();

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Reservation reservation = new Reservation(
                        rs.getInt("reservation_id"),
                        rs.getString("restaurant_name"),
                        rs.getDate("reservation_date"),
                        rs.getTime("reservation_time"),
                        rs.getString("customer_name"),
                        rs.getInt("number_of_people")
                );
                reservations.add(reservation);
            }
        }

        return reservations;
    }

    // 예약 수정
    public void updateReservation(Reservation reservation) throws SQLException {
        String sql = "update tbl_reservation set "
                   + "restaurant_name = ?, reservation_date = ?, reservation_time = ?, "
                   + "customer_name = ?, number_of_people = ? where reservation_id = ?";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, reservation.getRestaurantName());
            pstmt.setDate(2, new java.sql.Date(reservation.getReservationDate().getTime()));
            pstmt.setTime(3, reservation.getReservationTime());
            pstmt.setString(4, reservation.getCustomerName());
            pstmt.setInt(5, reservation.getNumberOfPeople());
            pstmt.setInt(6, reservation.getReservationId());

            pstmt.executeUpdate();
        }
    }

 // 예약 삭제
    public boolean deleteReservation(int reservationId) throws SQLException {
        String sql = "delete from tbl_reservation where reservation_id = ?";
        boolean isDeleted = false;

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, reservationId);
            int rowsAffected = pstmt.executeUpdate();
            
            // 행이 하나 이상 삭제된 경우에만 true 반환
            if (rowsAffected > 0) {
                isDeleted = true;
            }
        }
        return isDeleted;
    }
}
