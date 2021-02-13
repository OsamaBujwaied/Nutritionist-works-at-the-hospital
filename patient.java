import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class patient extends foodCaloric {
	public static foodCaloric[][][] meal = new foodCaloric[31][3][5];

	private static double foodGrameT;
	private static double beveragesMlT;

	public patient(String name, double portion, String unit, int cal, int fat, int carbon, int protein) {
		super(name, portion, unit, cal, fat, carbon, protein);
	}

	public static void main(String[] args) {
		patient.MainMenufood();

		Scanner scan = new Scanner(System.in);
		//sort();
		//showList();
		//search();
		//FilterFoodBeverages();
		
		
		foodGrameT = 0;
		beveragesMlT = 0;
		double foodGrame = 0;
		double beveragesMl = 0;
		int[][] edibles = new int[3][];

		for (int day = 1; day <= 31; day++) {
			System.out.println("\n////////////////////////////////////////////////////");

			System.out.println("\nFor the day " + day + " of the month");

			System.out.println("Choose the number of edibles to the first meal");
			meal[day][0] = new foodCaloric[scan.nextInt()];
			System.out.println("Choose  edibles of the first meal");
			for (int i = 0; i < meal[day][0].length; i++) {
				meal[day][0][i] = food.get(scan.nextInt() - 1);
			}
			System.out.println("\nThe edibles of the first meal:\n ");
			for (int i = 0; i < meal[day][0].length; i++) {
				System.out.println("food number " + (i + 1) + " \n" + meal[day][0][i]);
			}

			System.out.println("Choose the number of edibles to the second meal");
			meal[day][1] = new foodCaloric[scan.nextInt()];
			System.out.println("Choose  edibles of the second meal");
			for (int i = 0; i < meal[day][1].length; i++) {
				meal[day][1][i] = food.get(scan.nextInt() - 1);
			}
			System.out.println("\nThe edibles of the second meal:\n ");
			for (int i = 0; i < meal[day][1].length; i++) {
				System.out.println("food number " + (i + 1) + " \n" + meal[day][1][i]);
			}

			System.out.println("Choose the number of edibles to the third meal");
			meal[day][2] = new foodCaloric[scan.nextInt()];
			System.out.println("Choose  edibles of the third meal");
			for (int i = 0; i < meal[day][2].length; i++) {
				meal[day][2][i] = food.get(scan.nextInt() - 1);
			}
			System.out.println("\nThe edibles of the third meal:\n ");
			for (int i = 0; i < meal[day][2].length; i++) {
				System.out.println("food number " + (i + 1) + " \n" + meal[day][2][i]);
			}

			foodGrame = 0;
			beveragesMl = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < meal[day][i].length; j++) {
					if (meal[day][i][j].getUnit().equals("g"))
						foodGrame += meal[day][i][j].getPortion();
					else
						beveragesMl += meal[day][i][j].getPortion();
				}
			}
			foodGrameT += foodGrame;
			beveragesMlT = beveragesMl;

			System.out.println("The total food weight by g for the day " + day + " = " + foodGrame
					+ " ,and the drink amount by ml = " + beveragesMl + "\n");

			System.out.println("The edibles of the day " + day + " of the month are: ");
			for (int i = 0; i < 3; i++) {
				System.out.println("\nMeal number " + (i + 1) + " edibles:");
				for (int j = 0; j < meal[day][i].length; j++) {
					System.out.println(meal[day][i][j].toString2());
				}
			}
		}
	}
}