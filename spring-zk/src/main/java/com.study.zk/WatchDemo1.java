package com.study.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

/**
 * @author :LiuYang
 * @desc
 * @date :2021/2/8/008 14:54
 **/
public class WatchDemo1 {
    static List<String> children = null;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zkCli = new ZooKeeper(ZkPutFileTest.connectStr, 3000,
                new Watcher() {
                    // 监听回调
                    @Override
                    public void process(WatchedEvent event) {
                        System.out.println("正在监听中......");
                    }
                });

        // 监听目录
        children = zkCli.getChildren("/", new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("监听路径为：" + event.getPath());
                System.out.println("监听的类型为：" + event.getType());
                System.out.println("监听被修改了！！！");
                for (String c : children) {
                    System.out.println(c);
                }
            }
        });
        Thread.sleep(Long.MAX_VALUE);
    }
}
