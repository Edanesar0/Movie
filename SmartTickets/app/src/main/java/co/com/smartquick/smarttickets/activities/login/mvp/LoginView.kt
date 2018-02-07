package co.com.smartquick.smarttickets.activities.login.mvp


import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.text.TextUtils
import android.view.View
import android.widget.FrameLayout
import co.com.smartquick.smarttickets.R
import co.com.smartquick.smarttickets.activities.splash.SplashActivity
import co.com.smartquick.smarttickets.app.network.model.LoginRequest
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_login.view.*


@SuppressLint("ViewConstructor")
class LoginView(private val activity: Activity) : FrameLayout(activity) {
    lateinit var dialog: Dialog;

    init {
        View.inflate(context, R.layout.activity_login, this)
    }

    fun buttonCLickLogin(): Observable<Any> {
        return RxView.clicks(login_button)
    }

    fun buttonCLickCrearCuenta(): Observable<Any> {
        return RxView.clicks(btnCrearCuenta)
    }

    fun attemptLogin(): LoginRequest? {
        // Reset errors.
        email_edittext.error = null
        password_edittext.error = null

        val emailStr = email_edittext.text.toString()
        val passwordStr = password_edittext.text.toString()

        var cancel = false
        var focusView: View? = null

        if (TextUtils.isEmpty(passwordStr)) {
            password_edittext.error = activity.getString(R.string.error_field_required)
            focusView = password_edittext
            cancel = true
        } else if (!isPasswordValid(passwordStr)) {
            password_edittext.error = activity.getString(R.string.error_invalid_password)
            focusView = password_edittext
            cancel = true
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(emailStr)) {
            email_edittext.error = activity.getString(R.string.error_field_required)
            focusView = email_edittext
            cancel = true
        } else if (!isEmailValid(emailStr)) {
            email_edittext.error = activity.getString(R.string.error_invalid_email)
            focusView = email_edittext
            cancel = true
        }

        if (cancel) {
            focusView?.requestFocus()
            return null
        } else {
            return LoginRequest(emailStr, passwordStr)
        }


    }


    private fun isEmailValid(email: String): Boolean {
        return email.contains("@")
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 4
    }

    fun showDialog() {
        println("Mostar Dialog")
        val builder = AlertDialog.Builder(activity)
        builder.setView(R.layout.activity_carga)
        dialog = builder.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    fun dismissDialog() {
        println("Cerrar Dialog")
        Handler().postDelayed({
            if (dialog.isShowing)
                dialog.dismiss()
        }, 7 * 1000)

    }

    fun changeActivity() {
        context.startActivity(Intent(context, SplashActivity::class.java))
    }

}
