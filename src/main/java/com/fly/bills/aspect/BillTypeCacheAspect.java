package com.fly.bills.aspect;

import com.fly.bills.domain.Billtype;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import sun.awt.SunHints;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@EnableAspectJAutoProxy
public class BillTypeCacheAspect {
    /**
     * 缓存对象
     */
    private Map<String,Object>cache=new HashMap<>();

    /**
     * 缓存前缀
     */
    private static final String BILL_TYPE_CACHE_PREFIX="billtype:";


    @Pointcut("execution(* com.fly.bills.service.impl.BilltypeServiceImpl.getById(..))")
    public void pc(){

    }

    @Around(value = "pc()")
    public Object cacheBillType(ProceedingJoinPoint point) throws Throwable {
        //获取目标方法的参数
        Object[] args = point.getArgs();
        //取出id
        Integer typeId =(Integer) args[0];
        //从缓存区对象
        Object obj = cache.get(BILL_TYPE_CACHE_PREFIX+typeId);
        if(null!=obj) {//说明缓存里面有数据
            System.out.println("缓存里面有数据");
            return obj;
        }else {
            System.err.println("缓存里面有没有数据执行SQL查询");
            //说明缓存里面没有  放行执行目标方法 查询数据
            Billtype res = (Billtype) point.proceed();
            //放入缓存
            cache.put(BILL_TYPE_CACHE_PREFIX+res.getId(), res);
            return res;
        }
    }
}
