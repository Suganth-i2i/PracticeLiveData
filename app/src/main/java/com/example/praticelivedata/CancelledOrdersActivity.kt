package com.example.praticelivedata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.praticelivedata.databinding.ActivityCancelledOrdersBinding
import com.example.praticelivedata.databinding.ActivityPaymentBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class CancelledOrdersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCancelledOrdersBinding
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCancelledOrdersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAnalytics = Firebase.analytics

        initView()
    }

    private fun initView() {
        binding.nextScrn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        val screenName = "Cancelled Orders Screen"

        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            param(FirebaseAnalytics.Param.SCREEN_NAME, screenName)
            param(FirebaseAnalytics.Param.SCREEN_CLASS, "CancelledOrdersActivity")
        }
    }
}