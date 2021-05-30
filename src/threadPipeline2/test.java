package threadPipeline2;

public class test {
    public static void main(String[] args) {
        //创建一个共享商品
        //这就是同步代码块的锁
        Product p = new Product();

        Customer ct = new Customer(p);
        Producer pt = new Producer(p);
        pt.start();
        ct.start();

    }
}
