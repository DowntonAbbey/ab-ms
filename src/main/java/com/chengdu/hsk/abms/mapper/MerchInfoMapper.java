package com.chengdu.hsk.abms.mapper;

import com.chengdu.hsk.abms.pojo.MerchInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: hsk
 * @Date: 2019/6/1 16:40
 * @Description:
 */
@Component
public interface MerchInfoMapper {

    int addMerch(MerchInfo merchInfo);

    int addMerchBatch(List<MerchInfo> merchInfoList);

    MerchInfo findMerchById(Integer id);

    List<MerchInfo> findMerchAll();

    int updateMerch(MerchInfo merchInfo);

    int updateMerchBatch1(List<MerchInfo> merchInfoList);

    int updateMerchBatch2(List<MerchInfo> merchInfoList);

    int deleteMerch(Integer id);

    int deleteMerchBatch(List<Integer> ids);

    int countMerch();
}
