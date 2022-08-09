public class Carculator {

    private ICarcluator iCarcluator;

    public Carculator(ICarcluator iCarcluator){
        this.iCarcluator = iCarcluator;
    }

    public int sum(int x, int y){
        return this.iCarcluator.sum(x, y);
    }

    public int minus(int x, int y){
        return this.iCarcluator.minus(x, y);
    }

}
