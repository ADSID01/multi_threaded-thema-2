
public class Manufacturer {
    private int countCars;
    protected final int TIME_VISIT = 4000;
    protected Buyer buyer = new Buyer(this);

    public Manufacturer() {
        countCars = 0;
    }

    protected int getCountCars() {
        return countCars;
    }

    protected void sallCar() {
        countCars--;
    }

    protected void newCars() {
        countCars++;
    }

    protected void newDeliveryCars() {
        buyer.newDelivery();
    }

    public void carSale() {

        System.out.println("Пришел покупатель " + Thread.currentThread().getName());
        buyer.buyCar();

        try {
            Thread.sleep(TIME_VISIT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
