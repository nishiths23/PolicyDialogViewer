package com.policy.library

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.custom_dialog_layout.*


class PolicyViewer(context: Context, private val url: String) : Dialog(context) {

    private val DIMENSIONS_DIFF_LANDSCAPE = floatArrayOf(20f, 60f)
    private val DIMENSIONS_DIFF_PORTRAIT = floatArrayOf(40f, 60f)

    private var mContent: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.custom_dialog_layout)
        mContent = LinearLayout(context)
        mContent!!.orientation = LinearLayout.VERTICAL
        setUpWebView()
        val display = window!!.windowManager.defaultDisplay
        val scale = context.resources.displayMetrics.density
        val orientation = context.resources.configuration.orientation
        val dimensions =
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) DIMENSIONS_DIFF_LANDSCAPE else DIMENSIONS_DIFF_PORTRAIT
        addContentView(
            mContent!!,
            LinearLayout.LayoutParams(
                display.width - (dimensions[0] * scale + 0.5f).toInt(),
                display.height - (dimensions[1] * scale + 0.5f).toInt()
            )
        )
        window?.attributes?.windowAnimations = R.style.DialogAnimation
        closeButton.setOnClickListener { dismiss() }
    }

    private fun setUpWebView() {
        webView.webViewClient = DialogWebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)
    }

    private class DialogWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView,
            url: String
        ): Boolean {
            view.loadUrl(url)
            return true
        }

    }
}