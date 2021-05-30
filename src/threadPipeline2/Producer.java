package threadPipeline2;

public class Producer extends Thread{
    //生产者
    private Product p;

    public Producer(Product p){
        this.p = p;
    }

    //定义一个run

    @Override
    public void run() {
        for(int i = 1; i<=10; i++){
            synchronized (p){
                if(i %2 == 0){
                    //生产的是费列罗巧克力
                    p.setBrand("费列罗");
                    try {
                        Thread.sleep( 100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    p.setName("巧克力");
                }else{
                    p.setBrand("哈尔滨");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    p.setName("啤酒");
                }
                System.out.println("生产者生产了"+p.getBrand()+"-----"+p.getName());
            }
        }
    }
}
