package edu.temple.basicbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity()
{

    lateinit var urlEditText: EditText
    lateinit var goButton: ImageButton
    lateinit var webView: WebView
    lateinit var url: String

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        urlEditText = findViewById(R.id.urlEditText)
        goButton = findViewById(R.id.goButton)
        webView = findViewById(R.id.webView)
        webView.settings.setJavaScriptEnabled(true)


        // Allow your browser to intercept hyperlink clicks
        goButton.setOnClickListener()
        {
            url = urlEditText.text.toString()
        }

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean
            {
                if (url != null)
                {
                    view?.loadUrl(url)
                }
                return true
            }
        }
        webView.loadUrl(urlEditText.text.toString())
    }
    }


