package threadPipeline3;

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
            if(i %2 == 0){
                //生产的是费列罗巧克力
                p.setProduct("费列罗","巧克力");
            }else{
                p.setProduct("哈尔滨", "啤酒");
            }

        }
    }
}
