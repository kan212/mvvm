package com.ihandy.mvvm.direct

import android.os.Bundle
import android.view.View
import android.view.ViewParent
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ihandy.mvvm.R
import com.ihandy.mvvm.databinding.ActivityDirectBinding
import kotlinx.android.synthetic.main.activity_direct.*
import org.koin.android.viewmodel.ext.android.viewModel

class DirectActivity : AppCompatActivity(),View.OnClickListener{


    //使用viewModel的方式创建
//    val directViewModule :DirectViewModule by viewModel()
    lateinit var directViewModule: DirectViewModule

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //检索xml,查找data标签的对象
        val dataBinding =
            DataBindingUtil.setContentView<ActivityDirectBinding>(this, R.layout.activity_direct)
        //创建module对象
        directViewModule = ViewModelProviders.of(this)[DirectViewModule::class.java]
        //正式给xml中的model赋予对象
        dataBinding.model = directViewModule
        //正式链接上动态变化
        dataBinding.lifecycleOwner = this
        directViewModule.user = "哈哈"
        tv_user.setOnClickListener {
            directViewModule.live.postValue("change")
            directViewModule.live2.postValue("change")
        }
        dataBinding.listener = this
    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_live -> directViewModule.live.postValue("点击变化")
        }
    }
}