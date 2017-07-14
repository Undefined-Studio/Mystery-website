package com.hiczp.web.mystery.api;

import com.alibaba.fastjson.JSON;
import com.hiczp.web.mystery.configuration.SettingProperties;
import com.hiczp.web.mystery.dto.DataDto;
import com.hiczp.web.mystery.dto.ResponseDto;
import com.hiczp.web.mystery.entity.*;
import com.hiczp.web.mystery.repository.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by czp on 17-7-13.
 */
@RestController
@RequestMapping("/api/user/game")
public class GameController {
    private LevelRepository levelRepository;
    private AccountRepository accountRepository;
    private SettingRepository settingRepository;
    private CouponRepository couponRepository;
    private CouponInstanceRepository couponInstanceRepository;

    public GameController(LevelRepository levelRepository, AccountRepository accountRepository, SettingRepository settingRepository, CouponRepository couponRepository, CouponInstanceRepository couponInstanceRepository) {
        this.levelRepository = levelRepository;
        this.accountRepository = accountRepository;
        this.settingRepository = settingRepository;
        this.couponRepository = couponRepository;
        this.couponInstanceRepository = couponInstanceRepository;
    }

    @PostMapping("/levelClear")
    public ResponseDto levelClear(long id) {
        Level level = levelRepository.findOne(id);
        //关卡不存在
        if (level == null) {
            return new ResponseDto(1, "No such level");
        }

        //获得用户
        Account account = accountRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        //获取通关记录
        List<Long> clearedLevels = JSON.parseArray(account.getGameFlag(), Long.class);
        if (clearedLevels == null) {
            clearedLevels = new ArrayList<>();  //如果通关记录不存在则初始化
        }
        //判断是否已通关
        boolean isAlreadyCleared = false;
        for (Long clearedLevel : clearedLevels) {
            if (clearedLevel == id) {
                isAlreadyCleared = true;
                break;
            }
        }
        //已通关
        if (isAlreadyCleared) {
            return new ResponseDto(2, "Already cleared this level");
        }
        //未通关
        clearedLevels.add(id);  //添加当前关卡记录
        account.setGameFlag(JSON.toJSONString(clearedLevels));
        accountRepository.save(account);
        //获得通关奖励
        DataDto dataDto = new DataDto();
        Setting setting = settingRepository.findByProperty(SettingProperties.levelClearRewardCouponId);
        if (setting != null) {    //当奖励已被设置时
            Coupon coupon = couponRepository.findOne(Long.valueOf(setting.getValue()));
            if (coupon != null) { //对应的优惠券存在时
                CouponInstance couponInstance = new CouponInstance(coupon, account, coupon.getValue());
                couponInstance = couponInstanceRepository.save(couponInstance);
                dataDto.put("couponInstance", couponInstance);
            }
        }
        return dataDto;
    }
}
