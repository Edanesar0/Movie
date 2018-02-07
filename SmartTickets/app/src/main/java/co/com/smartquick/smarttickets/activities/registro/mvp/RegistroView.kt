package co.com.smartquick.smarttickets.activities.registro.mvp


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.text.TextUtils
import android.view.View
import android.widget.FrameLayout
import co.com.smartquick.smarttickets.R
import co.com.smartquick.smarttickets.activities.home.HomeActivity
import co.com.smartquick.smarttickets.entities.Usuario
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.content_registro.view.*


@SuppressLint("ViewConstructor")
class RegistroView(private val activity: Activity) : FrameLayout(activity) {

    init {
        View.inflate(context, R.layout.activity_registro, this)
    }

    fun buttonRegister(): Observable<Any> {
        return RxView.clicks(btnRegistro)

    }

    fun validateRegister(): Usuario? {
        // Reset errors.
        edtNombre.error = null
        edtApellido.error = null
        edtEmail.error = null
        edtPass.error = null
        edtTelfono.error = null

        val nombreStr = edtNombre.text.toString()
        val emailStr = edtEmail.text.toString()
        val passStr = edtPass.text.toString()
        val telefonoStr = edtTelfono.text.toString()
        val apellidoStr = edtApellido.text.toString()

        var cancel = false
        var focusView: View? = null

        if (TextUtils.isEmpty(passStr)) {
            edtPass.error = activity.getString(R.string.error_field_required)
            focusView = edtPass
            cancel = true
        } else if (!isPasswordValid(passStr)) {
            edtPass.error = activity.getString(R.string.error_invalid_password)
            focusView = edtPass
            cancel = true
        }
        if (TextUtils.isEmpty(apellidoStr)) {
            edtApellido.error = activity.getString(R.string.error_field_required)
            focusView = edtEmail
            cancel = true
        }
        if (TextUtils.isEmpty(emailStr)) {
            edtEmail.error = activity.getString(R.string.error_field_required)
            focusView = edtEmail
            cancel = true
        }
        if (TextUtils.isEmpty(nombreStr)) {
            edtNombre.error = activity.getString(R.string.error_field_required)
            focusView = edtNombre
            cancel = true
        }
        if (TextUtils.isEmpty(telefonoStr)) {
            edtTelfono.error = activity.getString(R.string.error_field_required)
            focusView = edtTelfono
            cancel = true
        }
        // Check for a valid email address.
        if (TextUtils.isEmpty(emailStr)) {
            edtEmail.error = activity.getString(R.string.error_field_required)
            focusView = edtEmail
            cancel = true
        } else if (!isEmailValid(emailStr)) {
            edtEmail.error = activity.getString(R.string.error_invalid_email)
            focusView = edtEmail
            cancel = true
        }

        if (cancel) {
            focusView?.requestFocus()
            return null
        } else {
            return Usuario(0, nombreStr, apellidoStr, null, emailStr, telefonoStr)
        }
    }

    private fun isEmailValid(email: String): Boolean {
        //TODO: Replace this with your own logic
        return email.contains("@")
    }

    private fun isPasswordValid(password: String): Boolean {
        //TODO: Replace this with your own logic
        return password.length > 4
    }

    fun showDialog() {
        println("Mostar Dialog")
    }

    fun dismissDialog() {
        println("Cerrar Dialog")
    }

    fun changeActivity() {
        context.startActivity(Intent(context, HomeActivity::class.java))
    }
}
