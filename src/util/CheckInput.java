package util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class CheckInput {
	public static Scanner sc = new Scanner(System.in);

	public String dateEx(String inputMessage) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		while (true) {
			try {
				System.out.print(inputMessage);
				Date date = df.parse(sc.nextLine());
				return df.format(date);
			} catch (ParseException e) {
				System.out.print("Định dạng ngày dd/MM/yyyy\n");
				// e.printStackTrace();
			}
		}
	}

	public String gioiTinh() {
		String gender;
		do {
			System.out.print("Nhập giới tính: ");
			gender = sc.nextLine().toLowerCase();
			if (gender.equals("nam") || gender.equals("nu") || gender.equals("nữ"))
				return gender;
			else
				System.out.println("Lỗi !\n");
		} while (true);

	}

	private boolean checkPhone(String s) {
		for (int i = 1; i < s.length(); i++)
			if (!Character.isDigit(s.charAt(i)))
				return false;
		return true;
	}

	public String phoneEx() {
		String s;
		do {
			System.out.print("Nhập số điện thoại: ");
			s = sc.nextLine();
			if (s.isEmpty() || s.charAt(0) != '0' || !checkPhone(s) || s.length() < 10)
				System.out.println("Error !");
		} while (s.isEmpty() || s.charAt(0) != '0' || !checkPhone(s) || s.length() < 10);
		return s;
	}

	public String emailEx() {
		String email;
		do {
			System.out.print("Input email: ");
			email = sc.nextLine();
			if (!email.contains("@") || email.contains(" "))
				System.out.println("Error !");
		} while (!email.contains("@") || email.contains(" "));
		return email;
	}

	public StringBuilder fullNameEx(String msgi) {
		StringBuilder name = new StringBuilder();
		name.append(this.inputString(msgi).toLowerCase().trim());
		name.setCharAt(0, Character.toUpperCase(name.charAt(0)));

		for (int i = 1; i < name.length(); i++) {
			if (name.charAt(i) == ' ')
				if (name.charAt(i + 1) == ' ') {
					name.deleteCharAt(i + 1);
					i -= 1;
				} else
					name.setCharAt(i + 1, Character.toUpperCase(name.charAt(i + 1)));
		}

		return name;
	}

	public String address() {
		String address;
		do {
			System.out.print("Nhập địa chỉ: ");
			address = sc.nextLine();
			if (address.isEmpty())
				System.out.println("Lỗi !\n");
		} while (address.isEmpty());
		return address;

	}

	public int inputInteger(String inputMsg) {
		do {
			try {
				System.out.print(inputMsg);
				int n = Integer.parseInt(sc.nextLine());
				return n;
			} catch (Exception e) {
				System.out.println("Lỗi !\n");
			}
		} while (true);
	}

	public double inputDouble(String inputMsg) {
		do {
			try {
				System.out.print(inputMsg);
				double n = Double.parseDouble((sc.nextLine()));
				return n;
			} catch (Exception e) {
				System.out.println("Lỗi !\n");
			}
		} while (true);
	}

	public double inputDouble(String inputMsg, String errorMsg, int lowerBound) {
		do {
			try {
				System.out.print(inputMsg);
				double n = Double.parseDouble((sc.nextLine()));
				if (n < lowerBound)
					throw new Exception();
				return n;
			} catch (Exception e) {
				System.out.println(errorMsg);
				System.out.println();
			}
		} while (true);
	}

	public double inputDouble(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
		// nếu đầu vào lower > upper thì đổi chỗ
		if (lowerBound > upperBound) {
			int tmp = lowerBound;
			lowerBound = upperBound;
			upperBound = tmp;
		}
		do {
			try {
				System.out.print(inputMsg);
				double n = Double.parseDouble((sc.nextLine()));
				if (n < lowerBound || n > upperBound)
					throw new Exception();
				return n;
			} catch (Exception e) {
				System.out.println(errorMsg);
				System.out.println();
			}
		} while (true);
	}

	public String inputString(String inputMsg) {
		String x;
		do {
			System.out.print(inputMsg);
			x = sc.nextLine();
		} while (x.isEmpty());
		return x;
	}

	public String intputMoney(String inputMsg) {
		double money;
		do {
			try {
				System.out.print(inputMsg);
				money = Double.parseDouble(sc.nextLine());
				Locale locale = new Locale("vi", "VN");
				DecimalFormat f = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
				DecimalFormatSymbols fSymbol = new DecimalFormatSymbols();
				fSymbol.setGroupingSeparator('-');
				fSymbol.setCurrencySymbol("VNĐ");

				f.setDecimalFormatSymbols(fSymbol);
				return f.format(money);

			} catch (Exception e) {
				System.out.println("Lỗi !\n");
			}
		} while (true);
	}

	public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
		int n, tmp;
		// nếu đầu vào lower > upper thì đổi chỗ
		if (lowerBound > upperBound) {
			tmp = lowerBound;
			lowerBound = upperBound;
			upperBound = tmp;
		}
		while (true) {
			try {
				System.out.print(inputMsg);
				n = Integer.parseInt(sc.nextLine());
				if (n < lowerBound || n > upperBound)
					throw new Exception();
				return n;
			} catch (Exception e) {
				System.out.println(errorMsg);
			}
		}
	}

}
