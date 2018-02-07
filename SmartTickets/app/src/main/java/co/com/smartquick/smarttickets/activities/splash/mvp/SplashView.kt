package co.com.smartquick.smarttickets.activities.splash.mvp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Handler
import android.view.View
import android.widget.FrameLayout
import co.com.smartquick.smarttickets.R
import co.com.smartquick.smarttickets.activities.home.HomeActivity
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable


@SuppressLint("ViewConstructor")
class SplashView(val activity: Activity) : FrameLayout(activity) {
    init {
        View.inflate(context, R.layout.activity_splash, this)

    }

    fun onEnterView(): Observable<Any> {
        return RxView.attaches(this)
    }

    fun changeActivity() {
        Handler().postDelayed({
            activity.finishAffinity()
            context.startActivity(Intent(context, HomeActivity::class.java))
        }, 7 * 1000)
    }


}
