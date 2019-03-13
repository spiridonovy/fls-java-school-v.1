package package_hw6.start;


public class Start {

	public static void main(String[] args) {

		PriorityDeque<String> deque = new PriorityDeque<String>();

		deque.add("десятый", 10);
		deque.add("Второй", 2);
		deque.add("Первый", 1);
		deque.add("тридцать четыре", 34);
		deque.add("шестнадцать", 16);
		deque.add("четыре", 4);

		while (deque.size() > 0){
			System.out.println(deque.getLast());
		}
	}


}