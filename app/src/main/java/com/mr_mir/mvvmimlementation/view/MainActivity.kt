package com.mr_mir.mvvmimlementation.view

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mr_mir.mvvmimlementation.R
import com.mr_mir.mvvmimlementation.repository.StatusCheck
import com.mr_mir.mvvmimlementation.adapter.MyAdapter
import com.mr_mir.mvvmimlementation.model.ModelClass
import com.mr_mir.mvvmimlementation.viewmodel.ShitabsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TextWatcher {

    private var viewModel: ShitabsViewModel? = null
    private var context: Context = this
    private var adapter: MyAdapter? = null
    private var path: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPathSet.addTextChangedListener(this)
        btnGet.setOnClickListener {
            if(path != "") {
                callGetAPI()
            } else {
                Toast.makeText(context,"Enter a path (1/2) ", Toast.LENGTH_LONG).show()

            }
        }
    }

    private fun callGetAPI() {
        viewModel = ViewModelProvider(this).get(ShitabsViewModel::class.java)

        //Observer to Fetch Data
        viewModel?.myLiveData
            ?.observe(this, Observer {
                when (it.status) {
                    StatusCheck.Status.SUCCESS -> {

                        successView(it.data)
                    }
                    StatusCheck.Status.ERROR -> {
                        failView(it.message)
                    }
                    StatusCheck.Status.LOADING -> {
                        loaderView()
                    }
                }
                viewModel?.removeSourceForData(path)

            })

        //Call to Fetch Data
        viewModel?.getData(path)

    }

    private fun loaderView() {
        //Toast.makeText(context,"Loading ... Please Wait!!! ", Toast.LENGTH_LONG).show()
    }

    private fun failView(errorMsg: String?) {
        Toast.makeText(context,"Error Msg: $errorMsg ", Toast.LENGTH_LONG).show()
    }

    private fun successView(body: List<ModelClass?>?) {
        setWebView()
        generateDataList(body)
    }

    private fun generateDataList(body: List<ModelClass?>?) {
        rvGet.visibility = View.VISIBLE
        adapter = MyAdapter(this, body)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        rvGet.layoutManager = layoutManager
        rvGet.adapter = adapter
    }

    private fun setWebView() {
        wvJson.webViewClient = WebViewClient()
        wvJson.settings.loadsImagesAutomatically = true
        wvJson.settings.javaScriptEnabled = true
        wvJson.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        val string =
            "https://shitab14.github.io/jsons/$path/retrofit.json"
        wvJson.loadUrl(string)
        //tvUrl.setText(string)
    }

    //TextWatcher
    override fun afterTextChanged(s: Editable?) {
        //nothing
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        //nothing
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        path = s.toString()
    }
}