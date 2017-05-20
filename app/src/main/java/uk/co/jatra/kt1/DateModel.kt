package uk.co.jatra.kt1

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import java.util.*

internal class DateModel : ViewModel() {

    private val TAG : String = "DateModel"

    val date = MutableLiveData<Date>()

    init {
        this.date.value = Date(0)
        object : Thread() {
            override fun run() {
                while (true) {
                    date.postValue(Date())
                    when {
                        !date.hasActiveObservers()
                            -> Log.d(TAG, "No observers. Date: "+date.value)
                    }
                    try {
                        Thread.sleep(500)
                    } catch (e: InterruptedException) {
                        //
                    }
                }
            }
        }.start()
    }
}