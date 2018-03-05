package ru.job4j.tracker;

import jdk.nashorn.internal.objects.annotations.Constructor;

/**
 * @author tgenman
 * Created by tgenman on 3/5/18.
 */
public class MenuOutException extends RuntimeException {

		public MenuOutException(String msg) {
		super(msg);
	}
}
