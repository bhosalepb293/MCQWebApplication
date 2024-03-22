package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DAO {
	private static Connection con = Service.getConnection();	
	
	public static ArrayList<DTO> displayBook() {
		String query = "select * from book";

		ArrayList<DTO> a1 = new ArrayList<DTO>();
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				DTO d1 = new DTO();
				d1.setBook_id(rs.getInt(1));
				d1.setBook_name(rs.getString(2));
				d1.setBook_auth(rs.getString(3));
				d1.setNo_of_pages(rs.getString(4));
				a1.add(d1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a1;
	}
	
	public ResultSet details(DTO dto) {
		String query = "Select * from book where book_id=?";
		ResultSet rs = null;
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, dto.getBook_id());
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public int addBook(DTO d1) {
		int count = 0;
		
		String name = d1.getBook_name();
		String auth = d1.getBook_auth();
		String pages = d1.getNo_of_pages();
		
		String query = "insert into book values(?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, 0);
			pstm.setString(2, name);
			pstm.setString(3, auth);
			pstm.setString(4, pages);
			count = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public int updateBook(DTO dto) {
		String query = "update book set book_name=?, book_auth=?, no_of_pages=? where book_id=?";
		int count = 0;
		
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, dto.getBook_name());
			pstm.setString(2, dto.getBook_auth());
			pstm.setString(3, dto.getNo_of_pages());
			pstm.setInt(4, dto.getBook_id());
			
			count = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
