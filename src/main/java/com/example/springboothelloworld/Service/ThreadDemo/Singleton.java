package com.example.springboothelloworld.Service.ThreadDemo;


/**
 * 单例模式：构造器私有化；
 * 1.懒汉式
 * 2.饿汉式
 */
public class Singleton {
    public static void main(String[] arg) {
//        Jvm jvm = Jvm.getInstance();
//        Jvm jvm2 = Jvm.getInstance();
//        System.out.println(jvm);
//        System.out.println(jvm2);

//        JvmThread thread1 = new JvmThread(100);
//        JvmThread thread2 = new JvmThread(500);
//        thread1.start();
//        thread2.start();

        MyJvm myJvm1=MyJvm.getInstance();
        MyJvm myJvm2=MyJvm.getInstance();
        System.out.println(myJvm1);
        System.out.println(myJvm2);

    }

}

/**
 * 懒汉式
 */
class Jvm {
    /**
     * 声明一个私有的静态变量
     */
    private static Jvm instance = null;
    /**
     * 构造器私有化
     */
    private Jvm() {
    }
    //创建一个公共的对外的静态方法访问该静态变量，如果没有就创建
    public static Jvm getInstance() {
        if (null == instance) {
        synchronized (Jvm.class) {
            if (null == instance) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance = new Jvm();
            }
        }
        }
        return instance;
    }
}

/**
 * 饿汉式
 */
class  MyJvm
{
    private static MyJvm instance=new MyJvm();
    private MyJvm()    {
    }
    public  static  MyJvm getInstance()    {
        return  instance;
    }
}

class JvmThread extends Thread {
    private long time;

    public JvmThread() {

    }

    public JvmThread(long time) {
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "===>创建:" + Jvm.getInstance());
    }
}