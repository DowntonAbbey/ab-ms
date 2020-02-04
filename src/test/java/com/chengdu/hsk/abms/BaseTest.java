package com.chengdu.hsk.abms;

import com.chengdu.hsk.abms.Test.Manager;
import com.chengdu.hsk.abms.Test.Staff;
import com.chengdu.hsk.abms.Test.User;
import com.chengdu.hsk.abms.pojo.Size;
import org.junit.Test;
import org.springframework.util.StringUtils;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: hsk
 * @Date: 2019/6/2 18:29
 * @Description:
 */

public class BaseTest {

    @Test
    public void testChange() {
        Staff staff = new Manager();
        if (staff instanceof Staff) {
            try {
                Manager manager = (Manager) staff;
                System.out.println("============");
                System.out.println(manager.getBuddy());
                System.out.println(manager.getSalary());
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testNull() {
        User user = new User();
        Integer id = user.getUserId();
        id = StringUtils.isEmpty(id) ? 1 : id;
        System.out.println(id);
    }

    @Test
    public void testEquals() throws InterruptedException {
        String[] string2 = new String[]{"tom","rose","jack"};
        Arrays.sort(string2);
        System.out.println(Arrays.toString(string2));
        Arrays.sort(string2,String::compareToIgnoreCase);
        System.out.println(Arrays.toString(string2));
        ExecutorService service = Executors.newFixedThreadPool(10);
        for(int i=0;i<10000;i++){
            service.execute(()->{
                System.out.println("hello");
            });
        }

        Thread.sleep(5000);

        service.shutdown();
    }

    @Test
    public void testHttp() throws IOException {
        URL url = new URL("https://www.csdn.net/");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        /**
         * URL对象调用openConnection()方法以后并不是直接去创建Socket进行通信
         * 而是调用了getContent()方法以后（以及其他的各种获得Header方法等等）
         * 所以要在真正建立Socket通信访问服务器80端口以前setRequestMethod
         */
        httpURLConnection.setRequestMethod("GET");

        BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        Iterator<Map.Entry<String, List<String>>> iterator = headerFields.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, List<String>> entry = iterator.next();
            String key = entry.getKey();
            List<String> value = entry.getValue();
            System.out.println(key+":"+value);
        }
        // 使用字符流类读取内容，注意编码从二进制转为字符时使用 UTF-8
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "utf-8"));
        String tem;
        while((tem = bufferedReader.readLine())!=null) {
            System.out.println(tem);
        }

        bufferedReader.close();

    }
}
