package com.study.zk;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author :LiuYang
 * @desc
 * 使用zookeeper存放文件到zookeeper上
 * @date :2021/2/8/008 14:10
 **/
@Slf4j
public class ZkPutFileTest {
    public static String connectStr="192.168.14.123:2181,192.168.14.124:2181,192.168.14.125:2181";
    private static int time=5000;
    public static void main(String[] args) {
        File file=new File("text.txt");
        try {
            if(!file.exists()){
               file.createNewFile();
            }
            FileOutputStream outputStream=new FileOutputStream(file);
            String s="hello world";
            outputStream.write(s.getBytes());
            ZkClient zkClient=new ZkClient(connectStr,time);
            zkClient.connectZk();
            zkClient.createNode();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static class ZkClient{
        private ZooKeeper zk;
        private final String connectStr;
        private final int timeOut;

        public ZkClient(String connectStr, int timeOut) {
            this.connectStr = connectStr;
            this.timeOut = timeOut;
        }

        public void connectZk(){
            try {
                zk=new ZooKeeper(connectStr, timeOut, new Watcher() {
                    @Override
                    public void process(WatchedEvent watchedEvent) {
                        try {
                           List<String> list= zk.getChildren("/",true);
                           for(String s:list){
                               log.info("child:{}",s);
                           }
                        } catch (KeeperException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                log.info("zookeeper连接异常:{}",e.getMessage());
            }
        }

        public void createNode() throws KeeperException, InterruptedException {
            String path = zk.create("/hello", "world".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            log.info("path:{}",path);
        }

        public ZooKeeper getZk() {
            return zk;
        }
    }

}
