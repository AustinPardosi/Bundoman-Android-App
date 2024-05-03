package com.example.bundoman

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.bundoman.models.ItemList
import com.example.bundoman.repository.BillRepo
import com.example.bundoman.service.BillApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Scan.newInstance] factory method to
 * create an instance of this fragment.
 */
class Scan : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var getScanPicture : ActivityResultLauncher<Uri>
    private lateinit var getGalleryPicture : ActivityResultLauncher<PickVisualMediaRequest>
    private lateinit var imgFile : File
    private var isSending = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val scanImg : ImageView = view.findViewById(R.id.scanImage)
        val scanButton : ImageButton = view.findViewById(R.id.cameraButton)
        val galleryButton : ImageButton = view.findViewById(R.id.galleryButton)
        val sendBillButton : Button = view.findViewById(R.id.sendBill)
        val scanUri : Uri = initTempUri()
        imgFile = File("")

        registerTakePic(scanUri, scanImg)

        val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission())
        {
            result: Boolean -> if (result) {
                scanButton.setOnClickListener {
                    getScanPicture.launch(scanUri)
                }
            } else {
                Toast.makeText(requireContext(), "Akses kamera ditolak, tidak bisa mengambil foto", Toast.LENGTH_LONG).show()
            }
        }

        galleryButton.setOnClickListener {
            getGalleryPicture.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        sendBillButton.setOnClickListener {
            if (imgFile != File("")) {
                val billRepo =
                    BillRepo(NetworkHandler.getRetrofitClient().create(BillApi::class.java))
                Toast.makeText(requireContext(), "Mengirim bill, mohon jangan tutup halaman scan", Toast.LENGTH_LONG).show()
                lifecycleScope.launch {
                    isSending = true
                    try {
                        val sharedPreferences =
                            requireContext().getSharedPreferences(
                                "BondoMan",
                                Context.MODE_PRIVATE
                            )
                        val storedToken = sharedPreferences.getString("Token", "").toString()
                        val response = billRepo.sendBill(storedToken, imgFile)
                        if (response.isSuccessful) {
                            val itemList = response.body()?.items
                            withContext(Dispatchers.Main) {
                                if (itemList != null) {
                                    showItemsPopUp(itemList)
                                } else {
                                    Toast.makeText(context, "Tidak ada item", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }
                        } else {
                            withContext(Dispatchers.Main) {
                                Toast.makeText(context, "Gagal mengirim bill", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                        isSending = false
                    } catch (e : Exception) {
                        isSending = false
                        val con = context
                        if (con != null && !NetworkHandler.hasInternetAccess) {
                            val intent = Intent(con, NoInternet::class.java)
                            con.startActivity(intent)
                        }
                    }
                }
            } else {
                Toast.makeText(requireContext(), "Pilih gambar terlebih dulu", Toast.LENGTH_SHORT).show()
            }
        }

        when {
            ContextCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                scanButton.setOnClickListener {
                    getScanPicture.launch(scanUri)
                }
            }
            else -> {
                requestPermissionLauncher.launch(
                    android.Manifest.permission.CAMERA)
            }
        }
    }

    private fun initTempUri(): Uri {
        //gets the temp_images dir
        val tempImagesDir = File(
            requireContext().filesDir, //this function gets the external cache dir
            getString(R.string.temp_images_dir)) //gets the directory for the temporary images dir

        tempImagesDir.mkdir() //Create the temp_images dir

        //Create the temp_image.jpg file
        val tempImage = File(
            tempImagesDir,
            getString(R.string.temp_image))

        return FileProvider.getUriForFile(
            requireContext(),
            getString(R.string.authorities),
            tempImage)
    }

    private fun registerTakePic(uri : Uri, scanImg : ImageView) {
        getScanPicture =
            registerForActivityResult(ActivityResultContracts.TakePicture()) { result: Boolean ->
                if (result) {
                    scanImg.setImageURI(uri)
                    val inp = requireContext().contentResolver.openInputStream(uri)
                    imgFile = File.createTempFile("scan", "png")
                    try {
                        imgFile.outputStream().use { fileOut ->
                            inp?.copyTo(fileOut)
                        }
                        imgFile.deleteOnExit()
                        inp?.close()
                    } catch (_: Exception) {
                        Toast.makeText(requireContext(), "Error saat mengambil gambar", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(requireContext(), "Gagal membuat URI gambar", Toast.LENGTH_SHORT).show()
                }
            }
        getGalleryPicture = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { diffUri ->
            // Callback is invoked after the user selects a media item or closes the
            // photo picker.
            if (diffUri != null) {
                scanImg.setImageURI(diffUri)
                val inp = requireContext().contentResolver.openInputStream(diffUri)
                imgFile = File.createTempFile("scan", "png")
                try {
                    imgFile.outputStream().use { fileOut ->
                        inp?.copyTo(fileOut)
                    }
                    imgFile.deleteOnExit()
                    inp?.close()
                } catch (_: Exception) {
                    Toast.makeText(requireContext(), "Error saat mengambil gambar", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Gagal mengambil gambar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showItemsPopUp(itemList : ItemList) {
        var itemNameArr = ArrayList<String>()
        var itemQtyArr = ArrayList<Int>()
        var itemPriceArr = ArrayList<Double>()
        for (item in itemList.items) {
            itemNameArr.add(item.name)
            itemQtyArr.add(item.qty)
            itemPriceArr.add(item.price)
        }
        val intent = Intent(requireContext().applicationContext, ItemPopup::class.java)
        intent.putExtra("itemNames", itemNameArr)
        intent.putExtra("itemQty", itemQtyArr)
        intent.putExtra("itemPrices", itemPriceArr.toDoubleArray())
        startActivity(intent)
    }

    override fun onStop() {
        super.onStop()
        if (isSending) {
            Toast.makeText(requireContext().applicationContext, "Pengiriman bill dibatalkan", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Scan.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Scan().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}