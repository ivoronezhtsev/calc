package calc;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		ICalc calc = new Calc(new Scanner(System.in));
		calc.process();
	}

}
