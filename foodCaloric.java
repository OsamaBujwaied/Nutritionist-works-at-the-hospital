import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class foodCaloric {
	public static ArrayList<foodCaloric> food = new ArrayList<foodCaloric>();
	private String name;
	private double portion;
	private String unit;
	private int cal;
	private int fat;
	private int carbon;
	private int protein;

	public foodCaloric(String name, double portion, String unit, int cal, int fat, int carbon, int protein) {
		this.name = name;
		this.portion = portion;
		this.cal = cal;
		this.unit = unit;
		this.fat = fat;
		this.carbon = carbon;
		this.protein = protein;
	}

	public foodCaloric() {

	}

	public String toString() {
		return "Name: " + name + "\nPortion: " + portion + "\nCal: " + cal + "\nUnit: " + unit + "\nFat: " + fat
				+ "\nCarbon: " + carbon + "\nProtein: " + protein + "\n";
	}

	public String toString2() {
		return name + "\t" + portion + "\t" + unit + "\t" + cal + "\t" + fat + "\t" + carbon + "\t" + protein + "\t";
	}

	public String getName() {
		return name;
	}

	public double getPortion() {
		return portion;
	}

	public String getUnit() {
		return unit;
	}

	public int getCal() {
		return cal;
	}

	public int getFat() {
		return fat;
	}

	public int getCarbon() {
		return carbon;
	}

	public int getProtein() {
		return protein;
	}

	public static void MainMenufood() {
		try {
			Scanner read = new Scanner(new FileInputStream("nutritionvalues-data.csv"));

			read.nextLine();
			read.nextLine();

			read.hasNextLine();
			read.hasNextLine();
			read.hasNextLine();

			String content;

			String name;
			double portion;
			String unit;
			int cal;
			int fat;
			int carbon;
			int protein;

			while (read.hasNextLine()) {
				content = read.nextLine();

				if (content.contains(",,,") == false) {

					if (content.contains("\"")) {

						name = content.substring(1, content.lastIndexOf('"'));
						if (name.length() < 6)
							name += "\t\t\t\t\t";
						else if (name.length() < 12)
							name += "\t\t\t\t";
						else if (name.length() < 18)
							name += "\t\t\t";
						else if (name.length() < 24)
							name += "\t\t";
						else if (name.length() < 30)
							name += "\t";
						content = content.substring(content.lastIndexOf('"') + 2);
						// System.out.println(name);
					} else {
						name = content.substring(0, content.indexOf(","));
						if (name.length() < 6)
							name += "\t\t\t\t\t";
						else if (name.length() < 12)
							name += "\t\t\t\t";
						else if (name.length() < 18)
							name += "\t\t\t";
						else if (name.length() < 24)
							name += "\t\t";
						else if (name.length() < 30)
							name += "\t";
						content = content.substring(content.indexOf(',') + 1);
						// System.out.println(name);
					}

					portion = Double.parseDouble((content.substring(0, content.indexOf(','))));
					// System.out.println(portion);
					content = content.substring(content.indexOf(',') + 1);

					unit = content.substring(0, content.indexOf(','));
					// System.out.println(unit);
					content = content.substring(content.indexOf(',') + 1);

					cal = Integer.parseInt((content.substring(0, content.indexOf(','))));
					// System.out.println(cal);
					content = content.substring(content.indexOf(',') + 1);

					fat = Integer.parseInt((content.substring(0, content.indexOf(','))));
					// System.out.println(fat);
					content = content.substring(content.indexOf(',') + 1);

					carbon = Integer.parseInt((content.substring(0, content.indexOf(','))));
					// System.out.println(carbon);
					content = content.substring(content.indexOf(',') + 1);

					protein = Integer.parseInt(content);
					// System.out.println(protein);

					// System.out.println(content);

					food.add(new foodCaloric(name, portion, unit, cal, fat, carbon, protein));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("captured");
		}
	}

	public static void showList() {
		for (int i = 0; i < food.size(); i++) {
			System.out.println((i + 1) + "\t" + food.get(i).toString2());
		}
	}

	public static void FilterFoodBeverages() {
		System.out.println("Do you want to filter food and beverages");
		Scanner scan = new Scanner(System.in);

		if (scan.next().equalsIgnoreCase("yes")) {

			System.out.println("Choose (food) or (beverages)");
			String kind = scan.next();

			if (kind.equalsIgnoreCase("Beverages")) {
				for (int i = 0; i < food.size(); i++) {
					if (food.get(i).unit.equalsIgnoreCase("ml"))
						System.out.println((i + 1) + "\t" + food.get(i).toString2());
				}
			}
			if (kind.equalsIgnoreCase("food")) {
				for (int i = 0; i < food.size(); i++) {
					if (food.get(i).unit.equalsIgnoreCase("g"))
						System.out.println((i + 1) + "\t" + food.get(i).toString2());
				}
			}
		}
	}

	public static void search() {
		System.out.print("Do you want to search for specific food (yes or no) >");
		Scanner scan = new Scanner(System.in);

		if (scan.next().equalsIgnoreCase("yes")) {

			System.out.println("Write the it's name> ");
			String search = scan.next();

			for (int i = 0; i < food.size(); i++) {
				if (food.get(i).name.contains(search))
					System.out.println((i + 1) + "\t" + food.get(i).toString2());
				
			}
		} else
			showList();
	}

	public static void sort() {
		Scanner scan = new Scanner(System.in);

		System.out.print("Do you want to sort the food list>");
		if (scan.next().equalsIgnoreCase("yes")) {
			System.out.print("Choose the kind of sort: 0(name) 1(calories) 2(protein)>");
			int kindSort = scan.nextInt();
			System.out.print("Choose the type of sort: 1(low to high) 2(high to low)>");
			int typeSort = scan.nextInt();

			ArrayList<foodCaloric> foodSorted = food;
			foodCaloric check = new foodCaloric();

			if (kindSort == 0) {
				for (int i = 0; i < foodSorted.size() - 1; i++) {
					for (int j = i + 1; j < foodSorted.size(); j++) {
						if (foodSorted.get(i).name.compareTo(foodSorted.get(j).name)>0) {
							check = foodSorted.get(i);
							foodSorted.set(i, foodSorted.get(j));
							foodSorted.set(j, check);
						}
					}
				}
			}
			
			if (kindSort == 1) {
				for (int i = 0; i < foodSorted.size() - 1; i++) {
					for (int j = i + 1; j < foodSorted.size(); j++) {
						if (foodSorted.get(i).cal > foodSorted.get(j).cal) {
							check = foodSorted.get(i);
							foodSorted.set(i, foodSorted.get(j));
							foodSorted.set(j, check);
						}
					}
				}
			}
			if (kindSort == 2) {
				for (int i = 0; i < foodSorted.size() - 1; i++) {
					for (int j = i + 1; j < foodSorted.size(); j++) {
						if (foodSorted.get(i).protein > foodSorted.get(j).protein) {
							check = foodSorted.get(i);
							foodSorted.set(i, foodSorted.get(j));
							foodSorted.set(j, check);
						}
					}
				}
			}
			if (typeSort == 2) {
				for (int i = 0; i < (double) foodSorted.size() / 2; i++) {
					check = foodSorted.get(i);
					foodSorted.set(i, food.get(food.size() - 1 - i));
					foodSorted.set(food.size() - 1 - i, check);
				}
			}
			for (int i = 0; i < foodSorted.size(); i++) {
				System.out.println((i + 1) + "\t" + foodSorted.get(i).toString2());
			}
		}
	}

	public static void sort2(int kindSort, int typeSort) {

		ArrayList<foodCaloric> foodSorted = food;
		foodCaloric check = new foodCaloric();
		
		if (kindSort == 0) {

		
		
		}
		
		if (kindSort == 0) {
			for (int i = 0; i < foodSorted.size() - 1; i++) {
				for (int j = i + 1; j < foodSorted.size(); j++) {
					if (foodSorted.get(i).name.compareTo(foodSorted.get(j).name)>0) {
						check = foodSorted.get(i);
						foodSorted.set(i, foodSorted.get(j));
						foodSorted.set(j, check);
					}
				}
			}
		}
		
		if (kindSort == 1) {
			for (int i = 0; i < foodSorted.size() - 1; i++) {
				for (int j = i + 1; j < foodSorted.size(); j++) {
					if (foodSorted.get(i).cal > foodSorted.get(j).cal) {
						check = foodSorted.get(i);
						foodSorted.set(i, foodSorted.get(j));
						foodSorted.set(j, check);
					}
				}
			}
		}
		if (kindSort == 2) {
			for (int i = 0; i < foodSorted.size() - 1; i++) {
				for (int j = i + 1; j < foodSorted.size(); j++) {
					if (foodSorted.get(i).protein > foodSorted.get(j).protein) {
						check = foodSorted.get(i);
						foodSorted.set(i, foodSorted.get(j));
						foodSorted.set(j, check);
					}
				}
			}
		}
		if (typeSort == 2) {
			for (int i = 0; i < (double) foodSorted.size() / 2; i++) {
				check = foodSorted.get(i);
				foodSorted.set(i, food.get(food.size() - 1 - i));
				foodSorted.set(food.size() - 1 - i, check);
			}
		}
		for (int i = 0; i < foodSorted.size(); i++) {
			System.out.println((i + 1) + "\t" + foodSorted.get(i).toString2());
		}
	}

	public static void main(String[] args) {

	}
}
