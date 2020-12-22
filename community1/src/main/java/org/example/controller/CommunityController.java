package org.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.CommonResult;
import org.example.entity.Community;
import org.example.entity.CommunityVO;
import org.example.mapper.CommunityMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
//@CrossOrigin(origins = "http://*",
//        allowCredentials = "true",
//        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.OPTIONS,RequestMethod.PUT},
//        exposedHeaders = "*",
//        maxAge = 3600L)
@RequestMapping("/community/1")
public class CommunityController {
    @Resource
    private CommunityMapper communityMapper;
    private final SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @GetMapping
    public ResponseEntity<CommonResult<?>> findPage(@RequestParam(required = false)Integer current, @RequestParam(required = false)Integer size) {
        LambdaQueryWrapper<Community> lambda = new QueryWrapper<Community>().lambda().eq(Community::getCommunityType,1);
        if (current == null ||size == null) {
            List<Community> list = communityMapper.selectList(lambda);
            return checkEmpty(list);
        } else {
            Page<Community> page1 = new Page<>(current,size);
            page1=communityMapper.selectPage(page1,lambda);
            var list=page1.getRecords();
            return checkEmpty(list);
        }
    }
    private List<CommunityVO> deal(List<Community> list){
        List<CommunityVO> list1=new ArrayList<>(list.size());
        list.forEach(community -> {
            CommunityVO communityVO=new CommunityVO();
            communityVO.setCommunityId(community.getCommunityId());
            communityVO.setCommunityName(community.getCommunityName());
            communityVO.setCommunityAddress(community.getCommunityAddress());
            communityVO.setName(community.getName());
            communityVO.setNote(community.getNote());
            communityVO.setType(community.getType());
            communityVO.setFinishDate(community.getFinishDate());
            communityVO.setCreateDate(community.getCreateDate());
            communityVO.setArea(community.getArea());
            communityVO.setDesigner(community.getDesigner());
            list1.add(communityVO);
        });
        return list1;
    }
    @PostMapping
    public ResponseEntity<CommonResult<Community>> insert(@RequestBody Community community){
        String[] strings={
                "小区名称不能为空",
                "小区地址不能为空",
                "录入人不能为空",
                "设计师不能为空",
                "房屋面积不能为空",
                "完工时间不能为空",
                "户型结构不能为空",
                "小区名称不能超过25字符",
                "录入人不能超过5字符",
                "设计师不能超过5字符",
                "户型结构不能超过10字符",
                "小区地址不能超过70字符",
                "备注不能超过200字符"
        };
        List<Boolean> list=new ArrayList<>(13);
        list.add(community.getCommunityName()==null);
        list.add(community.getCommunityAddress()==null);
        list.add(community.getName()==null);
        list.add(community.getDesigner()==null);
        list.add(community.getArea()==null);
        list.add(community.getFinishDate()==null);
        list.add(community.getType()==null);
        list.add(community.getCommunityName()!=null&&community.getCommunityName().length()>25);
        list.add(community.getName()!=null&&community.getName().length()>5);
        list.add(community.getDesigner()!=null&&community.getDesigner().length()>5);
        list.add(community.getType()!=null&&community.getType().length()>10);
        list.add(community.getCommunityAddress()!=null&&community.getCommunityAddress().length()>70);
        list.add(community.getNote()!=null&&community.getNote().length()>200);
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i)){
                return new ResponseEntity<>(new CommonResult<>(400,strings[i]),HttpStatus.BAD_REQUEST);
            }
        }
        community.setCommunityType(1);
        community.setDesignAdvice(null);
        community.setTakeKeyTime(null);
        community.setFeature(null);
        community.setRenovationRecommendation(null);
        community.setCreateDate(simpleDateFormat.format(new Date()));
        communityMapper.insert(community);
        return new ResponseEntity<>(new CommonResult<>(201,"添加成功"),HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<CommonResult<Community>> delete(@RequestParam Integer communityId){
        int i = communityMapper.deleteById(communityId);
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
