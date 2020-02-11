package com.fly.bills.service.impl;

import com.fly.bills.domain.Bills;
import com.fly.bills.mapper.BillsMapper;
import com.fly.bills.service.IBillsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 老雷
 * @since 2020-02-09
 */
@Service
@Transactional
public class BillsServiceImpl extends ServiceImpl<BillsMapper, Bills> implements IBillsService {

}
