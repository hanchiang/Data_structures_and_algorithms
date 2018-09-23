public class Result {
    int maxLeftIndex;
    int maxRightIndex;
    int sum;

    public Result() { }

    public Result(int left, int right, int total) {
        this.maxLeftIndex = left;
        this.maxRightIndex = right;
        this.sum = total;
    }
}