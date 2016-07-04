package Problem03_WildFarm.foods;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public abstract class Food {
    int quantity;

    public Food(int quantity) {
        this.setQuantity(quantity);
    }

    public int getQuantity() {

        return quantity;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
