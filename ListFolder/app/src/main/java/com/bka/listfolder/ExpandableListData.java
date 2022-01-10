package com.bka.listfolder;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class ExpandableListData extends AppCompatActivity {
    static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> listFolderRoot = new HashMap<>();

        String folderToList = Environment.getExternalStorageDirectory().getAbsolutePath();
        File folderFile = new File(folderToList);
        if (folderFile.isDirectory()) {
            File[] files = folderFile.listFiles();
            for (File f : files) {
                List<String> listdata = new ArrayList<String>();
                String folder = f.getName();
                String listFolder = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + folder;
                File newfolder = new File(listFolder);

                if (newfolder.isDirectory()) {
                    File[] folders = newfolder.listFiles();
                    for (File newfile : folders) {
                        String nameFolder = newfile.getName();
                        listdata.add(nameFolder);
                    }
                }
                listFolderRoot.put(folder, listdata);
            }
        } else if (folderFile.isFile()) {
            List<String> listdata = new ArrayList<String>();
            listFolderRoot.put(folderFile.getName(), listdata);
        }
        return listFolderRoot;
    }

}