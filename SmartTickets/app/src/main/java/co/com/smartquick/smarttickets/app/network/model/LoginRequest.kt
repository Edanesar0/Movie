package co.com.smartquick.smarttickets.app.network.model

import org.json.JSONObject

class LoginRequest(private val user: String, private val pass: String) {
    override fun toString(): String {
        val json = JSONObject().put("user", user)
        json.put("pass", pass)
        return json.toString()
    }
}