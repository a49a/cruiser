package me.cruiser.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReadHdfsExample {
    public static void main(String[] args) {
        String fileName = "";
        Path path = new Path(fileName);
        Configuration conf = new Configuration();
        FileSystem fs;
        FSDataInputStream inputStream = null;
        BufferedReader reader = null;
        try {
            fs = FileSystem.get(conf);
            // 向NN:9000 getFileInfo() 获取 HdfsFileStatus。
            // 再执行getBlockLocations()，默认返回10个Block，NN根据距离返回的时候已经排好序。
            inputStream = fs.open(path);
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            // 最近的DN读，完整性校验失败，换一个DN继续。
            //
            while ((line = reader.readLine()) != null) {
                System.out.println("Record: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
