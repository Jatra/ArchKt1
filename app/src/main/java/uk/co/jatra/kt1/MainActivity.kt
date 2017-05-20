package uk.co.jatra.kt1

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.textView
import java.util.Date

class MainActivity : LifecycleActivity() {

    override fun onCreate(b: Bundle?) {
        super.onCreate(b)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(DateModel::class.java)
        viewModel.date.observe(this, Observer<Date> { date -> textView.text = date.toString() })
    }
}


