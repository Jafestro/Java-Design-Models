package Adapter;

public class Main {
    public static void main(String[] args) {
        CalendarToNewDateAdapter adapter = new CalendarToNewDateAdapter();

        adapter.setDay(13);
        adapter.setMonth(11);
        adapter.setYear(2024);

        System.out.println(adapter.getDay() + "." + adapter.getMonth() + "." + adapter.getYear());

        adapter.advanceDays(5);

        System.out.println(adapter.getDay() + "." + adapter.getMonth() + "." + adapter.getYear());
    } 
}
