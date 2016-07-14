package edu.globant.day1;

import edu.globant.day1.interfaces.Validator;
import edu.globant.day1.interfaces.Validator2;

public class ValidatorImpl implements Validator, Validator2 {

//	public boolean isEmpty(String str) {
//		return str == null;
//	}

	public static void main(String[] args) {
		Validator2 val = new ValidatorImpl();
		System.out.println(val.isEmpty(null));
		System.out.println(val.isEmpty(""));
		System.out.println(Validator.isEmpty(null));
		System.out.println(Validator.isEmpty(""));
	}
}
