package threadPipeline3;

public class Product {
    //商品属性， 品牌， 名字

    private String brand;
    private String name;

    //没有商品呢， 所以初始值弗拉瑟， 如果==true， 那么就不生产，消费者消费
    boolean flag= false;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //生产
    public synchronized void setProduct(String brand, String name) {
        if(flag==true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setBrand(brand);
        try {
            Thread.sleep( 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setName(name);
        System.out.println("生产者生产了"+this.getBrand()+"-----"+this.getName());

        flag=true;
        notify();
    }
    //消费
    public synchronized void getProduct(){
        if(!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费者消费了"+ this.getBrand()+"-----"+this.getName());

        flag= false;
        notify();
    }
}
