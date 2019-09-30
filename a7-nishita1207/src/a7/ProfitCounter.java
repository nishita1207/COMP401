package a7;

public class ProfitCounter implements BeltObserver {

    private Belt b;
    private double finalProfit = 0;
    private int plateNumber = 0;

    public ProfitCounter(Belt b) {
        if (b == null) {
            throw new IllegalArgumentException();
        } else {
            this.b = b;
        }

        b.addBeltObserver(this);


        for (int i = 0; i < b.getSize(); i++) {
            if (b.getPlateAtPosition(i) != null) {
                plateNumber++;
                finalProfit += b.getPlateAtPosition(i).getProfit();

            }
        }
    }

    public double getTotalBeltProfit() {

        double total_profit = 0;

        for (int i = 0; i < b.getSize(); i++) {
            if (b.getPlateAtPosition(i) != null) {
                total_profit += b.getPlateAtPosition(i).getProfit();
            }
        }

        return total_profit;
    }

    public double getAverageBeltProfit() {

        int num = 0;


        for (int i = 0; i < b.getSize(); i++) {
            if (b.getPlateAtPosition(i) != null) {
                num++;
            }
        }

        if (num == 0) {
            return 0.0;
        } else {
            return getTotalBeltProfit() / num;
        }

    }

    @Override
    public void handlePlateEvent(PlateEvent e) {

        switch (e.getType()) {
            case PLATE_PLACED:
                double placed = e.getPlate().getProfit();
                plateNumber++;
                finalProfit += placed;
                break;
            case PLATE_REMOVED:
                double removed = e.getPlate().getProfit();
                plateNumber--;
                finalProfit -= removed;
                break;
        }

    }
}