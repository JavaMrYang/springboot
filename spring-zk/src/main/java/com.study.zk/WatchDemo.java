package com.study.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @author :LiuYang
 * @desc
 * @date :2021/2/8/008 14:53
 **/
public class WatchDemo {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zkCli = new ZooKeeper(ZkPutFileTest.connectStr, 3000,
                new Watcher() {
                    // 监听回调
                    @Override
                    public void process(WatchedEvent event) {

                    }
                });

        byte[] data = zkCli.getData("/hello", new Watcher() {
            // 监听的具体内容
            @Override
            public void process(WatchedEvent event) {
                System.out.println("监听路径为：" + event.getPath());
                System.out.println("监听的类型为：" + event.getType());
                System.out.println("监听被修改了！！！");
            }
        }, null);

        System.out.println(new String(data));
        Thread.sleep(Long.MAX_VALUE);
    }
}
