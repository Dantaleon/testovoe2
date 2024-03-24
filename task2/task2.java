package task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Имя      |Возраст|Должность                |Зарплата
	Кирилл   |26     |Middle java dev          |150000 руб
	Виталий  |28     |Senior java automation QA|2000$
	Александр|31     |junior functional tester |50000 руб
	Дементий |35     |dev-ops                  |1500$

 */

public class task2 {

	public static void main(String[] args) {

		List<Map<String, String>> table = new ArrayList<Map<String, String>>();
		
		// rows adding
		Map<String, String> rowMap = new HashMap<String, String>();  // 1st row
		rowMap.put("Имя", "Кирилл");
		rowMap.put("Возраст", "26");
		rowMap.put("Должность", "Middle java dev");
		rowMap.put("Зарплата", "150000 руб");
		table.add(rowMap);
		
		rowMap = new HashMap<String, String>();                       // 2nd row
		rowMap.put("Имя", "Виталий");
		rowMap.put("Возраст", "28");
		rowMap.put("Должность", "Senior java automation QA");
		rowMap.put("Зарплата", "2000$");
		table.add(rowMap);
		
		rowMap = new HashMap<String, String>();                       // 3rd row
		rowMap.put("Имя", "Александр");
		rowMap.put("Возраст", "31");
		rowMap.put("Должность", "junior functional tester");
		rowMap.put("Зарплата", "50000 руб");
		table.add(rowMap);
		
		rowMap = new HashMap<String, String>();                       // 4th row
		rowMap.put("Имя", "Дементий");
		rowMap.put("Возраст", "35");
		rowMap.put("Должность", "dev-ops");
		rowMap.put("Зарплата", "1500$");
		table.add(rowMap);
		
		// Выполнение задач
		
		List<String> namesAgeLT30 = new ArrayList<String>(); // for emp names where age < 30
		List<String> namesSalRub = new ArrayList<String>();  // for emp names where salary in rub
		int sumAge = 0; // for sum emp age
		
		// Обработка нужных значений за 1 проход по строкам таблицы
		
		for (Map<String, String> row : table) {
			
			// суммирование возраста
			int age = Integer.parseInt(row.get("Возраст"));
			
			sumAge += age;
			
			// обработка возраста
			if (age < 30) namesAgeLT30.add(row.get("Имя"));
			
			// обработка зарплаты
			if (row.get("Зарплата").contains("руб"))
				namesSalRub.add(row.get("Имя"));
		}
	
		// Вывод результатов
		System.out.println("Имена всех сотрудников младше 30:");
		System.out.println(namesAgeLT30.toString());
		
		System.out.println("Имена всех сотрудников, получающих ЗП в рублях:");
		System.out.println(namesSalRub.toString());
		
		System.out.println("Средний возраст сотрудников:");
		System.out.println(sumAge * 1.0 / table.size());
		
	}

}
