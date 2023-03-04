package com.example.appupdatekotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability

class MainActivity : AppCompatActivity() {


    private lateinit var inAppUpdate: InAppUpdate
    //ex 1
    private  var appUpdate: AppUpdateManager? = null
    private val REQUEST_CODE = 100


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inAppUpdate = InAppUpdate(this)
        //ex 1
        //appUpdate = AppUpdateManagerFactory.create(this)
        //checkUpdate()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        inAppUpdate.onActivityResult(requestCode,resultCode, data)
    }
    override fun onResume() {
        super.onResume()
        inAppUpdate.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        inAppUpdate.onDestroy()
    }

}

//ex 1
/*
fun checkUpdate(){
    appUpdate?.appUpdateInfo?.addOnSuccessListener { updateInfo->

        if (updateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
            && updateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)){
            appUpdate?.startUpdateFlowForResult(updateInfo,AppUpdateType.IMMEDIATE,this,REQUEST_CODE)
        }
    }
}

override fun onResume() {
    super.onResume()
    inProgressUpdate()
}
fun inProgressUpdate(){
    appUpdate?.appUpdateInfo?.addOnSuccessListener { updateInfo->

        if (updateInfo.updateAvailability() == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS){
            appUpdate?.startUpdateFlowForResult(updateInfo,AppUpdateType.IMMEDIATE,this,REQUEST_CODE)
        }
    }
}*/
