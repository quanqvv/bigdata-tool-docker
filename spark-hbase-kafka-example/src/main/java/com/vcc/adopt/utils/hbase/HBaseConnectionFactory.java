package com.vcc.adopt.utils.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

public class HBaseConnectionFactory {
    public static Connection createConnection(){
        try {
            Configuration conf = HBaseConfiguration.create();
            conf.addResource("hbase-site.xml");
            return ConnectionFactory.createConnection(conf);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
