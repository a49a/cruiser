package me.cruiser.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;


public class WriteHdfsExample {
    public static void main(String[] args) {
        String contents = "asd";
        String filename = "";
        Path path = new Path(filename);
        Configuration conf = new Configuration();
        FileSystem fs;
        FSDataOutputStream outputStream = null;

        try {
            fs = path.getFileSystem(conf);
            outputStream = fs.create(path);
            outputStream.write(contents.getBytes("UTF-8"));
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
