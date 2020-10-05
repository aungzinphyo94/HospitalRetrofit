package com.myanmaritc.typicoderetrofit.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.myanmaritc.typicoderetrofit.R
import com.myanmaritc.typicoderetrofit.fragment.adapter.HospitalAdapter
import com.myanmaritc.typicoderetrofit.model.HospitalsItem
import com.myanmaritc.typicoderetrofit.viewmodel.HospitalViewmodel
import kotlinx.android.synthetic.main.fragment_hospital.*


class HospitalFragment : Fragment() {

    lateinit var hospitalViewmodel: HospitalViewmodel
    lateinit var hospitalAdapter: HospitalAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hospital, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hospitalViewmodel = ViewModelProvider(this)
            .get(HospitalViewmodel::class.java)

        hospitalAdapter = HospitalAdapter()

        recyclerHospital.layoutManager = LinearLayoutManager(context)
        recyclerHospital.adapter = hospitalAdapter

        hospitalViewmodel.getHospital().observe(
            viewLifecycleOwner, Observer {
                hospitalAdapter.updateHospital(it.hospitals as List<HospitalsItem>)
            }
        )
    }

    override fun onResume() {
        super.onResume()
        hospitalViewmodel.loadHospital()
    }
}