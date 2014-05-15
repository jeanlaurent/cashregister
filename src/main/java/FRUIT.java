public enum FRUIT {
    POMME  (100, 100, -1, true),
    APPLE  (100, 100,  3, true),
    MELE   (100,  50,  2, true),
    BANANE (150, 150,  2, false),
    CERISE ( 75,  20,  2, false);

    public final long price;
    public final long discount;
    public final int discountTreshold;
    public final boolean pommeFamily;

    FRUIT(int price, int discount, int discountTreshold, boolean pommeFamily) {
        this.price = price;
        this.discount = discount;
        this.discountTreshold = discountTreshold;
        this.pommeFamily = pommeFamily;
    }

    public long discountedPrice(long numberOfFruit) {
        long price = this.price;
        if (this.discountTreshold > 0 && numberOfFruit % this.discountTreshold == 0) {
            price -= this.discount;
        }
        return price;
    }
}