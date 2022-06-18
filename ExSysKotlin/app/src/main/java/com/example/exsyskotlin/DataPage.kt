package com.example.exsyskotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.ajts.androidmads.library.SQLiteToExcel
import com.example.exsyskotlin.database.dbMaster.TempPatientdbMaster
import com.example.exsyskotlin.database.entity.TempPatientEnt
import kotlinx.android.synthetic.main.activity_data_page.*
import java.io.File

class DataPage:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_page)


        lateinit var adapter: RecyclerViewAdapter
        val dbTemp =
        Room.databaseBuilder(applicationContext, TempPatientdbMaster::class.java, "HasilDiagnosisPasien")
            .allowMainThreadQueries().build()
        val getAllData = dbTemp.temppatientDAO().getTempPatientList()
        val inputReturnPage= Intent(this,AdminLandingPage::class.java)
        var sqliteToExcel : SQLiteToExcel

        adapter = RecyclerViewAdapter(getAllData)
        recyclerview.layoutManager = LinearLayoutManager(applicationContext)
        recyclerview.adapter = adapter

        //check if data null
        checkData(getAllData)

        //button export data
        btnExportData.setOnClickListener {
            //export to excel
            sqliteToExcel = SQLiteToExcel(
                applicationContext,
                "HasilDiagnosisPasien",
                applicationContext.filesDir.path
            )
            exportToExcel(sqliteToExcel)
        }

        //button back to main menu
        btnKembaliMenu2.setOnClickListener{
            intentReturnPage(inputReturnPage)
        }
    }

    private fun checkData(getAllData :MutableList<TempPatientEnt>){
        if (getAllData.isNotEmpty()) {
            recyclerview.visibility = View.VISIBLE
        } else {
            Toast.makeText(
                this,
                "Data Pasien belum ada",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun exportToExcel(sqliteToExcel : SQLiteToExcel){
//        val export = ExportAdapter()
//        export.exportData(sqliteToExcel,applicationcontext)
        sqliteToExcel.exportAllTables(
            //excel filename
            "HasilDiagnosisPasien.xls",
            object : SQLiteToExcel.ExportListener {
                override fun onStart() {
                    Toast.makeText(applicationContext, "mulai export", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onCompleted(filePath: String) {
                    Toast.makeText(
                        applicationContext,
                        "data berhasil diekspor",
                        Toast.LENGTH_SHORT
                    )
                        .show()

                    val fileIntent = Intent(Intent.ACTION_SEND).apply {
                        val context: Context = applicationContext
                        val filelocation =
                            File(filesDir, "HasilDiagnosisPasien.xls")
                        val path = FileProvider.getUriForFile(
                            context,
                            "com.example.exsyskotlin.fileprovider",
                            filelocation
                        )
                        type = "plain/text"
                        putExtra(Intent.EXTRA_STREAM, path)
                        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                        addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                    }
                    if (packageManager != null && fileIntent.resolveActivity(
                            packageManager
                        ) != null
                    ) {
                        startActivity(fileIntent)
                    }

                }

                override fun onError(e: Exception) {
                    Toast.makeText(applicationContext, "gagal export", Toast.LENGTH_SHORT)
                        .show()
                }
            })
    }

    private fun intentReturnPage(inputPage : Intent) {
        startActivity(inputPage)
        finish()
    }
}