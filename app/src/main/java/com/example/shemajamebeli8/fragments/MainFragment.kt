package com.example.shemajamebeli8.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.shemajamebeli8.viewModels.MainViewModel
import com.example.shemajamebeli8.R
import com.example.shemajamebeli8.adapters.RecyclerAdapter
import com.example.shemajamebeli8.databinding.MainFragmentBinding

class MainFragment : Fragment() {


    private lateinit var binding : MainFragmentBinding

    private  val viewModel: MainViewModel by viewModels()

    private lateinit var adapter : RecyclerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater,container,false)
        init()
        return binding.root
    }


    private fun init(){

        viewModel.init()
        initRecycler()
        observes()




    }

    private fun initRecycler(){
        adapter = RecyclerAdapter()
        binding.firstRecycler.layoutManager = LinearLayoutManager(context)
        binding.firstRecycler.adapter = adapter
    }

    private fun observes(){
        viewModel._itemsLiveData.observe(viewLifecycleOwner, Observer {
            val progress = it.match?.team1?.ballPosition?.toInt()
            val  matchInfo = it.match?.stadiumAdress.toString()+" "+it.match?.matchDate.toString()
            val score = it.match?.team1?.score.toString() + ":"+it.match?.team2?.score.toString()
            binding.matchInfo.text = matchInfo
            binding.score.text = score
            binding.time.text = it.match?.matchTime.toString()
            glide(it.match?.team1?.teamImage.toString(),binding.firstTeamLogo)
            glide(it.match?.team2?.teamImage.toString(),binding.secondTeamLogo)
            binding.firstTeamName.text = it.match?.team1?.teamName.toString()
            binding.secondTeamName.text = it.match?.team2?.teamName.toString()
            if (progress != null) {
                binding.progress.progress = progress
            }

            it.match?.matchSummary?.summaries?.let { it1 -> adapter.getSummeries(it1) }




        })


    }

    private fun glide(url:String,image : ImageView){
        Glide.with(this)
            .load(url).placeholder(R.drawable.placeholder)
            .into(image)
    }



}