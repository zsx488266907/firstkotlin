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
import com.wd.tech.mypush.kotlin.RegisterBean
import com.wd.tech.mypushs.R
import com.wd.tech.mypushs.api.MyApi
import com.wd.tech.mypushs.contract.MyContract
import com.wd.tech.mypushs.net.RsaCoder
import com.wd.tech.mypushs.presenter.MyPresenter
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), MyContract.MyView {
    lateinit var myPresenter: MyPresenter
    var registerBean: RegisterBean? = null

    override fun success(objects: Any) {

        registerBean = objects as RegisterBean
        ToastUtils.showShort(registerBean!!.message)
        if (registerBean!!.message.equals("注册成功")) {
            var intent = Intent()
            intent.setClass(this, LoginActivity::class.java)
            startActivity(intent)

        }
    }

    override fun onfair(string: String) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getLayout()
        setContentView(R.layout.activity_register)
        initData()
    }

    private fun initData() {
        myPresenter = MyPresenter(this)
        but_re.setOnClickListener {
            var map = HashMap<String, String>()


            map["phone"] = "13611112114"
            map["nickName"] = "13611211132"
            map["pwd"] = RsaCoder.encryptByPublicKey("123456")
            myPresenter.register(map, MyApi.REGISTER_URL)

        }
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
}
