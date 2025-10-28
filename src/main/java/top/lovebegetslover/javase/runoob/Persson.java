package top.lovebegetslover.javase.runoob;

/**
 * 反射测试类
 */
public class Persson implements action {

    public  String name="小狗";

    protected String lover;

    private Integer length;

    private Integer value=0;

    private boolean isMan = false;

    public Persson(String name, String lover, Integer length) {
        this.name = name;
        this.lover = lover;
        this.length = length;
    }

    public Persson() {
    }

    @Override
    public String toString() {
        return "Persson{" +
                "name='" + name + '\'' +
                ", lover='" + lover + '\'' +
                ", length=" + length +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLover() {
        return lover;
    }

    public void setLover(String lover) {
        this.lover = lover;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    //计时器 版本控制器
    public void publicModel(Integer value){
        //传入某一个事件 我们通过这个事件来进行版本迭代
        this.value=value;
    }

    @Override
    public String speak(String ask) {
        if (ask.equals("你好")){
            System.out.println("我也很好");
            return "结束";
        }else {
            return "我不好";
        }

    }
    @Override
    public void isMan(Boolean isMan) {
        this.isMan=isMan;
    }
}
