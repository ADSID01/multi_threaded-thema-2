import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final int TIME_VISIT = 2000;
        final int COUNT_CARS = 10;
        final int TIME_DELIVERY = 2000;

        List<String> nameBuyers = new ArrayList<>();
        nameBuyers.add("Иван");
        nameBuyers.add("Дмитрий");
        nameBuyers.add("Оксана");
        nameBuyers.add("Григорий");
        nameBuyers.add("Олег");
        nameBuyers.add("Елена");
        nameBuyers.add("Юлия");
        nameBuyers.add("Ирина");
        nameBuyers.add("Андрей");
        nameBuyers.add("Денис");

        Manufacturer manufacturer = new Manufacturer();
        Runnable shopping = manufacturer::carSale;

        for(int i=0; i<COUNT_CARS;i++) {
            try {
                Thread thread = new Thread(shopping, nameBuyers.get(i));
                thread.start();
                Thread.sleep(TIME_VISIT);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        Runnable runNewDelivery = manufacturer::newDeliveryCars;
        for(int i=0; i<COUNT_CARS;i++) {
            try {
                Thread thread = new Thread(runNewDelivery, "Партия авто");
                thread.start();
                Thread.sleep(TIME_DELIVERY);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}