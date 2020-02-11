package com.fly.bills.web.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fly.bills.Vo.BillsVo;
import com.fly.bills.domain.Bills;
import com.fly.bills.domain.Billtype;
import com.fly.bills.service.IBillsService;
import com.fly.bills.service.IBilltypeService;
import com.fly.bills.util.DataGridView;
import com.fly.bills.util.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 老雷
 * @since 2020-02-09
 */
@Controller
@RequestMapping("bills")
public class BillsController {
    @Autowired
    private IBillsService billsService;
    @Autowired
    private IBilltypeService billtypeService;
    /**
     * 跳转到系统主页
     */
    @RequestMapping("toBillsList")
    public String toBillsList(){
        return "list";
    }


    /**
     * 加载帐单数
     */
    @RequestMapping("loadAllBills")
    @ResponseBody
    public DataGridView loadAllBills(BillsVo billsVo){
        IPage<Bills> page=new Page<>(billsVo.getPage(),billsVo.getLimit());
        QueryWrapper<Bills> queryWrapper=new QueryWrapper<>();
        if(billsVo.getTypeid()!=null) {
            queryWrapper.eq(billsVo.getTypeid() != 0 && billsVo.getTypeid() != null, "typeid", billsVo.getTypeid());
        }
        queryWrapper.ge(billsVo.getStartDate()!=null,"billtime",billsVo.getStartDate());
        queryWrapper.le(billsVo.getEndDate()!=null,"billtime",billsVo.getEndDate());
        queryWrapper.orderByDesc("billtime");
        billsService.page(page, queryWrapper);
        List<Bills>records=page.getRecords();
        List<Billtype>list=billtypeService.list();
        for (Bills record : records) {
            Billtype billtype = this.billtypeService.getById(record.getTypeid());
            record.setTypeName(billtype.getName());
        }
        return new DataGridView(page.getTotal(),records);
    }


    /**
     * 添加订单
     * @param billtype
     * @return
     */
    @RequestMapping("addBills")
    @ResponseBody
    public ResultObj addBills(BillsVo billsVo){
        try{
            billsService.save(billsVo);
            return new ResultObj(200,"录入成功");
        }catch (Exception e){
            e.printStackTrace();
            return new ResultObj(-1,"录入失败");
        }
    }
}

