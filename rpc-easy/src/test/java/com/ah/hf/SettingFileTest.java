package com.ah.hf;

import cn.hutool.core.io.FileUtil;
import cn.hutool.setting.Setting;

public class SettingFileTest {
    //读取classpath下的XXX.setting，不使用变量
/*
    Setting setting = new Setting("XXX.setting");

    //读取classpath下的config目录下的XXX.setting，不使用变量
    setting = new Setting("config/XXX.setting");

    //读取绝对路径文件/home/looly/XXX.setting（没有就创建，关于touch请查阅FileUtil）
    //第二个参数为自定义的编码，请保持与Setting文件的编码一致
    //第三个参数为是否使用变量，如果为true，则配置文件中的每个key都可以被之后的条目中的value引用，形式为 ${key}
    setting = new Setting(FileUtil.touch("/home/looly/XXX.setting"), CharsetUtil.CHARSET_UTF_8, true);

//读取与SettingDemo.class文件同包下的XXX.setting
    setting = new Setting("XXX.setting", SettingDemo.class,CharsetUtil.CHARSET_UTF_8, true);
*/

}
