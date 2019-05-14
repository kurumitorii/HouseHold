package service;

import static utils.CloseableUtil.*;
import static utils.DBUtil.*;

import java.sql.Connection;

import beans.User;
import dao.UserDao;
import utils.CipherUtil;

public class UserService {

    public void register(User user) {

        Connection connection = null;			//connectionの初期化
        try {
            connection = getConnection();		//DBへ接続

            String encPassword = CipherUtil.encrypt(user.getPassword());
            user.setPassword(encPassword);			//暗号化passをuserにset

            UserDao userDao = new UserDao();		//userDaoの生成
            userDao.insert(connection, user);		//データの追加（pass)

            commit(connection);
        } catch (RuntimeException e) {
            rollback(connection);
            throw e;
        } catch (Error e) {
            rollback(connection);
            throw e;
        } finally {
            close(connection);
        }
    }


    public void update(User user) {

		Connection connection = null;
		try {
			connection = getConnection();

			String encPassword = CipherUtil.encrypt(user.getPassword());
			user.setPassword(encPassword);

			UserDao userDao = new UserDao();
			userDao.update(connection, user);

			commit(connection);
		} catch (RuntimeException e) {
			rollback(connection);
			throw e;
		} catch (Error e) {
			rollback(connection);
			throw e;
		} finally {
			close(connection);
		}

	}
}
