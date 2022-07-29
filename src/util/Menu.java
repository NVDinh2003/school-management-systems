package util;

import java.util.ArrayList;

public class Menu {
	private String menuTitle;
	private ArrayList<String> optionList = new ArrayList<String>();

	public Menu(String menuTitle) {
		this.menuTitle = menuTitle;
	}

	public void addNewOption(String newOption) {
		optionList.add(newOption);
	}

	public void printMenu() {
		if (optionList.isEmpty()) {
			System.out.println("There is no item in the menu");
			return;
		}
		System.out.println("\n------------------------------------\n");
		System.out.println("Welcome to " + menuTitle);
		for (String x : optionList)
			System.out.println(x);
	}

	public int getChoice() {
		int maxOption = optionList.size();
		String inputMsg = "Chọn [1.." + maxOption + "]: ";
		String errorMsg = "You are required to choose the option 1.." + maxOption;
		return CheckInput.getAnInteger(inputMsg, errorMsg, 1, maxOption);

	}

	public int getMaxOption() {
		return optionList.size();
	}
}