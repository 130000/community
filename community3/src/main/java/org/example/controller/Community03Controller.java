package org.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.CommonResult;
import org.example.entity.Community;
import org.example.entity.Community03VO;
import org.example.mapper.Community03Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/community/3")
public class Community03Controller {
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Resource
    private Community03Mapper community03Mapper;
    @PostMapping
    public ResponseEntity<CommonResult<?>> insert(@RequestBody Community community) {
        var list = new ArrayList<Boolean>(9);
        list.add(community.getName() == null);
        list.add(community.getArea() == null);
        list.add(community.getType() == null);
        list.add(community.getFeature() == null);
        list.add(community.getName() != null && community.getName().length() > 5);
        list.add(community.getType() != null && community.getType().length() > 10);
        list.add(community.getFeature() != null && community.getFeature().length() > 50);
        list.add(community.getRenovationRecommendation() != null && community.getRenovationRecommendation().length() > 200);
        list.add(community.getNote() != null && community.getNote().length() > 200);
        var strings = new String[]{
                "录入人不能为空",
                "房屋面积不能为空",
                "户型结构不能为空",
                "户型特点不能为空",
                "录入人不能超过5字符",
                "户型结构不能超过10字符",
                "户型特点不能超过50字符",
                "装修建议不能超过200字符",
                "备注不能超过200字符"
        };
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i))
                return new ResponseEntity<>(new CommonResult<>(400, strings[i]), HttpStatus.BAD_REQUEST);
        }
        community.setTakeKeyTime(null);
        community.setCommunityType(3);
        community.setFinishDate(null);
        community.setCreateDate(simpleDateFormat.format(new Date()));
        community.setCommunityAddress(null);
        community.setDesigner(null);
        community.setCommunityName(null);
        community.setDesignAdvice(null);
        community03Mapper.insert(community);
        return new ResponseEntity<>(new CommonResult<>(201, "插入成功"), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CommonResult<?>> findAll(@RequestParam(required = false) Integer current, @RequestParam(required = false) Integer size) {
        var lambdaQueryWrapper = new LambdaQueryWrapper<Community>().eq(Community::getCommunityType, 3);
        if (current == null || size == null) {
            var list = community03Mapper.selectList(lambdaQueryWrapper);
            return checkEmpty(list);
        }
        else{
            var page = new Page<Community>(current, size);
            page = community03Mapper.selectPage(page, lambdaQueryWrapper);
            var list = page.getRecords();
            return checkEmpty(list);
        }
    }
    private List<Community03VO> deal(List<Community> list){
        var list1=new ArrayList<Community03VO>(list.size());
        list.forEach(community -> {
            var community03VO=new Community03VO();
            community03VO.setCommunityId(community.getCommunityId());
            community03VO.setRenovationRecommendation(community.getRenovationRecommendation());
            community03VO.setType(community.getType());
            community03VO.setFeature(community.getFeature());
            community03VO.setArea(community.getArea());
            community03VO.setNote(community.getNote());
            community03VO.setName(community.getName());
            community03VO.setCreateDate(community.getCreateDate());
            list1.add(community03VO);
        });
        return list1;
    }
    @DeleteMapping
    public ResponseEntity<CommonResult<?>> delete(@RequestParam Integer communityId){
        var i = community03Mapper.deleteById(communityId);
        if(i>0){
            return new ResponseEntity<>(new CommonResult<>(201,"删除成功"),HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(new CommonResult<>(404,"没有找到id是"+communityId+"的记录"),HttpStatus.NOT_FOUND);
        }
    }
    private ResponseEntity<CommonResult<?>> checkEmpty(List<Community> list) {
        if (list == null || list.isEmpty())
            return new ResponseEntity<>(new CommonResult<>(404, "列表为空"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(new CommonResult<>(200,"查询成功",deal(list)),HttpStatus.OK);
    }
}
