package threadPipeline3;

public class test {
    public static void main(String[] args) {
        //创建一个共享商品

        Product p = new Product();

        Customer ct = new Customer(p);
        Producer pt = new Producer(p);
        pt.start();
        ct.start();

    }
}
