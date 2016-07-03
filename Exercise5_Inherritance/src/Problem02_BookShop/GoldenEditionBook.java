package Problem02_BookShop;

/**
 * Created by Bludya on 2.7.2016 г..
 * All rights reserved!
 */
public class GoldenEditionBook extends Book {

    public GoldenEditionBook(String author,
                              String title,
                              double price){
        super(author, title, price);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + super.getPrice() * 0.3;
    }

}
