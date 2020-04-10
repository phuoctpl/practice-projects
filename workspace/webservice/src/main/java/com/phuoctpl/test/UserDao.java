package com.phuoctpl.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class UserDao {
	
	final static Logger logger = Logger.getLogger(UserDao.class.getName());
	
	public List<User> getAllUsers() {

		List<User> userList = null;
		try {
			File file = new File("E:/personal/dev/practice/workUsers.dat");
			if (!file.exists()) {
				User user = new User(1, "Mahesh", "Teacher");
				userList = new ArrayList<User>();
				userList.add(user);
				saveUserList(userList);
			} else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				userList = (List<User>) ois.readObject();
				ois.close();
			}
		} catch (IOException e) {
			logger.debug(e.getMessage());
		} catch (ClassNotFoundException e) {
			logger.debug(e.getMessage());
		}
		return userList;
	}

	private void saveUserList(List<User> userList) {
		try {
			File file = new File("E:/personal/dev/practice/workUsers.dat");
			FileOutputStream fos;
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(userList);
			oos.close();
		} catch (FileNotFoundException e) {
			logger.debug(e.getMessage());
		} catch (IOException e) {
			logger.debug(e.getMessage());
		}
	}
}
