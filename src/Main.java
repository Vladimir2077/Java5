import java.util.*;
public class Main {

    static void sortedPrint(Map<String, ArrayList> map) {
        Set<String> keySet = map.keySet();
        int maxCount = 0;
        int minCount = 1_000_000;
        for (var item : map.entrySet()) {
            if (maxCount < item.getValue().size())
                maxCount = item.getValue().size();
            if (minCount > item.getValue().size())
                minCount = item.getValue().size();
        }

        Stack<String> st = new Stack<>();
        int num = minCount;
        while (num <= maxCount) {
            for (var item : map.entrySet()) {
                if (item.getValue().size() == num) {
                    st.push(item.getKey());
                }
            }
            num += 1;
        }

        String name;
        for (int i = 0; i < keySet.size(); i++) {
            name = st.pop();
            for (var item : map.entrySet()) {
                if (name == item.getKey()) {
                    System.out.printf("%8s: ", item.getKey());
                    System.out.println(item.getValue());
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Map<String, ArrayList> abon = new HashMap<>() {
            {
                put("Кукушкин Н.Н.", new ArrayList<Integer>() {
                    {
                        add(323454);
                        add(123454);
                        add(427654);
                    }
                });
                put("Синицин Е.М.", new ArrayList<Integer>() {
                    {
                        add(443289);
                    }
                });
                put("Кузнецов И.С.", new ArrayList<Integer>() {
                    {
                        add(745677);
                        add(555555);

                    }
                });
                put("Пушкин А.С.", new ArrayList<Integer>() {
                    {
                        add(334455);
                        add(778899);
                        add(123456);
                        add(778890);
                    }
                });
            }
        };
        System.out.println();
        System.out.println("Исходные данные: ");
        sortedPrint(abon);
        Scanner scan = new Scanner(System.in, "cp866");
        Boolean getOut = false;
        String st;
        while (!getOut) {
            System.out.println("Введи номер операции (1 - добавить абонента, 9 - выход):");
            st = scan.nextLine();
            String name = "";
            String phString;
            switch (st) {
                case "1": {
                    System.out.println("Введите ФИО абонента через пробел:");
                    name = scan.nextLine();
                    if (abon.containsKey(name)) {
                        System.out.println("Неверный ввод! Такой абонент уже есть");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Введите номера телефонов через запятую: ");
                        phString = scan.nextLine();
                        String[] arr = phString.split(",");
                        ArrayList<Integer> arrInt = new ArrayList<>();
                        for (String item: arr) {
                            arrInt.add(Integer.parseInt(item.trim())) ;
                        }
                        abon.put(name, arrInt);
                        System.out.println();
                        sortedPrint(abon);
                        break;
                    }
                }
                case "9": {
                    getOut = true;
                    System.out.println();
                    System.out.println("До встречи!");
                    System.out.println();
                    break;
                }
            }
        }
    }
}