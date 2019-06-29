package com.chengdu.hsk.abms.serviceImpl;

import com.chengdu.hsk.abms.mapper.MerchInfoMapper;
import com.chengdu.hsk.abms.pojo.MerchInfo;
import com.chengdu.hsk.abms.service.MerchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: hsk
 * @Date: 2019/6/1 16:39
 * @Description:
 */
@Service
public class MerchInfoServiceImpl implements MerchInfoService {

    @Autowired
    private MerchInfoMapper merchInfoMapper;

    @Override
    public int addMerch(MerchInfo merchInfo) {
        return merchInfoMapper.addMerch(merchInfo);
    }

    @Override
    public int addMerchBatch(List<MerchInfo> merchInfoList) {
        return merchInfoMapper.addMerchBatch(merchInfoList);
    }

    @Override
    public MerchInfo findMerchById(Integer id) {
        return merchInfoMapper.findMerchById(id);
    }

    @Override
    public List<MerchInfo> findMerchAll() {
        return merchInfoMapper.findMerchAll();
    }

    @Override
    public int updateMerch(MerchInfo merchInfo) {
        return merchInfoMapper.updateMerch(merchInfo);
    }

    @Override
    public int updateMerchBatch1(List<MerchInfo> merchInfoList) {
        return merchInfoMapper.updateMerchBatch1(merchInfoList);
    }

    @Override
    public int updateMerchBatch2(List<MerchInfo> merChInfoList) {
        return merchInfoMapper.updateMerchBatch2(merChInfoList);
    }

    @Override
    public int deleteMerch(Integer id) {
        return merchInfoMapper.deleteMerch(id);
    }

    @Override
    public int deleteMerchBatch(List<Integer> ids) {
        return merchInfoMapper.deleteMerchBatch(ids);
    }

    @Override
    public int countMerch() {
        return merchInfoMapper.countMerch();
    }
}
