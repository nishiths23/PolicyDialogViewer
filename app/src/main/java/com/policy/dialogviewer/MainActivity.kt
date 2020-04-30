package com.policy.dialogviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.policy.library.PolicyViewer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showPrivacyPolicy(v: View) {
        val cdd = PolicyViewer(this, "[Privacy policy url]");
        cdd.show()
    }

    fun showTermsAndConditions(v: View) {
        val cdd = PolicyViewer(this, "[Terms and conditions url]");
        cdd.show()

    }

}
