package uk.co.jatra.kt1

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.widget.TextView
import java.util.*


class MainActivity : LifecycleActivity() {

    override fun onCreate(b: Bundle?) {
        super.onCreate(b)
        setContentView(R.layout.activity_main)

        val t = findViewById(R.id.textView) as TextView

        val viewModel = ViewModelProviders.of(this).get(DateModel::class.java)

        viewModel.date.observe(this, Observer<Date> { date -> t.text = date.toString() })
    }
}


