package threadPipeline2;

public class Customer extends Thread{
    private Product p;

    public Customer(Product p){
        this.p = p;
    }

    @Override
    public void run() {
        for(int i = 1; i<=10; i++){
            synchronized (p){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者消费了"+ p.getBrand()+"-----"+p.getName());
            }
        }
    }
}
