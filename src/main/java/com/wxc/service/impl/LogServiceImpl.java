package com.wxc.service.impl;

import com.wxc.entity.Log;
import com.wxc.mapper.LogMapper;
import com.wxc.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author wangxiaocheng
 * @since 2021-07-16
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

}
