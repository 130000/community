package org.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.CommonResult;
import org.example.entity.Community;
import org.example.entity.Community02VO;
import org.example.mapper.Community02Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/community/2")
public class Community02Controller {
    private final SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Resource
    private Community02Mapper community2Mapper;
    @GetMapping
    public ResponseEntity<CommonResult<?>> findAll(@RequestParam(required = false) Integer current, @RequestParam(required = false)Integer size){
        var lambda = new QueryWrapper<Community>().lambda().eq(Community::getCommunityType,2);
        if(current==null||size==null){
            List<Community> list=community2Mapper.selectList(lambda);
            return checkEmpty(list);
        }
        else{
            var page=new Page<Community>(current,size);
            page=community2Mapper.selectPage(page,lambda);
            List<Community> records = page.getRecords();
            return checkEmpty(records);
        }
    }
    private List<Community02VO> deal(List<Community> list){
        List<Community02VO> list1=new ArrayList<>(list.size());
        list.forEach(community -> {
            Community02VO community02VO=new Community02VO();
            community02VO.setCommunityId(community.getCommunityId());
            community02VO.setCommunityName(community.getCommunityName());
            community02VO.setType(community.getType());
            community02VO.setDesigner(community.getDesigner());
            community02VO.setArea(community.getArea());
            community02VO.setNote(community.getNote());
            community02VO.setTakeKeyTime(community.getTakeKeyTime());
            community02VO.setCreateDate(community.getCreateDate());
            community02VO.setDesignAdvice(community.getDesignAdvice());
            community02VO.setName(community.getName());
            community02VO.setCommunityAddress(community.getCommunityAddress());
            list1.add(community02VO);
        });
        return list1;
    }
    @PostMapping
    public ResponseEntity<CommonResult<?>> insert(@RequestBody Community community){
        var list=new ArrayList<Boolean>(14);
        list.add(community.getCommunityName()==null);
        list.add(community.getCommunityAddress()==null);
        list.add(community.getArea()==null);
        list.add(community.getTakeKeyTime()==null);
        list.add(community.getName()==null);
        list.add(community.getDesigner()==null);
        list.add(community.getType()==null);
        list.add(community.getCommunityName()!=null&&community.getCommunityName().length()>25);
        list.add(community.getName()!=null&&community.getName().length()>5);
        list.add(community.getDesigner()!=null&&community.getDesigner().length()>5);
        list.add(community.getCommunityAddress()!=null&&community.getCommunityAddress().length()>70);
        list.add(community.getType()!=null&&community.getType().length()>10);
        list.add(community.getNote()!=null&&community.getNote().length()>200);
        list.add(community.getDesignAdvice()!=null&&community.getDesignAdvice().length()>200);
        list.add(community.getTakeKeyTime()!=null&&community.getTakeKeyTime().length()>30);
        String[] strings={
                "小区名称不能为空",
                "小区地址不能为空",
                "房屋面积不能为空",
                "拿钥匙时间不能为空",
                "录入人不能为空",
                "设计师不能为空",
                "户型结构不能为空",
                "小区名称不能超过25字符",
                "录入人不能超过5字符",
                "设计师不能超过5字符",
                "小区地址不能超过70字符",
                "户型结构不能超过10字符",
                "备注不能超过200字符",
                "设计意见不能超过200字符",
                "拿钥匙时间不能超过30字符"
        };
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)){
                return new ResponseEntity<>(new CommonResult<>(400,strings[i]),HttpStatus.BAD_REQUEST);
            }
        }
        community.setCreateDate(simpleDateFormat.format(new Date()));
        community.setCommunityType(2);
        community.setFinishDate(null);
        community.setRenovationRecommendation(null);
        community.setFeature(null);
        community2Mapper.insert(community);
        return new ResponseEntity<>(new CommonResult<>(201,"插入成功"),HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<CommonResult<?>> delete(@RequestParam Integer communityId){
        int i = community2Mapper.deleteById(communityId);
        if(i>0){
            return new ResponseEntity<>(new CommonResult<>(201,"删除成功"),HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(new CommonResult<>(404,"没有找到id是"+communityId+"的记录"),HttpStatus.NOT_FOUND);
        }
    }
    private ResponseEntity<CommonResult<?>> checkEmpty(List<Community> list){
        if(list==null||list.isEmpty()){
            return new ResponseEntity<>(new CommonResult<>(404, "列表为空"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CommonResult<>(200,"查询成功",deal(list)),HttpStatus.OK);    }
}
