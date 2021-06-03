package com.chengdu.hsk.abms.controller;

import com.chengdu.hsk.abms.pojo.MerchInfo;
import com.chengdu.hsk.abms.service.MerchInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;


/**
 * @Auther: hsk
 * @Date: 2019/6/1 16:16
 * @Description:
 */
@RestController
@Api(value = "商户信息查询")
public class MerchController {

    @Autowired
    private MerchInfoService merchInfoService;

    @RequestMapping("findMerchById")
    @ApiOperation(value="根据id获取商户信息", notes="test: 仅1和2有正确返回")
    public String findMerchById(@RequestParam("id") Integer id){
//        return merchInfoService.findMerchById(id);
        return "test";
    }

    @RequestMapping("/addMerch")
    public Integer addMerch(MerchInfo merchInfo){
        Date date = new Date();
        merchInfo.setCreateDate(date);
        return merchInfoService.addMerch(merchInfo);
    }
    @RequestMapping("/addMerchBatch")
    public Map addMerchBatch(Integer number){
        Map resultMap = new HashMap();
        int updateNumber = -1;
        ArrayList<MerchInfo> merchInfoList = new ArrayList<>();
        long startTime = (new Date()).getTime();
        for(int start=0;start <number;start = start + 1000) {
            int flag = 1000;
            System.out.println("==============");
            System.out.println("已新增："+start);
            System.out.println("==============");
            if(flag>number - start) {
                flag = number - start;
            }
            merchInfoList.clear();
            for (int i = 0; i < flag; i++) {
                MerchInfo merchInfo = new MerchInfo(null, "商户号" + i, "商户名" + i,
                        "商户简称" + i, new Date(), "" + i, "账号名" + i, null);
                merchInfoList.add(merchInfo);
            }
            if (merchInfoList.size() > 0) {
                try {
                    updateNumber = updateNumber + merchInfoService.addMerchBatch(merchInfoList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        long endTime = (new Date()).getTime();
        long useTime = endTime - startTime;
        resultMap.put("更新条数",updateNumber);
        resultMap.put("花费时间",useTime);
        return resultMap;

    }

    @RequestMapping("/deleteMerchBatch")
    public int deleteMerchBatch(){
        return merchInfoService.deleteMerchBatch(null);
    }

    @RequestMapping("/countMerch")
    public int countMerch(){
        return merchInfoService.countMerch();
    }

    @RequestMapping("/updateMerchBatch1")
    public Map updateMerchBatch1(int number,int limit){
        int index = 0;
        int updateNumber = 0;
        Map resultMap = new HashMap();
        long startTime = (new Date()).getTime();
        for(int i = 0;i<number;i = i + limit){
            List<MerchInfo> merchInfoList = new ArrayList<>();
            for(int j = 0;j<limit;j++) {
                MerchInfo merchInfo = new MerchInfo();
                merchInfo.setTradeAccountNumber("" + index);
                merchInfo.setTradeAccountType("1");
                merchInfoList.add(merchInfo);
                index ++;
            }
            updateNumber += merchInfoService.updateMerchBatch1(merchInfoList);
        }
        long endTime = (new Date()).getTime();
        resultMap.put("useTime",endTime - startTime);
        resultMap.put("updteNumber",updateNumber);
        return resultMap;
    }

    @RequestMapping("/updateMerchBatch2")
    public Map updateMerchBatch2(int number,int limit){
        int index = 0;
        int updateNumber = 0;
        Map resultMap = new HashMap();
        long startTime = (new Date()).getTime();
        for(int i = 0;i<number;i = i + limit){
            List<MerchInfo> merchInfoList = new ArrayList<>();
            for(int j = 0;j<limit;j++) {
                MerchInfo merchInfo = new MerchInfo();
                merchInfo.setTradeAccountNumber("" + index);
                merchInfo.setTradeAccountType("2");
                merchInfoList.add(merchInfo);
                index ++;
            }
            updateNumber += merchInfoService.updateMerchBatch2(merchInfoList);
        }
        long endTime = (new Date()).getTime();
        resultMap.put("useTime",endTime - startTime);
        resultMap.put("updteNumber",updateNumber);
        return resultMap;
    }
    @GetMapping("/test")
    public void sayHello(@RequestParam("filePath") String filePath, HttpServletRequest req, HttpServletResponse res){
        File f = new File(filePath);
        byte [] a = new byte[1024*8];
        StringBuilder result = new StringBuilder();
        int n = -1;
        long startTime = (new Date()).getTime();
        OutputStream out;
        try{
            out = res.getOutputStream();
            InputStream in = new FileInputStream(f);
            BufferedInputStream bfi = new BufferedInputStream(in);
            while((n = in.read(a))!=-1){
                out.write(a,0,n);
                out.flush();
            }
            bfi.close();
            in.close();
        }catch (IOException e){

        }
        long endTime = (new Date()).getTime();
        long useTime = endTime - startTime;
        System.out.println("userTime:"+useTime);
    }

    @GetMapping("/test2")
    public Map test2(@RequestParam("filePath") String filePath){
        File f = new File(filePath);
        char [] a = new char[100];
        StringBuilder result = new StringBuilder();
        String s = null;
        long startTime = (new Date()).getTime();
        try{
            Reader reader = new FileReader(f);
            BufferedReader bf = new BufferedReader(reader);
            while((s=bf.readLine())!= null){
                result.append(s);
            }
            bf.close();
            reader.close();
        }catch (IOException e){

        }
        long endTime = (new Date()).getTime();
        long useTime = endTime - startTime;
        System.out.println("useTime:"+useTime);
        Map resultMap = new HashMap();
        resultMap.put("useTime",useTime);
        resultMap.put("result",result);
        return  resultMap;
    }



}
