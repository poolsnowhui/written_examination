import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author
 *
 */
public class Main {
	int income[]; // 收入
	int payment[]; // 开销
	int profit[]; // 利润
	Calendar cale1[];
	Calendar cale2[];
	int inAll = 0; // 总收入
	int payAll = 0; // 总开销
	int proAll = 0; // 总利润

	/**
	 * 
	 * @param length
	 */
	public Main(int length) {
		this.income = new int[length];
		this.payment = new int[length];
		this.profit = new int[length];
		this.cale1 = new Calendar[length];
		this.cale2 = new Calendar[length];
	}

	public static void main(String[] args) {
		String in = "2016-06-02 20:00~22:00 7\n" + "2016-06-03 09:00~12:00 14\n" + "2016-06-04 14:00~17:00 22\n"
				+ "2016-06-05 19:00~22:00 3\n" + "2016-06-06 12:00~15:00 15\n" + "2016-06-07 15:00~17:00 12\n"
				+ "2016-06-08 10:00~13:00 19\n" + "2016-06-09 16:00~18:00 16\n" + "2016-06-10 20:00~22:00 5\n"
				+ "2016-06-11 13:00~15:00 11";
		String input[] = { "2016-06-02 20:00~22:00 7", "2016-06-03 09:00~12:00 14", "2016-06-04 14:00~17:00 22",
				"2016-06-05 19:00~22:00 3", "2016-06-06 12:00~15:00 15", "2016-06-07 15:00~17:00 12",
				"2016-06-08 10:00~13:00 19", "2016-06-09 16:00~18:00 16", "2016-06-10 20:00~22:00 5",
				"2016-06-11 13:00~15:00 11" };

		Main main = new Main(input.length);
		System.out.println(main.generateSummary(in));
//		System.out.println(main.generateSummary(input));
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// Calendar c = new GregorianCalendar();
		// System.out.println(sdf.format(c.getTime()));
		// System.out.println(c.get(Calendar.YEAR));
		// System.out.println(c.get(Calendar.MONTH+1));
		// System.out.println(c.get(Calendar.DAY_OF_MONTH));
		// System.out.println(c.get(Calendar.HOUR_OF_DAY));
		// System.out.println(c.get(Calendar.MINUTE));
		// System.out.println(c.get(Calendar.SECOND));
		// System.out.println(c.get(Calendar.MILLISECOND));
	}

	public String generateSummary(String in) {
		return generateSummary(in.split("\n"));
	}

	public String generateSummary(String input[]) {
		StringBuffer ret = new StringBuffer("[Summary]\n\n");
		for (int i = 0; i < input.length; i++) {

			String str[] = input[i].split(" ");
			String zone[] = str[1].split("~");
			// System.out.println(str[0] + "," + str[1]);
			// System.out.println(zone[0] + "," + zone[1]);
			SimpleDateFormat nyr = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
			try {
				Date d = nyr.parse(str[0]);
				cale1[i] = Calendar.getInstance();
				cale1[i].setTime(d);
				cale2[i] = Calendar.getInstance();
				cale2[i].setTime(d);

				Calendar c = Calendar.getInstance();
				c.setTime(sf.parse(zone[0]));
				cale1[i].set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY));
				c.setTime(sf.parse(zone[1]));
				cale2[i].set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY));

			} catch (ParseException e) {
				e.printStackTrace();
			}
			int M = Integer.valueOf(str[2]);
			payment[i] = diChang(M) * price(cale1[i], cale2[i]);// 花费
			payAll += payment[i];

			if (payment[i] != 0) {
				income[i] = M * 30;// 收入
			} else {
				income[i] = 0;
			}
			inAll += income[i];

			profit[i] = income[i] - payment[i];// 利润
			proAll += profit[i];

			ret.append(str[0]).append(" ").append(str[1]).append(" +");
			ret.append(income[i]);
			ret.append(" -");
			ret.append(payment[i]);
			ret.append(" ");
			if (profit[i] > 0)
				ret.append("+");

			ret.append(profit[i]);
			ret.append("\n");
		}
		// 循环

		ret.append("\nTotal Income: ");
		ret.append(inAll);
		ret.append("\nTotal Payment: ");
		ret.append(payAll);
		ret.append("\nProfit: ");
		ret.append(proAll);
		ret.append("\n");

		return ret.toString();
	}

	/**
	 * 
	 * @param M
	 *            算来了M个人
	 * @return 需要租的场地
	 */
	public int diChang(int M) {// 算来了M个人，需要租的场地
		int X = M % 6;
		int T = M / 6;
		// System.out.println("T"+T);
		// System.out.println("X"+X);
		if (T == 0 && X < 4)
			return 0;
		else if (T == 0 && X >= 4)
			return 1;
		else if (T == 1)
			return 2;
		else if ((T == 2 || T == 3) && X >= 4)
			return T + 1;
		else if ((T == 2 || T == 3) && X < 4)
			// {System.out.println(T);
			return T;
		else
			return T;
	}

	/**
	 * 
	 * @param date1
	 *            开始时间
	 * @param date2
	 *            结束时间
	 * @return 时间段单场的价格
	 */
	public int price(Calendar cale1, Calendar cale2) {// 算时间段的价格
		int week_index = cale1.get(Calendar.DAY_OF_WEEK) - 1;
		// System.out.println("星期" + week_index);

		int huafei = 0, s = cale1.get(Calendar.HOUR_OF_DAY);
		int e = cale2.get(Calendar.HOUR_OF_DAY);
		// System.out.println(s);
		// System.out.println(e);
		for (int i = s; i < e; i++) {
			if (week_index >= 1 && week_index <= 5) {
				// System.out.println(i);
				switch (i) {// 小时
				case 9:
				case 10:
				case 11:
					huafei += 30;
					break;
				case 12:
				case 13:
				case 14:
				case 15:
				case 16:
				case 17:
					huafei += 50;
					break;
				case 18:
				case 19:
					huafei += 80;
					break;
				case 20:
				case 21:
					huafei += 60;
					break;
				default:
					break;
				}
			} else {
				// System.out.println(i);
				switch (i) {// 小时
				case 9:
				case 10:
				case 11:
					huafei += 40;
					break;
				case 12:
				case 13:
				case 14:
				case 15:
				case 16:
				case 17:
					huafei += 50;
					break;
				case 18:
				case 19:
				case 20:
				case 21:
					huafei += 60;
					break;
				default:
					break;
				}
			}

		}
		return huafei;
	}

}
