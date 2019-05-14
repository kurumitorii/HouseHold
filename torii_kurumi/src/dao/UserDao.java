package dao;

import static utils.CloseableUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import beans.User;
import exception.NoRowsUpdatedRuntimeException;
import exception.SQLRuntimeException;

public class UserDao {

	public void insert(Connection connection, User user) {

		//		可変になるカラムの値を「?」と記述
		//		この「?」は、「バインド変数(bind variables)」と呼ぶ。

		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO users ( ");
			sql.append("name");    			//文字列を追加する
			sql.append(", accountid");
			sql.append(", password");
			sql.append(", created_date");
			sql.append(", updated_date");
			sql.append(", account");
			sql.append(") VALUES (");
			sql.append("?"); // name
			sql.append(", ?"); // accounid
			sql.append(", ?"); // password
			sql.append(", CURRENT_TIMESTAMP"); // created_date
			sql.append(", CURRENT_TIMESTAMP"); // updated_date
			sql.append(", ?");
			sql.append(")");

			ps = connection.prepareStatement(sql.toString());

			ps.setString(1, user.getName());
			ps.setString(2, user.getAccountid());
			ps.setString(3, user.getPassword());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.getMessage();
		} finally {
			close(ps);
		}
	}

	public User getUser(Connection connection, String accountid,
			String password) {

		PreparedStatement ps = null;
		try {
			String sql = "SELECT * FROM users WHERE accountid = ? AND password = ?";

			ps = connection.prepareStatement(sql);
			ps.setString(1, accountid);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			List<User> userList = toUserList(rs);
			if (userList.isEmpty() == true) {
				return null;
			} else if (2 <= userList.size()) {
				throw new IllegalStateException("2 <= userList.size()");
			} else {
				return userList.get(0);
			}
		} catch (SQLException e) {
			throw new SQLRuntimeException(e);
		} finally {
			close(ps);
		}
	}


	private List<User> toUserList(ResultSet rs) throws SQLException {

		List<User> ret = new ArrayList<User>();
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String accountid = rs.getString("accountid");
				String password = rs.getString("password");
				Timestamp createdDate = rs.getTimestamp("created_date");
				Timestamp updatedDate = rs.getTimestamp("updated_date");

				User user = new User();
				user.setId(id);
				user.setName(name);
				user.setAccountid(accountid);
				user.setPassword(password);
				user.setCreatedDate(createdDate);
				user.setUpdatedDate(updatedDate);

				ret.add(user);
			}
			return ret;
		} finally {
			close(rs);
		}
	}

	public User getUser(Connection connection, int id) {
		PreparedStatement ps = null;
		try {
			String sql = "SELECT * FROM users WHERE id = ?";

			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);


			ResultSet rs = ps.executeQuery();
			List<User>userList = toUserList(rs);
			if(userList.isEmpty() == true) {
				return null;
			}else if (2 <= userList.size()) {
				throw new IllegalStateException("2 <= userList.size()");
			}else {
				return userList.get(0);
			}
		}catch(SQLException e) {
			throw new SQLRuntimeException(e);
		}finally {
			close(ps);
		}
	}

	public void update(Connection connection, User user) {

		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE users SET");
			sql.append("  name = ?");
			sql.append(", accountid = ?");
			sql.append(", password = ?");
			sql.append(", updated_date = CURRENT_TIMESTAMP");
			sql.append(" WHERE");
			sql.append(" id = ?");

			ps = connection.prepareStatement(sql.toString());

			ps.setString(1, user.getName());
			ps.setString(2, user.getAccountid());
			ps.setString(3, user.getPassword());
			ps.setInt(6, user.getId());

			int count = ps.executeUpdate();
			if (count == 0) {
				throw new NoRowsUpdatedRuntimeException();
			}
		} catch (SQLException e) {
			throw new SQLRuntimeException(e);
		} finally {
			close(ps);
		}
	}
	public void search(Connection connection, User user) {

		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE users SET");
			sql.append("  name = ?");
			sql.append(", accountid = ?");
			sql.append(", password = ?");
			sql.append(", updated_date = CURRENT_TIMESTAMP");
			sql.append(" WHERE");
			sql.append(" id = ?");

			ps = connection.prepareStatement(sql.toString());

			ps.setString(1, user.getName());
			ps.setString(2, user.getAccountid());
			ps.setString(3, user.getPassword());
			ps.setInt(6, user.getId());

			int count = ps.executeUpdate();
			if (count == 0) {
				throw new NoRowsUpdatedRuntimeException();
			}
		} catch (SQLException e) {
			throw new SQLRuntimeException(e);
		} finally {
			close(ps);
		}
	}

	public User getEdit(Connection connection, int id, String accountid) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}