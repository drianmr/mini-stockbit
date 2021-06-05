package com.drianmr.stockbit.mini.ext

import android.content.res.Resources
import androidx.recyclerview.widget.RecyclerView

val RecyclerView.ViewHolder.resources: Resources
    get() = itemView.context.resources
