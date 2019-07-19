package com.up.javaProgs;

public class Switch_Eg {

	public static void main(String[] args) {
	
int switchCase =89;

switch(switchCase) {
case 1: 
	System.out.println("Its 1 ");
	break;
case 2:
	System.out.println(("Its 2"));
	break;
case 3: case 4: case 5:
	System.out.println("may be 3 or 4 or 5");
	System.out.println("And acctual value is " +  switchCase);
	break;
	default: 
	System.out.println("None of the value");
	break;
}

String switchCase2 ="JanuarY";
switch(switchCase2.toLowerCase()) {
case "january":
	System.out.println("Its Jan");
	break;
case "february":
	System.out.println("Its Feb");
	break;
default:
	System.out.println("Not Sure!");
	break;
}

	}
}
