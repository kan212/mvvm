package com.ihandy.mvvm.recycler

import com.ihandy.mvvm.dagger.net.NetService
import javax.inject.Inject

class RecyclerRepository  {

    @Inject
    lateinit var netService: NetService
}