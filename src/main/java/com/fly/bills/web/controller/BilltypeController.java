package com.fly.bills.web.controller;


import com.fly.bills.domain.Billtype;
import com.fly.bills.service.IBilltypeService;
import com.fly.bills.util.DataGridView;
import com.fly.bills.util.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 老雷
 * @since 2020-02-09
 */
@RestController
@RequestMapping("billtype")
public class BilltypeController {

    @Autowired
    private IBilltypeService billtypeService;
    @RequestMapping("loadAllBillType")

    public DataGridView loadAllBillType(){
        return new DataGridView(0l,billtypeService.list());
    }


}

