package sample;

public class UnluckyException extends  Exception {
    protected String log = "13! How do you know?";

    public UnluckyException() {}

    public void logPrint() {
        System.out.println(this.log);
    }
}