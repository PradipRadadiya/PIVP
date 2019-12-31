package com.d.pivp

import android.app.Application
import com.d.pivp.model.ObjectBox
import com.facebook.drawee.backends.pipeline.Fresco

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        ObjectBox.init(this)
    }
}