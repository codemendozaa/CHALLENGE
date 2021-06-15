package com.example.challengedesarrolladormobile.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengedesarrolladormobile.R
import com.example.challengedesarrolladormobile.data.DataSource
import com.example.challengedesarrolladormobile.data.model.Product
import com.example.challengedesarrolladormobile.databinding.FragmentMainBinding
import com.example.challengedesarrolladormobile.domain.RepoImpl
import com.example.challengedesarrolladormobile.ui.viewModel.MainViewModel
import com.example.challengedesarrolladormobile.ui.viewModel.VMFactory
import com.example.challengedesarrolladormobile.vo.Resource


class MainFragment : Fragment(),MainAdapter.OnProductClickListener {

    private var _binding: FragmentMainBinding?  = null
    private val binding get() = _binding!!
    private  val viewModel by viewModels<MainViewModel> { VMFactory(RepoImpl(DataSource())) }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel.fetchProductList.observe(viewLifecycleOwner, Observer {  result ->
            when(result){
                is Resource.Loading ->{
                    binding.progressBar.visibility = View.VISIBLE

                }
                is Resource.Success ->{
                   binding.progressBar.visibility = View.GONE
                    binding.rvProduct.adapter = MainAdapter(requireContext(),result.data,this)
                    
                    
                }
                is Resource.Failure ->{
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Ocurrió un Error al traer los datos ${result.exception}", Toast.LENGTH_SHORT).show()
                }
                
            }
        })

    }

    private fun setupRecyclerView(){
        binding.rvProduct.layoutManager = LinearLayoutManager(requireContext())
        binding.rvProduct.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
        }



    override fun onDestroyView() {
        // Consider not storing the binding instance in a field, if not needed.
        _binding = null
        super.onDestroyView()


    }

    override fun onProductClick(product: Product) {
        val bundle = Bundle()
         bundle.putParcelable("product",product)
        findNavController().navigate(R.id.detailFragment)
    }

}