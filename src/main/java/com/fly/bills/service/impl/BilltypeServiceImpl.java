package com.fly.bills.service.impl;

import com.fly.bills.domain.Billtype;
import com.fly.bills.mapper.BilltypeMapper;
import com.fly.bills.service.IBilltypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

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
public class BilltypeServiceImpl extends ServiceImpl<BilltypeMapper, Billtype> implements IBilltypeService {
    @Override
    public Billtype getById(Serializable id) {
        return super.getById(id);
    }
}
