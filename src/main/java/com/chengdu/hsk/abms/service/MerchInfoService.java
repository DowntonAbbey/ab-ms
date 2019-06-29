package com.chengdu.hsk.abms.service;

import com.chengdu.hsk.abms.pojo.MerchInfo;

import java.util.List;

/**
 * @Auther: hsk
 * @Date: 2019/6/1 16:18
 * @Description:
 */
public interface MerchInfoService {
    int addMerch(MerchInfo merchInfo);
    int addMerchBatch(List<MerchInfo> merchInfoList);
    MerchInfo findMerchById(Integer id);
    List<MerchInfo> findMerchAll();
    int updateMerch(MerchInfo merchInfo);
    int updateMerchBatch1(List<MerchInfo> merchInfoList);
    int updateMerchBatch2(List<MerchInfo> merChInfoList);
    int deleteMerch(Integer id);
    int deleteMerchBatch(List<Integer> ids);
    int countMerch();

}
