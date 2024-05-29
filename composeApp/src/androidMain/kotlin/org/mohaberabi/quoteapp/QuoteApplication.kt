package org.mohaberabi.quoteapp

import android.app.Application
import di.KoinInit


class QuoteApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInit(this@QuoteApplication).init()
    }
}