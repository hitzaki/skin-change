package com.github.hitzaki.skin;


import com.github.hitzaki.skin.constant.resource.ResourceCopyPathEnum;
import com.github.hitzaki.skin.util.CmdCallUtil;
import com.github.hitzaki.skin.util.ResourceInitUtil;

/**
 * 主程序
 * @author hitzaki
 */
public class MainApplication {
    public static void main(String[] args) {
        try {
            ResourceInitUtil.initWorkResource();
        } catch (Exception e) {
            // TODO 窗口报错执行失败
            throw new RuntimeException("初始化失败");
        }
        CmdCallUtil.exeCmdOne(ResourceCopyPathEnum.RESOURCE_PATH_ENUM.getAbsolutePath());
    }

}
