package com.up.javaProgs;

public class Switch_Challange {
	public static void main(String[] args) {
		printDayOfTheWeek(10);
	}
	public static void printDayOfTheWeek(int day) {
		switch(day){
		case 0:
			System.out.println("Yeyy!!! Its Sunday");
			break;
		case 1:
			System.out.println("Yeyy!!! Its Monday");
			break;
		case 2:	
			System.out.println("Yeyy!!! Its Tuesday");
			break;
		case 3:
			System.out.println("Yeyy!!! Its Wednesday");
			break;
		case 4:
			System.out.println("Yeyy!!! Its Thursday");
			break;
		case 5:
			System.out.println("Yeyy!!! Its Friday");
			break;
		case 6:
			System.out.println("Yeyy!!! Its Saturday");
			break;
		default:
			System.out.println("You entered a wrong day");
			break;
		}
	}
}
