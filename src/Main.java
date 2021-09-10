import java.util.Scanner;
import java.util.Stack;

/*
 * Abbiamo una calcolatrice a notazione postfissa.
 * Esempio inseriamo questi valori: 8 1 - 4 3 5 * + * =
 * 8 - 1 = 7
 * 3 * 5 = 15
 * 4 + 15 = 19
 * 7 * 19 = 133
 * Esempio inseriamo questi valori: 10 5 4 - 3 2 * + - =
 * 5 - 4 = 1
 * 3 * 2 = 6
 * 1 + 6 = 7
 * 10 - 7 = 3
 * Ci sono 4 errori che si possono generare a runtime di cui 3 sollevano un eccezione. Trovare gli errori
 * ed aggiungere i controlli opportuni.
 */
public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Inserire l'espressione da esaminare");
		System.out.println("(un elemento per riga, = per terminare)");
		Stack<Integer> stack = new Stack<Integer>();
		String row = input.nextLine();
		while(!row.equals("=")) {
			Integer sx, dx, result;
			char selector = row.charAt(0);
			switch(selector) {
				case '+':
				case '-':
				case '*':
				case '/':
					dx = stack.pop();
					sx = stack.pop();
					result = calculate(sx, dx, selector);
					stack.push(result);
					break;
				default:
					Integer n = Integer.parseInt(row);
					stack.push(n);
					break;
			}
			row = input.nextLine();
		}
		Integer result = stack.pop();
		System.out.println("Il risultato è " + result);
	}

	private static int calculate(Integer sx, Integer dx, char selector) {
		int result = 0;
		switch(selector) {
			case '+':
				result = sx + dx;
				break;
			case '-':
				result = sx - dx;
				break;
			case '*':
				result = sx * dx;
				break;
			case '/':
				result = sx / dx;
				break;
		}
		return result;
	}
}
