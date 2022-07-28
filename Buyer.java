public class Buyer {
    Manufacturer manufacturer;

    public Buyer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public synchronized void buyCar() {
        try {
            System.out.println("Покупатель " + Thread.currentThread().getName() + ": Хочу купить автомобиль.");
            System.out.println("Кол-во машин: " + manufacturer.getCountCars());
            while (manufacturer.getCountCars() == 0) {
                System.out.println("Покупатель " + Thread.currentThread().getName() + ": жаль, что еще нет машин! Придется подождать.");
                wait();
            }
            manufacturer.sallCar();
            System.out.println("Кол-во машин: " + manufacturer.getCountCars());
            System.out.println("Покупатель " + Thread.currentThread().getName() + ": Ура, свершилась мечта!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void newDelivery() {
        try {
            System.out.println("Прибыла партия автомобилей.");
            manufacturer.newCars();
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
