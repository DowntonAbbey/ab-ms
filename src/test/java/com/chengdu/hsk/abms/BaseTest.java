package com.chengdu.hsk.abms;

import com.chengdu.hsk.abms.Test.Manager;
import com.chengdu.hsk.abms.Test.Staff;
import org.junit.Test;

/**
 * @Auther: hsk
 * @Date: 2019/6/2 18:29
 * @Description:
 */

public class BaseTest {

    @Test
    public void testChange(){
        Staff staff = new Manager();
        if (staff instanceof Staff){
            try {
                Manager manager = (Manager) staff;
                System.out.println("============");
                System.out.println(manager.getBuddy());
                System.out.println(manager.getSalary());
            }catch (ClassCastException e){
                e.printStackTrace();
            }
        }
    }
}
