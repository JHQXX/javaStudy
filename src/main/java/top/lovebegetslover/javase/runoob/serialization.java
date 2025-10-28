package top.lovebegetslover.javase.runoob;

import java.io.*;

//要使一个类可以被序列化，就要实现序列化接口
public class serialization implements Serializable {
    private Integer a;
}


class Main{
    public static void main(String[] args) {
        serialization serialization = new serialization();
        try {
            FileOutputStream fileOut = new FileOutputStream("serialization.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(serialization);
            fileOut.close();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
}

class Main2{
    public static void main(String[] args) {
        serialization serialization = null;
        try {
            FileInputStream fileIn = new FileInputStream("serialization.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            in.close();
            fileIn.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}