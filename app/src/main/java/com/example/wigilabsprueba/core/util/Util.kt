package com.example.wigilabsprueba.core.util

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.wigilabsprueba.R
import com.google.android.material.snackbar.Snackbar
import java.time.temporal.TemporalAmount


fun Fragment.notifyErrorWithAction(
    message: String,
    actionText: String,
    action: () -> Any
){
    val snackBar = Snackbar.make(this.requireView(), message, Snackbar.LENGTH_INDEFINITE)
    snackBar.setAction(actionText) { _ -> action.invoke() }
    snackBar.setActionTextColor(ContextCompat.getColor(this.requireContext(), R.color.design_default_color_on_primary))
    snackBar.show()

}


fun String.cut(amount:Int):String{
    if (this.length<amount) return this+"......"
    return this.substring(0,amount)+"......"
}


class Util{
    companion object{
        @JvmStatic
        @BindingAdapter("loadImageUrl")
        fun ImageView.setImageUrl(url:String?){

            if(url!=null){
                Glide.with(this.context)
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .placeholder(R.drawable.ic_baseline_refresh_24)
                    .error(R.drawable.ic_baseline_wifi_off_24)
                    .into(this)
                this.visibility= View.VISIBLE
            }else{
                this.visibility= View.GONE
            }




        }
    }
}

