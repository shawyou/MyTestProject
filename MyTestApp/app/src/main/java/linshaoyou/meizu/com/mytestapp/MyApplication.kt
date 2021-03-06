package linshaoyou.meizu.com.mytestapp

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDexApplication
import android.util.Log
import com.taobao.sophix.PatchStatus
import com.taobao.sophix.SophixManager
import com.taobao.sophix.SophixManager.*
import com.taobao.sophix.listener.PatchLoadStatusListener
import com.taobao.weex.InitConfig
import com.taobao.weex.WXSDKEngine
import linshaoyou.meizu.com.mytestapp.weex.WXImageLoaderAdapter

/**
 * Created by linshaoyou on 17/8/26.
 */
class MyApplication : MultiDexApplication(){

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Log.e("LSY", "attachBastContext start")
        // initialize最好放在attachBaseContext最前面
        SophixManager.getInstance()
                .setContext(this)
                .setAppVersion("1.0.0")
                .setAesKey(null)
                .setEnableDebug(true)
                .setPatchLoadStatusStub(object : PatchLoadStatusListener {
                    override fun onLoad(mode: Int, code: Int, info: String, handlePatchVersion: Int) {
                        Log.e("LSY", "补丁加载回调通知 code == " + code)
                        // 补丁加载回调通知
                        if (code == PatchStatus.CODE_LOAD_SUCCESS) {
                            // 表明补丁加载成功
                        } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
                            // 表明新补丁生效需要重启. 开发者可提示用户或者强制重启;
                            // 建议: 用户可以监听进入后台事件, 然后调用killProcessSafely自杀，以此加快应用补丁，详见1.3.2.3
                        } else {
                            // 其它错误信息, 查看PatchStatus类说明
                        }
                    }
                }).initialize()
        Log.e("LSY", "attachBastContext finish")
    }

    override fun onCreate() {
        super.onCreate()
        Log.e("LSY", "MyApplication onCreate")
        initial()
    }

    private fun initial() {
        initSophix()
        initWeex()
    }

    private fun initSophix() {
        // queryAndLoadNewPatch不可放在attachBaseContext 中，否则无网络权限，建议放在后面任意时刻，如onCreate中
        SophixManager.getInstance().queryAndLoadNewPatch()
    }

    private fun initWeex() {
        var initConfig = InitConfig
                .Builder()
                .setImgAdapter(WXImageLoaderAdapter())
                .build()
        WXSDKEngine.initialize(this,initConfig)
    }
}
