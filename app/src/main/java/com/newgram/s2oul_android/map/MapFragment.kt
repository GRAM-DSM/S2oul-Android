package com.newgram.s2oul_android.map

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.newgram.s2oul_android.R
import org.jetbrains.anko.noButton
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.yesButton

class MapFragment : Fragment(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap


    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationCallback: MyLocationCallBack

    private val REQUEST_ACCESS_FINE_LOCATION = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //화면 안꺼지게 하기
        //activity!!.window!!.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        //SupportMapFragment 가져와서 지도 준비되면 알림을 받음
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = fragmentManager!!.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        locationInit()
    }


    private fun locationInit() {
        fusedLocationProviderClient = FusedLocationProviderClient(this.requireActivity())

        locationCallback = MyLocationCallBack()

        locationRequest = LocationRequest()

        //GPS 우선
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        locationRequest.interval = 10000

        locationRequest.fastestInterval = 5000
    }

    override fun onMapReady(googleMap: GoogleMap) {
        //구글 맵 객체 불러오기!
        mMap = googleMap

        // 마커 위치 설정 Add a marker in Sydney and move the camer
        val dsm = LatLng(36.391442, 127.363347)

        mMap.addMarker(MarkerOptions().position(dsm).title("대마고에 마커를 표시했습니다!")) //Marker in Sydney
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dsm))

    }

    override fun onResume() {
        super.onResume()

        //권한요청
        permissionCheck(cancel = {
            showPermissionInfoDialog()
        }, ok = {
            //현재 위치를 주기적으로 요청
            addLocationListener()
        })
    }

    @SuppressLint("MissingPermission")
    private fun addLocationListener() {
        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, null)
    }

    inner class MyLocationCallBack : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult?) {
            super.onLocationResult(locationResult)

            val location = locationResult?.lastLocation

            location?.run {
                //14 level로 확대하고 현재 위치로 카메라 이동
                val latLng = LatLng(latitude, longitude)
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17f))

                Log.d("MapsActivity", "위도: $latitude, 경도: $longitude")

                //자기위치 표시
                //mMap.isMyLocationEnabled = true
            }
        }
    }

    private fun permissionCheck(cancel: () -> Unit, ok:() -> Unit) {
        //위치 권한 있는지 검사 //this context!!
        if (ContextCompat.checkSelfPermission(context!!, Manifest.permission.ACCESS_FINE_LOCATION) !=
            PackageManager.PERMISSION_GRANTED) {
            //권한 허용 X
            if (ActivityCompat.shouldShowRequestPermissionRationale(this.requireActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                //이전에 권한을 한번 거부한 적이 있을때 실행
                cancel()
            } else {
                //권한 요청
                ActivityCompat.requestPermissions(this.requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    REQUEST_ACCESS_FINE_LOCATION)
            }
        } else {
            //권한 수락했을때 실행
            ok()
        }
    }

    private fun showPermissionInfoDialog() {
        alert("현재 위치 정보를 얻으려면 위치 권한이 필요합니다", "권한이 필요한 이유") {
            yesButton {
                ActivityCompat.requestPermissions(this@MapFragment.requireActivity(),
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    REQUEST_ACCESS_FINE_LOCATION)
            }
            noButton { }
        }.show()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_ACCESS_FINE_LOCATION -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    //권한 허용 시
                    addLocationListener()
                } else {
                    //권한 거부 시
                    toast("권한 거부 됨")
                }
                return
            }
        }
    }


    override fun onPause() {
        super.onPause()

        removeLocationLister()
    }

    private fun removeLocationLister() {
        fusedLocationProviderClient.removeLocationUpdates(locationCallback)
    }

}