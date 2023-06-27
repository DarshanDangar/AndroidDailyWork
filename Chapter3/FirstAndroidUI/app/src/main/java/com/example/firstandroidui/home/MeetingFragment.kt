package com.example.firstandroidui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import com.example.firstandroidui.R

class MeetingFragment : Fragment(R.layout.fragment_meeting), ActivityMenuProvider {

    override fun getMenu(): Int? = null

}