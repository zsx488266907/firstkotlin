package com.wd.tech.mypushs.activity

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.blankj.utilcode.util.SPUtils
import com.blankj.utilcode.util.ToastUtils
import com.wd.tech.mypush.kotlin.LoginBean
import com.wd.tech.mypushs.R
import com.wd.tech.mypushs.api.MyApi
import com.wd.tech.mypushs.contract.MyContract
import com.wd.tech.mypushs.net.EncryptUtil
import com.wd.tech.mypushs.net.RsaCoder
import com.wd.tech.mypushs.presenter.MyPresenter
import kotlinx.android.synthetic.main.activity_main2.*

class LoginActivity : AppCompatActivity(), MyContract.MyView {
    lateinit var myPresenter: MyPresenter
    var loginBean : LoginBean?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getLayout()
        setContentView(R.layout.activity_main2)
        initData()


    }

    private fun getLayout() {
        supportActionBar!!.hide()
        //让状态栏透明
        if (Build.VERSION.SDK_INT >= 21) {
            val decorView = window.decorView
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun initData() {
        myPresenter = MyPresenter(this)
        but.setOnClickListener {
            var map = HashMap<String, String>()

            map["phone"] = "13611111111"
            map["pwd"] = RsaCoder.encryptByPublicKey("123456")
            myPresenter.login(map, MyApi.LOGIN_URL)

        }
        text.setOnClickListener {
            var intent = Intent()
            intent.setClass(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    override fun success(objects: Any) {

      loginBean = objects as LoginBean
        if (true) {
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
            SPUtils.getInstance().put("userId", loginBean!!.result.userId)
            SPUtils.getInstance().put("sessionId", loginBean!!.result.sessionId)
            var intent = Intent()
            intent.setClass(this,ProductActivity::class.java)
            startActivity(intent)


        }

    }

    override fun onfair(string: String) {
    }
}
